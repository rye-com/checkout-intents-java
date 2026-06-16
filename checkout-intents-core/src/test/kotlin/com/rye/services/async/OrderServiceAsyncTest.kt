// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val orderServiceAsync = client.orders()

        val orderFuture = orderServiceAsync.retrieve("id")

        val order = orderFuture.get()
        order.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val orderServiceAsync = client.orders()

        val pageFuture = orderServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }
}
