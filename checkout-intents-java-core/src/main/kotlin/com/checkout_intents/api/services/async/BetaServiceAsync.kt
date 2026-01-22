// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.async

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.services.async.betas.CheckoutSessionServiceAsync
import java.util.function.Consumer

interface BetaServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaServiceAsync

    fun checkoutSessions(): CheckoutSessionServiceAsync

    /** A view of [BetaServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaServiceAsync.WithRawResponse

        fun checkoutSessions(): CheckoutSessionServiceAsync.WithRawResponse
    }
}
