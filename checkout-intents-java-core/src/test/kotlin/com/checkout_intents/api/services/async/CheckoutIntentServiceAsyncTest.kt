// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.async

import com.checkout_intents.api.TestServerExtension
import com.checkout_intents.api.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.checkout_intents.api.models.checkoutintents.Buyer
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentConfirmParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentCreateParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentPurchaseParams
import com.checkout_intents.api.models.checkoutintents.PaymentMethod
import com.checkout_intents.api.models.checkoutintents.VariantSelection
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CheckoutIntentServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentServiceAsync = client.checkoutIntents()

        val checkoutIntentFuture =
            checkoutIntentServiceAsync.create(
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
            )

        val checkoutIntent = checkoutIntentFuture.get()
        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentServiceAsync = client.checkoutIntents()

        val checkoutIntentFuture = checkoutIntentServiceAsync.retrieve("id")

        val checkoutIntent = checkoutIntentFuture.get()
        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentServiceAsync = client.checkoutIntents()

        val pageFuture = checkoutIntentServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun addPayment() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentServiceAsync = client.checkoutIntents()

        val checkoutIntentFuture =
            checkoutIntentServiceAsync.addPayment(
                CheckoutIntentAddPaymentParams.builder()
                    .id("id")
                    .paymentMethod(
                        PaymentMethod.StripeTokenPaymentMethod.builder()
                            .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                            .build()
                    )
                    .build()
            )

        val checkoutIntent = checkoutIntentFuture.get()
        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun confirm() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentServiceAsync = client.checkoutIntents()

        val checkoutIntentFuture =
            checkoutIntentServiceAsync.confirm(
                CheckoutIntentConfirmParams.builder()
                    .id("id")
                    .paymentMethod(
                        PaymentMethod.StripeTokenPaymentMethod.builder()
                            .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                            .build()
                    )
                    .build()
            )

        val checkoutIntent = checkoutIntentFuture.get()
        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun purchase() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentServiceAsync = client.checkoutIntents()

        val checkoutIntentFuture =
            checkoutIntentServiceAsync.purchase(
                CheckoutIntentPurchaseParams.builder()
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
                    .paymentMethod(
                        PaymentMethod.StripeTokenPaymentMethod.builder()
                            .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                            .build()
                    )
                    .productUrl("productUrl")
                    .quantity(1)
                    .constraints(
                        CheckoutIntentPurchaseParams.Constraints.builder()
                            .maxShippingPrice(500)
                            .maxTotalPrice(100000)
                            .offerRetrievalEffort(
                                CheckoutIntentPurchaseParams.Constraints.OfferRetrievalEffort.MAX
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
            )

        val checkoutIntent = checkoutIntentFuture.get()
        checkoutIntent.validate()
    }
}
