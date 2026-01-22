// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import com.checkout_intents.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VariantSelectionTest {

    @Test
    fun create() {
        val variantSelection =
            VariantSelection.builder()
                .label("Size, Color, etc.")
                .value("Small, Red, XS, L, etc.")
                .build()

        assertThat(variantSelection.label()).isEqualTo("Size, Color, etc.")
        assertThat(variantSelection.value())
            .isEqualTo(VariantSelection.Value.ofString("Small, Red, XS, L, etc."))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val variantSelection =
            VariantSelection.builder()
                .label("Size, Color, etc.")
                .value("Small, Red, XS, L, etc.")
                .build()

        val roundtrippedVariantSelection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(variantSelection),
                jacksonTypeRef<VariantSelection>(),
            )

        assertThat(roundtrippedVariantSelection).isEqualTo(variantSelection)
    }
}
