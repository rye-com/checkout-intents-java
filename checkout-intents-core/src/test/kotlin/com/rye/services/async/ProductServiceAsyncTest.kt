// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.products.ProductLookupParams
import com.rye.models.products.ProductSubscribeParams
import com.rye.models.products.ProductUnsubscribeParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProductServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun listSubscriptions() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val productServiceAsync = client.products()

        val responseFuture = productServiceAsync.listSubscriptions()

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun lookup() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val productServiceAsync = client.products()

        val productFuture =
            productServiceAsync.lookup(ProductLookupParams.builder().url("url").build())

        val product = productFuture.get()
        product.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun subscribe() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val productServiceAsync = client.products()

        val productSubscriptionFuture =
            productServiceAsync.subscribe(
                ProductSubscribeParams.builder()
                    .type(ProductSubscribeParams.Type.STORE)
                    .url("https://store.com")
                    .build()
            )

        val productSubscription = productSubscriptionFuture.get()
        productSubscription.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun unsubscribe() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val productServiceAsync = client.products()

        val productSubscriptionFuture =
            productServiceAsync.unsubscribe(
                ProductUnsubscribeParams.builder()
                    .type(ProductUnsubscribeParams.Type.STORE)
                    .url("https://store.com")
                    .build()
            )

        val productSubscription = productSubscriptionFuture.get()
        productSubscription.validate()
    }
}
