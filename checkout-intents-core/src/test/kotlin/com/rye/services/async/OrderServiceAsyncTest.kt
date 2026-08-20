// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.orders.OrderCancelParams
import com.rye.models.orders.OrderUpdateBuyerParams
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateBuyer() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val orderServiceAsync = client.orders()

        val orderFuture =
            orderServiceAsync.updateBuyer(
                OrderUpdateBuyerParams.builder()
                    .id("id")
                    .buyer(
                        OrderUpdateBuyerParams.Buyer.builder()
                            .address1("123 Main St")
                            .address2("Apt 1")
                            .city("New York")
                            .country("US")
                            .email("john.doe@example.com")
                            .firstName("John")
                            .lastName("Doe")
                            .phone("1234567890")
                            .postalCode("10001")
                            .province("NY")
                            .build()
                    )
                    .build()
            )

        val order = orderFuture.get()
        order.validate()
    }
}
