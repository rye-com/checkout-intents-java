// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.JsonValue
import com.rye.core.jsonMapper
import com.rye.errors.CheckoutIntentsInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ProductSubscriptionTest {

    @Test
    fun ofProduct() {
        val product =
            ProductSubscriptionProduct.builder()
                .id("id")
                .subscribed(true)
                .type(ProductSubscriptionProduct.Type.PRODUCT)
                .url("url")
                .build()

        val productSubscription = ProductSubscription.ofProduct(product)

        assertThat(productSubscription.product()).contains(product)
        assertThat(productSubscription.store()).isEmpty
    }

    @Test
    fun ofProductRoundtrip() {
        val jsonMapper = jsonMapper()
        val productSubscription =
            ProductSubscription.ofProduct(
                ProductSubscriptionProduct.builder()
                    .id("id")
                    .subscribed(true)
                    .type(ProductSubscriptionProduct.Type.PRODUCT)
                    .url("url")
                    .build()
            )

        val roundtrippedProductSubscription =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(productSubscription),
                jacksonTypeRef<ProductSubscription>(),
            )

        assertThat(roundtrippedProductSubscription).isEqualTo(productSubscription)
    }

    @Test
    fun ofStore() {
        val store =
            ProductSubscriptionStore.builder()
                .domain("domain")
                .subscribed(true)
                .type(ProductSubscriptionStore.Type.STORE)
                .url("url")
                .build()

        val productSubscription = ProductSubscription.ofStore(store)

        assertThat(productSubscription.product()).isEmpty
        assertThat(productSubscription.store()).contains(store)
    }

    @Test
    fun ofStoreRoundtrip() {
        val jsonMapper = jsonMapper()
        val productSubscription =
            ProductSubscription.ofStore(
                ProductSubscriptionStore.builder()
                    .domain("domain")
                    .subscribed(true)
                    .type(ProductSubscriptionStore.Type.STORE)
                    .url("url")
                    .build()
            )

        val roundtrippedProductSubscription =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(productSubscription),
                jacksonTypeRef<ProductSubscription>(),
            )

        assertThat(roundtrippedProductSubscription).isEqualTo(productSubscription)
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
        val productSubscription =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ProductSubscription>())

        val e = assertThrows<CheckoutIntentsInvalidDataException> { productSubscription.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
