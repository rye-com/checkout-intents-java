// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.testhelpers

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ShipmentServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun advance() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val shipmentService = client.testHelpers().shipments()

        val response = shipmentService.advance("checkoutIntentId")

        response.validate()
    }
}
