// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnFailureTest {

    @Test
    fun create() {
        val returnFailure =
            ReturnFailure.builder()
                .code(ReturnFailure.Code.DRAWDOWN_CREDIT_FAILED)
                .message("message")
                .build()

        assertThat(returnFailure.code()).isEqualTo(ReturnFailure.Code.DRAWDOWN_CREDIT_FAILED)
        assertThat(returnFailure.message()).isEqualTo("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val returnFailure =
            ReturnFailure.builder()
                .code(ReturnFailure.Code.DRAWDOWN_CREDIT_FAILED)
                .message("message")
                .build()

        val roundtrippedReturnFailure =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(returnFailure),
                jacksonTypeRef<ReturnFailure>(),
            )

        assertThat(roundtrippedReturnFailure).isEqualTo(returnFailure)
    }
}
