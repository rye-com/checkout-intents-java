// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductUnsubscribeParamsTest {

    @Test
    fun create() {
        ProductUnsubscribeParams.builder()
            .type(ProductUnsubscribeParams.Type.STORE)
            .url("https://store.myshopify.com")
            .build()
    }

    @Test
    fun body() {
        val params =
            ProductUnsubscribeParams.builder()
                .type(ProductUnsubscribeParams.Type.STORE)
                .url("https://store.myshopify.com")
                .build()

        val body = params._body()

        assertThat(body.type()).isEqualTo(ProductUnsubscribeParams.Type.STORE)
        assertThat(body.url()).isEqualTo("https://store.myshopify.com")
    }
}
