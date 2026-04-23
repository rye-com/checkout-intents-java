// File generated from our OpenAPI spec by Stainless.

package com.rye.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.JsonValue
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventTest {

    @Test
    fun create() {
        val event =
            Event.builder()
                .id("evt_1234567890")
                .createdAt("2026-03-25T00:00:00Z")
                .object_(Event.Object.EVENT)
                .source(
                    Event.Source.builder()
                        .id("ci_1234567890")
                        .type(Event.Source.Type.CHECKOUT_INTENT)
                        .build()
                )
                .type(Event.Type.CHECKOUT_INTENT_OFFER_RETRIEVED)
                .data(
                    Event.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
                )
                .build()

        assertThat(event.id()).isEqualTo("evt_1234567890")
        assertThat(event.createdAt()).isEqualTo("2026-03-25T00:00:00Z")
        assertThat(event.object_()).isEqualTo(Event.Object.EVENT)
        assertThat(event.source())
            .isEqualTo(
                Event.Source.builder()
                    .id("ci_1234567890")
                    .type(Event.Source.Type.CHECKOUT_INTENT)
                    .build()
            )
        assertThat(event.type()).isEqualTo(Event.Type.CHECKOUT_INTENT_OFFER_RETRIEVED)
        assertThat(event.data())
            .contains(
                Event.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.builder()
                .id("evt_1234567890")
                .createdAt("2026-03-25T00:00:00Z")
                .object_(Event.Object.EVENT)
                .source(
                    Event.Source.builder()
                        .id("ci_1234567890")
                        .type(Event.Source.Type.CHECKOUT_INTENT)
                        .build()
                )
                .type(Event.Type.CHECKOUT_INTENT_OFFER_RETRIEVED)
                .data(
                    Event.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
                )
                .build()

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
    }
}
