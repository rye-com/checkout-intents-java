// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.testhelpers

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.returns.Return
import com.rye.models.testhelpers.returns.ReturnApproveParams
import com.rye.models.testhelpers.returns.ReturnCreateParams
import com.rye.models.testhelpers.returns.ReturnDenyParams
import com.rye.models.testhelpers.returns.ReturnFailParams
import com.rye.models.testhelpers.returns.ReturnRefundParams
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
     * Create a simulated return for an order, then drive it through its lifecycle with the
     * approve/deny/refund/fail helpers below.
     */
    fun create(params: ReturnCreateParams): CompletableFuture<Return> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ReturnCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return>

    /** Approve a simulated return. */
    fun approve(returnId: String): CompletableFuture<Return> =
        approve(returnId, ReturnApproveParams.none())

    /** @see approve */
    fun approve(
        returnId: String,
        params: ReturnApproveParams = ReturnApproveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return> =
        approve(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see approve */
    fun approve(
        returnId: String,
        params: ReturnApproveParams = ReturnApproveParams.none(),
    ): CompletableFuture<Return> = approve(returnId, params, RequestOptions.none())

    /** @see approve */
    fun approve(
        params: ReturnApproveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return>

    /** @see approve */
    fun approve(params: ReturnApproveParams): CompletableFuture<Return> =
        approve(params, RequestOptions.none())

    /** @see approve */
    fun approve(returnId: String, requestOptions: RequestOptions): CompletableFuture<Return> =
        approve(returnId, ReturnApproveParams.none(), requestOptions)

    /** Deny a simulated return. */
    fun deny(returnId: String): CompletableFuture<Return> = deny(returnId, ReturnDenyParams.none())

    /** @see deny */
    fun deny(
        returnId: String,
        params: ReturnDenyParams = ReturnDenyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return> =
        deny(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see deny */
    fun deny(
        returnId: String,
        params: ReturnDenyParams = ReturnDenyParams.none(),
    ): CompletableFuture<Return> = deny(returnId, params, RequestOptions.none())

    /** @see deny */
    fun deny(
        params: ReturnDenyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return>

    /** @see deny */
    fun deny(params: ReturnDenyParams): CompletableFuture<Return> =
        deny(params, RequestOptions.none())

    /** @see deny */
    fun deny(returnId: String, requestOptions: RequestOptions): CompletableFuture<Return> =
        deny(returnId, ReturnDenyParams.none(), requestOptions)

    /** Mark a simulated return as failed. */
    fun fail(returnId: String): CompletableFuture<Return> = fail(returnId, ReturnFailParams.none())

    /** @see fail */
    fun fail(
        returnId: String,
        params: ReturnFailParams = ReturnFailParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return> =
        fail(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see fail */
    fun fail(
        returnId: String,
        params: ReturnFailParams = ReturnFailParams.none(),
    ): CompletableFuture<Return> = fail(returnId, params, RequestOptions.none())

    /** @see fail */
    fun fail(
        params: ReturnFailParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return>

    /** @see fail */
    fun fail(params: ReturnFailParams): CompletableFuture<Return> =
        fail(params, RequestOptions.none())

    /** @see fail */
    fun fail(returnId: String, requestOptions: RequestOptions): CompletableFuture<Return> =
        fail(returnId, ReturnFailParams.none(), requestOptions)

    /** Refund a simulated return using the order total as the simulated refund amount. */
    fun refund(returnId: String): CompletableFuture<Return> =
        refund(returnId, ReturnRefundParams.none())

    /** @see refund */
    fun refund(
        returnId: String,
        params: ReturnRefundParams = ReturnRefundParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return> =
        refund(params.toBuilder().returnId(returnId).build(), requestOptions)

    /** @see refund */
    fun refund(
        returnId: String,
        params: ReturnRefundParams = ReturnRefundParams.none(),
    ): CompletableFuture<Return> = refund(returnId, params, RequestOptions.none())

    /** @see refund */
    fun refund(
        params: ReturnRefundParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Return>

    /** @see refund */
    fun refund(params: ReturnRefundParams): CompletableFuture<Return> =
        refund(params, RequestOptions.none())

    /** @see refund */
    fun refund(returnId: String, requestOptions: RequestOptions): CompletableFuture<Return> =
        refund(returnId, ReturnRefundParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns`, but is otherwise the
         * same as [ReturnServiceAsync.create].
         */
        fun create(params: ReturnCreateParams): CompletableFuture<HttpResponseFor<Return>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ReturnCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>>

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/approve`,
         * but is otherwise the same as [ReturnServiceAsync.approve].
         */
        fun approve(returnId: String): CompletableFuture<HttpResponseFor<Return>> =
            approve(returnId, ReturnApproveParams.none())

        /** @see approve */
        fun approve(
            returnId: String,
            params: ReturnApproveParams = ReturnApproveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            approve(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see approve */
        fun approve(
            returnId: String,
            params: ReturnApproveParams = ReturnApproveParams.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            approve(returnId, params, RequestOptions.none())

        /** @see approve */
        fun approve(
            params: ReturnApproveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>>

        /** @see approve */
        fun approve(params: ReturnApproveParams): CompletableFuture<HttpResponseFor<Return>> =
            approve(params, RequestOptions.none())

        /** @see approve */
        fun approve(
            returnId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Return>> =
            approve(returnId, ReturnApproveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/deny`, but
         * is otherwise the same as [ReturnServiceAsync.deny].
         */
        fun deny(returnId: String): CompletableFuture<HttpResponseFor<Return>> =
            deny(returnId, ReturnDenyParams.none())

        /** @see deny */
        fun deny(
            returnId: String,
            params: ReturnDenyParams = ReturnDenyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            deny(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see deny */
        fun deny(
            returnId: String,
            params: ReturnDenyParams = ReturnDenyParams.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            deny(returnId, params, RequestOptions.none())

        /** @see deny */
        fun deny(
            params: ReturnDenyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>>

        /** @see deny */
        fun deny(params: ReturnDenyParams): CompletableFuture<HttpResponseFor<Return>> =
            deny(params, RequestOptions.none())

        /** @see deny */
        fun deny(
            returnId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Return>> =
            deny(returnId, ReturnDenyParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/fail`, but
         * is otherwise the same as [ReturnServiceAsync.fail].
         */
        fun fail(returnId: String): CompletableFuture<HttpResponseFor<Return>> =
            fail(returnId, ReturnFailParams.none())

        /** @see fail */
        fun fail(
            returnId: String,
            params: ReturnFailParams = ReturnFailParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            fail(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see fail */
        fun fail(
            returnId: String,
            params: ReturnFailParams = ReturnFailParams.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            fail(returnId, params, RequestOptions.none())

        /** @see fail */
        fun fail(
            params: ReturnFailParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>>

        /** @see fail */
        fun fail(params: ReturnFailParams): CompletableFuture<HttpResponseFor<Return>> =
            fail(params, RequestOptions.none())

        /** @see fail */
        fun fail(
            returnId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Return>> =
            fail(returnId, ReturnFailParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/test-helpers/returns/{returnId}/refund`,
         * but is otherwise the same as [ReturnServiceAsync.refund].
         */
        fun refund(returnId: String): CompletableFuture<HttpResponseFor<Return>> =
            refund(returnId, ReturnRefundParams.none())

        /** @see refund */
        fun refund(
            returnId: String,
            params: ReturnRefundParams = ReturnRefundParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            refund(params.toBuilder().returnId(returnId).build(), requestOptions)

        /** @see refund */
        fun refund(
            returnId: String,
            params: ReturnRefundParams = ReturnRefundParams.none(),
        ): CompletableFuture<HttpResponseFor<Return>> =
            refund(returnId, params, RequestOptions.none())

        /** @see refund */
        fun refund(
            params: ReturnRefundParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Return>>

        /** @see refund */
        fun refund(params: ReturnRefundParams): CompletableFuture<HttpResponseFor<Return>> =
            refund(params, RequestOptions.none())

        /** @see refund */
        fun refund(
            returnId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Return>> =
            refund(returnId, ReturnRefundParams.none(), requestOptions)
    }
}
