// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import com.rye.models.checkoutintents.VariantSelection
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductVariantTest {

    @Test
    fun create() {
        val productVariant =
            ProductVariant.builder()
                .id("id")
                .availability(ProductAvailability.IN_STOCK)
                .addDimension(
                    VariantSelection.builder()
                        .label("Size, Color, etc.")
                        .value("Small, Red, XS, L, etc.")
                        .build()
                )
                .addImage(
                    ProductImage.builder()
                        .isFeatured(true)
                        .url("https://example.com/images/product-123.jpg")
                        .build()
                )
                .name("name")
                .price(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .sku("sku")
                .build()

        assertThat(productVariant.id()).contains("id")
        assertThat(productVariant.availability()).isEqualTo(ProductAvailability.IN_STOCK)
        assertThat(productVariant.dimensions())
            .containsExactly(
                VariantSelection.builder()
                    .label("Size, Color, etc.")
                    .value("Small, Red, XS, L, etc.")
                    .build()
            )
        assertThat(productVariant.images())
            .containsExactly(
                ProductImage.builder()
                    .isFeatured(true)
                    .url("https://example.com/images/product-123.jpg")
                    .build()
            )
        assertThat(productVariant.name()).contains("name")
        assertThat(productVariant.price())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
        assertThat(productVariant.sku()).contains("sku")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val productVariant =
            ProductVariant.builder()
                .id("id")
                .availability(ProductAvailability.IN_STOCK)
                .addDimension(
                    VariantSelection.builder()
                        .label("Size, Color, etc.")
                        .value("Small, Red, XS, L, etc.")
                        .build()
                )
                .addImage(
                    ProductImage.builder()
                        .isFeatured(true)
                        .url("https://example.com/images/product-123.jpg")
                        .build()
                )
                .name("name")
                .price(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .sku("sku")
                .build()

        val roundtrippedProductVariant =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(productVariant),
                jacksonTypeRef<ProductVariant>(),
            )

        assertThat(roundtrippedProductVariant).isEqualTo(productVariant)
    }
}
