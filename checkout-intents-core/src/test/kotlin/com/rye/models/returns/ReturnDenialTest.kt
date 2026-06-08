// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnDenialTest {

    @Test
    fun create() {
        val returnDenial =
            ReturnDenial.builder().reason(ReturnDenial.Reason.FINAL_SALE).note("note").build()

        assertThat(returnDenial.reason()).isEqualTo(ReturnDenial.Reason.FINAL_SALE)
        assertThat(returnDenial.note()).contains("note")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val returnDenial =
            ReturnDenial.builder().reason(ReturnDenial.Reason.FINAL_SALE).note("note").build()

        val roundtrippedReturnDenial =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(returnDenial),
                jacksonTypeRef<ReturnDenial>(),
            )

        assertThat(roundtrippedReturnDenial).isEqualTo(returnDenial)
    }
}
