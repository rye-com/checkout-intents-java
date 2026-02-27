// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.JsonValue
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingListTransactionsPageResponseTest {

    @Test
    fun create() {
        val billingListTransactionsPageResponse =
            BillingListTransactionsPageResponse.builder()
                .addData(
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
                )
                .pageInfo(
                    BillingListTransactionsPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        assertThat(billingListTransactionsPageResponse.data())
            .containsExactly(
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
            )
        assertThat(billingListTransactionsPageResponse.pageInfo())
            .isEqualTo(
                BillingListTransactionsPageResponse.PageInfo.builder()
                    .hasNextPage(true)
                    .hasPreviousPage(true)
                    .endCursor("endCursor")
                    .startCursor("startCursor")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val billingListTransactionsPageResponse =
            BillingListTransactionsPageResponse.builder()
                .addData(
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
                )
                .pageInfo(
                    BillingListTransactionsPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        val roundtrippedBillingListTransactionsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(billingListTransactionsPageResponse),
                jacksonTypeRef<BillingListTransactionsPageResponse>(),
            )

        assertThat(roundtrippedBillingListTransactionsPageResponse)
            .isEqualTo(billingListTransactionsPageResponse)
    }
}
