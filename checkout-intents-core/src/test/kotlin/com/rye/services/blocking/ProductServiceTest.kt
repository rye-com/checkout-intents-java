// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.products.ProductLookupParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProductServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun lookup() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val productService = client.products()

        val product = productService.lookup(ProductLookupParams.builder().url("url").build())

        product.validate()
    }
}
