// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnRefundTest {

    @Test
    fun create() {
        val returnRefund =
            ReturnRefund.builder()
                .id("id")
                .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .shopperRefundTotal(
                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                )
                .build()

        assertThat(returnRefund.id()).isEqualTo("id")
        assertThat(returnRefund.refundedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(returnRefund.shopperRefundTotal())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val returnRefund =
            ReturnRefund.builder()
                .id("id")
                .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .shopperRefundTotal(
                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                )
                .build()

        val roundtrippedReturnRefund =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(returnRefund),
                jacksonTypeRef<ReturnRefund>(),
            )

        assertThat(roundtrippedReturnRefund).isEqualTo(returnRefund)
    }
}
