// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BuyerTest {

    @Test
    fun create() {
        val buyer =
            Buyer.builder()
                .address1("123 Main St")
                .city("New York")
                .country("US")
                .email("john.doe@example.com")
                .firstName("John")
                .lastName("Doe")
                .phone("1234567890")
                .postalCode("10001")
                .province("NY")
                .address2("Apt 1")
                .build()

        assertThat(buyer.address1()).isEqualTo("123 Main St")
        assertThat(buyer.city()).isEqualTo("New York")
        assertThat(buyer.country()).isEqualTo("US")
        assertThat(buyer.email()).isEqualTo("john.doe@example.com")
        assertThat(buyer.firstName()).isEqualTo("John")
        assertThat(buyer.lastName()).isEqualTo("Doe")
        assertThat(buyer.phone()).isEqualTo("1234567890")
        assertThat(buyer.postalCode()).isEqualTo("10001")
        assertThat(buyer.province()).isEqualTo("NY")
        assertThat(buyer.address2()).contains("Apt 1")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val buyer =
            Buyer.builder()
                .address1("123 Main St")
                .city("New York")
                .country("US")
                .email("john.doe@example.com")
                .firstName("John")
                .lastName("Doe")
                .phone("1234567890")
                .postalCode("10001")
                .province("NY")
                .address2("Apt 1")
                .build()

        val roundtrippedBuyer =
            jsonMapper.readValue(jsonMapper.writeValueAsString(buyer), jacksonTypeRef<Buyer>())

        assertThat(roundtrippedBuyer).isEqualTo(buyer)
    }
}
