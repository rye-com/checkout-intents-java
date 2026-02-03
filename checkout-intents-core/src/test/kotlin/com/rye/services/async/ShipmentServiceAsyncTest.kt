// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.TestServerExtension
import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ShipmentServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val shipmentServiceAsync = client.shipments()

        val shipmentFuture = shipmentServiceAsync.retrieve("id")

        val shipment = shipmentFuture.get()
        shipment.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val shipmentServiceAsync = client.shipments()

        val pageFuture = shipmentServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }
}
