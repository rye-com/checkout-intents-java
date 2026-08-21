// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.orders.Cancellation
import com.rye.models.orders.Order
import com.rye.models.orders.OrderCancelParams
import com.rye.models.orders.OrderListPage
import com.rye.models.orders.OrderListParams
import com.rye.models.orders.OrderRetrieveParams
import com.rye.models.orders.OrderUpdateBuyerParams
import java.util.function.Consumer

interface OrderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService

    /** Retrieve an order by id. */
    fun retrieve(id: String): Order = retrieve(id, OrderRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: OrderRetrieveParams = OrderRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(id: String, params: OrderRetrieveParams = OrderRetrieveParams.none()): Order =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order

    /** @see retrieve */
    fun retrieve(params: OrderRetrieveParams): Order = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): Order =
        retrieve(id, OrderRetrieveParams.none(), requestOptions)

    /** List orders for the authenticated developer with cursor-based pagination. */
    fun list(): OrderListPage = list(OrderListParams.none())

    /** @see list */
    fun list(
        params: OrderListParams = OrderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrderListPage

    /** @see list */
    fun list(params: OrderListParams = OrderListParams.none()): OrderListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): OrderListPage =
        list(OrderListParams.none(), requestOptions)

    /**
     * Request cancellation of an order.
     *
     * Order cancellations are subject to each merchant's cancellation policy.
     */
    fun cancel(id: String, params: OrderCancelParams): Cancellation =
        cancel(id, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        id: String,
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Cancellation = cancel(params.toBuilder().id(id).build(), requestOptions)

    /** @see cancel */
    fun cancel(params: OrderCancelParams): Cancellation = cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: OrderCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Cancellation

    /** Update buyer fields for an order and update its Shopify shipping address. */
    fun updateBuyer(id: String, params: OrderUpdateBuyerParams): Order =
        updateBuyer(id, params, RequestOptions.none())

    /** @see updateBuyer */
    fun updateBuyer(
        id: String,
        params: OrderUpdateBuyerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order = updateBuyer(params.toBuilder().id(id).build(), requestOptions)

    /** @see updateBuyer */
    fun updateBuyer(params: OrderUpdateBuyerParams): Order =
        updateBuyer(params, RequestOptions.none())

    /** @see updateBuyer */
    fun updateBuyer(
        params: OrderUpdateBuyerParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Order

    /** A view of [OrderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/orders/{id}`, but is otherwise the same as
         * [OrderService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<Order> = retrieve(id, OrderRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: OrderRetrieveParams = OrderRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: OrderRetrieveParams = OrderRetrieveParams.none(),
        ): HttpResponseFor<Order> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: OrderRetrieveParams): HttpResponseFor<Order> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<Order> =
            retrieve(id, OrderRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/orders`, but is otherwise the same as
         * [OrderService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<OrderListPage> = list(OrderListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrderListParams = OrderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrderListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: OrderListParams = OrderListParams.none()): HttpResponseFor<OrderListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<OrderListPage> =
            list(OrderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/orders/{id}/cancel`, but is otherwise the
         * same as [OrderService.cancel].
         */
        @MustBeClosed
        fun cancel(id: String, params: OrderCancelParams): HttpResponseFor<Cancellation> =
            cancel(id, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Cancellation> = cancel(params.toBuilder().id(id).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: OrderCancelParams): HttpResponseFor<Cancellation> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: OrderCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Cancellation>

        /**
         * Returns a raw HTTP response for `put /api/v1/orders/{id}/buyer`, but is otherwise the
         * same as [OrderService.updateBuyer].
         */
        @MustBeClosed
        fun updateBuyer(id: String, params: OrderUpdateBuyerParams): HttpResponseFor<Order> =
            updateBuyer(id, params, RequestOptions.none())

        /** @see updateBuyer */
        @MustBeClosed
        fun updateBuyer(
            id: String,
            params: OrderUpdateBuyerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order> = updateBuyer(params.toBuilder().id(id).build(), requestOptions)

        /** @see updateBuyer */
        @MustBeClosed
        fun updateBuyer(params: OrderUpdateBuyerParams): HttpResponseFor<Order> =
            updateBuyer(params, RequestOptions.none())

        /** @see updateBuyer */
        @MustBeClosed
        fun updateBuyer(
            params: OrderUpdateBuyerParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Order>
    }
}
