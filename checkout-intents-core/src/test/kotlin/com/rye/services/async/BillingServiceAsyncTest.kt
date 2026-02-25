// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BillingServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun getBalance() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val billingServiceAsync = client.billing()

        val responseFuture = billingServiceAsync.getBalance()

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listTransactions() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val billingServiceAsync = client.billing()

        val pageFuture = billingServiceAsync.listTransactions()

        val page = pageFuture.get()
        page.response().validate()
    }
}
