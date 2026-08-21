// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.testhelpers

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ShipmentServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun advance() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val shipmentServiceAsync = client.testHelpers().shipments()

        val responseFuture = shipmentServiceAsync.advance("checkoutIntentId")

        val response = responseFuture.get()
        response.validate()
    }
}
