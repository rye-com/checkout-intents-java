// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.JsonValue
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingListTransactionsResponseTest {

    @Test
    fun create() {
        val billingListTransactionsResponse =
            BillingListTransactionsResponse.builder()
                .id("id")
                .amount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .metadata(
                    BillingListTransactionsResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(billingListTransactionsResponse.id()).isEqualTo("id")
        assertThat(billingListTransactionsResponse.amount())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
        assertThat(billingListTransactionsResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(billingListTransactionsResponse.description()).contains("description")
        assertThat(billingListTransactionsResponse.metadata())
            .contains(
                BillingListTransactionsResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val billingListTransactionsResponse =
            BillingListTransactionsResponse.builder()
                .id("id")
                .amount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .metadata(
                    BillingListTransactionsResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val roundtrippedBillingListTransactionsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(billingListTransactionsResponse),
                jacksonTypeRef<BillingListTransactionsResponse>(),
            )

        assertThat(roundtrippedBillingListTransactionsResponse)
            .isEqualTo(billingListTransactionsResponse)
    }
}
