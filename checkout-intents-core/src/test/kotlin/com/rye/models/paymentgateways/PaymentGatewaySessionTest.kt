// File generated from our OpenAPI spec by Stainless.

package com.rye.models.paymentgateways

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaymentGatewaySessionTest {

    @Test
    fun create() {
        val paymentGatewaySession =
            PaymentGatewaySession.builder()
                .container("container")
                .gateway(PaymentGatewaySession.Gateway.BASIS_THEORY)
                .sessionKey("sessionKey")
                .build()

        assertThat(paymentGatewaySession.container()).isEqualTo("container")
        assertThat(paymentGatewaySession.gateway())
            .isEqualTo(PaymentGatewaySession.Gateway.BASIS_THEORY)
        assertThat(paymentGatewaySession.sessionKey()).isEqualTo("sessionKey")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paymentGatewaySession =
            PaymentGatewaySession.builder()
                .container("container")
                .gateway(PaymentGatewaySession.Gateway.BASIS_THEORY)
                .sessionKey("sessionKey")
                .build()

        val roundtrippedPaymentGatewaySession =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paymentGatewaySession),
                jacksonTypeRef<PaymentGatewaySession>(),
            )

        assertThat(roundtrippedPaymentGatewaySession).isEqualTo(paymentGatewaySession)
    }
}
