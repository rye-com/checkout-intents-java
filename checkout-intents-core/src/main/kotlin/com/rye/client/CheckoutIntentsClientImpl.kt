// File generated from our OpenAPI spec by Stainless.

package com.rye.client

import com.rye.core.ClientOptions
import com.rye.core.getPackageVersion
import com.rye.services.blocking.BetaService
import com.rye.services.blocking.BetaServiceImpl
import com.rye.services.blocking.BrandService
import com.rye.services.blocking.BrandServiceImpl
import com.rye.services.blocking.CheckoutIntentService
import com.rye.services.blocking.CheckoutIntentServiceImpl
import com.rye.services.blocking.ProductService
import com.rye.services.blocking.ProductServiceImpl
import java.util.function.Consumer

class CheckoutIntentsClientImpl(private val clientOptions: ClientOptions) : CheckoutIntentsClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: CheckoutIntentsClientAsync by lazy {
        CheckoutIntentsClientAsyncImpl(clientOptions)
    }

    private val withRawResponse: CheckoutIntentsClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val checkoutIntents: CheckoutIntentService by lazy {
        CheckoutIntentServiceImpl(clientOptionsWithUserAgent)
    }

    private val betas: BetaService by lazy { BetaServiceImpl(clientOptionsWithUserAgent) }

    private val brands: BrandService by lazy { BrandServiceImpl(clientOptionsWithUserAgent) }

    private val products: ProductService by lazy { ProductServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): CheckoutIntentsClientAsync = async

    override fun withRawResponse(): CheckoutIntentsClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutIntentsClient =
        CheckoutIntentsClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun checkoutIntents(): CheckoutIntentService = checkoutIntents

    override fun betas(): BetaService = betas

    override fun brands(): BrandService = brands

    override fun products(): ProductService = products

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckoutIntentsClient.WithRawResponse {

        private val checkoutIntents: CheckoutIntentService.WithRawResponse by lazy {
            CheckoutIntentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val betas: BetaService.WithRawResponse by lazy {
            BetaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val brands: BrandService.WithRawResponse by lazy {
            BrandServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val products: ProductService.WithRawResponse by lazy {
            ProductServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutIntentsClient.WithRawResponse =
            CheckoutIntentsClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun checkoutIntents(): CheckoutIntentService.WithRawResponse = checkoutIntents

        override fun betas(): BetaService.WithRawResponse = betas

        override fun brands(): BrandService.WithRawResponse = brands

        override fun products(): ProductService.WithRawResponse = products
    }
}
