// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.testhelpers

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
import com.rye.core.prepare
import com.rye.models.testhelpers.shipments.ShipmentAdvanceParams
import com.rye.models.testhelpers.shipments.ShipmentAdvanceResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ShipmentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ShipmentService {

    private val withRawResponse: ShipmentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ShipmentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ShipmentService =
        ShipmentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun advance(
        params: ShipmentAdvanceParams,
        requestOptions: RequestOptions,
    ): ShipmentAdvanceResponse =
        // post /api/v1/test-helpers/checkout-intents/{checkoutIntentId}/shipments/advance
        withRawResponse().advance(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ShipmentService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ShipmentService.WithRawResponse =
            ShipmentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val advanceHandler: Handler<ShipmentAdvanceResponse> =
            jsonHandler<ShipmentAdvanceResponse>(clientOptions.jsonMapper)

        override fun advance(
            params: ShipmentAdvanceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ShipmentAdvanceResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
