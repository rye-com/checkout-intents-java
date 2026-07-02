// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.orders.Cancellation
import com.rye.models.orders.Order
import com.rye.models.orders.OrderCancelParams
import com.rye.models.orders.OrderListPageAsync
import com.rye.models.orders.OrderListParams
import com.rye.models.orders.OrderRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OrderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderServiceAsync

    /** Retrieve an order by id. */
    fun retrieve(id: String): CompletableFuture<Order> = retrieve(id, OrderRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: OrderRetrieveParams = OrderRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order> = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: OrderRetrieveParams = OrderRetrieveParams.none(),
    ): CompletableFuture<Order> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Order>

    /** @see retrieve */
    fun retrieve(params: OrderRetrieveParams): CompletableFuture<Order> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<Order> =
        retrieve(id, OrderRetrieveParams.none(), requestOptions)

    /** List orders for the authenticated developer with cursor-based pagination. */
    fun list(): CompletableFuture<OrderListPageAsync> = list(OrderListParams.none())

    /** @see list */
    fun list(
        params: OrderListParams = OrderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrderListPageAsync>

    /** @see list */
    fun list(
        params: OrderListParams = OrderListParams.none()
    ): CompletableFuture<OrderListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<OrderListPageAsync> =
        list(OrderListParams.none(), requestOptions)

    /**
     * Request cancellation of an order.
     *
     * Order cancellations are subject to each merchant's cancellation policy.
     */
    fun cancel(id: String, params: OrderCancelParams): CompletableFuture<Cancellation> =
        cancel(id, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        id: String,
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Cancellation> = cancel(params.toBuilder().id(id).build(), requestOptions)

    /** @see cancel */
    fun cancel(params: OrderCancelParams): CompletableFuture<Cancellation> =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Cancellation>

    /** A view of [OrderServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/orders/{id}`, but is otherwise the same as
         * [OrderServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<Order>> =
            retrieve(id, OrderRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: OrderRetrieveParams = OrderRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Order>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: OrderRetrieveParams = OrderRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Order>> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Order>>

        /** @see retrieve */
        fun retrieve(params: OrderRetrieveParams): CompletableFuture<HttpResponseFor<Order>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Order>> =
            retrieve(id, OrderRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/orders`, but is otherwise the same as
         * [OrderServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<OrderListPageAsync>> =
            list(OrderListParams.none())

        /** @see list */
        fun list(
            params: OrderListParams = OrderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrderListPageAsync>>

        /** @see list */
        fun list(
            params: OrderListParams = OrderListParams.none()
        ): CompletableFuture<HttpResponseFor<OrderListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<OrderListPageAsync>> =
            list(OrderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/orders/{id}/cancel`, but is otherwise the
         * same as [OrderServiceAsync.cancel].
         */
        fun cancel(
            id: String,
            params: OrderCancelParams,
        ): CompletableFuture<HttpResponseFor<Cancellation>> =
            cancel(id, params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            id: String,
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Cancellation>> =
            cancel(params.toBuilder().id(id).build(), requestOptions)

        /** @see cancel */
        fun cancel(params: OrderCancelParams): CompletableFuture<HttpResponseFor<Cancellation>> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Cancellation>>
    }
}
