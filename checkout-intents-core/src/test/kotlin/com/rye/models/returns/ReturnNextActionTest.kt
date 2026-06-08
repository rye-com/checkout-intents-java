// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnNextActionTest {

    @Test
    fun create() {
        val returnNextAction =
            ReturnNextAction.builder()
                .type(ReturnNextAction.Type.SHIP_ITEMS_TO_MERCHANT)
                .shipItemsToMerchant(
                    ReturnNextAction.ShipItemsToMerchant.builder()
                        .label(
                            ReturnNextAction.ShipItemsToMerchant.Label.builder().url("url").build()
                        )
                        .build()
                )
                .build()

        assertThat(returnNextAction.type()).isEqualTo(ReturnNextAction.Type.SHIP_ITEMS_TO_MERCHANT)
        assertThat(returnNextAction.shipItemsToMerchant())
            .contains(
                ReturnNextAction.ShipItemsToMerchant.builder()
                    .label(ReturnNextAction.ShipItemsToMerchant.Label.builder().url("url").build())
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val returnNextAction =
            ReturnNextAction.builder()
                .type(ReturnNextAction.Type.SHIP_ITEMS_TO_MERCHANT)
                .shipItemsToMerchant(
                    ReturnNextAction.ShipItemsToMerchant.builder()
                        .label(
                            ReturnNextAction.ShipItemsToMerchant.Label.builder().url("url").build()
                        )
                        .build()
                )
                .build()

        val roundtrippedReturnNextAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(returnNextAction),
                jacksonTypeRef<ReturnNextAction>(),
            )

        assertThat(roundtrippedReturnNextAction).isEqualTo(returnNextAction)
    }
}
