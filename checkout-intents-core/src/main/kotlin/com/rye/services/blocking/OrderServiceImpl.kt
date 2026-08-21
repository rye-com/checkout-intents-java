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
import com.rye.core.http.json
import com.rye.core.http.parseable
import com.rye.core.prepare
import com.rye.models.orders.Cancellation
import com.rye.models.orders.Order
import com.rye.models.orders.OrderCancelParams
import com.rye.models.orders.OrderListPage
import com.rye.models.orders.OrderListPageResponse
import com.rye.models.orders.OrderListParams
import com.rye.models.orders.OrderRetrieveParams
import com.rye.models.orders.OrderUpdateBuyerParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderService {

    private val withRawResponse: OrderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService =
        OrderServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(params: OrderRetrieveParams, requestOptions: RequestOptions): Order =
        // get /api/v1/orders/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: OrderListParams, requestOptions: RequestOptions): OrderListPage =
        // get /api/v1/orders
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(params: OrderCancelParams, requestOptions: RequestOptions): Cancellation =
        // post /api/v1/orders/{id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun updateBuyer(
        params: OrderUpdateBuyerParams,
        requestOptions: RequestOptions,
    ): Order =
        // put /api/v1/orders/{id}/buyer
        withRawResponse().updateBuyer(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderService.WithRawResponse =
            OrderServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<Order> = jsonHandler<Order>(clientOptions.jsonMapper)

        override fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "orders", params._pathParam(0))
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

        private val listHandler: Handler<OrderListPageResponse> =
            jsonHandler<OrderListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: OrderListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrderListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "orders")
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
                        OrderListPage.builder()
                            .service(OrderServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val cancelHandler: Handler<Cancellation> =
            jsonHandler<Cancellation>(clientOptions.jsonMapper)

        override fun cancel(
            params: OrderCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Cancellation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "orders", params._pathParam(0), "cancel")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateBuyerHandler: Handler<Order> =
            jsonHandler<Order>(clientOptions.jsonMapper)

        override fun updateBuyer(
            params: OrderUpdateBuyerParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "orders", params._pathParam(0), "buyer")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateBuyerHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
