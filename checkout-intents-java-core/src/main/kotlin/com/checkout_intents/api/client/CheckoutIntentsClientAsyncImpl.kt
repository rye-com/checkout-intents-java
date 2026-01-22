// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.client

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.getPackageVersion
import com.checkout_intents.api.services.async.BetaServiceAsync
import com.checkout_intents.api.services.async.BetaServiceAsyncImpl
import com.checkout_intents.api.services.async.BrandServiceAsync
import com.checkout_intents.api.services.async.BrandServiceAsyncImpl
import com.checkout_intents.api.services.async.CheckoutIntentServiceAsync
import com.checkout_intents.api.services.async.CheckoutIntentServiceAsyncImpl
import java.util.function.Consumer

class CheckoutIntentsClientAsyncImpl(private val clientOptions: ClientOptions) :
    CheckoutIntentsClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: CheckoutIntentsClient by lazy { CheckoutIntentsClientImpl(clientOptions) }

    private val withRawResponse: CheckoutIntentsClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val checkoutIntents: CheckoutIntentServiceAsync by lazy {
        CheckoutIntentServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val betas: BetaServiceAsync by lazy { BetaServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val brands: BrandServiceAsync by lazy {
        BrandServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): CheckoutIntentsClient = sync

    override fun withRawResponse(): CheckoutIntentsClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): CheckoutIntentsClientAsync =
        CheckoutIntentsClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun checkoutIntents(): CheckoutIntentServiceAsync = checkoutIntents

    override fun betas(): BetaServiceAsync = betas

    override fun brands(): BrandServiceAsync = brands

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckoutIntentsClientAsync.WithRawResponse {

        private val checkoutIntents: CheckoutIntentServiceAsync.WithRawResponse by lazy {
            CheckoutIntentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val betas: BetaServiceAsync.WithRawResponse by lazy {
            BetaServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val brands: BrandServiceAsync.WithRawResponse by lazy {
            BrandServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutIntentsClientAsync.WithRawResponse =
            CheckoutIntentsClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun checkoutIntents(): CheckoutIntentServiceAsync.WithRawResponse = checkoutIntents

        override fun betas(): BetaServiceAsync.WithRawResponse = betas

        override fun brands(): BrandServiceAsync.WithRawResponse = brands
    }
}
