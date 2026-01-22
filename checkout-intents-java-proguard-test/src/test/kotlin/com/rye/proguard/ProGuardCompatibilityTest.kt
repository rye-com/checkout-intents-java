// File generated from our OpenAPI spec by Stainless.

package com.rye.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.BaseCheckoutIntent
import com.rye.models.checkoutintents.Buyer
import com.rye.models.checkoutintents.CheckoutIntent
import com.rye.models.checkoutintents.VariantSelection
import java.time.OffsetDateTime
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/checkout-intents-java-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.checkoutIntents()).isNotNull()
        assertThat(client.betas()).isNotNull()
        assertThat(client.brands()).isNotNull()
    }

    @Test
    fun baseCheckoutIntentRoundtrip() {
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

    @Test
    fun checkoutIntentRoundtrip() {
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
}
