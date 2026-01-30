// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test
    fun create() {
        val money = Money.builder().amountSubunits(1500).currencyCode("USD").build()

        assertThat(money.amountSubunits()).isEqualTo(1500)
        assertThat(money.currencyCode()).isEqualTo("USD")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val money = Money.builder().amountSubunits(1500).currencyCode("USD").build()

        val roundtrippedMoney =
            jsonMapper.readValue(jsonMapper.writeValueAsString(money), jacksonTypeRef<Money>())

        assertThat(roundtrippedMoney).isEqualTo(money)
    }
}
