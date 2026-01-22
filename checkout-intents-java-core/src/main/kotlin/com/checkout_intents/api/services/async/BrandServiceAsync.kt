// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.async

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
import com.checkout_intents.api.core.http.HttpResponseFor
import com.checkout_intents.api.models.brands.BrandRetrieveParams
import com.checkout_intents.api.models.brands.BrandRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BrandServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BrandServiceAsync

    /**
     * Retrieve brand information by domain name
     *
     * Look up a brand by its domain name (e.g. "aloyoga.com" or "www.amazon.com"). Returns brand
     * information including the marketplace type if the lookup succeeds.
     */
    fun retrieve(domain: String): CompletableFuture<BrandRetrieveResponse> =
        retrieve(domain, BrandRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        domain: String,
        params: BrandRetrieveParams = BrandRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BrandRetrieveResponse> =
        retrieve(params.toBuilder().domain(domain).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        domain: String,
        params: BrandRetrieveParams = BrandRetrieveParams.none(),
    ): CompletableFuture<BrandRetrieveResponse> = retrieve(domain, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: BrandRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BrandRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: BrandRetrieveParams): CompletableFuture<BrandRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        domain: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<BrandRetrieveResponse> =
        retrieve(domain, BrandRetrieveParams.none(), requestOptions)

    /** A view of [BrandServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BrandServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/brands/domain/{domain}`, but is otherwise
         * the same as [BrandServiceAsync.retrieve].
         */
        fun retrieve(domain: String): CompletableFuture<HttpResponseFor<BrandRetrieveResponse>> =
            retrieve(domain, BrandRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            domain: String,
            params: BrandRetrieveParams = BrandRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BrandRetrieveResponse>> =
            retrieve(params.toBuilder().domain(domain).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            domain: String,
            params: BrandRetrieveParams = BrandRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<BrandRetrieveResponse>> =
            retrieve(domain, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: BrandRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BrandRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: BrandRetrieveParams
        ): CompletableFuture<HttpResponseFor<BrandRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            domain: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BrandRetrieveResponse>> =
            retrieve(domain, BrandRetrieveParams.none(), requestOptions)
    }
}
