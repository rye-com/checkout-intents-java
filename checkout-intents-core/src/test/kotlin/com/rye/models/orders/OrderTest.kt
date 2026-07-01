// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderTest {

    @Test
    fun create() {
        val order =
            Order.builder()
                .id("id")
                .checkoutIntentId("ci_aaa8af5c5aae4c0e8ef0172c26c65c13")
                .createdAt("2026-03-25T00:00:00Z")
                .updatedAt("2026-03-27T00:00:00Z")
                .referenceId("order-1234")
                .build()

        assertThat(order.id()).isEqualTo("id")
        assertThat(order.checkoutIntentId()).isEqualTo("ci_aaa8af5c5aae4c0e8ef0172c26c65c13")
        assertThat(order.createdAt()).isEqualTo("2026-03-25T00:00:00Z")
        assertThat(order.updatedAt()).isEqualTo("2026-03-27T00:00:00Z")
        assertThat(order.referenceId()).contains("order-1234")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val order =
            Order.builder()
                .id("id")
                .checkoutIntentId("ci_aaa8af5c5aae4c0e8ef0172c26c65c13")
                .createdAt("2026-03-25T00:00:00Z")
                .updatedAt("2026-03-27T00:00:00Z")
                .referenceId("order-1234")
                .build()

        val roundtrippedOrder =
            jsonMapper.readValue(jsonMapper.writeValueAsString(order), jacksonTypeRef<Order>())

        assertThat(roundtrippedOrder).isEqualTo(order)
    }
}
