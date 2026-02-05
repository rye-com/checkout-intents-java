// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.checkoutintents

import com.rye.TestServerExtension
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ShipmentServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val shipmentService = client.checkoutIntents().shipments()

        val page = shipmentService.list("id")

        page.response().validate()
    }
}
