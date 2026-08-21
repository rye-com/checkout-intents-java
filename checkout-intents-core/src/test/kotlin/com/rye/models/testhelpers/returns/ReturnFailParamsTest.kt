// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.returns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnFailParamsTest {

    @Test
    fun create() {
        ReturnFailParams.builder().returnId("returnId").note("note").build()
    }

    @Test
    fun pathParams() {
        val params = ReturnFailParams.builder().returnId("returnId").build()

        assertThat(params._pathParam(0)).isEqualTo("returnId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = ReturnFailParams.builder().returnId("returnId").note("note").build()

        val body = params._body()

        assertThat(body.note()).contains("note")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ReturnFailParams.builder().returnId("returnId").build()

        val body = params._body()
    }
}
