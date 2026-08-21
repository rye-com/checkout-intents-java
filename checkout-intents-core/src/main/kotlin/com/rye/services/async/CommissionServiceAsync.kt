// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.commissions.CommissionListPageAsync
import com.rye.models.commissions.CommissionListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CommissionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommissionServiceAsync

    /**
     * List commissions for the authenticated developer
     *
     * Returns a paginated list of commissions with optional filters using cursor-based pagination.
     * Pass the `endCursor` from a previous response as `after` to fetch the next page, or the
     * `startCursor` as `before` to fetch the previous page. Specifying both `after` and `before`
     * returns 422.
     */
    fun list(): CompletableFuture<CommissionListPageAsync> = list(CommissionListParams.none())

    /** @see list */
    fun list(
        params: CommissionListParams = CommissionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CommissionListPageAsync>

    /** @see list */
    fun list(
        params: CommissionListParams = CommissionListParams.none()
    ): CompletableFuture<CommissionListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<CommissionListPageAsync> =
        list(CommissionListParams.none(), requestOptions)

    /**
     * A view of [CommissionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommissionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/commissions`, but is otherwise the same as
         * [CommissionServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<CommissionListPageAsync>> =
            list(CommissionListParams.none())

        /** @see list */
        fun list(
            params: CommissionListParams = CommissionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CommissionListPageAsync>>

        /** @see list */
        fun list(
            params: CommissionListParams = CommissionListParams.none()
        ): CompletableFuture<HttpResponseFor<CommissionListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CommissionListPageAsync>> =
            list(CommissionListParams.none(), requestOptions)
    }
}
