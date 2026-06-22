// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.returns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnDenyParamsTest {

    @Test
    fun create() {
        ReturnDenyParams.builder()
            .returnId("returnId")
            .note("note")
            .reason(ReturnDenyParams.Reason.FINAL_SALE)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ReturnDenyParams.builder().returnId("returnId").build()

        assertThat(params._pathParam(0)).isEqualTo("returnId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ReturnDenyParams.builder()
                .returnId("returnId")
                .note("note")
                .reason(ReturnDenyParams.Reason.FINAL_SALE)
                .build()

        val body = params._body()

        assertThat(body.note()).contains("note")
        assertThat(body.reason()).contains(ReturnDenyParams.Reason.FINAL_SALE)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ReturnDenyParams.builder().returnId("returnId").build()

        val body = params._body()
    }
}
