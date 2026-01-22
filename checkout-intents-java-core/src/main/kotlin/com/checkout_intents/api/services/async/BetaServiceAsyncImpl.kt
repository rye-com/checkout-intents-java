// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.async

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.services.async.betas.CheckoutSessionServiceAsync
import com.checkout_intents.api.services.async.betas.CheckoutSessionServiceAsyncImpl
import java.util.function.Consumer

class BetaServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BetaServiceAsync {

    private val withRawResponse: BetaServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val checkoutSessions: CheckoutSessionServiceAsync by lazy {
        CheckoutSessionServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): BetaServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaServiceAsync =
        BetaServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun checkoutSessions(): CheckoutSessionServiceAsync = checkoutSessions

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaServiceAsync.WithRawResponse {

        private val checkoutSessions: CheckoutSessionServiceAsync.WithRawResponse by lazy {
            CheckoutSessionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BetaServiceAsync.WithRawResponse =
            BetaServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun checkoutSessions(): CheckoutSessionServiceAsync.WithRawResponse =
            checkoutSessions
    }
}
