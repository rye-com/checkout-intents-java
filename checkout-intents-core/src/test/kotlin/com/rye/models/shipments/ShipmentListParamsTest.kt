// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

import com.rye.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShipmentListParamsTest {

    @Test
    fun create() {
        ShipmentListParams.builder()
            .after("after")
            .before("before")
            .addId("string")
            .limit(0.0)
            .addStatus(ShipmentListParams.Status.OUT_FOR_DELIVERY)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ShipmentListParams.builder()
                .after("after")
                .before("before")
                .addId("string")
                .limit(0.0)
                .addStatus(ShipmentListParams.Status.OUT_FOR_DELIVERY)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("before", "before")
                    .put("ids", listOf("string").joinToString(","))
                    .put("limit", "0.0")
                    .put("status", listOf("out_for_delivery").joinToString(","))
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ShipmentListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
