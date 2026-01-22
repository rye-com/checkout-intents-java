// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.betas

import com.checkout_intents.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutSessionTest {

    @Test
    fun create() {
        val checkoutSession = CheckoutSession.builder().url("url").build()

        assertThat(checkoutSession.url()).isEqualTo("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val checkoutSession = CheckoutSession.builder().url("url").build()

        val roundtrippedCheckoutSession =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkoutSession),
                jacksonTypeRef<CheckoutSession>(),
            )

        assertThat(roundtrippedCheckoutSession).isEqualTo(checkoutSession)
    }
}
