// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

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
import com.rye.core.http.parseable
import com.rye.core.prepare
import com.rye.models.shipments.Shipment
import com.rye.models.shipments.ShipmentListPage
import com.rye.models.shipments.ShipmentListPageResponse
import com.rye.models.shipments.ShipmentListParams
import com.rye.models.shipments.ShipmentRetrieveParams
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

    override fun retrieve(
        params: ShipmentRetrieveParams,
        requestOptions: RequestOptions,
    ): Shipment =
        // get /api/v1/shipments/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: ShipmentListParams,
        requestOptions: RequestOptions,
    ): ShipmentListPage =
        // get /api/v1/shipments
        withRawResponse().list(params, requestOptions).parse()

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

        private val retrieveHandler: Handler<Shipment> =
            jsonHandler<Shipment>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ShipmentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Shipment> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "shipments", params._pathParam(0))
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

        private val listHandler: Handler<ShipmentListPageResponse> =
            jsonHandler<ShipmentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ShipmentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ShipmentListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "shipments")
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
                        ShipmentListPage.builder()
                            .service(ShipmentServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
