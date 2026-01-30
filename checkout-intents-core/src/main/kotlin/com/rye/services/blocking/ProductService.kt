// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.products.Product
import com.rye.models.products.ProductLookupParams
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

    /** Lookup a product's information by URL. */
    fun lookup(params: ProductLookupParams): Product = lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: ProductLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Product

    /** A view of [ProductService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProductService.WithRawResponse

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
    }
}
