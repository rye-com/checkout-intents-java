// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductTest {

    @Test
    fun create() {
        val product =
            Product.builder()
                .id("amazon.com:B0DFC9MT8Q")
                .availability(ProductAvailability.IN_STOCK)
                .brand("Acme")
                .description("A high-quality widget designed for professionals.")
                .addImage(
                    ProductImage.builder()
                        .isFeatured(true)
                        .url("https://example.com/images/product-123.jpg")
                        .build()
                )
                .name("Widget Pro")
                .price(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .sku("SKU-12345")
                .url("https://example.com/products/widget-pro")
                .build()

        assertThat(product.id()).isEqualTo("amazon.com:B0DFC9MT8Q")
        assertThat(product.availability()).isEqualTo(ProductAvailability.IN_STOCK)
        assertThat(product.brand()).contains("Acme")
        assertThat(product.description())
            .contains("A high-quality widget designed for professionals.")
        assertThat(product.images())
            .containsExactly(
                ProductImage.builder()
                    .isFeatured(true)
                    .url("https://example.com/images/product-123.jpg")
                    .build()
            )
        assertThat(product.name()).isEqualTo("Widget Pro")
        assertThat(product.price())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
        assertThat(product.sku()).contains("SKU-12345")
        assertThat(product.url()).isEqualTo("https://example.com/products/widget-pro")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val product =
            Product.builder()
                .id("amazon.com:B0DFC9MT8Q")
                .availability(ProductAvailability.IN_STOCK)
                .brand("Acme")
                .description("A high-quality widget designed for professionals.")
                .addImage(
                    ProductImage.builder()
                        .isFeatured(true)
                        .url("https://example.com/images/product-123.jpg")
                        .build()
                )
                .name("Widget Pro")
                .price(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .sku("SKU-12345")
                .url("https://example.com/products/widget-pro")
                .build()

        val roundtrippedProduct =
            jsonMapper.readValue(jsonMapper.writeValueAsString(product), jacksonTypeRef<Product>())

        assertThat(roundtrippedProduct).isEqualTo(product)
    }
}
