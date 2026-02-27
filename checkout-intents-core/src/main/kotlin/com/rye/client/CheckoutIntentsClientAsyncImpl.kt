// File generated from our OpenAPI spec by Stainless.

package com.rye.client

import com.rye.core.ClientOptions
import com.rye.core.getPackageVersion
import com.rye.services.async.BetaServiceAsync
import com.rye.services.async.BetaServiceAsyncImpl
import com.rye.services.async.BillingServiceAsync
import com.rye.services.async.BillingServiceAsyncImpl
import com.rye.services.async.BrandServiceAsync
import com.rye.services.async.BrandServiceAsyncImpl
import com.rye.services.async.CheckoutIntentServiceAsync
import com.rye.services.async.CheckoutIntentServiceAsyncImpl
import com.rye.services.async.ProductServiceAsync
import com.rye.services.async.ProductServiceAsyncImpl
import com.rye.services.async.ShipmentServiceAsync
import com.rye.services.async.ShipmentServiceAsyncImpl
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

    private val products: ProductServiceAsync by lazy {
        ProductServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val shipments: ShipmentServiceAsync by lazy {
        ShipmentServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val billing: BillingServiceAsync by lazy {
        BillingServiceAsyncImpl(clientOptionsWithUserAgent)
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

    override fun products(): ProductServiceAsync = products

    override fun shipments(): ShipmentServiceAsync = shipments

    override fun billing(): BillingServiceAsync = billing

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

        private val products: ProductServiceAsync.WithRawResponse by lazy {
            ProductServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val shipments: ShipmentServiceAsync.WithRawResponse by lazy {
            ShipmentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val billing: BillingServiceAsync.WithRawResponse by lazy {
            BillingServiceAsyncImpl.WithRawResponseImpl(clientOptions)
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

        override fun products(): ProductServiceAsync.WithRawResponse = products

        override fun shipments(): ShipmentServiceAsync.WithRawResponse = shipments

        override fun billing(): BillingServiceAsync.WithRawResponse = billing
    }
}
