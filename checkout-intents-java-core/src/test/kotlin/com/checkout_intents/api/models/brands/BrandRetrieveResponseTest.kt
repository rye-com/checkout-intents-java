// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.brands

import com.checkout_intents.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandRetrieveResponseTest {

    @Test
    fun create() {
        val brandRetrieveResponse =
            BrandRetrieveResponse.builder()
                .id("id")
                .marketplace(BrandRetrieveResponse.Marketplace.AMAZON)
                .supported(true)
                .build()

        assertThat(brandRetrieveResponse.id()).isEqualTo("id")
        assertThat(brandRetrieveResponse.marketplace())
            .isEqualTo(BrandRetrieveResponse.Marketplace.AMAZON)
        assertThat(brandRetrieveResponse.supported()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandRetrieveResponse =
            BrandRetrieveResponse.builder()
                .id("id")
                .marketplace(BrandRetrieveResponse.Marketplace.AMAZON)
                .supported(true)
                .build()

        val roundtrippedBrandRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandRetrieveResponse),
                jacksonTypeRef<BrandRetrieveResponse>(),
            )

        assertThat(roundtrippedBrandRetrieveResponse).isEqualTo(brandRetrieveResponse)
    }
}
