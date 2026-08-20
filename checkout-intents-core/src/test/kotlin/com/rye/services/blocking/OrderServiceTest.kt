// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.orders.OrderCancelParams
import com.rye.models.orders.OrderUpdateBuyerParams
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

    @Disabled("Mock server tests are disabled")
    @Test
    fun cancel() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val orderService = client.orders()

        val cancellation =
            orderService.cancel(
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

        cancellation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateBuyer() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val orderService = client.orders()

        val order =
            orderService.updateBuyer(
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

        order.validate()
    }
}
