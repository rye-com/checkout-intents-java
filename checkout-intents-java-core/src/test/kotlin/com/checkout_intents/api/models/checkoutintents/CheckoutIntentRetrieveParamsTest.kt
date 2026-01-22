// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutIntentRetrieveParamsTest {

    @Test
    fun create() {
        CheckoutIntentRetrieveParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = CheckoutIntentRetrieveParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
