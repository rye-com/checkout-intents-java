// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking

import com.checkout_intents.api.TestServerExtension
import com.checkout_intents.api.client.okhttp.CheckoutIntentsOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BrandServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val brandService = client.brands()

        val brand = brandService.retrieve("shop.aloyoga.com")

        brand.validate()
    }
}
