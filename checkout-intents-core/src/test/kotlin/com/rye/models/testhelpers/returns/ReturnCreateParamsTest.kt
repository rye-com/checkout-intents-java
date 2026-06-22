// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.returns

import com.rye.models.returns.ReturnReason
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnCreateParamsTest {

    @Test
    fun create() {
        ReturnCreateParams.builder()
            .orderId("orderId")
            .addLineItem(
                ReturnCreateParams.LineItem.builder()
                    .orderLineItemId("orderLineItemId")
                    .quantity(1)
                    .build()
            )
            .reason(ReturnReason.DEFECTIVE)
            .build()
    }

    @Test
    fun body() {
        val params =
            ReturnCreateParams.builder()
                .orderId("orderId")
                .addLineItem(
                    ReturnCreateParams.LineItem.builder()
                        .orderLineItemId("orderLineItemId")
                        .quantity(1)
                        .build()
                )
                .reason(ReturnReason.DEFECTIVE)
                .build()

        val body = params._body()

        assertThat(body.orderId()).isEqualTo("orderId")
        assertThat(body.lineItems().getOrNull())
            .containsExactly(
                ReturnCreateParams.LineItem.builder()
                    .orderLineItemId("orderLineItemId")
                    .quantity(1)
                    .build()
            )
        assertThat(body.reason()).contains(ReturnReason.DEFECTIVE)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ReturnCreateParams.builder().orderId("orderId").build()

        val body = params._body()

        assertThat(body.orderId()).isEqualTo("orderId")
    }
}
