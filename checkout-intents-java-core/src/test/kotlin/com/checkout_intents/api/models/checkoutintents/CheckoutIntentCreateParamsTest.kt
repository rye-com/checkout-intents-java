// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutIntentCreateParamsTest {

    @Test
    fun create() {
        CheckoutIntentCreateParams.builder()
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
            .productUrl("productUrl")
            .quantity(1)
            .constraints(
                CheckoutIntentCreateParams.Constraints.builder()
                    .maxShippingPrice(500)
                    .maxTotalPrice(100000)
                    .offerRetrievalEffort(
                        CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
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
    }

    @Test
    fun body() {
        val params =
            CheckoutIntentCreateParams.builder()
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
                .productUrl("productUrl")
                .quantity(1)
                .constraints(
                    CheckoutIntentCreateParams.Constraints.builder()
                        .maxShippingPrice(500)
                        .maxTotalPrice(100000)
                        .offerRetrievalEffort(
                            CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
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

        val body = params._body()

        assertThat(body.buyer())
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
        assertThat(body.productUrl()).isEqualTo("productUrl")
        assertThat(body.quantity()).isEqualTo(1)
        assertThat(body.constraints())
            .contains(
                CheckoutIntentCreateParams.Constraints.builder()
                    .maxShippingPrice(500)
                    .maxTotalPrice(100000)
                    .offerRetrievalEffort(
                        CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                    )
                    .build()
            )
        assertThat(body.promoCodes().getOrNull()).containsExactly("sqF12lZ1VlBb")
        assertThat(body.variantSelections().getOrNull())
            .containsExactly(
                VariantSelection.builder()
                    .label("Size, Color, etc.")
                    .value("Small, Red, XS, L, etc.")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CheckoutIntentCreateParams.builder()
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
                        .build()
                )
                .productUrl("productUrl")
                .quantity(1)
                .build()

        val body = params._body()

        assertThat(body.buyer())
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
                    .build()
            )
        assertThat(body.productUrl()).isEqualTo("productUrl")
        assertThat(body.quantity()).isEqualTo(1)
    }
}
