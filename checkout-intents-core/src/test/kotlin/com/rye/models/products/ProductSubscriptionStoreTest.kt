// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductSubscriptionStoreTest {

    @Test
    fun create() {
        val productSubscriptionStore =
            ProductSubscriptionStore.builder()
                .domain("domain")
                .subscribed(true)
                .type(ProductSubscriptionStore.Type.STORE)
                .url("url")
                .build()

        assertThat(productSubscriptionStore.domain()).isEqualTo("domain")
        assertThat(productSubscriptionStore.subscribed()).isEqualTo(true)
        assertThat(productSubscriptionStore.type()).isEqualTo(ProductSubscriptionStore.Type.STORE)
        assertThat(productSubscriptionStore.url()).isEqualTo("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val productSubscriptionStore =
            ProductSubscriptionStore.builder()
                .domain("domain")
                .subscribed(true)
                .type(ProductSubscriptionStore.Type.STORE)
                .url("url")
                .build()

        val roundtrippedProductSubscriptionStore =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(productSubscriptionStore),
                jacksonTypeRef<ProductSubscriptionStore>(),
            )

        assertThat(roundtrippedProductSubscriptionStore).isEqualTo(productSubscriptionStore)
    }
}
