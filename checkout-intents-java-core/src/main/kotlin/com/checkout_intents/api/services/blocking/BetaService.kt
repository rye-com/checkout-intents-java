// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.services.blocking.betas.CheckoutSessionService
import java.util.function.Consumer

interface BetaService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService

    fun checkoutSessions(): CheckoutSessionService

    /** A view of [BetaService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService.WithRawResponse

        fun checkoutSessions(): CheckoutSessionService.WithRawResponse
    }
}
