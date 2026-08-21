// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnRetrieveParamsTest {

    @Test
    fun create() {
        ReturnRetrieveParams.builder().returnId("returnId").build()
    }

    @Test
    fun pathParams() {
        val params = ReturnRetrieveParams.builder().returnId("returnId").build()

        assertThat(params._pathParam(0)).isEqualTo("returnId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
