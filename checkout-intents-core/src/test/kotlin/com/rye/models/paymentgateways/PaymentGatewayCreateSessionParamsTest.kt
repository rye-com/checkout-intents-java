// File generated from our OpenAPI spec by Stainless.

package com.rye.models.paymentgateways

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaymentGatewayCreateSessionParamsTest {

    @Test
    fun create() {
        PaymentGatewayCreateSessionParams.builder().gateway(PaymentGateway.BASIS_THEORY).build()
    }

    @Test
    fun pathParams() {
        val params =
            PaymentGatewayCreateSessionParams.builder().gateway(PaymentGateway.BASIS_THEORY).build()

        assertThat(params._pathParam(0)).isEqualTo("basis-theory")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
