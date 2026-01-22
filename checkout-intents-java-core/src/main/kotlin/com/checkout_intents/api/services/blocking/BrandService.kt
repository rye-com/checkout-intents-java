// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
import com.checkout_intents.api.core.http.HttpResponseFor
import com.checkout_intents.api.models.brands.BrandRetrieveParams
import com.checkout_intents.api.models.brands.BrandRetrieveResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface BrandService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BrandService

    /**
     * Retrieve brand information by domain name
     *
     * Look up a brand by its domain name (e.g. "aloyoga.com" or "www.amazon.com"). Returns brand
     * information including the marketplace type if the lookup succeeds.
     */
    fun retrieve(domain: String): BrandRetrieveResponse =
        retrieve(domain, BrandRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        domain: String,
        params: BrandRetrieveParams = BrandRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandRetrieveResponse = retrieve(params.toBuilder().domain(domain).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        domain: String,
        params: BrandRetrieveParams = BrandRetrieveParams.none(),
    ): BrandRetrieveResponse = retrieve(domain, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: BrandRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: BrandRetrieveParams): BrandRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(domain: String, requestOptions: RequestOptions): BrandRetrieveResponse =
        retrieve(domain, BrandRetrieveParams.none(), requestOptions)

    /** A view of [BrandService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BrandService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/brands/domain/{domain}`, but is otherwise
         * the same as [BrandService.retrieve].
         */
        @MustBeClosed
        fun retrieve(domain: String): HttpResponseFor<BrandRetrieveResponse> =
            retrieve(domain, BrandRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            domain: String,
            params: BrandRetrieveParams = BrandRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandRetrieveResponse> =
            retrieve(params.toBuilder().domain(domain).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            domain: String,
            params: BrandRetrieveParams = BrandRetrieveParams.none(),
        ): HttpResponseFor<BrandRetrieveResponse> = retrieve(domain, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: BrandRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: BrandRetrieveParams): HttpResponseFor<BrandRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            domain: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandRetrieveResponse> =
            retrieve(domain, BrandRetrieveParams.none(), requestOptions)
    }
}
