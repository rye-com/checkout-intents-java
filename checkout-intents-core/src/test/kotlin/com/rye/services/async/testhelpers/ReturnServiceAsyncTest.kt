// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.testhelpers

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.returns.ReturnReason
import com.rye.models.testhelpers.returns.ReturnApproveParams
import com.rye.models.testhelpers.returns.ReturnCreateParams
import com.rye.models.testhelpers.returns.ReturnDenyParams
import com.rye.models.testhelpers.returns.ReturnFailParams
import com.rye.models.testhelpers.returns.ReturnRefundParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ReturnServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val returnServiceAsync = client.testHelpers().returns()

        val returnFuture =
            returnServiceAsync.create(
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

        val return_ = returnFuture.get()
        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun approve() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val returnServiceAsync = client.testHelpers().returns()

        val returnFuture =
            returnServiceAsync.approve(
                ReturnApproveParams.builder()
                    .returnId("returnId")
                    .nextAction(ReturnApproveParams.NextAction.SHIP_ITEMS_TO_MERCHANT)
                    .build()
            )

        val return_ = returnFuture.get()
        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deny() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val returnServiceAsync = client.testHelpers().returns()

        val returnFuture =
            returnServiceAsync.deny(
                ReturnDenyParams.builder()
                    .returnId("returnId")
                    .note("note")
                    .reason(ReturnDenyParams.Reason.FINAL_SALE)
                    .build()
            )

        val return_ = returnFuture.get()
        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun fail() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val returnServiceAsync = client.testHelpers().returns()

        val returnFuture =
            returnServiceAsync.fail(
                ReturnFailParams.builder().returnId("returnId").note("note").build()
            )

        val return_ = returnFuture.get()
        return_.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun refund() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val returnServiceAsync = client.testHelpers().returns()

        val returnFuture =
            returnServiceAsync.refund(
                ReturnRefundParams.builder()
                    .returnId("returnId")
                    .costBearer(ReturnRefundParams.CostBearer.SHOPPER)
                    .build()
            )

        val return_ = returnFuture.get()
        return_.validate()
    }
}
