// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.returns.Return
import com.rye.models.returns.ReturnCreateParams
import com.rye.models.returns.ReturnRetrieveParams
import java.util.function.Consumer

interface ReturnService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ReturnService

    /**
     * Create a return for a completed order. Whole-order returns only — the order's line items are
     * enumerated for you. The return is submitted for approval and then progresses asynchronously
     * toward the refund; poll the returned return id (or listen for webhooks) to follow its state.
     */
    fun create(params: ReturnCreateParams): Return = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ReturnCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return

    /** Fetch a Return by id. Tenancy is scoped to the authenticated developer. */
    fun retrieve(returnId: String): Return = retrieve(returnId, ReturnRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        returnId: String,
        params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return = retrieve(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        returnId: String,
        params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
    ): Return = retrieve(returnId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ReturnRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return

    /** @see retrieve */
    fun retrieve(params: ReturnRetrieveParams): Return = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(returnId: String, requestOptions: RequestOptions): Return =
        retrieve(returnId, ReturnRetrieveParams.none(), requestOptions)

    /** A view of [ReturnService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ReturnService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/returns`, but is otherwise the same as
         * [ReturnService.create].
         */
        @MustBeClosed
        fun create(params: ReturnCreateParams): HttpResponseFor<Return> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ReturnCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return>

        /**
         * Returns a raw HTTP response for `get /api/v1/returns/{returnId}`, but is otherwise the
         * same as [ReturnService.retrieve].
         */
        @MustBeClosed
        fun retrieve(returnId: String): HttpResponseFor<Return> =
            retrieve(returnId, ReturnRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            returnId: String,
            params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return> =
            retrieve(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            returnId: String,
            params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
        ): HttpResponseFor<Return> = retrieve(returnId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ReturnRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ReturnRetrieveParams): HttpResponseFor<Return> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(returnId: String, requestOptions: RequestOptions): HttpResponseFor<Return> =
            retrieve(returnId, ReturnRetrieveParams.none(), requestOptions)
    }
}
