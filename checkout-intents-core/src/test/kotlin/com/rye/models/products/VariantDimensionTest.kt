// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VariantDimensionTest {

    @Test
    fun create() {
        val variantDimension = VariantDimension.builder().label("label").addValue("string").build()

        assertThat(variantDimension.label()).isEqualTo("label")
        assertThat(variantDimension.values()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val variantDimension = VariantDimension.builder().label("label").addValue("string").build()

        val roundtrippedVariantDimension =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(variantDimension),
                jacksonTypeRef<VariantDimension>(),
            )

        assertThat(roundtrippedVariantDimension).isEqualTo(variantDimension)
    }
}
