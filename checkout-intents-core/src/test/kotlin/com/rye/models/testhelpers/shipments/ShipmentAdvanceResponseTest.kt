// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.shipments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.shipments.Shipment
import com.rye.models.shipments.ShipmentStatus
import com.rye.models.shipments.ShipmentTracking
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShipmentAdvanceResponseTest {

    @Test
    fun create() {
        val shipmentAdvanceResponse =
            ShipmentAdvanceResponse.builder()
                .shipment(
                    Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .externalId("externalId")
                        .marketplaceOrderId("marketplaceOrderId")
                        .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                        .tracking(
                            ShipmentTracking.builder()
                                .number("number")
                                .carrierName("carrierName")
                                .deliveryDate(
                                    ShipmentTracking.DeliveryDate.builder()
                                        .estimated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .build()
                                )
                                .url("url")
                                .build()
                        )
                        .addTrackingEvent(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                .builder()
                                .description("description")
                                .location(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Location
                                        .builder()
                                        .city("city")
                                        .country("country")
                                        .province("province")
                                        .build()
                                )
                                .status(ShipmentStatus.OUT_FOR_DELIVERY)
                                .timestamp(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Timestamp
                                        .builder()
                                        .local("local")
                                        .utc(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        assertThat(shipmentAdvanceResponse.shipment())
            .isEqualTo(
                Shipment.ofWithStatusBaseShipmentWithTrackingShipped(
                    Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .externalId("externalId")
                        .marketplaceOrderId("marketplaceOrderId")
                        .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                        .tracking(
                            ShipmentTracking.builder()
                                .number("number")
                                .carrierName("carrierName")
                                .deliveryDate(
                                    ShipmentTracking.DeliveryDate.builder()
                                        .estimated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .build()
                                )
                                .url("url")
                                .build()
                        )
                        .addTrackingEvent(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                .builder()
                                .description("description")
                                .location(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Location
                                        .builder()
                                        .city("city")
                                        .country("country")
                                        .province("province")
                                        .build()
                                )
                                .status(ShipmentStatus.OUT_FOR_DELIVERY)
                                .timestamp(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Timestamp
                                        .builder()
                                        .local("local")
                                        .utc(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val shipmentAdvanceResponse =
            ShipmentAdvanceResponse.builder()
                .shipment(
                    Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .externalId("externalId")
                        .marketplaceOrderId("marketplaceOrderId")
                        .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                        .tracking(
                            ShipmentTracking.builder()
                                .number("number")
                                .carrierName("carrierName")
                                .deliveryDate(
                                    ShipmentTracking.DeliveryDate.builder()
                                        .estimated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .build()
                                )
                                .url("url")
                                .build()
                        )
                        .addTrackingEvent(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                .builder()
                                .description("description")
                                .location(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Location
                                        .builder()
                                        .city("city")
                                        .country("country")
                                        .province("province")
                                        .build()
                                )
                                .status(ShipmentStatus.OUT_FOR_DELIVERY)
                                .timestamp(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Timestamp
                                        .builder()
                                        .local("local")
                                        .utc(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val roundtrippedShipmentAdvanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipmentAdvanceResponse),
                jacksonTypeRef<ShipmentAdvanceResponse>(),
            )

        assertThat(roundtrippedShipmentAdvanceResponse).isEqualTo(shipmentAdvanceResponse)
    }
}
