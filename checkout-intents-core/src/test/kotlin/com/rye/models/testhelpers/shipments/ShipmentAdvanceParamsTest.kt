// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.shipments

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShipmentAdvanceParamsTest {

    @Test
    fun create() {
        ShipmentAdvanceParams.builder().checkoutIntentId("checkoutIntentId").build()
    }

    @Test
    fun pathParams() {
        val params = ShipmentAdvanceParams.builder().checkoutIntentId("checkoutIntentId").build()

        assertThat(params._pathParam(0)).isEqualTo("checkoutIntentId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
