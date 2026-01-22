// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.betas.checkoutsessions

import com.checkout_intents.api.models.checkoutintents.VariantSelection
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutSessionCreateParamsTest {

    @Test
    fun create() {
        CheckoutSessionCreateParams.builder()
            .productUrl("productUrl")
            .quantity(1)
            .buyer(
                CheckoutSessionCreateParams.Buyer.builder()
                    .address1("123 Main St")
                    .address2("Apt 1")
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
            .constraints(
                CheckoutSessionCreateParams.Constraints.builder()
                    .maxShippingPrice(500)
                    .maxTotalPrice(100000)
                    .offerRetrievalEffort(
                        CheckoutSessionCreateParams.Constraints.OfferRetrievalEffort.MAX
                    )
                    .build()
            )
            .addPromoCode("string")
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
            CheckoutSessionCreateParams.builder()
                .productUrl("productUrl")
                .quantity(1)
                .buyer(
                    CheckoutSessionCreateParams.Buyer.builder()
                        .address1("123 Main St")
                        .address2("Apt 1")
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
                .constraints(
                    CheckoutSessionCreateParams.Constraints.builder()
                        .maxShippingPrice(500)
                        .maxTotalPrice(100000)
                        .offerRetrievalEffort(
                            CheckoutSessionCreateParams.Constraints.OfferRetrievalEffort.MAX
                        )
                        .build()
                )
                .addPromoCode("string")
                .addVariantSelection(
                    VariantSelection.builder()
                        .label("Size, Color, etc.")
                        .value("Small, Red, XS, L, etc.")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.productUrl()).isEqualTo("productUrl")
        assertThat(body.quantity()).isEqualTo(1)
        assertThat(body.buyer())
            .contains(
                CheckoutSessionCreateParams.Buyer.builder()
                    .address1("123 Main St")
                    .address2("Apt 1")
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
        assertThat(body.constraints())
            .contains(
                CheckoutSessionCreateParams.Constraints.builder()
                    .maxShippingPrice(500)
                    .maxTotalPrice(100000)
                    .offerRetrievalEffort(
                        CheckoutSessionCreateParams.Constraints.OfferRetrievalEffort.MAX
                    )
                    .build()
            )
        assertThat(body.promoCodes().getOrNull()).containsExactly("string")
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
            CheckoutSessionCreateParams.builder().productUrl("productUrl").quantity(1).build()

        val body = params._body()

        assertThat(body.productUrl()).isEqualTo("productUrl")
        assertThat(body.quantity()).isEqualTo(1)
    }
}
