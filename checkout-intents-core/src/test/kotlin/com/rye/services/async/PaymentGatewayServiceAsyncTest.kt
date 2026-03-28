// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.paymentgateways.PaymentGateway
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PaymentGatewayServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun createSession() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val paymentGatewayServiceAsync = client.paymentGateways()

        val paymentGatewaySessionFuture =
            paymentGatewayServiceAsync.createSession(PaymentGateway.BASIS_THEORY)

        val paymentGatewaySession = paymentGatewaySessionFuture.get()
        paymentGatewaySession.validate()
    }
}
