// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductListSubscriptionsResponseTest {

    @Test
    fun create() {
        val productListSubscriptionsResponse =
            ProductListSubscriptionsResponse.builder()
                .addData(
                    ProductSubscriptionProduct.builder()
                        .id("id")
                        .subscribed(true)
                        .type(ProductSubscriptionProduct.Type.PRODUCT)
                        .url("url")
                        .build()
                )
                .build()

        assertThat(productListSubscriptionsResponse.data())
            .containsExactly(
                ProductSubscription.ofProduct(
                    ProductSubscriptionProduct.builder()
                        .id("id")
                        .subscribed(true)
                        .type(ProductSubscriptionProduct.Type.PRODUCT)
                        .url("url")
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val productListSubscriptionsResponse =
            ProductListSubscriptionsResponse.builder()
                .addData(
                    ProductSubscriptionProduct.builder()
                        .id("id")
                        .subscribed(true)
                        .type(ProductSubscriptionProduct.Type.PRODUCT)
                        .url("url")
                        .build()
                )
                .build()

        val roundtrippedProductListSubscriptionsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(productListSubscriptionsResponse),
                jacksonTypeRef<ProductListSubscriptionsResponse>(),
            )

        assertThat(roundtrippedProductListSubscriptionsResponse)
            .isEqualTo(productListSubscriptionsResponse)
    }
}
