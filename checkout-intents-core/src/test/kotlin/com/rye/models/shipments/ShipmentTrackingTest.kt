// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShipmentTrackingTest {

    @Test
    fun create() {
        val shipmentTracking =
            ShipmentTracking.builder()
                .number("number")
                .carrierName("carrierName")
                .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("url")
                .build()

        assertThat(shipmentTracking.number()).contains("number")
        assertThat(shipmentTracking.carrierName()).contains("carrierName")
        assertThat(shipmentTracking.estimatedDeliveryDate())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(shipmentTracking.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val shipmentTracking =
            ShipmentTracking.builder()
                .number("number")
                .carrierName("carrierName")
                .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .url("url")
                .build()

        val roundtrippedShipmentTracking =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipmentTracking),
                jacksonTypeRef<ShipmentTracking>(),
            )

        assertThat(roundtrippedShipmentTracking).isEqualTo(shipmentTracking)
    }
}
