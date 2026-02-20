// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BrandServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val brandServiceAsync = client.brands()

        val brandFuture = brandServiceAsync.retrieve("shop.aloyoga.com")

        val brand = brandFuture.get()
        brand.validate()
    }
}
