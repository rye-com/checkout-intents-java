// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.testhelpers

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.returns.Return
import com.rye.models.testhelpers.returns.ReturnApproveParams
import com.rye.models.testhelpers.returns.ReturnCreateParams
import com.rye.models.testhelpers.returns.ReturnDenyParams
import com.rye.models.testhelpers.returns.ReturnFailParams
import com.rye.models.testhelpers.returns.ReturnRefundParams
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
     * Create a simulated return for an order, then drive it through its lifecycle with the
     * approve/deny/refund/fail helpers below.
     */
    fun create(params: ReturnCreateParams): Return = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ReturnCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return

    /** Approve a simulated return. */
    fun approve(returnId: String): Return = approve(returnId, ReturnApproveParams.none())

    /** @see approve */
    fun approve(
        returnId: String,
        params: ReturnApproveParams = ReturnApproveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return = approve(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see approve */
    fun approve(
        returnId: String,
        params: ReturnApproveParams = ReturnApproveParams.none(),
    ): Return = approve(returnId, params, RequestOptions.none())

    /** @see approve */
    fun approve(
        params: ReturnApproveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return

    /** @see approve */
    fun approve(params: ReturnApproveParams): Return = approve(params, RequestOptions.none())

    /** @see approve */
    fun approve(returnId: String, requestOptions: RequestOptions): Return =
        approve(returnId, ReturnApproveParams.none(), requestOptions)

    /** Deny a simulated return. */
    fun deny(returnId: String): Return = deny(returnId, ReturnDenyParams.none())

    /** @see deny */
    fun deny(
        returnId: String,
        params: ReturnDenyParams = ReturnDenyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return = deny(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see deny */
    fun deny(returnId: String, params: ReturnDenyParams = ReturnDenyParams.none()): Return =
        deny(returnId, params, RequestOptions.none())

    /** @see deny */
    fun deny(
        params: ReturnDenyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return

    /** @see deny */
    fun deny(params: ReturnDenyParams): Return = deny(params, RequestOptions.none())

    /** @see deny */
    fun deny(returnId: String, requestOptions: RequestOptions): Return =
        deny(returnId, ReturnDenyParams.none(), requestOptions)

    /** Mark a simulated return as failed. */
    fun fail(returnId: String): Return = fail(returnId, ReturnFailParams.none())

    /** @see fail */
    fun fail(
        returnId: String,
        params: ReturnFailParams = ReturnFailParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return = fail(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see fail */
    fun fail(returnId: String, params: ReturnFailParams = ReturnFailParams.none()): Return =
        fail(returnId, params, RequestOptions.none())

    /** @see fail */
    fun fail(
        params: ReturnFailParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return

    /** @see fail */
    fun fail(params: ReturnFailParams): Return = fail(params, RequestOptions.none())

    /** @see fail */
    fun fail(returnId: String, requestOptions: RequestOptions): Return =
        fail(returnId, ReturnFailParams.none(), requestOptions)

    /** Refund a simulated return using the order total as the simulated refund amount. */
    fun refund(returnId: String): Return = refund(returnId, ReturnRefundParams.none())

    /** @see refund */
    fun refund(
        returnId: String,
        params: ReturnRefundParams = ReturnRefundParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return = refund(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see refund */
    fun refund(returnId: String, params: ReturnRefundParams = ReturnRefundParams.none()): Return =
        refund(returnId, params, RequestOptions.none())

    /** @see refund */
    fun refund(
        params: ReturnRefundParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Return

    /** @see refund */
    fun refund(params: ReturnRefundParams): Return = refund(params, RequestOptions.none())

    /** @see refund */
    fun refund(returnId: String, requestOptions: RequestOptions): Return =
        refund(returnId, ReturnRefundParams.none(), requestOptions)

    /** A view of [ReturnService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ReturnService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns`, but is otherwise the
         * same as [ReturnService.create].
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
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/approve`,
         * but is otherwise the same as [ReturnService.approve].
         */
        @MustBeClosed
        fun approve(returnId: String): HttpResponseFor<Return> =
            approve(returnId, ReturnApproveParams.none())

        /** @see approve */
        @MustBeClosed
        fun approve(
            returnId: String,
            params: ReturnApproveParams = ReturnApproveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return> =
            approve(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see approve */
        @MustBeClosed
        fun approve(
            returnId: String,
            params: ReturnApproveParams = ReturnApproveParams.none(),
        ): HttpResponseFor<Return> = approve(returnId, params, RequestOptions.none())

        /** @see approve */
        @MustBeClosed
        fun approve(
            params: ReturnApproveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return>

        /** @see approve */
        @MustBeClosed
        fun approve(params: ReturnApproveParams): HttpResponseFor<Return> =
            approve(params, RequestOptions.none())

        /** @see approve */
        @MustBeClosed
        fun approve(returnId: String, requestOptions: RequestOptions): HttpResponseFor<Return> =
            approve(returnId, ReturnApproveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/deny`, but
         * is otherwise the same as [ReturnService.deny].
         */
        @MustBeClosed
        fun deny(returnId: String): HttpResponseFor<Return> =
            deny(returnId, ReturnDenyParams.none())

        /** @see deny */
        @MustBeClosed
        fun deny(
            returnId: String,
            params: ReturnDenyParams = ReturnDenyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return> =
            deny(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see deny */
        @MustBeClosed
        fun deny(
            returnId: String,
            params: ReturnDenyParams = ReturnDenyParams.none(),
        ): HttpResponseFor<Return> = deny(returnId, params, RequestOptions.none())

        /** @see deny */
        @MustBeClosed
        fun deny(
            params: ReturnDenyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return>

        /** @see deny */
        @MustBeClosed
        fun deny(params: ReturnDenyParams): HttpResponseFor<Return> =
            deny(params, RequestOptions.none())

        /** @see deny */
        @MustBeClosed
        fun deny(returnId: String, requestOptions: RequestOptions): HttpResponseFor<Return> =
            deny(returnId, ReturnDenyParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/fail`, but
         * is otherwise the same as [ReturnService.fail].
         */
        @MustBeClosed
        fun fail(returnId: String): HttpResponseFor<Return> =
            fail(returnId, ReturnFailParams.none())

        /** @see fail */
        @MustBeClosed
        fun fail(
            returnId: String,
            params: ReturnFailParams = ReturnFailParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return> =
            fail(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see fail */
        @MustBeClosed
        fun fail(
            returnId: String,
            params: ReturnFailParams = ReturnFailParams.none(),
        ): HttpResponseFor<Return> = fail(returnId, params, RequestOptions.none())

        /** @see fail */
        @MustBeClosed
        fun fail(
            params: ReturnFailParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return>

        /** @see fail */
        @MustBeClosed
        fun fail(params: ReturnFailParams): HttpResponseFor<Return> =
            fail(params, RequestOptions.none())

        /** @see fail */
        @MustBeClosed
        fun fail(returnId: String, requestOptions: RequestOptions): HttpResponseFor<Return> =
            fail(returnId, ReturnFailParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/refund`,
         * but is otherwise the same as [ReturnService.refund].
         */
        @MustBeClosed
        fun refund(returnId: String): HttpResponseFor<Return> =
            refund(returnId, ReturnRefundParams.none())

        /** @see refund */
        @MustBeClosed
        fun refund(
            returnId: String,
            params: ReturnRefundParams = ReturnRefundParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return> =
            refund(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see refund */
        @MustBeClosed
        fun refund(
            returnId: String,
            params: ReturnRefundParams = ReturnRefundParams.none(),
        ): HttpResponseFor<Return> = refund(returnId, params, RequestOptions.none())

        /** @see refund */
        @MustBeClosed
        fun refund(
            params: ReturnRefundParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Return>

        /** @see refund */
        @MustBeClosed
        fun refund(params: ReturnRefundParams): HttpResponseFor<Return> =
            refund(params, RequestOptions.none())

        /** @see refund */
        @MustBeClosed
        fun refund(returnId: String, requestOptions: RequestOptions): HttpResponseFor<Return> =
            refund(returnId, ReturnRefundParams.none(), requestOptions)
    }
}
