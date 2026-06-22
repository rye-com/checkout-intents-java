// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.returns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnRefundParamsTest {

    @Test
    fun create() {
        ReturnRefundParams.builder()
            .returnId("returnId")
            .costBearer(ReturnRefundParams.CostBearer.SHOPPER)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ReturnRefundParams.builder().returnId("returnId").build()

        assertThat(params._pathParam(0)).isEqualTo("returnId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ReturnRefundParams.builder()
                .returnId("returnId")
                .costBearer(ReturnRefundParams.CostBearer.SHOPPER)
                .build()

        val body = params._body()

        assertThat(body.costBearer()).contains(ReturnRefundParams.CostBearer.SHOPPER)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ReturnRefundParams.builder().returnId("returnId").build()

        val body = params._body()
    }
}
