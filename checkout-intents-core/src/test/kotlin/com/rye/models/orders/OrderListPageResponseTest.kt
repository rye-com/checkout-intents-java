// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Buyer
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderListPageResponseTest {

    @Test
    fun create() {
        val orderListPageResponse =
            OrderListPageResponse.builder()
                .addData(
                    Order.builder()
                        .id("id")
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .cancellation(
                            Cancellation.RequestedCancellation.builder()
                                .id("id")
                                .checkoutIntentId("checkoutIntentId")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .marketplaceOrderId("marketplaceOrderId")
                                .reason(
                                    Cancellation.RequestedCancellation.Reason.builder()
                                        .code(
                                            Cancellation.RequestedCancellation.Reason.Code
                                                .REQUESTED_BY_CUSTOMER
                                        )
                                        .message("message")
                                        .build()
                                )
                                .state(Cancellation.RequestedCancellation.State.REQUESTED)
                                .build()
                        )
                        .checkoutIntentId("ci_aaa8af5c5aae4c0e8ef0172c26c65c13")
                        .createdAt("2026-03-25T00:00:00Z")
                        .updatedAt("2026-03-27T00:00:00Z")
                        .referenceId("order-1234")
                        .build()
                )
                .pageInfo(
                    OrderListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        assertThat(orderListPageResponse.data())
            .containsExactly(
                Order.builder()
                    .id("id")
                    .buyer(
                        Buyer.builder()
                            .address1("123 Main St")
                            .city("New York")
                            .country("US")
                            .email("john.doe@example.com")
                            .firstName("John")
                            .lastName("Doe")
                            .phone("1234567890")
                            .postalCode("10001")
                            .province("NY")
                            .address2("Apt 1")
                            .build()
                    )
                    .cancellation(
                        Cancellation.RequestedCancellation.builder()
                            .id("id")
                            .checkoutIntentId("checkoutIntentId")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .marketplaceOrderId("marketplaceOrderId")
                            .reason(
                                Cancellation.RequestedCancellation.Reason.builder()
                                    .code(
                                        Cancellation.RequestedCancellation.Reason.Code
                                            .REQUESTED_BY_CUSTOMER
                                    )
                                    .message("message")
                                    .build()
                            )
                            .state(Cancellation.RequestedCancellation.State.REQUESTED)
                            .build()
                    )
                    .checkoutIntentId("ci_aaa8af5c5aae4c0e8ef0172c26c65c13")
                    .createdAt("2026-03-25T00:00:00Z")
                    .updatedAt("2026-03-27T00:00:00Z")
                    .referenceId("order-1234")
                    .build()
            )
        assertThat(orderListPageResponse.pageInfo())
            .isEqualTo(
                OrderListPageResponse.PageInfo.builder()
                    .hasNextPage(true)
                    .hasPreviousPage(true)
                    .endCursor("endCursor")
                    .startCursor("startCursor")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val orderListPageResponse =
            OrderListPageResponse.builder()
                .addData(
                    Order.builder()
                        .id("id")
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .cancellation(
                            Cancellation.RequestedCancellation.builder()
                                .id("id")
                                .checkoutIntentId("checkoutIntentId")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .marketplaceOrderId("marketplaceOrderId")
                                .reason(
                                    Cancellation.RequestedCancellation.Reason.builder()
                                        .code(
                                            Cancellation.RequestedCancellation.Reason.Code
                                                .REQUESTED_BY_CUSTOMER
                                        )
                                        .message("message")
                                        .build()
                                )
                                .state(Cancellation.RequestedCancellation.State.REQUESTED)
                                .build()
                        )
                        .checkoutIntentId("ci_aaa8af5c5aae4c0e8ef0172c26c65c13")
                        .createdAt("2026-03-25T00:00:00Z")
                        .updatedAt("2026-03-27T00:00:00Z")
                        .referenceId("order-1234")
                        .build()
                )
                .pageInfo(
                    OrderListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        val roundtrippedOrderListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(orderListPageResponse),
                jacksonTypeRef<OrderListPageResponse>(),
            )

        assertThat(roundtrippedOrderListPageResponse).isEqualTo(orderListPageResponse)
    }
}
