// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val orderService = client.orders()

        val order = orderService.retrieve("id")

        order.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val orderService = client.orders()

        val page = orderService.list()

        page.response().validate()
    }
}
