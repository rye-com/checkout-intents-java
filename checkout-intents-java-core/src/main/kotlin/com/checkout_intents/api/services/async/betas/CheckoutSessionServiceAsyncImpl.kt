// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.async.betas

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
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
import com.checkout_intents.api.models.betas.CheckoutSession
import com.checkout_intents.api.models.betas.checkoutsessions.CheckoutSessionCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class CheckoutSessionServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : CheckoutSessionServiceAsync {

    private val withRawResponse: CheckoutSessionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CheckoutSessionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): CheckoutSessionServiceAsync =
        CheckoutSessionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CheckoutSessionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckoutSession> =
        // post /api/v1/betas/checkout-sessions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckoutSessionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutSessionServiceAsync.WithRawResponse =
            CheckoutSessionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CheckoutSession> =
            jsonHandler<CheckoutSession>(clientOptions.jsonMapper)

        override fun create(
            params: CheckoutSessionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutSession>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "betas", "checkout-sessions")
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
    }
}
