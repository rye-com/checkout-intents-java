// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BrandServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val brandService = client.brands()

        val brand = brandService.retrieve("shop.aloyoga.com")

        brand.validate()
    }
}
