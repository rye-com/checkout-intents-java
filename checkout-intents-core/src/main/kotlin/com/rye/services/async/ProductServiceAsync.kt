// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.products.Product
import com.rye.models.products.ProductLookupParams
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

    /** Retrieve a product's information by URL. */
    fun lookup(params: ProductLookupParams): CompletableFuture<Product> =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: ProductLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Product>

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
    }
}
