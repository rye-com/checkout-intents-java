// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BillingServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun getBalance() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val billingService = client.billing()

        val response = billingService.getBalance()

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listTransactions() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val billingService = client.billing()

        val page = billingService.listTransactions()

        page.response().validate()
    }
}
