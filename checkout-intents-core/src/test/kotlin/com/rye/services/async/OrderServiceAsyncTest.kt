// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.orders.OrderCancelParams
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun cancel() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val orderServiceAsync = client.orders()

        val cancellationFuture =
            orderServiceAsync.cancel(
                OrderCancelParams.builder()
                    .id("id")
                    .reason(
                        OrderCancelParams.Reason.builder()
                            .code(OrderCancelParams.Reason.Code.REQUESTED_BY_CUSTOMER)
                            .message("message")
                            .build()
                    )
                    .build()
            )

        val cancellation = cancellationFuture.get()
        cancellation.validate()
    }
}
