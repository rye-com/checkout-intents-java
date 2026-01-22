// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.betas

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.betas.CheckoutSession
import com.rye.models.betas.checkoutsessions.CheckoutSessionCreateParams
import java.util.function.Consumer

interface CheckoutSessionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutSessionService

    /**
     * Create a new checkout session.
     *
     * Checkout sessions are hosted checkout forms your shoppers can use to complete their
     * purchases.
     */
    fun create(params: CheckoutSessionCreateParams): CheckoutSession =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CheckoutSessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutSession

    /**
     * A view of [CheckoutSessionService] that provides access to raw HTTP responses for each
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
        ): CheckoutSessionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/betas/checkout-sessions`, but is otherwise
         * the same as [CheckoutSessionService.create].
         */
        @MustBeClosed
        fun create(params: CheckoutSessionCreateParams): HttpResponseFor<CheckoutSession> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CheckoutSessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutSession>
    }
}
