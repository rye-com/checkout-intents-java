// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutIntentRetrieveOrderParamsTest {

    @Test
    fun create() {
        CheckoutIntentRetrieveOrderParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = CheckoutIntentRetrieveOrderParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
