// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.checkRequired
import com.rye.core.handlers.errorBodyHandler
import com.rye.core.handlers.errorHandler
import com.rye.core.handlers.jsonHandler
import com.rye.core.http.Headers
import com.rye.core.http.HttpMethod
import com.rye.core.http.HttpRequest
import com.rye.core.http.HttpResponse
import com.rye.core.http.HttpResponse.Handler
import com.rye.core.http.HttpResponseFor
import com.rye.core.http.json
import com.rye.core.http.parseable
import com.rye.core.prepare
import com.rye.errors.PollTimeoutException
import com.rye.models.checkoutintents.CheckoutIntent
import com.rye.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.rye.models.checkoutintents.CheckoutIntentConfirmParams
import com.rye.models.checkoutintents.CheckoutIntentCreateParams
import com.rye.models.checkoutintents.CheckoutIntentListPage
import com.rye.models.checkoutintents.CheckoutIntentListPageResponse
import com.rye.models.checkoutintents.CheckoutIntentListParams
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams
import com.rye.models.checkoutintents.CheckoutIntentRetrieveParams
import com.rye.models.checkoutintents.PollOptions
import com.rye.services.blocking.checkoutintents.ShipmentService
import com.rye.services.blocking.checkoutintents.ShipmentServiceImpl
import java.time.Duration
import java.util.function.Consumer
import java.util.logging.Logger
import kotlin.jvm.optionals.getOrNull

class CheckoutIntentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckoutIntentService {

    private val withRawResponse: CheckoutIntentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val shipments: ShipmentService by lazy { ShipmentServiceImpl(clientOptions) }

    override fun withRawResponse(): CheckoutIntentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutIntentService =
        CheckoutIntentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun shipments(): ShipmentService = shipments

    override fun create(
        params: CheckoutIntentCreateParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: CheckoutIntentRetrieveParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // get /api/v1/checkout-intents/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: CheckoutIntentListParams,
        requestOptions: RequestOptions,
    ): CheckoutIntentListPage =
        // get /api/v1/checkout-intents
        withRawResponse().list(params, requestOptions).parse()

