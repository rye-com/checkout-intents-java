// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.products.Product
import com.rye.models.products.ProductListSubscriptionsParams
import com.rye.models.products.ProductListSubscriptionsResponse
import com.rye.models.products.ProductLookupParams
import com.rye.models.products.ProductSubscribeParams
import com.rye.models.products.ProductSubscription
import com.rye.models.products.ProductUnsubscribeParams
import java.util.function.Consumer

interface ProductService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProductService

    /** Retrieve product subscription rules. */
    fun listSubscriptions(): ProductListSubscriptionsResponse =
        listSubscriptions(ProductListSubscriptionsParams.none())

    /** @see listSubscriptions */
    fun listSubscriptions(
        params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProductListSubscriptionsResponse

    /** @see listSubscriptions */
    fun listSubscriptions(
        params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none()
    ): ProductListSubscriptionsResponse = listSubscriptions(params, RequestOptions.none())

    /** @see listSubscriptions */
    fun listSubscriptions(requestOptions: RequestOptions): ProductListSubscriptionsResponse =
        listSubscriptions(ProductListSubscriptionsParams.none(), requestOptions)

    /** Lookup a product's information by URL. */
    fun lookup(params: ProductLookupParams): Product = lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: ProductLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Product

    /** Subscribe to product events from a store. */
    fun subscribe(params: ProductSubscribeParams): ProductSubscription =
        subscribe(params, RequestOptions.none())

    /** @see subscribe */
    fun subscribe(
        params: ProductSubscribeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProductSubscription

    /** Unsubscribe from product events from a store. */
    fun unsubscribe(params: ProductUnsubscribeParams): ProductSubscription =
        unsubscribe(params, RequestOptions.none())

    /** @see unsubscribe */
    fun unsubscribe(
        params: ProductUnsubscribeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProductSubscription

    /** A view of [ProductService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProductService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/products/subscriptions`, but is otherwise
         * the same as [ProductService.listSubscriptions].
         */
        @MustBeClosed
        fun listSubscriptions(): HttpResponseFor<ProductListSubscriptionsResponse> =
            listSubscriptions(ProductListSubscriptionsParams.none())

        /** @see listSubscriptions */
        @MustBeClosed
        fun listSubscriptions(
            params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProductListSubscriptionsResponse>

        /** @see listSubscriptions */
        @MustBeClosed
        fun listSubscriptions(
            params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none()
        ): HttpResponseFor<ProductListSubscriptionsResponse> =
            listSubscriptions(params, RequestOptions.none())

        /** @see listSubscriptions */
        @MustBeClosed
        fun listSubscriptions(
            requestOptions: RequestOptions
        ): HttpResponseFor<ProductListSubscriptionsResponse> =
            listSubscriptions(ProductListSubscriptionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/products/lookup`, but is otherwise the same
         * as [ProductService.lookup].
         */
        @MustBeClosed
        fun lookup(params: ProductLookupParams): HttpResponseFor<Product> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: ProductLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Product>

        /**
         * Returns a raw HTTP response for `post /api/v1/products/subscribe`, but is otherwise the
         * same as [ProductService.subscribe].
         */
        @MustBeClosed
        fun subscribe(params: ProductSubscribeParams): HttpResponseFor<ProductSubscription> =
            subscribe(params, RequestOptions.none())

        /** @see subscribe */
        @MustBeClosed
        fun subscribe(
            params: ProductSubscribeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProductSubscription>

        /**
         * Returns a raw HTTP response for `post /api/v1/products/unsubscribe`, but is otherwise the
         * same as [ProductService.unsubscribe].
         */
        @MustBeClosed
        fun unsubscribe(params: ProductUnsubscribeParams): HttpResponseFor<ProductSubscription> =
            unsubscribe(params, RequestOptions.none())

        /** @see unsubscribe */
        @MustBeClosed
        fun unsubscribe(
            params: ProductUnsubscribeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProductSubscription>
    }
}
