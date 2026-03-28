// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.paymentgateways.PaymentGateway
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PaymentGatewayServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun createSession() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val paymentGatewayService = client.paymentGateways()

        val paymentGatewaySession = paymentGatewayService.createSession(PaymentGateway.BASIS_THEORY)

        paymentGatewaySession.validate()
    }
}
