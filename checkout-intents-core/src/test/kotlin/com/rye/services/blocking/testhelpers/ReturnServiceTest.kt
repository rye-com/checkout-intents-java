// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.testhelpers

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.returns.ReturnReason
import com.rye.models.testhelpers.returns.ReturnApproveParams
import com.rye.models.testhelpers.returns.ReturnCreateParams
import com.rye.models.testhelpers.returns.ReturnDenyParams
import com.rye.models.testhelpers.returns.ReturnFailParams
import com.rye.models.testhelpers.returns.ReturnRefundParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ReturnServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val returnService = client.testHelpers().returns()

        val return_ =
            returnService.create(
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
            )

        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun approve() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val returnService = client.testHelpers().returns()

        val return_ =
            returnService.approve(
                ReturnApproveParams.builder()
                    .returnId("returnId")
                    .nextAction(ReturnApproveParams.NextAction.SHIP_ITEMS_TO_MERCHANT)
                    .build()
            )

        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deny() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val returnService = client.testHelpers().returns()

        val return_ =
            returnService.deny(
                ReturnDenyParams.builder()
                    .returnId("returnId")
                    .note("note")
                    .reason(ReturnDenyParams.Reason.FINAL_SALE)
                    .build()
            )

        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun fail() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val returnService = client.testHelpers().returns()

        val return_ =
            returnService.fail(ReturnFailParams.builder().returnId("returnId").note("note").build())

        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun refund() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val returnService = client.testHelpers().returns()

        val return_ =
            returnService.refund(
                ReturnRefundParams.builder()
                    .returnId("returnId")
                    .costBearer(ReturnRefundParams.CostBearer.SHOPPER)
                    .build()
            )

        return_.validate()
    }
}
