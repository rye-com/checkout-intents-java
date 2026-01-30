// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OfferTest {

    @Test
    fun create() {
        val offer =
            Offer.builder()
                .cost(
                    Offer.Cost.builder()
                        .subtotal(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .total(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .discount(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .shipping(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .surcharge(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .tax(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .build()
                )
                .shipping(
                    Offer.Shipping.builder()
                        .addAvailableOption(
                            Offer.Shipping.AvailableOption.builder()
                                .id("id")
                                .cost(
                                    Money.builder()
                                        .amountSubunits(0.0)
                                        .currencyCode("currencyCode")
                                        .build()
                                )
                                .discount(
                                    Money.builder()
                                        .amountSubunits(0.0)
                                        .currencyCode("currencyCode")
                                        .build()
                                )
                                .build()
                        )
                        .selectedOptionId("selectedOptionId")
                        .build()
                )
                .addAppliedPromoCode("string")
                .build()

        assertThat(offer.cost())
            .isEqualTo(
                Offer.Cost.builder()
                    .subtotal(
                        Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                    )
                    .total(Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build())
                    .discount(
                        Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                    )
                    .shipping(
                        Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                    )
                    .surcharge(
                        Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                    )
                    .tax(Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build())
                    .build()
            )
        assertThat(offer.shipping())
            .isEqualTo(
                Offer.Shipping.builder()
                    .addAvailableOption(
                        Offer.Shipping.AvailableOption.builder()
                            .id("id")
                            .cost(
                                Money.builder()
                                    .amountSubunits(0.0)
                                    .currencyCode("currencyCode")
                                    .build()
                            )
                            .discount(
                                Money.builder()
                                    .amountSubunits(0.0)
                                    .currencyCode("currencyCode")
                                    .build()
                            )
                            .build()
                    )
                    .selectedOptionId("selectedOptionId")
                    .build()
            )
        assertThat(offer.appliedPromoCodes().getOrNull()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val offer =
            Offer.builder()
                .cost(
                    Offer.Cost.builder()
                        .subtotal(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .total(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .discount(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .shipping(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .surcharge(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .tax(
                            Money.builder().amountSubunits(0.0).currencyCode("currencyCode").build()
                        )
                        .build()
                )
                .shipping(
                    Offer.Shipping.builder()
                        .addAvailableOption(
                            Offer.Shipping.AvailableOption.builder()
                                .id("id")
                                .cost(
                                    Money.builder()
                                        .amountSubunits(0.0)
                                        .currencyCode("currencyCode")
                                        .build()
                                )
                                .discount(
                                    Money.builder()
                                        .amountSubunits(0.0)
                                        .currencyCode("currencyCode")
                                        .build()
                                )
                                .build()
                        )
                        .selectedOptionId("selectedOptionId")
                        .build()
                )
                .addAppliedPromoCode("string")
                .build()

        val roundtrippedOffer =
            jsonMapper.readValue(jsonMapper.writeValueAsString(offer), jacksonTypeRef<Offer>())

        assertThat(roundtrippedOffer).isEqualTo(offer)
    }
}