    override fun addPayment(
        params: CheckoutIntentAddPaymentParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents/{id}/payment
        withRawResponse().addPayment(params, requestOptions).parse()

    override fun confirm(
        params: CheckoutIntentConfirmParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents/{id}/confirm
        withRawResponse().confirm(params, requestOptions).parse()

    override fun purchase(
        params: CheckoutIntentPurchaseParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents/purchase
        withRawResponse().purchase(params, requestOptions).parse()

    // Polling implementation

    override fun pollUntilCompleted(
        id: String,
        options: PollOptions,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        pollUntil(
            id = id,
            options = options,
            requestOptions = requestOptions,
            isTerminal = { it.isCompleted() || it.isFailed() },
            targetStateDescription = "completed or failed",
        )

    override fun pollUntilAwaitingConfirmation(
        id: String,
        options: PollOptions,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        pollUntil(
            id = id,
            options = options,
            requestOptions = requestOptions,
            isTerminal = { it.isAwaitingConfirmation() || it.isFailed() },
            targetStateDescription = "awaiting_confirmation or failed",
        )

    override fun createAndPoll(
        params: CheckoutIntentCreateParams,
        options: PollOptions,
        requestOptions: RequestOptions,
    ): CheckoutIntent {
        val intent = create(params, requestOptions)
        val intentId = extractIntentId(intent)
        return pollUntilAwaitingConfirmation(intentId, options, requestOptions)
    }

    override fun confirmAndPoll(
        id: String,
        params: CheckoutIntentConfirmParams,
        options: PollOptions,
        requestOptions: RequestOptions,
    ): CheckoutIntent {
        confirm(id, params, requestOptions)
        return pollUntilCompleted(id, options, requestOptions)
    }

    private fun pollUntil(
        id: String,
        options: PollOptions,
        requestOptions: RequestOptions,
        isTerminal: (CheckoutIntent) -> Boolean,
        targetStateDescription: String,
    ): CheckoutIntent {
        val pollIntervalMs =
            options.pollInterval().orElse(PollOptions.DEFAULT_POLL_INTERVAL).toMillis()
        var maxAttempts = options.maxAttempts().orElse(PollOptions.DEFAULT_MAX_ATTEMPTS)

        // Coerce invalid maxAttempts to 1 with a warning
        if (maxAttempts < 1) {
            logger.warning("Invalid maxAttempts value: $maxAttempts. Coercing to 1.")
            maxAttempts = 1
        }

        // Build polling headers
        val pollHeaders =
            Headers.builder()
                .put("X-Stainless-Poll-Helper", "true")
                .put("X-Stainless-Custom-Poll-Interval", pollIntervalMs.toString())
                .build()

        // Create service with polling headers
        val pollingService = withOptions { builder -> builder.putAllHeaders(pollHeaders) }

        var currentIntervalMs = pollIntervalMs
        var attempt = 0

        while (attempt < maxAttempts) {
            attempt++

            val response = pollingService.withRawResponse().retrieve(id, requestOptions)
            val intent = response.parse()

            // Check if we've reached a terminal state
            if (isTerminal(intent)) {
                return intent
            }

            // Check if this was our last attempt
            if (attempt >= maxAttempts) {
                break
            }

            // Check for server-provided retry interval
            val retryAfterMs =
                response.headers().values("retry-after-ms").firstOrNull()?.toLongOrNull()
            if (retryAfterMs != null && retryAfterMs > 0) {
                currentIntervalMs = retryAfterMs
            }

            // Sleep before next poll
            clientOptions.sleeper.sleep(Duration.ofMillis(currentIntervalMs))
        }

        throw PollTimeoutException(
            intentId = id,
            attempts = attempt,
            maxAttempts = maxAttempts,
            pollIntervalMs = pollIntervalMs,
            message =
                "Polling timed out after $attempt attempts. " +
                    "Expected state: $targetStateDescription. Intent ID: $id",
        )
    }

    private fun extractIntentId(intent: CheckoutIntent): String =
        intent.accept(
            object : CheckoutIntent.Visitor<String> {
                override fun visitRetrievingOffer(
                    retrievingOffer: CheckoutIntent.RetrievingOfferCheckoutIntent
                ) = retrievingOffer.id()

                override fun visitAwaitingConfirmation(
                    awaitingConfirmation: CheckoutIntent.AwaitingConfirmationCheckoutIntent
                ) = awaitingConfirmation.id()

                override fun visitPlacingOrder(
                    placingOrder: CheckoutIntent.PlacingOrderCheckoutIntent
                ) = placingOrder.id()

                override fun visitCompleted(completed: CheckoutIntent.CompletedCheckoutIntent) =
                    completed.id()

                override fun visitFailed(failed: CheckoutIntent.FailedCheckoutIntent) = failed.id()
            }
        )

    companion object {
        private val logger: Logger = Logger.getLogger(CheckoutIntentServiceImpl::class.java.name)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckoutIntentService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val shipments: ShipmentService.WithRawResponse by lazy {
            ShipmentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutIntentService.WithRawResponse =
            CheckoutIntentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun shipments(): ShipmentService.WithRawResponse = shipments

        private val createHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun create(
            params: CheckoutIntentCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CheckoutIntentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<CheckoutIntentListPageResponse> =
            jsonHandler<CheckoutIntentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CheckoutIntentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntentListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        CheckoutIntentListPage.builder()
                            .service(CheckoutIntentServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val addPaymentHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun addPayment(
            params: CheckoutIntentAddPaymentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "checkout-intents",
                        params._pathParam(0),
                        "payment",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addPaymentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val confirmHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun confirm(
            params: CheckoutIntentConfirmParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "checkout-intents",
                        params._pathParam(0),
                        "confirm",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { confirmHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val purchaseHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun purchase(
            params: CheckoutIntentPurchaseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents", "purchase")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { purchaseHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
