// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.brands

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandRetrieveParamsTest {

    @Test
    fun create() {
        BrandRetrieveParams.builder().domain("shop.aloyoga.com").build()
    }

    @Test
    fun pathParams() {
        val params = BrandRetrieveParams.builder().domain("shop.aloyoga.com").build()

        assertThat(params._pathParam(0)).isEqualTo("shop.aloyoga.com")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
