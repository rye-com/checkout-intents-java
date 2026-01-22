// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import com.checkout_intents.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaseCheckoutIntentTest {

    @Test
    fun create() {
        val baseCheckoutIntent =
            BaseCheckoutIntent.builder()
                .id("id")
                .buyer(
                    Buyer.builder()
                        .address1("123 Main St")
                        .city("New York")
                        .country("US")
                        .email("john.doe@example.com")
                        .firstName("John")
                        .lastName("Doe")
                        .phone("1234567890")
                        .postalCode("10001")
                        .province("NY")
                        .address2("Apt 1")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .productUrl("productUrl")
                .quantity(0)
                .constraints(
                    BaseCheckoutIntent.Constraints.builder()
                        .maxShippingPrice(500)
                        .maxTotalPrice(100000)
                        .offerRetrievalEffort(
                            BaseCheckoutIntent.Constraints.OfferRetrievalEffort.MAX
                        )
                        .build()
                )
                .addPromoCode("sqF12lZ1VlBb")
                .addVariantSelection(
                    VariantSelection.builder()
                        .label("Size, Color, etc.")
                        .value("Small, Red, XS, L, etc.")
                        .build()
                )
                .build()

        assertThat(baseCheckoutIntent.id()).isEqualTo("id")
        assertThat(baseCheckoutIntent.buyer())
            .isEqualTo(
                Buyer.builder()
                    .address1("123 Main St")
                    .city("New York")
                    .country("US")
                    .email("john.doe@example.com")
                    .firstName("John")
                    .lastName("Doe")
                    .phone("1234567890")
                    .postalCode("10001")
                    .province("NY")
                    .address2("Apt 1")
                    .build()
            )
        assertThat(baseCheckoutIntent.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(baseCheckoutIntent.productUrl()).isEqualTo("productUrl")
        assertThat(baseCheckoutIntent.quantity()).isEqualTo(0)
        assertThat(baseCheckoutIntent.constraints())
            .contains(
                BaseCheckoutIntent.Constraints.builder()
                    .maxShippingPrice(500)
                    .maxTotalPrice(100000)
                    .offerRetrievalEffort(BaseCheckoutIntent.Constraints.OfferRetrievalEffort.MAX)
                    .build()
            )
        assertThat(baseCheckoutIntent.promoCodes().getOrNull()).containsExactly("sqF12lZ1VlBb")
        assertThat(baseCheckoutIntent.variantSelections().getOrNull())
            .containsExactly(
                VariantSelection.builder()
                    .label("Size, Color, etc.")
                    .value("Small, Red, XS, L, etc.")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val baseCheckoutIntent =
            BaseCheckoutIntent.builder()
                .id("id")
                .buyer(
                    Buyer.builder()
                        .address1("123 Main St")
                        .city("New York")
                        .country("US")
                        .email("john.doe@example.com")
                        .firstName("John")
                        .lastName("Doe")
                        .phone("1234567890")
                        .postalCode("10001")
                        .province("NY")
                        .address2("Apt 1")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .productUrl("productUrl")
                .quantity(0)
                .constraints(
                    BaseCheckoutIntent.Constraints.builder()
                        .maxShippingPrice(500)
                        .maxTotalPrice(100000)
                        .offerRetrievalEffort(
                            BaseCheckoutIntent.Constraints.OfferRetrievalEffort.MAX
                        )
                        .build()
                )
                .addPromoCode("sqF12lZ1VlBb")
                .addVariantSelection(
                    VariantSelection.builder()
                        .label("Size, Color, etc.")
                        .value("Small, Red, XS, L, etc.")
                        .build()
                )
                .build()

        val roundtrippedBaseCheckoutIntent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(baseCheckoutIntent),
                jacksonTypeRef<BaseCheckoutIntent>(),
            )

        assertThat(roundtrippedBaseCheckoutIntent).isEqualTo(baseCheckoutIntent)
    }
}
