// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.testhelpers

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
import com.rye.models.testhelpers.shipments.ShipmentAdvanceParams
import com.rye.models.testhelpers.shipments.ShipmentAdvanceResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ShipmentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ShipmentServiceAsync {

    private val withRawResponse: ShipmentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ShipmentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ShipmentServiceAsync =
        ShipmentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun advance(
        params: ShipmentAdvanceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ShipmentAdvanceResponse> =
        // post /api/v1/test-helpers/checkout-intents/{checkoutIntentId}/shipments/advance
        withRawResponse().advance(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ShipmentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ShipmentServiceAsync.WithRawResponse =
            ShipmentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val advanceHandler: Handler<ShipmentAdvanceResponse> =
            jsonHandler<ShipmentAdvanceResponse>(clientOptions.jsonMapper)

        override fun advance(
            params: ShipmentAdvanceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ShipmentAdvanceResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("checkoutIntentId", params.checkoutIntentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "test-helpers",
                        "checkout-intents",
                        params._pathParam(0),
                        "shipments",
                        "advance",
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
                            .use { advanceHandler.handle(it) }
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
