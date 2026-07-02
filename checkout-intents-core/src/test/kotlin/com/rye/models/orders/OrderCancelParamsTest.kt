// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderCancelParamsTest {

    @Test
    fun create() {
        OrderCancelParams.builder()
            .id("id")
            .reason(
                OrderCancelParams.Reason.builder()
                    .code(OrderCancelParams.Reason.Code.REQUESTED_BY_CUSTOMER)
                    .message("message")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrderCancelParams.builder()
                .id("id")
                .reason(
                    OrderCancelParams.Reason.builder()
                        .code(OrderCancelParams.Reason.Code.REQUESTED_BY_CUSTOMER)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            OrderCancelParams.builder()
                .id("id")
                .reason(
                    OrderCancelParams.Reason.builder()
                        .code(OrderCancelParams.Reason.Code.REQUESTED_BY_CUSTOMER)
                        .message("message")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.reason())
            .isEqualTo(
                OrderCancelParams.Reason.builder()
                    .code(OrderCancelParams.Reason.Code.REQUESTED_BY_CUSTOMER)
                    .message("message")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OrderCancelParams.builder()
                .id("id")
                .reason(
                    OrderCancelParams.Reason.builder()
                        .code(OrderCancelParams.Reason.Code.REQUESTED_BY_CUSTOMER)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.reason())
            .isEqualTo(
                OrderCancelParams.Reason.builder()
                    .code(OrderCancelParams.Reason.Code.REQUESTED_BY_CUSTOMER)
                    .build()
            )
    }
}
