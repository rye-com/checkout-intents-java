// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.returns.Return
import com.rye.models.returns.ReturnCreateParams
import com.rye.models.returns.ReturnRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ReturnServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ReturnServiceAsync

    /**
     * Create a return for a completed order. Whole-order returns only — the order's line items are
     * enumerated for you. The return is submitted for approval and then progresses asynchronously
     * toward the refund; poll the returned return id (or listen for webhooks) to follow its state.
     */
    fun create(params: ReturnCreateParams): CompletableFuture<Return> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ReturnCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return>

    /** Fetch a Return by id. Tenancy is scoped to the authenticated developer. */
    fun retrieve(returnId: String): CompletableFuture<Return> =
        retrieve(returnId, ReturnRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        returnId: String,
        params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return> =
        retrieve(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        returnId: String,
        params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
    ): CompletableFuture<Return> = retrieve(returnId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ReturnRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return>

    /** @see retrieve */
    fun retrieve(params: ReturnRetrieveParams): CompletableFuture<Return> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(returnId: String, requestOptions: RequestOptions): CompletableFuture<Return> =
        retrieve(returnId, ReturnRetrieveParams.none(), requestOptions)

    /**
     * A view of [ReturnServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ReturnServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/returns`, but is otherwise the same as
         * [ReturnServiceAsync.create].
         */
        fun create(params: ReturnCreateParams): CompletableFuture<HttpResponseFor<Return>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ReturnCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>>

        /**
         * Returns a raw HTTP response for `get /api/v1/returns/{returnId}`, but is otherwise the
         * same as [ReturnServiceAsync.retrieve].
         */
        fun retrieve(returnId: String): CompletableFuture<HttpResponseFor<Return>> =
            retrieve(returnId, ReturnRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            returnId: String,
            params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            retrieve(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            returnId: String,
            params: ReturnRetrieveParams = ReturnRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            retrieve(returnId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ReturnRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>>

        /** @see retrieve */
        fun retrieve(params: ReturnRetrieveParams): CompletableFuture<HttpResponseFor<Return>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            returnId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Return>> =
            retrieve(returnId, ReturnRetrieveParams.none(), requestOptions)
    }
}
