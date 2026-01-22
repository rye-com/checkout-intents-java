// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.async

import com.checkout_intents.api.TestServerExtension
import com.checkout_intents.api.client.okhttp.CheckoutIntentsOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BrandServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val brandServiceAsync = client.brands()

        val brandFuture = brandServiceAsync.retrieve("shop.aloyoga.com")

        val brand = brandFuture.get()
        brand.validate()
    }
}
