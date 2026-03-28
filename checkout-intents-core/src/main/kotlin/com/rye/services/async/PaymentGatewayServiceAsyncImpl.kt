// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.checkRequired
import com.rye.core.handlers.errorBodyHandler
import com.rye.core.handlers.errorHandler
import com.rye.core.handlers.jsonHandler
import com.rye.core.http.HttpMethod
import com.rye.core.http.HttpRequest
import com.rye.core.http.HttpResponse
import com.rye.core.http.HttpResponse.Handler
import com.rye.core.http.HttpResponseFor
import com.rye.core.http.json
import com.rye.core.http.parseable
import com.rye.core.prepareAsync
import com.rye.models.paymentgateways.PaymentGatewayCreateSessionParams
import com.rye.models.paymentgateways.PaymentGatewaySession
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class PaymentGatewayServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : PaymentGatewayServiceAsync {

    private val withRawResponse: PaymentGatewayServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PaymentGatewayServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): PaymentGatewayServiceAsync =
        PaymentGatewayServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun createSession(
        params: PaymentGatewayCreateSessionParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaymentGatewaySession> =
        // post /api/v1/payment-gateways/{gateway}/session
        withRawResponse().createSession(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PaymentGatewayServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PaymentGatewayServiceAsync.WithRawResponse =
            PaymentGatewayServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createSessionHandler: Handler<PaymentGatewaySession> =
            jsonHandler<PaymentGatewaySession>(clientOptions.jsonMapper)

        override fun createSession(
            params: PaymentGatewayCreateSessionParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaymentGatewaySession>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("gateway", params.gateway().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "payment-gateways",
                        params._pathParam(0),
                        "session",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createSessionHandler.handle(it) }
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
