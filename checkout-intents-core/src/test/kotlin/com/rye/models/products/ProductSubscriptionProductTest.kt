// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductSubscriptionProductTest {

    @Test
    fun create() {
        val productSubscriptionProduct =
            ProductSubscriptionProduct.builder()
                .id("id")
                .subscribed(true)
                .type(ProductSubscriptionProduct.Type.PRODUCT)
                .url("url")
                .build()

        assertThat(productSubscriptionProduct.id()).isEqualTo("id")
        assertThat(productSubscriptionProduct.subscribed()).isEqualTo(true)
        assertThat(productSubscriptionProduct.type())
            .isEqualTo(ProductSubscriptionProduct.Type.PRODUCT)
        assertThat(productSubscriptionProduct.url()).isEqualTo("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val productSubscriptionProduct =
            ProductSubscriptionProduct.builder()
                .id("id")
                .subscribed(true)
                .type(ProductSubscriptionProduct.Type.PRODUCT)
                .url("url")
                .build()

        val roundtrippedProductSubscriptionProduct =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(productSubscriptionProduct),
                jacksonTypeRef<ProductSubscriptionProduct>(),
            )

        assertThat(roundtrippedProductSubscriptionProduct).isEqualTo(productSubscriptionProduct)
    }
}
