// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommissionListPageResponseTest {

    @Test
    fun create() {
        val commissionListPageResponse =
            CommissionListPageResponse.builder()
                .addData(
                    Commission.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .developerCommission(
                            Money.builder().amountSubunits(1500).currencyCode("USD").build()
                        )
                        .ryeFee(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                        .settlementDirection(SettlementDirection.RYE_OWES_DEVELOPER)
                        .status(CommissionStatus.PENDING)
                        .type(CommissionType.SURCHARGE)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .finalizedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .pageInfo(
                    CommissionListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        assertThat(commissionListPageResponse.data())
            .containsExactly(
                Commission.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .developerCommission(
                        Money.builder().amountSubunits(1500).currencyCode("USD").build()
                    )
                    .ryeFee(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                    .settlementDirection(SettlementDirection.RYE_OWES_DEVELOPER)
                    .status(CommissionStatus.PENDING)
                    .type(CommissionType.SURCHARGE)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .finalizedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(commissionListPageResponse.pageInfo())
            .isEqualTo(
                CommissionListPageResponse.PageInfo.builder()
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
        val commissionListPageResponse =
            CommissionListPageResponse.builder()
                .addData(
                    Commission.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .developerCommission(
                            Money.builder().amountSubunits(1500).currencyCode("USD").build()
                        )
                        .ryeFee(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                        .settlementDirection(SettlementDirection.RYE_OWES_DEVELOPER)
                        .status(CommissionStatus.PENDING)
                        .type(CommissionType.SURCHARGE)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .finalizedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .pageInfo(
                    CommissionListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        val roundtrippedCommissionListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(commissionListPageResponse),
                jacksonTypeRef<CommissionListPageResponse>(),
            )

        assertThat(roundtrippedCommissionListPageResponse).isEqualTo(commissionListPageResponse)
    }
}
