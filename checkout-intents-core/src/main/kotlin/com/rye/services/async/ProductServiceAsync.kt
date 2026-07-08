// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ProductServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProductServiceAsync

    /** Retrieve product subscription rules. */
    fun listSubscriptions(): CompletableFuture<ProductListSubscriptionsResponse> =
        listSubscriptions(ProductListSubscriptionsParams.none())

    /** @see listSubscriptions */
    fun listSubscriptions(
        params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProductListSubscriptionsResponse>

    /** @see listSubscriptions */
    fun listSubscriptions(
        params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none()
    ): CompletableFuture<ProductListSubscriptionsResponse> =
        listSubscriptions(params, RequestOptions.none())

    /** @see listSubscriptions */
    fun listSubscriptions(
        requestOptions: RequestOptions
    ): CompletableFuture<ProductListSubscriptionsResponse> =
        listSubscriptions(ProductListSubscriptionsParams.none(), requestOptions)

    /** Lookup a product's information by URL. */
    fun lookup(params: ProductLookupParams): CompletableFuture<Product> =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: ProductLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Product>

    /** Subscribe to product events for one integrated Shopify URL. */
    fun subscribe(params: ProductSubscribeParams): CompletableFuture<ProductSubscription> =
        subscribe(params, RequestOptions.none())

    /** @see subscribe */
    fun subscribe(
        params: ProductSubscribeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProductSubscription>

    /** Unsubscribe from product events for one integrated Shopify URL. */
    fun unsubscribe(params: ProductUnsubscribeParams): CompletableFuture<ProductSubscription> =
        unsubscribe(params, RequestOptions.none())

    /** @see unsubscribe */
    fun unsubscribe(
        params: ProductUnsubscribeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProductSubscription>

    /**
     * A view of [ProductServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProductServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/products/subscriptions`, but is otherwise
         * the same as [ProductServiceAsync.listSubscriptions].
         */
        fun listSubscriptions():
            CompletableFuture<HttpResponseFor<ProductListSubscriptionsResponse>> =
            listSubscriptions(ProductListSubscriptionsParams.none())

        /** @see listSubscriptions */
        fun listSubscriptions(
            params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProductListSubscriptionsResponse>>

        /** @see listSubscriptions */
        fun listSubscriptions(
            params: ProductListSubscriptionsParams = ProductListSubscriptionsParams.none()
        ): CompletableFuture<HttpResponseFor<ProductListSubscriptionsResponse>> =
            listSubscriptions(params, RequestOptions.none())

        /** @see listSubscriptions */
        fun listSubscriptions(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ProductListSubscriptionsResponse>> =
            listSubscriptions(ProductListSubscriptionsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/products/lookup`, but is otherwise the same
         * as [ProductServiceAsync.lookup].
         */
        fun lookup(params: ProductLookupParams): CompletableFuture<HttpResponseFor<Product>> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        fun lookup(
            params: ProductLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Product>>

        /**
         * Returns a raw HTTP response for `post /api/v1/products/subscribe`, but is otherwise the
         * same as [ProductServiceAsync.subscribe].
         */
        fun subscribe(
            params: ProductSubscribeParams
        ): CompletableFuture<HttpResponseFor<ProductSubscription>> =
            subscribe(params, RequestOptions.none())

        /** @see subscribe */
        fun subscribe(
            params: ProductSubscribeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProductSubscription>>

        /**
         * Returns a raw HTTP response for `post /api/v1/products/unsubscribe`, but is otherwise the
         * same as [ProductServiceAsync.unsubscribe].
         */
        fun unsubscribe(
            params: ProductUnsubscribeParams
        ): CompletableFuture<HttpResponseFor<ProductSubscription>> =
            unsubscribe(params, RequestOptions.none())

        /** @see unsubscribe */
        fun unsubscribe(
            params: ProductUnsubscribeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProductSubscription>>
    }
}
