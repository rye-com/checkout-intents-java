// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test
    fun create() {
        val money = Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()

        assertThat(money.amountSubunits()).isEqualTo(0.0)
        assertThat(money.currencyCode()).isEqualTo("currencyCode")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val money = Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()

        val roundtrippedMoney =
            jsonMapper.readValue(jsonMapper.writeValueAsString(money), jacksonTypeRef<Money>())

        assertThat(roundtrippedMoney).isEqualTo(money)
    }
}
