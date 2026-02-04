// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.JsonValue
import com.rye.core.jsonMapper
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class CheckoutIntentTest {

    @Test
    fun ofRetrievingOffer() {
        val retrievingOffer =
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

        val checkoutIntent = CheckoutIntent.ofRetrievingOffer(retrievingOffer)

        assertThat(checkoutIntent.retrievingOffer()).contains(retrievingOffer)
        assertThat(checkoutIntent.awaitingConfirmation()).isEmpty
        assertThat(checkoutIntent.placingOrder()).isEmpty
        assertThat(checkoutIntent.completed()).isEmpty
        assertThat(checkoutIntent.failed()).isEmpty
    }

    @Test
    fun ofRetrievingOfferRoundtrip() {
        val jsonMapper = jsonMapper()
        val checkoutIntent =
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

        val roundtrippedCheckoutIntent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkoutIntent),
                jacksonTypeRef<CheckoutIntent>(),
            )

        assertThat(roundtrippedCheckoutIntent).isEqualTo(checkoutIntent)
    }

    @Test
    fun ofAwaitingConfirmation() {
        val awaitingConfirmation =
            CheckoutIntent.AwaitingConfirmationCheckoutIntent.builder()
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
                .offer(
                    Offer.builder()
                        .cost(
                            Offer.Cost.builder()
                                .subtotal(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .total(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .discount(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .shipping(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .surcharge(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .tax(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
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
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .discount(
                                            Money.builder()
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .build()
                                )
                                .selectedOptionId("selectedOptionId")
                                .build()
                        )
                        .addAppliedPromoCode("string")
                        .build()
                )
                .state(
                    CheckoutIntent.AwaitingConfirmationCheckoutIntent.State.AWAITING_CONFIRMATION
                )
                .paymentMethod(
                    PaymentMethod.StripeTokenPaymentMethod.builder()
                        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                        .build()
                )
                .build()

        val checkoutIntent = CheckoutIntent.ofAwaitingConfirmation(awaitingConfirmation)

        assertThat(checkoutIntent.retrievingOffer()).isEmpty
        assertThat(checkoutIntent.awaitingConfirmation()).contains(awaitingConfirmation)
        assertThat(checkoutIntent.placingOrder()).isEmpty
        assertThat(checkoutIntent.completed()).isEmpty
        assertThat(checkoutIntent.failed()).isEmpty
    }

    @Test
    fun ofAwaitingConfirmationRoundtrip() {
        val jsonMapper = jsonMapper()
        val checkoutIntent =
            CheckoutIntent.ofAwaitingConfirmation(
                CheckoutIntent.AwaitingConfirmationCheckoutIntent.builder()
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
                    .offer(
                        Offer.builder()
                            .cost(
                                Offer.Cost.builder()
                                    .subtotal(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .total(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .discount(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .shipping(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .surcharge(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .tax(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
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
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .discount(
                                                Money.builder()
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .selectedOptionId("selectedOptionId")
                                    .build()
                            )
                            .addAppliedPromoCode("string")
                            .build()
                    )
                    .state(
                        CheckoutIntent.AwaitingConfirmationCheckoutIntent.State
                            .AWAITING_CONFIRMATION
                    )
                    .paymentMethod(
                        PaymentMethod.StripeTokenPaymentMethod.builder()
                            .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                            .build()
                    )
                    .build()
            )

        val roundtrippedCheckoutIntent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkoutIntent),
                jacksonTypeRef<CheckoutIntent>(),
            )

        assertThat(roundtrippedCheckoutIntent).isEqualTo(checkoutIntent)
    }

    @Test
    fun ofPlacingOrder() {
        val placingOrder =
            CheckoutIntent.PlacingOrderCheckoutIntent.builder()
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
                .offer(
                    Offer.builder()
                        .cost(
                            Offer.Cost.builder()
                                .subtotal(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .total(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .discount(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .shipping(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .surcharge(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .tax(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
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
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .discount(
                                            Money.builder()
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .build()
                                )
                                .selectedOptionId("selectedOptionId")
                                .build()
                        )
                        .addAppliedPromoCode("string")
                        .build()
                )
                .paymentMethod(
                    PaymentMethod.StripeTokenPaymentMethod.builder()
                        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                        .build()
                )
                .state(CheckoutIntent.PlacingOrderCheckoutIntent.State.PLACING_ORDER)
                .build()

        val checkoutIntent = CheckoutIntent.ofPlacingOrder(placingOrder)

        assertThat(checkoutIntent.retrievingOffer()).isEmpty
        assertThat(checkoutIntent.awaitingConfirmation()).isEmpty
        assertThat(checkoutIntent.placingOrder()).contains(placingOrder)
        assertThat(checkoutIntent.completed()).isEmpty
        assertThat(checkoutIntent.failed()).isEmpty
    }

    @Test
    fun ofPlacingOrderRoundtrip() {
        val jsonMapper = jsonMapper()
        val checkoutIntent =
            CheckoutIntent.ofPlacingOrder(
                CheckoutIntent.PlacingOrderCheckoutIntent.builder()
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
                    .offer(
                        Offer.builder()
                            .cost(
                                Offer.Cost.builder()
                                    .subtotal(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .total(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .discount(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .shipping(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .surcharge(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .tax(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
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
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .discount(
                                                Money.builder()
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .selectedOptionId("selectedOptionId")
                                    .build()
                            )
                            .addAppliedPromoCode("string")
                            .build()
                    )
                    .paymentMethod(
                        PaymentMethod.StripeTokenPaymentMethod.builder()
                            .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                            .build()
                    )
                    .state(CheckoutIntent.PlacingOrderCheckoutIntent.State.PLACING_ORDER)
                    .build()
            )

        val roundtrippedCheckoutIntent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkoutIntent),
                jacksonTypeRef<CheckoutIntent>(),
            )

        assertThat(roundtrippedCheckoutIntent).isEqualTo(checkoutIntent)
    }

    @Test
    fun ofCompleted() {
        val completed =
            CheckoutIntent.CompletedCheckoutIntent.builder()
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
                .offer(
                    Offer.builder()
                        .cost(
                            Offer.Cost.builder()
                                .subtotal(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .total(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .discount(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .shipping(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .surcharge(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .tax(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
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
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .discount(
                                            Money.builder()
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .build()
                                )
                                .selectedOptionId("selectedOptionId")
                                .build()
                        )
                        .addAppliedPromoCode("string")
                        .build()
                )
                .orderId("orderId")
                .paymentMethod(
                    PaymentMethod.StripeTokenPaymentMethod.builder()
                        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                        .build()
                )
                .state(CheckoutIntent.CompletedCheckoutIntent.State.COMPLETED)
                .build()

        val checkoutIntent = CheckoutIntent.ofCompleted(completed)

        assertThat(checkoutIntent.retrievingOffer()).isEmpty
        assertThat(checkoutIntent.awaitingConfirmation()).isEmpty
        assertThat(checkoutIntent.placingOrder()).isEmpty
        assertThat(checkoutIntent.completed()).contains(completed)
        assertThat(checkoutIntent.failed()).isEmpty
    }

    @Test
    fun ofCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val checkoutIntent =
            CheckoutIntent.ofCompleted(
                CheckoutIntent.CompletedCheckoutIntent.builder()
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
                    .offer(
                        Offer.builder()
                            .cost(
                                Offer.Cost.builder()
                                    .subtotal(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .total(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .discount(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .shipping(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .surcharge(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .tax(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
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
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .discount(
                                                Money.builder()
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .selectedOptionId("selectedOptionId")
                                    .build()
                            )
                            .addAppliedPromoCode("string")
                            .build()
                    )
                    .orderId("orderId")
                    .paymentMethod(
                        PaymentMethod.StripeTokenPaymentMethod.builder()
                            .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                            .build()
                    )
                    .state(CheckoutIntent.CompletedCheckoutIntent.State.COMPLETED)
                    .build()
            )

        val roundtrippedCheckoutIntent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkoutIntent),
                jacksonTypeRef<CheckoutIntent>(),
            )

        assertThat(roundtrippedCheckoutIntent).isEqualTo(checkoutIntent)
    }

    @Test
    fun ofFailed() {
        val failed =
            CheckoutIntent.FailedCheckoutIntent.builder()
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
                .failureReason(
                    CheckoutIntent.FailedCheckoutIntent.FailureReason.builder()
                        .code(
                            CheckoutIntent.FailedCheckoutIntent.FailureReason.Code
                                .CHECKOUT_INTENT_EXPIRED
                        )
                        .message("message")
                        .build()
                )
                .state(CheckoutIntent.FailedCheckoutIntent.State.FAILED)
                .offer(
                    Offer.builder()
                        .cost(
                            Offer.Cost.builder()
                                .subtotal(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .total(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .discount(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .shipping(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .surcharge(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
                                )
                                .tax(
                                    Money.builder().amountSubunits(1500).currencyCode("USD").build()
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
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .discount(
                                            Money.builder()
                                                .amountSubunits(1500)
                                                .currencyCode("USD")
                                                .build()
                                        )
                                        .build()
                                )
                                .selectedOptionId("selectedOptionId")
                                .build()
                        )
                        .addAppliedPromoCode("string")
                        .build()
                )
                .paymentMethod(
                    PaymentMethod.StripeTokenPaymentMethod.builder()
                        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                        .build()
                )
                .build()

        val checkoutIntent = CheckoutIntent.ofFailed(failed)

        assertThat(checkoutIntent.retrievingOffer()).isEmpty
        assertThat(checkoutIntent.awaitingConfirmation()).isEmpty
        assertThat(checkoutIntent.placingOrder()).isEmpty
        assertThat(checkoutIntent.completed()).isEmpty
        assertThat(checkoutIntent.failed()).contains(failed)
    }

    @Test
    fun ofFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val checkoutIntent =
            CheckoutIntent.ofFailed(
                CheckoutIntent.FailedCheckoutIntent.builder()
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
                    .failureReason(
                        CheckoutIntent.FailedCheckoutIntent.FailureReason.builder()
                            .code(
                                CheckoutIntent.FailedCheckoutIntent.FailureReason.Code
                                    .CHECKOUT_INTENT_EXPIRED
                            )
                            .message("message")
                            .build()
                    )
                    .state(CheckoutIntent.FailedCheckoutIntent.State.FAILED)
                    .offer(
                        Offer.builder()
                            .cost(
                                Offer.Cost.builder()
                                    .subtotal(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .total(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .discount(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .shipping(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .surcharge(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
                                    )
                                    .tax(
                                        Money.builder()
                                            .amountSubunits(1500)
                                            .currencyCode("USD")
                                            .build()
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
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .discount(
                                                Money.builder()
                                                    .amountSubunits(1500)
                                                    .currencyCode("USD")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .selectedOptionId("selectedOptionId")
                                    .build()
                            )
                            .addAppliedPromoCode("string")
                            .build()
                    )
                    .paymentMethod(
                        PaymentMethod.StripeTokenPaymentMethod.builder()
                            .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                            .build()
                    )
                    .build()
            )

        val roundtrippedCheckoutIntent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkoutIntent),
                jacksonTypeRef<CheckoutIntent>(),
            )

        assertThat(roundtrippedCheckoutIntent).isEqualTo(checkoutIntent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val checkoutIntent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CheckoutIntent>())

        val e = assertThrows<CheckoutIntentsInvalidDataException> { checkoutIntent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
