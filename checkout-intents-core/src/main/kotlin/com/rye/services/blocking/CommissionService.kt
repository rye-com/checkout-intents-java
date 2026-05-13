// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.commissions.CommissionListPage
import com.rye.models.commissions.CommissionListParams
import java.util.function.Consumer

interface CommissionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommissionService

    /**
     * List commissions for the authenticated developer
     *
     * Returns a paginated list of commissions with optional filters using cursor-based pagination.
     * Pass the `endCursor` from a previous response as `after` to fetch the next page, or the
     * `startCursor` as `before` to fetch the previous page. Specifying both `after` and `before`
     * returns 422.
     */
    fun list(): CommissionListPage = list(CommissionListParams.none())

    /** @see list */
    fun list(
        params: CommissionListParams = CommissionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CommissionListPage

    /** @see list */
    fun list(params: CommissionListParams = CommissionListParams.none()): CommissionListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CommissionListPage =
        list(CommissionListParams.none(), requestOptions)

    /** A view of [CommissionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommissionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/commissions`, but is otherwise the same as
         * [CommissionService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<CommissionListPage> = list(CommissionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CommissionListParams = CommissionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CommissionListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: CommissionListParams = CommissionListParams.none()
        ): HttpResponseFor<CommissionListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<CommissionListPage> =
            list(CommissionListParams.none(), requestOptions)
    }
}
