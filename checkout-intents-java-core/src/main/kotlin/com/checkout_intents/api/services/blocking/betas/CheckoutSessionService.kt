// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking.betas

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
import com.checkout_intents.api.core.http.HttpResponseFor
import com.checkout_intents.api.models.betas.CheckoutSession
import com.checkout_intents.api.models.betas.checkoutsessions.CheckoutSessionCreateParams
import com.google.errorprone.annotations.MustBeClosed
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
