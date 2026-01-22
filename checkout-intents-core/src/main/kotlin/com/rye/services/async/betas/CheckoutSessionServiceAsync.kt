// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.betas

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.betas.CheckoutSession
import com.rye.models.betas.checkoutsessions.CheckoutSessionCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CheckoutSessionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutSessionServiceAsync

    /**
     * Create a new checkout session.
     *
     * Checkout sessions are hosted checkout forms your shoppers can use to complete their
     * purchases.
     */
    fun create(params: CheckoutSessionCreateParams): CompletableFuture<CheckoutSession> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CheckoutSessionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutSession>

    /**
     * A view of [CheckoutSessionServiceAsync] that provides access to raw HTTP responses for each
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
        ): CheckoutSessionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/betas/checkout-sessions`, but is otherwise
         * the same as [CheckoutSessionServiceAsync.create].
         */
        fun create(
            params: CheckoutSessionCreateParams
        ): CompletableFuture<HttpResponseFor<CheckoutSession>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CheckoutSessionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutSession>>
    }
}
