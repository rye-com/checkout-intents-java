// File generated from our OpenAPI spec by Stainless.

package com.rye.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListPageResponseTest {

    @Test
    fun create() {
        val eventListPageResponse =
            EventListPageResponse.builder()
                .addData(
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
                        .build()
                )
                .pageInfo(
                    EventListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        assertThat(eventListPageResponse.data())
            .containsExactly(
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
                    .build()
            )
        assertThat(eventListPageResponse.pageInfo())
            .isEqualTo(
                EventListPageResponse.PageInfo.builder()
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
        val eventListPageResponse =
            EventListPageResponse.builder()
                .addData(
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
                        .build()
                )
                .pageInfo(
                    EventListPageResponse.PageInfo.builder()
                        .hasNextPage(true)
                        .hasPreviousPage(true)
                        .endCursor("endCursor")
                        .startCursor("startCursor")
                        .build()
                )
                .build()

        val roundtrippedEventListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListPageResponse),
                jacksonTypeRef<EventListPageResponse>(),
            )

        assertThat(roundtrippedEventListPageResponse).isEqualTo(eventListPageResponse)
    }
}
