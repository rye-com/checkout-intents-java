// File generated from our OpenAPI spec by Stainless.

package com.rye.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.rye.client.CheckoutIntentsClient
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.core.JsonValue
import com.rye.models.checkoutintents.Buyer
import com.rye.models.checkoutintents.CheckoutIntentCreateParams
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams
import com.rye.models.checkoutintents.PaymentMethod
import com.rye.models.checkoutintents.VariantSelection
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: CheckoutIntentsClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun purchase() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
