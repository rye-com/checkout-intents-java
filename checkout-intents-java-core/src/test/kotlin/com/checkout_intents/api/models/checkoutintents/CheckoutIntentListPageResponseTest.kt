// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import com.checkout_intents.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutIntentListPageResponseTest {

    @Test
    fun create() {
        val checkoutIntentListPageResponse =
            CheckoutIntentListPageResponse.builder()
                .addData(
                    CheckoutIntent.RetrievingOfferCheckoutIntent.builder()
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
                        .state(CheckoutIntent.RetrievingOfferCheckoutIntent.State.RETRIEVING_OFFER)
                        .build()
                )
                .pageInfo(
                    CheckoutIntentListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        assertThat(checkoutIntentListPageResponse.data())
            .containsExactly(
                CheckoutIntent.ofRetrievingOffer(
                    CheckoutIntent.RetrievingOfferCheckoutIntent.builder()
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
                        .state(CheckoutIntent.RetrievingOfferCheckoutIntent.State.RETRIEVING_OFFER)
                        .build()
                )
            )
        assertThat(checkoutIntentListPageResponse.pageInfo())
            .isEqualTo(
                CheckoutIntentListPageResponse.PageInfo.builder()
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
        val checkoutIntentListPageResponse =
            CheckoutIntentListPageResponse.builder()
                .addData(
                    CheckoutIntent.RetrievingOfferCheckoutIntent.builder()
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
                        .state(CheckoutIntent.RetrievingOfferCheckoutIntent.State.RETRIEVING_OFFER)
                        .build()
                )
                .pageInfo(
                    CheckoutIntentListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        val roundtrippedCheckoutIntentListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkoutIntentListPageResponse),
                jacksonTypeRef<CheckoutIntentListPageResponse>(),
            )

        assertThat(roundtrippedCheckoutIntentListPageResponse)
            .isEqualTo(checkoutIntentListPageResponse)
    }
}
