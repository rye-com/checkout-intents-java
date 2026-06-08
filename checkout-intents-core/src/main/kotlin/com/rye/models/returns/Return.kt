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
import com.rye.core.checkKnown
import com.rye.core.checkRequired
import com.rye.core.toImmutable
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A single Return record. The `state` discriminator tells you which of `denial`, `failure`, and
 * `refunds` is populated; `nextAction` is set once the Return is approved (see {@link
 * NextActionResponse}).
 */
class Return
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val checkoutIntentId: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val orderId: JsonField<String>,
    private val reason: JsonField<ReturnReason>,
    private val state: JsonField<ReturnState>,
    private val timeline: JsonField<ReturnTimeline>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val denial: JsonField<ReturnDenial>,
    private val failure: JsonField<ReturnFailure>,
    private val nextAction: JsonField<ReturnNextAction>,
    private val refunds: JsonField<List<ReturnRefund>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("checkoutIntentId")
        @ExcludeMissing
        checkoutIntentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("orderId") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<ReturnReason> = JsonMissing.of(),
        @JsonProperty("state") @ExcludeMissing state: JsonField<ReturnState> = JsonMissing.of(),
        @JsonProperty("timeline")
        @ExcludeMissing
        timeline: JsonField<ReturnTimeline> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("denial") @ExcludeMissing denial: JsonField<ReturnDenial> = JsonMissing.of(),
        @JsonProperty("failure")
        @ExcludeMissing
        failure: JsonField<ReturnFailure> = JsonMissing.of(),
        @JsonProperty("nextAction")
        @ExcludeMissing
        nextAction: JsonField<ReturnNextAction> = JsonMissing.of(),
        @JsonProperty("refunds")
        @ExcludeMissing
        refunds: JsonField<List<ReturnRefund>> = JsonMissing.of(),
    ) : this(
        id,
        checkoutIntentId,
        createdAt,
        orderId,
        reason,
        state,
        timeline,
        updatedAt,
        denial,
        failure,
        nextAction,
        refunds,
        mutableMapOf(),
    )

    /**
     * Rye return id (`ret_<32 hex>`).
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Rye checkout intent id that produced the order being returned.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

    /**
     * When the Return record was created.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * Rye order id (`order_<32 hex>`) this Return was opened against.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderId(): String = orderId.getRequired("orderId")

    /**
     * Reason the return was requested, echoed back from the create call.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reason(): ReturnReason = reason.getRequired("reason")

    /**
     * Lifecycle state; the discriminator for the optional sub-objects below.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun state(): ReturnState = state.getRequired("state")

    /**
     * Per-transition timestamps; later stamps fill in as the Return advances.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun timeline(): ReturnTimeline = timeline.getRequired("timeline")

    /**
     * When the Return record was last updated.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

    /**
     * Why the merchant declined the return. Present only on `denied`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun denial(): Optional<ReturnDenial> = denial.getOptional("denial")

    /**
     * What went wrong. Present only on `failed`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun failure(): Optional<ReturnFailure> = failure.getOptional("failure")

    /**
     * What the shopper must do next (e.g. ship the items back). Present once the return is approved
     * — i.e. on `requires_action`, `processing`, and `refunded` — and may be present on `denied` /
     * `failed` if they were approved before terminating. Absent on `requested`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun nextAction(): Optional<ReturnNextAction> = nextAction.getOptional("nextAction")

    /**
     * Issued refunds. Present only on `refunded`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun refunds(): Optional<List<ReturnRefund>> = refunds.getOptional("refunds")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [checkoutIntentId].
     *
     * Unlike [checkoutIntentId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("checkoutIntentId")
    @ExcludeMissing
    fun _checkoutIntentId(): JsonField<String> = checkoutIntentId

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [orderId].
     *
     * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("orderId") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<ReturnReason> = reason

    /**
     * Returns the raw JSON value of [state].
     *
     * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<ReturnState> = state

    /**
     * Returns the raw JSON value of [timeline].
     *
     * Unlike [timeline], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timeline") @ExcludeMissing fun _timeline(): JsonField<ReturnTimeline> = timeline

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [denial].
     *
     * Unlike [denial], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("denial") @ExcludeMissing fun _denial(): JsonField<ReturnDenial> = denial

    /**
     * Returns the raw JSON value of [failure].
     *
     * Unlike [failure], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failure") @ExcludeMissing fun _failure(): JsonField<ReturnFailure> = failure

    /**
     * Returns the raw JSON value of [nextAction].
     *
     * Unlike [nextAction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nextAction")
    @ExcludeMissing
    fun _nextAction(): JsonField<ReturnNextAction> = nextAction

    /**
     * Returns the raw JSON value of [refunds].
     *
     * Unlike [refunds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("refunds") @ExcludeMissing fun _refunds(): JsonField<List<ReturnRefund>> = refunds

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
         * Returns a mutable builder for constructing an instance of [Return].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .checkoutIntentId()
         * .createdAt()
         * .orderId()
         * .reason()
         * .state()
         * .timeline()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Return]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var checkoutIntentId: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var orderId: JsonField<String>? = null
        private var reason: JsonField<ReturnReason>? = null
        private var state: JsonField<ReturnState>? = null
        private var timeline: JsonField<ReturnTimeline>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var denial: JsonField<ReturnDenial> = JsonMissing.of()
        private var failure: JsonField<ReturnFailure> = JsonMissing.of()
        private var nextAction: JsonField<ReturnNextAction> = JsonMissing.of()
        private var refunds: JsonField<MutableList<ReturnRefund>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(return_: Return) = apply {
            id = return_.id
            checkoutIntentId = return_.checkoutIntentId
            createdAt = return_.createdAt
            orderId = return_.orderId
            reason = return_.reason
            state = return_.state
            timeline = return_.timeline
            updatedAt = return_.updatedAt
            denial = return_.denial
            failure = return_.failure
            nextAction = return_.nextAction
            refunds = return_.refunds.map { it.toMutableList() }
            additionalProperties = return_.additionalProperties.toMutableMap()
        }

        /** Rye return id (`ret_<32 hex>`). */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Rye checkout intent id that produced the order being returned. */
        fun checkoutIntentId(checkoutIntentId: String) =
            checkoutIntentId(JsonField.of(checkoutIntentId))

        /**
         * Sets [Builder.checkoutIntentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.checkoutIntentId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun checkoutIntentId(checkoutIntentId: JsonField<String>) = apply {
            this.checkoutIntentId = checkoutIntentId
        }

        /** When the Return record was created. */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Rye order id (`order_<32 hex>`) this Return was opened against. */
        fun orderId(orderId: String) = orderId(JsonField.of(orderId))

        /**
         * Sets [Builder.orderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

        /** Reason the return was requested, echoed back from the create call. */
        fun reason(reason: ReturnReason) = reason(JsonField.of(reason))

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [ReturnReason] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reason(reason: JsonField<ReturnReason>) = apply { this.reason = reason }

        /** Lifecycle state; the discriminator for the optional sub-objects below. */
        fun state(state: ReturnState) = state(JsonField.of(state))

        /**
         * Sets [Builder.state] to an arbitrary JSON value.
         *
         * You should usually call [Builder.state] with a well-typed [ReturnState] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun state(state: JsonField<ReturnState>) = apply { this.state = state }

        /** Per-transition timestamps; later stamps fill in as the Return advances. */
        fun timeline(timeline: ReturnTimeline) = timeline(JsonField.of(timeline))

        /**
         * Sets [Builder.timeline] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timeline] with a well-typed [ReturnTimeline] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun timeline(timeline: JsonField<ReturnTimeline>) = apply { this.timeline = timeline }

        /** When the Return record was last updated. */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** Why the merchant declined the return. Present only on `denied`. */
        fun denial(denial: ReturnDenial) = denial(JsonField.of(denial))

        /**
         * Sets [Builder.denial] to an arbitrary JSON value.
         *
         * You should usually call [Builder.denial] with a well-typed [ReturnDenial] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun denial(denial: JsonField<ReturnDenial>) = apply { this.denial = denial }

        /** What went wrong. Present only on `failed`. */
        fun failure(failure: ReturnFailure) = failure(JsonField.of(failure))

        /**
         * Sets [Builder.failure] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failure] with a well-typed [ReturnFailure] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun failure(failure: JsonField<ReturnFailure>) = apply { this.failure = failure }

        /**
         * What the shopper must do next (e.g. ship the items back). Present once the return is
         * approved — i.e. on `requires_action`, `processing`, and `refunded` — and may be present
         * on `denied` / `failed` if they were approved before terminating. Absent on `requested`.
         */
        fun nextAction(nextAction: ReturnNextAction) = nextAction(JsonField.of(nextAction))

        /**
         * Sets [Builder.nextAction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextAction] with a well-typed [ReturnNextAction] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun nextAction(nextAction: JsonField<ReturnNextAction>) = apply {
            this.nextAction = nextAction
        }

        /** Issued refunds. Present only on `refunded`. */
        fun refunds(refunds: List<ReturnRefund>) = refunds(JsonField.of(refunds))

        /**
         * Sets [Builder.refunds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.refunds] with a well-typed `List<ReturnRefund>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun refunds(refunds: JsonField<List<ReturnRefund>>) = apply {
            this.refunds = refunds.map { it.toMutableList() }
        }

        /**
         * Adds a single [ReturnRefund] to [refunds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRefund(refund: ReturnRefund) = apply {
            refunds =
                (refunds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("refunds", it).add(refund)
                }
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
         * Returns an immutable instance of [Return].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .checkoutIntentId()
         * .createdAt()
         * .orderId()
         * .reason()
         * .state()
         * .timeline()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Return =
            Return(
                checkRequired("id", id),
                checkRequired("checkoutIntentId", checkoutIntentId),
                checkRequired("createdAt", createdAt),
                checkRequired("orderId", orderId),
                checkRequired("reason", reason),
                checkRequired("state", state),
                checkRequired("timeline", timeline),
                checkRequired("updatedAt", updatedAt),
                denial,
                failure,
                nextAction,
                (refunds ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): Return = apply {
        if (validated) {
            return@apply
        }

        id()
        checkoutIntentId()
        createdAt()
        orderId()
        reason().validate()
        state().validate()
        timeline().validate()
        updatedAt()
        denial().ifPresent { it.validate() }
        failure().ifPresent { it.validate() }
        nextAction().ifPresent { it.validate() }
        refunds().ifPresent { it.forEach { it.validate() } }
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (checkoutIntentId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (orderId.asKnown().isPresent) 1 else 0) +
            (reason.asKnown().getOrNull()?.validity() ?: 0) +
            (state.asKnown().getOrNull()?.validity() ?: 0) +
            (timeline.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (denial.asKnown().getOrNull()?.validity() ?: 0) +
            (failure.asKnown().getOrNull()?.validity() ?: 0) +
            (nextAction.asKnown().getOrNull()?.validity() ?: 0) +
            (refunds.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Return &&
            id == other.id &&
            checkoutIntentId == other.checkoutIntentId &&
            createdAt == other.createdAt &&
            orderId == other.orderId &&
            reason == other.reason &&
            state == other.state &&
            timeline == other.timeline &&
            updatedAt == other.updatedAt &&
            denial == other.denial &&
            failure == other.failure &&
            nextAction == other.nextAction &&
            refunds == other.refunds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            checkoutIntentId,
            createdAt,
            orderId,
            reason,
            state,
            timeline,
            updatedAt,
            denial,
            failure,
            nextAction,
            refunds,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Return{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, orderId=$orderId, reason=$reason, state=$state, timeline=$timeline, updatedAt=$updatedAt, denial=$denial, failure=$failure, nextAction=$nextAction, refunds=$refunds, additionalProperties=$additionalProperties}"
}
