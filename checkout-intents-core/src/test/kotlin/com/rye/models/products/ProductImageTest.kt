// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductImageTest {

    @Test
    fun create() {
        val productImage =
            ProductImage.builder()
                .isFeatured(true)
                .url("https://example.com/images/product-123.jpg")
                .build()

        assertThat(productImage.isFeatured()).isEqualTo(true)
        assertThat(productImage.url()).isEqualTo("https://example.com/images/product-123.jpg")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val productImage =
            ProductImage.builder()
                .isFeatured(true)
                .url("https://example.com/images/product-123.jpg")
                .build()

        val roundtrippedProductImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(productImage),
                jacksonTypeRef<ProductImage>(),
            )

        assertThat(roundtrippedProductImage).isEqualTo(productImage)
    }
}
