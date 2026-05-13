// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.rye.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommissionListParamsTest {

    @Test
    fun create() {
        CommissionListParams.builder()
            .after("after")
            .before("before")
            .limit(1)
            .status(CommissionStatus.PENDING)
            .type(CommissionType.SURCHARGE)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CommissionListParams.builder()
                .after("after")
                .before("before")
                .limit(1)
                .status(CommissionStatus.PENDING)
                .type(CommissionType.SURCHARGE)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "1")
                    .put("status", "pending")
                    .put("type", "surcharge")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CommissionListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
