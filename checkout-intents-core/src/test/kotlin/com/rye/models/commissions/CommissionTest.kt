// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommissionTest {

    @Test
    fun create() {
        val commission =
            Commission.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .developerShareAmount(
                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                )
                .developerSharePercent(0.0)
                .grossAmount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .ryeShareAmount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .settlementDirection(SettlementDirection.RYE_OWES_DEVELOPER)
                .status(CommissionStatus.PENDING)
                .type(CommissionType.SURCHARGE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .finalizedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(commission.id()).isEqualTo("id")
        assertThat(commission.checkoutIntentId()).isEqualTo("checkoutIntentId")
        assertThat(commission.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(commission.developerShareAmount())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
        assertThat(commission.developerSharePercent()).isEqualTo(0.0)
        assertThat(commission.grossAmount())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
        assertThat(commission.ryeShareAmount())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
        assertThat(commission.settlementDirection())
            .isEqualTo(SettlementDirection.RYE_OWES_DEVELOPER)
        assertThat(commission.status()).isEqualTo(CommissionStatus.PENDING)
        assertThat(commission.type()).isEqualTo(CommissionType.SURCHARGE)
        assertThat(commission.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(commission.finalizedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val commission =
            Commission.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .developerShareAmount(
                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                )
                .developerSharePercent(0.0)
                .grossAmount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .ryeShareAmount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .settlementDirection(SettlementDirection.RYE_OWES_DEVELOPER)
                .status(CommissionStatus.PENDING)
                .type(CommissionType.SURCHARGE)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .finalizedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedCommission =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(commission),
                jacksonTypeRef<Commission>(),
            )

        assertThat(roundtrippedCommission).isEqualTo(commission)
    }
}
