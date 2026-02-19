// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.rye.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutIntentListParamsTest {

    @Test
    fun create() {
        CheckoutIntentListParams.builder()
            .addId("string")
            .after("after")
            .before("before")
            .limit(0.0)
            .addState(CheckoutIntentListParams.State.COMPLETED)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CheckoutIntentListParams.builder()
                .addId("string")
                .after("after")
                .before("before")
                .limit(0.0)
                .addState(CheckoutIntentListParams.State.COMPLETED)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("id", listOf("string").joinToString(","))
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "0.0")
                    .put("state", listOf("completed").joinToString(","))
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CheckoutIntentListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
