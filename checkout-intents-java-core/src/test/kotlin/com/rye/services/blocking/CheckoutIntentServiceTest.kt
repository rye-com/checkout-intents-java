// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.TestServerExtension
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.checkoutintents.Buyer
import com.rye.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.rye.models.checkoutintents.CheckoutIntentConfirmParams
import com.rye.models.checkoutintents.CheckoutIntentCreateParams
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams
import com.rye.models.checkoutintents.PaymentMethod
import com.rye.models.checkoutintents.VariantSelection
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CheckoutIntentServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentService = client.checkoutIntents()

        val checkoutIntent =
            checkoutIntentService.create(
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

        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentService = client.checkoutIntents()

        val checkoutIntent = checkoutIntentService.retrieve("id")

        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentService = client.checkoutIntents()

        val page = checkoutIntentService.list()

        page.response().validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun addPayment() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentService = client.checkoutIntents()

        val checkoutIntent =
            checkoutIntentService.addPayment(
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

        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun confirm() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentService = client.checkoutIntents()

        val checkoutIntent =
            checkoutIntentService.confirm(
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

        checkoutIntent.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun purchase() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutIntentService = client.checkoutIntents()

        val checkoutIntent =
            checkoutIntentService.purchase(
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

        checkoutIntent.validate()
    }
}
