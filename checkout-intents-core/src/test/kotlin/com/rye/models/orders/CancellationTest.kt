// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

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

internal class CancellationTest {

    @Test
    fun ofRequested() {
        val requested =
            Cancellation.RequestedCancellation.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .marketplaceOrderId("marketplaceOrderId")
                .reason(
                    Cancellation.RequestedCancellation.Reason.builder()
                        .code(Cancellation.RequestedCancellation.Reason.Code.REQUESTED_BY_CUSTOMER)
                        .message("message")
                        .build()
                )
                .state(Cancellation.RequestedCancellation.State.REQUESTED)
                .build()

        val cancellation = Cancellation.ofRequested(requested)

        assertThat(cancellation.requested()).contains(requested)
        assertThat(cancellation.completed()).isEmpty
        assertThat(cancellation.denied()).isEmpty
    }

    @Test
    fun ofRequestedRoundtrip() {
        val jsonMapper = jsonMapper()
        val cancellation =
            Cancellation.ofRequested(
                Cancellation.RequestedCancellation.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .marketplaceOrderId("marketplaceOrderId")
                    .reason(
                        Cancellation.RequestedCancellation.Reason.builder()
                            .code(
                                Cancellation.RequestedCancellation.Reason.Code.REQUESTED_BY_CUSTOMER
                            )
                            .message("message")
                            .build()
                    )
                    .state(Cancellation.RequestedCancellation.State.REQUESTED)
                    .build()
            )

        val roundtrippedCancellation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(cancellation),
                jacksonTypeRef<Cancellation>(),
            )

        assertThat(roundtrippedCancellation).isEqualTo(cancellation)
    }

    @Test
    fun ofCompleted() {
        val completed =
            Cancellation.CompletedCancellation.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .marketplaceOrderId("marketplaceOrderId")
                .reason(
                    Cancellation.CompletedCancellation.Reason.builder()
                        .code(Cancellation.CompletedCancellation.Reason.Code.REQUESTED_BY_CUSTOMER)
                        .message("message")
                        .build()
                )
                .state(Cancellation.CompletedCancellation.State.COMPLETED)
                .build()

        val cancellation = Cancellation.ofCompleted(completed)

        assertThat(cancellation.requested()).isEmpty
        assertThat(cancellation.completed()).contains(completed)
        assertThat(cancellation.denied()).isEmpty
    }

    @Test
    fun ofCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val cancellation =
            Cancellation.ofCompleted(
                Cancellation.CompletedCancellation.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .marketplaceOrderId("marketplaceOrderId")
                    .reason(
                        Cancellation.CompletedCancellation.Reason.builder()
                            .code(
                                Cancellation.CompletedCancellation.Reason.Code.REQUESTED_BY_CUSTOMER
                            )
                            .message("message")
                            .build()
                    )
                    .state(Cancellation.CompletedCancellation.State.COMPLETED)
                    .build()
            )

        val roundtrippedCancellation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(cancellation),
                jacksonTypeRef<Cancellation>(),
            )

        assertThat(roundtrippedCancellation).isEqualTo(cancellation)
    }

    @Test
    fun ofDenied() {
        val denied =
            Cancellation.DeniedCancellation.builder()
                .id("id")
                .checkoutIntentId("checkoutIntentId")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .denialReason(
                    Cancellation.DeniedCancellation.DenialReason.builder()
                        .code(Cancellation.DeniedCancellation.DenialReason.Code.OTHER)
                        .message("message")
                        .build()
                )
                .marketplaceOrderId("marketplaceOrderId")
                .reason(
                    Cancellation.DeniedCancellation.Reason.builder()
                        .code(Cancellation.DeniedCancellation.Reason.Code.REQUESTED_BY_CUSTOMER)
                        .message("message")
                        .build()
                )
                .state(Cancellation.DeniedCancellation.State.DENIED)
                .build()

        val cancellation = Cancellation.ofDenied(denied)

        assertThat(cancellation.requested()).isEmpty
        assertThat(cancellation.completed()).isEmpty
        assertThat(cancellation.denied()).contains(denied)
    }

    @Test
    fun ofDeniedRoundtrip() {
        val jsonMapper = jsonMapper()
        val cancellation =
            Cancellation.ofDenied(
                Cancellation.DeniedCancellation.builder()
                    .id("id")
                    .checkoutIntentId("checkoutIntentId")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .denialReason(
                        Cancellation.DeniedCancellation.DenialReason.builder()
                            .code(Cancellation.DeniedCancellation.DenialReason.Code.OTHER)
                            .message("message")
                            .build()
                    )
                    .marketplaceOrderId("marketplaceOrderId")
                    .reason(
                        Cancellation.DeniedCancellation.Reason.builder()
                            .code(Cancellation.DeniedCancellation.Reason.Code.REQUESTED_BY_CUSTOMER)
                            .message("message")
                            .build()
                    )
                    .state(Cancellation.DeniedCancellation.State.DENIED)
                    .build()
            )

        val roundtrippedCancellation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(cancellation),
                jacksonTypeRef<Cancellation>(),
            )

        assertThat(roundtrippedCancellation).isEqualTo(cancellation)
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
        val cancellation = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Cancellation>())

        val e = assertThrows<CheckoutIntentsInvalidDataException> { cancellation.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
