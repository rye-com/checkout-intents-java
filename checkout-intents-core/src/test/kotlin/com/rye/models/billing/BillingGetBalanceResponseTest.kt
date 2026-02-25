// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingGetBalanceResponseTest {

    @Test
    fun create() {
        val billingGetBalanceResponse =
            BillingGetBalanceResponse.builder()
                .balance(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .build()

        assertThat(billingGetBalanceResponse.balance())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val billingGetBalanceResponse =
            BillingGetBalanceResponse.builder()
                .balance(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .build()

        val roundtrippedBillingGetBalanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(billingGetBalanceResponse),
                jacksonTypeRef<BillingGetBalanceResponse>(),
            )

        assertThat(roundtrippedBillingGetBalanceResponse).isEqualTo(billingGetBalanceResponse)
    }
}
