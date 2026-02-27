// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.rye.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingListTransactionsParamsTest {

    @Test
    fun create() {
        BillingListTransactionsParams.builder().after("after").before("before").limit(1).build()
    }

    @Test
    fun queryParams() {
        val params =
            BillingListTransactionsParams.builder().after("after").before("before").limit(1).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("limit", "1")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BillingListTransactionsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
