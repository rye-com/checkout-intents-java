// File generated from our OpenAPI spec by Stainless.

package com.rye.models.events

import com.rye.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListParamsTest {

    @Test
    fun create() {
        EventListParams.builder().after("after").before("before").limit(1).build()
    }

    @Test
    fun queryParams() {
        val params = EventListParams.builder().after("after").before("before").limit(1).build()

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
        val params = EventListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
