// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.JsonValue
import com.rye.core.jsonMapper
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ShipmentTest {

    @Test
    fun ofWithStatusBaseShipmentWithTrackingShipped() {
        val withStatusBaseShipmentWithTrackingShipped =
            Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .externalId("externalId")
                .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                .tracking(
                    ShipmentTracking.builder()
                        .number("number")
                        .carrierName("carrierName")
                        .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("url")
                        .build()
                )
                .addTrackingEvent(
                    Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent.builder()
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

        val shipment =
            Shipment.ofWithStatusBaseShipmentWithTrackingShipped(
                withStatusBaseShipmentWithTrackingShipped
            )

        assertThat(shipment.withStatusBaseShipmentWithTrackingShipped())
            .contains(withStatusBaseShipmentWithTrackingShipped)
        assertThat(shipment.delivered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingDelayed()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingOutForDelivery()).isEmpty
        assertThat(shipment.withStatusBaseShipmentOrdered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentCanceled()).isEmpty
    }

    @Test
    fun ofWithStatusBaseShipmentWithTrackingShippedRoundtrip() {
        val jsonMapper = jsonMapper()
        val shipment =
            Shipment.ofWithStatusBaseShipmentWithTrackingShipped(
                Shipment.WithStatusBaseShipmentWithTrackingShipped.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .externalId("externalId")
                    .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(Shipment.WithStatusBaseShipmentWithTrackingShipped.Status.SHIPPED)
                    .tracking(
                        ShipmentTracking.builder()
                            .number("number")
                            .carrierName("carrierName")
                            .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .url("url")
                            .build()
                    )
                    .addTrackingEvent(
                        Shipment.WithStatusBaseShipmentWithTrackingShipped.TrackingEvent.builder()
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

        val roundtrippedShipment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipment),
                jacksonTypeRef<Shipment>(),
            )

        assertThat(roundtrippedShipment).isEqualTo(shipment)
    }

    @Test
    fun ofDelivered() {
        val delivered =
            Shipment.DeliveredShipment.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .externalId("externalId")
                .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Shipment.DeliveredShipment.Status.DELIVERED)
                .tracking(
                    ShipmentTracking.builder()
                        .number("number")
                        .carrierName("carrierName")
                        .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("url")
                        .build()
                )
                .addTrackingEvent(
                    Shipment.DeliveredShipment.TrackingEvent.builder()
                        .description("description")
                        .displayDate("displayDate")
                        .displayTime("displayTime")
                        .location(
                            Shipment.DeliveredShipment.TrackingEvent.Location.builder()
                                .city("city")
                                .country("country")
                                .province("province")
                                .build()
                        )
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val shipment = Shipment.ofDelivered(delivered)

        assertThat(shipment.withStatusBaseShipmentWithTrackingShipped()).isEmpty
        assertThat(shipment.delivered()).contains(delivered)
        assertThat(shipment.withStatusBaseShipmentWithTrackingDelayed()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingOutForDelivery()).isEmpty
        assertThat(shipment.withStatusBaseShipmentOrdered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentCanceled()).isEmpty
    }

    @Test
    fun ofDeliveredRoundtrip() {
        val jsonMapper = jsonMapper()
        val shipment =
            Shipment.ofDelivered(
                Shipment.DeliveredShipment.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .deliveredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .externalId("externalId")
                    .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(Shipment.DeliveredShipment.Status.DELIVERED)
                    .tracking(
                        ShipmentTracking.builder()
                            .number("number")
                            .carrierName("carrierName")
                            .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .url("url")
                            .build()
                    )
                    .addTrackingEvent(
                        Shipment.DeliveredShipment.TrackingEvent.builder()
                            .description("description")
                            .displayDate("displayDate")
                            .displayTime("displayTime")
                            .location(
                                Shipment.DeliveredShipment.TrackingEvent.Location.builder()
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

        val roundtrippedShipment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipment),
                jacksonTypeRef<Shipment>(),
            )

        assertThat(roundtrippedShipment).isEqualTo(shipment)
    }

    @Test
    fun ofWithStatusBaseShipmentWithTrackingDelayed() {
        val withStatusBaseShipmentWithTrackingDelayed =
            Shipment.WithStatusBaseShipmentWithTrackingDelayed.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .externalId("externalId")
                .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Shipment.WithStatusBaseShipmentWithTrackingDelayed.Status.DELAYED)
                .tracking(
                    ShipmentTracking.builder()
                        .number("number")
                        .carrierName("carrierName")
                        .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("url")
                        .build()
                )
                .addTrackingEvent(
                    Shipment.WithStatusBaseShipmentWithTrackingDelayed.TrackingEvent.builder()
                        .description("description")
                        .displayDate("displayDate")
                        .displayTime("displayTime")
                        .location(
                            Shipment.WithStatusBaseShipmentWithTrackingDelayed.TrackingEvent
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

        val shipment =
            Shipment.ofWithStatusBaseShipmentWithTrackingDelayed(
                withStatusBaseShipmentWithTrackingDelayed
            )

        assertThat(shipment.withStatusBaseShipmentWithTrackingShipped()).isEmpty
        assertThat(shipment.delivered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingDelayed())
            .contains(withStatusBaseShipmentWithTrackingDelayed)
        assertThat(shipment.withStatusBaseShipmentWithTrackingOutForDelivery()).isEmpty
        assertThat(shipment.withStatusBaseShipmentOrdered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentCanceled()).isEmpty
    }

    @Test
    fun ofWithStatusBaseShipmentWithTrackingDelayedRoundtrip() {
        val jsonMapper = jsonMapper()
        val shipment =
            Shipment.ofWithStatusBaseShipmentWithTrackingDelayed(
                Shipment.WithStatusBaseShipmentWithTrackingDelayed.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .externalId("externalId")
                    .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(Shipment.WithStatusBaseShipmentWithTrackingDelayed.Status.DELAYED)
                    .tracking(
                        ShipmentTracking.builder()
                            .number("number")
                            .carrierName("carrierName")
                            .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .url("url")
                            .build()
                    )
                    .addTrackingEvent(
                        Shipment.WithStatusBaseShipmentWithTrackingDelayed.TrackingEvent.builder()
                            .description("description")
                            .displayDate("displayDate")
                            .displayTime("displayTime")
                            .location(
                                Shipment.WithStatusBaseShipmentWithTrackingDelayed.TrackingEvent
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

        val roundtrippedShipment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipment),
                jacksonTypeRef<Shipment>(),
            )

        assertThat(roundtrippedShipment).isEqualTo(shipment)
    }

    @Test
    fun ofWithStatusBaseShipmentWithTrackingOutForDelivery() {
        val withStatusBaseShipmentWithTrackingOutForDelivery =
            Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .externalId("externalId")
                .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(
                    Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery.Status
                        .OUT_FOR_DELIVERY
                )
                .tracking(
                    ShipmentTracking.builder()
                        .number("number")
                        .carrierName("carrierName")
                        .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("url")
                        .build()
                )
                .addTrackingEvent(
                    Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery.TrackingEvent
                        .builder()
                        .description("description")
                        .displayDate("displayDate")
                        .displayTime("displayTime")
                        .location(
                            Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery.TrackingEvent
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

        val shipment =
            Shipment.ofWithStatusBaseShipmentWithTrackingOutForDelivery(
                withStatusBaseShipmentWithTrackingOutForDelivery
            )

        assertThat(shipment.withStatusBaseShipmentWithTrackingShipped()).isEmpty
        assertThat(shipment.delivered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingDelayed()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingOutForDelivery())
            .contains(withStatusBaseShipmentWithTrackingOutForDelivery)
        assertThat(shipment.withStatusBaseShipmentOrdered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentCanceled()).isEmpty
    }

    @Test
    fun ofWithStatusBaseShipmentWithTrackingOutForDeliveryRoundtrip() {
        val jsonMapper = jsonMapper()
        val shipment =
            Shipment.ofWithStatusBaseShipmentWithTrackingOutForDelivery(
                Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .externalId("externalId")
                    .shippedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(
                        Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery.Status
                            .OUT_FOR_DELIVERY
                    )
                    .tracking(
                        ShipmentTracking.builder()
                            .number("number")
                            .carrierName("carrierName")
                            .estimatedDeliveryDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .url("url")
                            .build()
                    )
                    .addTrackingEvent(
                        Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery.TrackingEvent
                            .builder()
                            .description("description")
                            .displayDate("displayDate")
                            .displayTime("displayTime")
                            .location(
                                Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery
                                    .TrackingEvent
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

        val roundtrippedShipment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipment),
                jacksonTypeRef<Shipment>(),
            )

        assertThat(roundtrippedShipment).isEqualTo(shipment)
    }

    @Test
    fun ofWithStatusBaseShipmentOrdered() {
        val withStatusBaseShipmentOrdered =
            Shipment.WithStatusBaseShipmentOrdered.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Shipment.WithStatusBaseShipmentOrdered.Status.ORDERED)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val shipment = Shipment.ofWithStatusBaseShipmentOrdered(withStatusBaseShipmentOrdered)

        assertThat(shipment.withStatusBaseShipmentWithTrackingShipped()).isEmpty
        assertThat(shipment.delivered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingDelayed()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingOutForDelivery()).isEmpty
        assertThat(shipment.withStatusBaseShipmentOrdered()).contains(withStatusBaseShipmentOrdered)
        assertThat(shipment.withStatusBaseShipmentCanceled()).isEmpty
    }

    @Test
    fun ofWithStatusBaseShipmentOrderedRoundtrip() {
        val jsonMapper = jsonMapper()
        val shipment =
            Shipment.ofWithStatusBaseShipmentOrdered(
                Shipment.WithStatusBaseShipmentOrdered.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(Shipment.WithStatusBaseShipmentOrdered.Status.ORDERED)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        val roundtrippedShipment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipment),
                jacksonTypeRef<Shipment>(),
            )

        assertThat(roundtrippedShipment).isEqualTo(shipment)
    }

    @Test
    fun ofWithStatusBaseShipmentCanceled() {
        val withStatusBaseShipmentCanceled =
            Shipment.WithStatusBaseShipmentCanceled.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Shipment.WithStatusBaseShipmentCanceled.Status.CANCELED)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val shipment = Shipment.ofWithStatusBaseShipmentCanceled(withStatusBaseShipmentCanceled)

        assertThat(shipment.withStatusBaseShipmentWithTrackingShipped()).isEmpty
        assertThat(shipment.delivered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingDelayed()).isEmpty
        assertThat(shipment.withStatusBaseShipmentWithTrackingOutForDelivery()).isEmpty
        assertThat(shipment.withStatusBaseShipmentOrdered()).isEmpty
        assertThat(shipment.withStatusBaseShipmentCanceled())
            .contains(withStatusBaseShipmentCanceled)
    }

    @Test
    fun ofWithStatusBaseShipmentCanceledRoundtrip() {
        val jsonMapper = jsonMapper()
        val shipment =
            Shipment.ofWithStatusBaseShipmentCanceled(
                Shipment.WithStatusBaseShipmentCanceled.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(Shipment.WithStatusBaseShipmentCanceled.Status.CANCELED)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        val roundtrippedShipment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shipment),
                jacksonTypeRef<Shipment>(),
            )

        assertThat(roundtrippedShipment).isEqualTo(shipment)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val shipment = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Shipment>())

        val e = assertThrows<CheckoutIntentsInvalidDataException> { shipment.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
