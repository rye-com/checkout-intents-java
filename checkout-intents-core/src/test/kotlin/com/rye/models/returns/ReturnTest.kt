// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnTest {

    @Test
    fun create() {
        val return_ =
            Return.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderId("orderId")
                .reason(ReturnReason.DEFECTIVE)
                .state(ReturnState.REQUESTED)
                .timeline(
                    ReturnTimeline.builder()
                        .requestedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .deniedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .failedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .refundIssuedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .returnApprovedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .denial(
                    ReturnDenial.builder()
                        .reason(ReturnDenial.Reason.FINAL_SALE)
                        .note("note")
                        .build()
                )
                .failure(
                    ReturnFailure.builder()
                        .code(ReturnFailure.Code.DRAWDOWN_CREDIT_FAILED)
                        .message("message")
                        .build()
                )
                .nextAction(
                    ReturnNextAction.builder()
                        .type(ReturnNextAction.Type.SHIP_ITEMS_TO_MERCHANT)
                        .shipItemsToMerchant(
                            ReturnNextAction.ShipItemsToMerchant.builder()
                                .label(
                                    ReturnNextAction.ShipItemsToMerchant.Label.builder()
                                        .url("url")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .addRefund(
                    ReturnRefund.builder()
                        .id("id")
                        .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .shopperRefundTotal(
                            Money.builder().amountSubunits(1500).currencyCode("USD").build()
                        )
                        .build()
                )
                .build()

        assertThat(return_.id()).isEqualTo("id")
        assertThat(return_.checkoutIntentId()).isEqualTo("checkoutIntentId")
        assertThat(return_.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(return_.orderId()).isEqualTo("orderId")
        assertThat(return_.reason()).isEqualTo(ReturnReason.DEFECTIVE)
        assertThat(return_.state()).isEqualTo(ReturnState.REQUESTED)
        assertThat(return_.timeline())
            .isEqualTo(
                ReturnTimeline.builder()
                    .requestedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .deniedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .failedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .refundIssuedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .returnApprovedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(return_.updatedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(return_.denial())
            .contains(
                ReturnDenial.builder().reason(ReturnDenial.Reason.FINAL_SALE).note("note").build()
            )
        assertThat(return_.failure())
            .contains(
                ReturnFailure.builder()
                    .code(ReturnFailure.Code.DRAWDOWN_CREDIT_FAILED)
                    .message("message")
                    .build()
            )
        assertThat(return_.nextAction())
            .contains(
                ReturnNextAction.builder()
                    .type(ReturnNextAction.Type.SHIP_ITEMS_TO_MERCHANT)
                    .shipItemsToMerchant(
                        ReturnNextAction.ShipItemsToMerchant.builder()
                            .label(
                                ReturnNextAction.ShipItemsToMerchant.Label.builder()
                                    .url("url")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(return_.refunds().getOrNull())
            .containsExactly(
                ReturnRefund.builder()
                    .id("id")
                    .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .shopperRefundTotal(
                        Money.builder().amountSubunits(1500).currencyCode("USD").build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val return_ =
            Return.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .orderId("orderId")
                .reason(ReturnReason.DEFECTIVE)
                .state(ReturnState.REQUESTED)
                .timeline(
                    ReturnTimeline.builder()
                        .requestedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .deniedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .failedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .refundIssuedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .returnApprovedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .denial(
                    ReturnDenial.builder()
                        .reason(ReturnDenial.Reason.FINAL_SALE)
                        .note("note")
                        .build()
                )
                .failure(
                    ReturnFailure.builder()
                        .code(ReturnFailure.Code.DRAWDOWN_CREDIT_FAILED)
                        .message("message")
                        .build()
                )
                .nextAction(
                    ReturnNextAction.builder()
                        .type(ReturnNextAction.Type.SHIP_ITEMS_TO_MERCHANT)
                        .shipItemsToMerchant(
                            ReturnNextAction.ShipItemsToMerchant.builder()
                                .label(
                                    ReturnNextAction.ShipItemsToMerchant.Label.builder()
                                        .url("url")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .addRefund(
                    ReturnRefund.builder()
                        .id("id")
                        .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .shopperRefundTotal(
                            Money.builder().amountSubunits(1500).currencyCode("USD").build()
                        )
                        .build()
                )
                .build()

        val roundtrippedReturn =
            jsonMapper.readValue(jsonMapper.writeValueAsString(return_), jacksonTypeRef<Return>())

        assertThat(roundtrippedReturn).isEqualTo(return_)
    }
}
