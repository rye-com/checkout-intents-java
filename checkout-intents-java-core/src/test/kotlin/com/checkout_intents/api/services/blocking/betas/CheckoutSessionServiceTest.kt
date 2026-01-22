// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking.betas

import com.checkout_intents.api.TestServerExtension
import com.checkout_intents.api.client.okhttp.CheckoutIntentsOkHttpClient
import com.checkout_intents.api.models.betas.checkoutsessions.CheckoutSessionCreateParams
import com.checkout_intents.api.models.checkoutintents.VariantSelection
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CheckoutSessionServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkoutSessionService = client.betas().checkoutSessions()

        val checkoutSession =
            checkoutSessionService.create(
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
            )

        checkoutSession.validate()
    }
}
