// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductSubscribeParamsTest {

    @Test
    fun create() {
        ProductSubscribeParams.builder()
            .type(ProductSubscribeParams.Type.STORE)
            .url("https://store.com")
            .build()
    }

    @Test
    fun body() {
        val params =
            ProductSubscribeParams.builder()
                .type(ProductSubscribeParams.Type.STORE)
                .url("https://store.com")
                .build()

        val body = params._body()

        assertThat(body.type()).isEqualTo(ProductSubscribeParams.Type.STORE)
        assertThat(body.url()).isEqualTo("https://store.com")
    }
}
