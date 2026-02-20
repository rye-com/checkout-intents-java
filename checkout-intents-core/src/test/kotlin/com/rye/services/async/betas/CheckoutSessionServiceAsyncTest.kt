// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.betas

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.betas.checkoutsessions.CheckoutSessionCreateParams
import com.rye.models.checkoutintents.VariantSelection
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CheckoutSessionServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val checkoutSessionServiceAsync = client.betas().checkoutSessions()

        val checkoutSessionFuture =
            checkoutSessionServiceAsync.create(
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
                    .discoverPromoCodes(true)
                    .addPromoCode("string")
                    .addVariantSelection(
                        VariantSelection.builder()
                            .label("Size, Color, etc.")
                            .value("Small, Red, XS, L, etc.")
                            .build()
                    )
                    .build()
            )

        val checkoutSession = checkoutSessionFuture.get()
        checkoutSession.validate()
    }
}
