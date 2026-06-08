// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReturnTimelineTest {

    @Test
    fun create() {
        val returnTimeline =
            ReturnTimeline.builder()
                .requestedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deniedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .failedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .refundIssuedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .returnApprovedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(returnTimeline.requestedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(returnTimeline.deniedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(returnTimeline.failedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(returnTimeline.refundedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(returnTimeline.refundIssuedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(returnTimeline.returnApprovedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val returnTimeline =
            ReturnTimeline.builder()
                .requestedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deniedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .failedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .refundedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .refundIssuedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .returnApprovedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedReturnTimeline =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(returnTimeline),
                jacksonTypeRef<ReturnTimeline>(),
            )

        assertThat(roundtrippedReturnTimeline).isEqualTo(returnTimeline)
    }
}
