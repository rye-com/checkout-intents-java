// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.checkRequired
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Per-transition timestamps for a Return. `requestedAt` is always set; the rest fill in as the
 * Return advances and reflect the path it actually took (a `denied` Return has `deniedAt` but never
 * `refundedAt`).
 */
class ReturnTimeline
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val requestedAt: JsonField<OffsetDateTime>,
    private val deniedAt: JsonField<OffsetDateTime>,
    private val failedAt: JsonField<OffsetDateTime>,
    private val refundedAt: JsonField<OffsetDateTime>,
    private val refundIssuedAt: JsonField<OffsetDateTime>,
    private val returnApprovedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("requestedAt")
        @ExcludeMissing
        requestedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("deniedAt")
        @ExcludeMissing
        deniedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("failedAt")
        @ExcludeMissing
        failedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("refundedAt")
        @ExcludeMissing
        refundedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("refundIssuedAt")
        @ExcludeMissing
        refundIssuedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("returnApprovedAt")
        @ExcludeMissing
        returnApprovedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        requestedAt,
        deniedAt,
        failedAt,
        refundedAt,
        refundIssuedAt,
        returnApprovedAt,
        mutableMapOf(),
    )

    /**
     * When the return was requested. Always present.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestedAt(): OffsetDateTime = requestedAt.getRequired("requestedAt")

    /**
     * When the return was denied. Present only on `denied`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun deniedAt(): Optional<OffsetDateTime> = deniedAt.getOptional("deniedAt")

    /**
     * When the return failed. Present only on `failed`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun failedAt(): Optional<OffsetDateTime> = failedAt.getOptional("failedAt")

    /**
     * When the refund was fully reconciled and the Return reached `refunded`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun refundedAt(): Optional<OffsetDateTime> = refundedAt.getOptional("refundedAt")

    /**
     * When the merchant issued the refund on its side.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun refundIssuedAt(): Optional<OffsetDateTime> = refundIssuedAt.getOptional("refundIssuedAt")

    /**
     * When the merchant approved the return.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun returnApprovedAt(): Optional<OffsetDateTime> =
        returnApprovedAt.getOptional("returnApprovedAt")

    /**
     * Returns the raw JSON value of [requestedAt].
     *
     * Unlike [requestedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requestedAt")
    @ExcludeMissing
    fun _requestedAt(): JsonField<OffsetDateTime> = requestedAt

    /**
     * Returns the raw JSON value of [deniedAt].
     *
     * Unlike [deniedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deniedAt") @ExcludeMissing fun _deniedAt(): JsonField<OffsetDateTime> = deniedAt

    /**
     * Returns the raw JSON value of [failedAt].
     *
     * Unlike [failedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failedAt") @ExcludeMissing fun _failedAt(): JsonField<OffsetDateTime> = failedAt

    /**
     * Returns the raw JSON value of [refundedAt].
     *
     * Unlike [refundedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("refundedAt")
    @ExcludeMissing
    fun _refundedAt(): JsonField<OffsetDateTime> = refundedAt

    /**
     * Returns the raw JSON value of [refundIssuedAt].
     *
     * Unlike [refundIssuedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("refundIssuedAt")
    @ExcludeMissing
    fun _refundIssuedAt(): JsonField<OffsetDateTime> = refundIssuedAt

    /**
     * Returns the raw JSON value of [returnApprovedAt].
     *
     * Unlike [returnApprovedAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("returnApprovedAt")
    @ExcludeMissing
    fun _returnApprovedAt(): JsonField<OffsetDateTime> = returnApprovedAt

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ReturnTimeline].
         *
         * The following fields are required:
         * ```java
         * .requestedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ReturnTimeline]. */
    class Builder internal constructor() {

        private var requestedAt: JsonField<OffsetDateTime>? = null
        private var deniedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var failedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var refundedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var refundIssuedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var returnApprovedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(returnTimeline: ReturnTimeline) = apply {
            requestedAt = returnTimeline.requestedAt
            deniedAt = returnTimeline.deniedAt
            failedAt = returnTimeline.failedAt
            refundedAt = returnTimeline.refundedAt
            refundIssuedAt = returnTimeline.refundIssuedAt
            returnApprovedAt = returnTimeline.returnApprovedAt
            additionalProperties = returnTimeline.additionalProperties.toMutableMap()
        }

        /** When the return was requested. Always present. */
        fun requestedAt(requestedAt: OffsetDateTime) = requestedAt(JsonField.of(requestedAt))

        /**
         * Sets [Builder.requestedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requestedAt(requestedAt: JsonField<OffsetDateTime>) = apply {
            this.requestedAt = requestedAt
        }

        /** When the return was denied. Present only on `denied`. */
        fun deniedAt(deniedAt: OffsetDateTime) = deniedAt(JsonField.of(deniedAt))

        /**
         * Sets [Builder.deniedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deniedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deniedAt(deniedAt: JsonField<OffsetDateTime>) = apply { this.deniedAt = deniedAt }

        /** When the return failed. Present only on `failed`. */
        fun failedAt(failedAt: OffsetDateTime) = failedAt(JsonField.of(failedAt))

        /**
         * Sets [Builder.failedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun failedAt(failedAt: JsonField<OffsetDateTime>) = apply { this.failedAt = failedAt }

        /** When the refund was fully reconciled and the Return reached `refunded`. */
        fun refundedAt(refundedAt: OffsetDateTime) = refundedAt(JsonField.of(refundedAt))

        /**
         * Sets [Builder.refundedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.refundedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun refundedAt(refundedAt: JsonField<OffsetDateTime>) = apply {
            this.refundedAt = refundedAt
        }

        /** When the merchant issued the refund on its side. */
        fun refundIssuedAt(refundIssuedAt: OffsetDateTime) =
            refundIssuedAt(JsonField.of(refundIssuedAt))

        /**
         * Sets [Builder.refundIssuedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.refundIssuedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun refundIssuedAt(refundIssuedAt: JsonField<OffsetDateTime>) = apply {
            this.refundIssuedAt = refundIssuedAt
        }

        /** When the merchant approved the return. */
        fun returnApprovedAt(returnApprovedAt: OffsetDateTime) =
            returnApprovedAt(JsonField.of(returnApprovedAt))

        /**
         * Sets [Builder.returnApprovedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.returnApprovedAt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun returnApprovedAt(returnApprovedAt: JsonField<OffsetDateTime>) = apply {
            this.returnApprovedAt = returnApprovedAt
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [ReturnTimeline].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .requestedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ReturnTimeline =
            ReturnTimeline(
                checkRequired("requestedAt", requestedAt),
                deniedAt,
                failedAt,
                refundedAt,
                refundIssuedAt,
                returnApprovedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws CheckoutIntentsInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): ReturnTimeline = apply {
        if (validated) {
            return@apply
        }

        requestedAt()
        deniedAt()
        failedAt()
        refundedAt()
        refundIssuedAt()
        returnApprovedAt()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: CheckoutIntentsInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (requestedAt.asKnown().isPresent) 1 else 0) +
            (if (deniedAt.asKnown().isPresent) 1 else 0) +
            (if (failedAt.asKnown().isPresent) 1 else 0) +
            (if (refundedAt.asKnown().isPresent) 1 else 0) +
            (if (refundIssuedAt.asKnown().isPresent) 1 else 0) +
            (if (returnApprovedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ReturnTimeline &&
            requestedAt == other.requestedAt &&
            deniedAt == other.deniedAt &&
            failedAt == other.failedAt &&
            refundedAt == other.refundedAt &&
            refundIssuedAt == other.refundIssuedAt &&
            returnApprovedAt == other.returnApprovedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            requestedAt,
            deniedAt,
            failedAt,
            refundedAt,
            refundIssuedAt,
            returnApprovedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ReturnTimeline{requestedAt=$requestedAt, deniedAt=$deniedAt, failedAt=$failedAt, refundedAt=$refundedAt, refundIssuedAt=$refundIssuedAt, returnApprovedAt=$returnApprovedAt, additionalProperties=$additionalProperties}"
}
