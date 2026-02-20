// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ShipmentServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val shipmentService = client.shipments()

        val shipment = shipmentService.retrieve("id")

        shipment.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val shipmentService = client.shipments()

        val page = shipmentService.list()

        page.response().validate()
    }
}
