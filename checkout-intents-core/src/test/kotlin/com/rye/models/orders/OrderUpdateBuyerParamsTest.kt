// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderUpdateBuyerParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params =
            OrderUpdateBuyerParams.builder()
                .id("id")
                .buyer(OrderUpdateBuyerParams.Buyer.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.buyer())
            .isEqualTo(
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OrderUpdateBuyerParams.builder()
                .id("id")
                .buyer(OrderUpdateBuyerParams.Buyer.builder().build())
                .build()

        val body = params._body()

        assertThat(body.buyer()).isEqualTo(OrderUpdateBuyerParams.Buyer.builder().build())
    }
}
