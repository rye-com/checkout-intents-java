// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShipmentListPageResponseTest {

    @Test
    fun create() {
        val shipmentListPageResponse =
            ShipmentListPageResponse.builder()
                .addData(
                    Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .externalId("externalId")
                        .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                        .tracking(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.Tracking.builder()
                                .number("number")
                                .carrierName("carrierName")
                                .estimatedDeliveryDate(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .url("url")
                                .build()
                        )
                        .addTrackingEvent(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                .builder()
                                .description("description")
                                .displayDate("displayDate")
                                .displayTime("displayTime")
                                .location(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Location
                                        .builder()
                                        .city("city")
                                        .country("country")
                                        .province("province")
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .pageInfo(
                    ShipmentListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        assertThat(shipmentListPageResponse.data())
            .containsExactly(
                Shipment.ofWithStatusBaseShipmentWithTrackingShipped(
                    Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .externalId("externalId")
                        .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                        .tracking(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.Tracking.builder()
                                .number("number")
                                .carrierName("carrierName")
                                .estimatedDeliveryDate(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .url("url")
                                .build()
                        )
                        .addTrackingEvent(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                .builder()
                                .description("description")
                                .displayDate("displayDate")
                                .displayTime("displayTime")
                                .location(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Location
                                        .builder()
                                        .city("city")
                                        .country("country")
                                        .province("province")
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            )
        assertThat(shipmentListPageResponse.pageInfo())
            .isEqualTo(
                ShipmentListPageResponse.PageInfo.builder()
                    .hasNextPage(true)
                    .hasPreviousPage(true)
                    .endCursor("endCursor")
                    .startCursor("startCursor")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val shipmentListPageResponse =
            ShipmentListPageResponse.builder()
                .addData(
                    Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                        .id("id")
                        .checkoutIntentId("checkoutIntentId")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .externalId("externalId")
                        .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                        .tracking(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.Tracking.builder()
                                .number("number")
                                .carrierName("carrierName")
                                .estimatedDeliveryDate(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .url("url")
                                .build()
                        )
                        .addTrackingEvent(
                            Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                .builder()
                                .description("description")
                                .displayDate("displayDate")
                                .displayTime("displayTime")
                                .location(
                                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent
                                        .Location
                                        .builder()
                                        .city("city")
                                        .country("country")
                                        .province("province")
                                        .build()
                                )
                                .build()
                        )
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .pageInfo(
                    ShipmentListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        val roundtrippedShipmentListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipmentListPageResponse),
                jacksonTypeRef<ShipmentListPageResponse>(),
            )

        assertThat(roundtrippedShipmentListPageResponse).isEqualTo(shipmentListPageResponse)
    }
}
