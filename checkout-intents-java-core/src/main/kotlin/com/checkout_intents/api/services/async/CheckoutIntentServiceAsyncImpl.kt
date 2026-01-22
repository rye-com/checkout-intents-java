// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.async

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
import com.checkout_intents.api.core.checkRequired
import com.checkout_intents.api.core.handlers.errorBodyHandler
import com.checkout_intents.api.core.handlers.errorHandler
import com.checkout_intents.api.core.handlers.jsonHandler
import com.checkout_intents.api.core.http.HttpMethod
import com.checkout_intents.api.core.http.HttpRequest
import com.checkout_intents.api.core.http.HttpResponse
import com.checkout_intents.api.core.http.HttpResponse.Handler
import com.checkout_intents.api.core.http.HttpResponseFor
import com.checkout_intents.api.core.http.json
import com.checkout_intents.api.core.http.parseable
import com.checkout_intents.api.core.prepareAsync
import com.checkout_intents.api.models.checkoutintents.CheckoutIntent
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentConfirmParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentCreateParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentListPageAsync
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentListPageResponse
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentListParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentPurchaseParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
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
