// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

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
import com.rye.core.prepareAsync
import com.rye.errors.PollTimeoutException
import com.rye.models.checkoutintents.CheckoutIntent
import com.rye.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.rye.models.checkoutintents.CheckoutIntentConfirmParams
import com.rye.models.checkoutintents.CheckoutIntentCreateParams
import com.rye.models.checkoutintents.CheckoutIntentListPageAsync
import com.rye.models.checkoutintents.CheckoutIntentListPageResponse
import com.rye.models.checkoutintents.CheckoutIntentListParams
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams
import com.rye.models.checkoutintents.CheckoutIntentRetrieveParams
import com.rye.models.checkoutintents.PollOptions
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import java.util.logging.Logger
import kotlin.jvm.optionals.getOrNull

class CheckoutIntentServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : CheckoutIntentServiceAsync {

    private val withRawResponse: CheckoutIntentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CheckoutIntentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): CheckoutIntentServiceAsync =
        CheckoutIntentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CheckoutIntentCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntent> =
        // post /api/v1/checkout-intents
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: CheckoutIntentRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntent> =
        // get /api/v1/checkout-intents/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: CheckoutIntentListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntentListPageAsync> =
        // get /api/v1/checkout-intents
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun addPayment(
        params: CheckoutIntentAddPaymentParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntent> =
        // post /api/v1/checkout-intents/{id}/payment
        withRawResponse().addPayment(params, requestOptions).thenApply { it.parse() }

    override fun confirm(
        params: CheckoutIntentConfirmParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntent> =
        // post /api/v1/checkout-intents/{id}/confirm
        withRawResponse().confirm(params, requestOptions).thenApply { it.parse() }

    override fun purchase(
        params: CheckoutIntentPurchaseParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntent> =
        // post /api/v1/checkout-intents/purchase
        withRawResponse().purchase(params, requestOptions).thenApply { it.parse() }

    // Polling implementation

    override fun pollUntilCompleted(
        id: String,
        options: PollOptions,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntent> =
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
    ): CompletableFuture<CheckoutIntent> =
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
    ): CompletableFuture<CheckoutIntent> =
        create(params, requestOptions).thenCompose { intent ->
            val intentId = extractIntentId(intent)
            pollUntilAwaitingConfirmation(intentId, options, requestOptions)
        }

    override fun confirmAndPoll(
        id: String,
        params: CheckoutIntentConfirmParams,
        options: PollOptions,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutIntent> =
        confirm(id, params, requestOptions).thenCompose {
            pollUntilCompleted(id, options, requestOptions)
        }

    private fun pollUntil(
        id: String,
        options: PollOptions,
        requestOptions: RequestOptions,
        isTerminal: (CheckoutIntent) -> Boolean,
        targetStateDescription: String,
    ): CompletableFuture<CheckoutIntent> {
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

        return pollLoop(
            id = id,
            pollingService = pollingService,
            requestOptions = requestOptions,
            isTerminal = isTerminal,
            targetStateDescription = targetStateDescription,
            attempt = 0,
            maxAttempts = maxAttempts,
            pollIntervalMs = pollIntervalMs,
            currentIntervalMs = pollIntervalMs,
        )
    }

    private fun pollLoop(
        id: String,
        pollingService: CheckoutIntentServiceAsync,
        requestOptions: RequestOptions,
        isTerminal: (CheckoutIntent) -> Boolean,
        targetStateDescription: String,
        attempt: Int,
        maxAttempts: Int,
        pollIntervalMs: Long,
        currentIntervalMs: Long,
    ): CompletableFuture<CheckoutIntent> {
        val currentAttempt = attempt + 1

        return pollingService.withRawResponse().retrieve(id, requestOptions).thenCompose { response
            ->
            val intent = response.parse()

            // Check if we've reached a terminal state
            if (isTerminal(intent)) {
                CompletableFuture.completedFuture(intent)
            } else if (currentAttempt >= maxAttempts) {
                // Throw timeout exception
                val future = CompletableFuture<CheckoutIntent>()
                future.completeExceptionally(
                    PollTimeoutException(
                        intentId = id,
                        attempts = currentAttempt,
                        maxAttempts = maxAttempts,
                        pollIntervalMs = pollIntervalMs,
                        message =
                            "Polling timed out after $currentAttempt attempts. " +
                                "Expected state: $targetStateDescription. Intent ID: $id",
                    )
                )
                future
            } else {
                // Check for server-provided retry interval
                val retryAfterMs =
                    response.headers().values("retry-after-ms").firstOrNull()?.toLongOrNull()
                val nextIntervalMs =
                    if (retryAfterMs != null && retryAfterMs > 0) retryAfterMs
                    else currentIntervalMs

                // Sleep and then continue polling
                clientOptions.sleeper.sleepAsync(Duration.ofMillis(nextIntervalMs)).thenCompose {
                    pollLoop(
                        id = id,
                        pollingService = pollingService,
                        requestOptions = requestOptions,
                        isTerminal = isTerminal,
                        targetStateDescription = targetStateDescription,
                        attempt = currentAttempt,
                        maxAttempts = maxAttempts,
                        pollIntervalMs = pollIntervalMs,
                        currentIntervalMs = nextIntervalMs,
                    )
                }
            }
        }
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
        private val logger: Logger =
            Logger.getLogger(CheckoutIntentServiceAsyncImpl::class.java.name)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckoutIntentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutIntentServiceAsync.WithRawResponse =
            CheckoutIntentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun create(
            params: CheckoutIntentCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CheckoutIntentRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<CheckoutIntentListPageResponse> =
            jsonHandler<CheckoutIntentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CheckoutIntentListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutIntentListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                CheckoutIntentListPageAsync.builder()
                                    .service(CheckoutIntentServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val addPaymentHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun addPayment(
            params: CheckoutIntentAddPaymentParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { addPaymentHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val confirmHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun confirm(
            params: CheckoutIntentConfirmParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { confirmHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val purchaseHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun purchase(
            params: CheckoutIntentPurchaseParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents", "purchase")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
