// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.products.ProductLookupParams
import com.rye.models.products.ProductSubscribeParams
import com.rye.models.products.ProductUnsubscribeParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProductServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun listSubscriptions() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val productService = client.products()

        val response = productService.listSubscriptions()

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun lookup() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val productService = client.products()

        val product = productService.lookup(ProductLookupParams.builder().url("url").build())

        product.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun subscribe() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val productService = client.products()

        val productSubscription =
            productService.subscribe(
                ProductSubscribeParams.builder()
                    .type(ProductSubscribeParams.Type.STORE)
                    .url("https://store.myshopify.com")
                    .build()
            )

        productSubscription.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun unsubscribe() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val productService = client.products()

        val productSubscription =
            productService.unsubscribe(
                ProductUnsubscribeParams.builder()
                    .type(ProductUnsubscribeParams.Type.STORE)
                    .url("https://store.myshopify.com")
                    .build()
            )

        productSubscription.validate()
    }
}
