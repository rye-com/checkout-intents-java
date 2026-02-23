// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.checkoutintents

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ShipmentServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val shipmentServiceAsync = client.checkoutIntents().shipments()

        val pageFuture = shipmentServiceAsync.list("id")

        val page = pageFuture.get()
        page.response().validate()
    }
}
