// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.returns.ReturnCreateParams
import com.rye.models.returns.ReturnReason
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ReturnServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val returnServiceAsync = client.returns()

        val returnFuture =
            returnServiceAsync.create(
                ReturnCreateParams.builder()
                    .orderId("orderId")
                    .reason(ReturnReason.DEFECTIVE)
                    .build()
            )

        val return_ = returnFuture.get()
        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val returnServiceAsync = client.returns()

        val returnFuture = returnServiceAsync.retrieve("returnId")

        val return_ = returnFuture.get()
        return_.validate()
    }
}
