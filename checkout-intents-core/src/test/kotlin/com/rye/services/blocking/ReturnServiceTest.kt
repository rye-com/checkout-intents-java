// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.returns.ReturnCreateParams
import com.rye.models.returns.ReturnReason
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ReturnServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val returnService = client.returns()

        val return_ =
            returnService.create(
                ReturnCreateParams.builder()
                    .orderId("orderId")
                    .reason(ReturnReason.DEFECTIVE)
                    .build()
            )

        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val returnService = client.returns()

        val return_ = returnService.retrieve("returnId")

        return_.validate()
    }
}
