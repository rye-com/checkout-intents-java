// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnCreateParamsTest {

    @Test
    fun create() {
        ReturnCreateParams.builder().orderId("orderId").reason(ReturnReason.DEFECTIVE).build()
    }

    @Test
    fun body() {
        val params =
            ReturnCreateParams.builder().orderId("orderId").reason(ReturnReason.DEFECTIVE).build()

        val body = params._body()

        assertThat(body.orderId()).isEqualTo("orderId")
        assertThat(body.reason()).isEqualTo(ReturnReason.DEFECTIVE)
    }
}
