// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.returns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnApproveParamsTest {

    @Test
    fun create() {
        ReturnApproveParams.builder()
            .returnId("returnId")
            .nextAction(ReturnApproveParams.NextAction.SHIP_ITEMS_TO_MERCHANT)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ReturnApproveParams.builder().returnId("returnId").build()

        assertThat(params._pathParam(0)).isEqualTo("returnId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ReturnApproveParams.builder()
                .returnId("returnId")
                .nextAction(ReturnApproveParams.NextAction.SHIP_ITEMS_TO_MERCHANT)
                .build()

        val body = params._body()

        assertThat(body.nextAction())
            .contains(ReturnApproveParams.NextAction.SHIP_ITEMS_TO_MERCHANT)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ReturnApproveParams.builder().returnId("returnId").build()

        val body = params._body()
    }
}
