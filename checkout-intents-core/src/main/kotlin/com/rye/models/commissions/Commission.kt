// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

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
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A commission earned (or owed) on a completed checkout intent. */
class Commission
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val checkoutIntentId: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val developerCommission: JsonField<Money>,
    private val ryeFee: JsonField<Money>,
    private val settlementDirection: JsonField<SettlementDirection>,
    private val status: JsonField<CommissionStatus>,
    private val type: JsonField<CommissionType>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val finalizedAt: JsonField<OffsetDateTime>,
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
        @JsonProperty("developerCommission")
        @ExcludeMissing
        developerCommission: JsonField<Money> = JsonMissing.of(),
        @JsonProperty("ryeFee") @ExcludeMissing ryeFee: JsonField<Money> = JsonMissing.of(),
        @JsonProperty("settlementDirection")
        @ExcludeMissing
        settlementDirection: JsonField<SettlementDirection> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<CommissionStatus> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<CommissionType> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("finalizedAt")
        @ExcludeMissing
        finalizedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        checkoutIntentId,
        createdAt,
        developerCommission,
        ryeFee,
        settlementDirection,
        status,
        type,
        updatedAt,
        finalizedAt,
        mutableMapOf(),
    )

    /**
     * Unique identifier for this commission.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The checkout intent this commission was generated from.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

    /**
     * Time the commission was first recorded.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * Commission amount paid to the developer.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun developerCommission(): Money = developerCommission.getRequired("developerCommission")

    /**
     * Fee retained by Rye.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun ryeFee(): Money = ryeFee.getRequired("ryeFee")

    /**
     * Whether Rye owes the developer or vice versa once settled.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun settlementDirection(): SettlementDirection =
        settlementDirection.getRequired("settlementDirection")

    /**
     * Lifecycle status, e.g. pending, finalized, refunded.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): CommissionStatus = status.getRequired("status")

    /**
     * Kind of commission, e.g. surcharge, discount_code, affiliate.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): CommissionType = type.getRequired("type")

    /**
     * Time the commission last changed (e.g. status transition).
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

    /**
     * Time the commission moved to a terminal status. Unset until finalized.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun finalizedAt(): Optional<OffsetDateTime> = finalizedAt.getOptional("finalizedAt")

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
     * Returns the raw JSON value of [developerCommission].
     *
     * Unlike [developerCommission], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("developerCommission")
    @ExcludeMissing
    fun _developerCommission(): JsonField<Money> = developerCommission

    /**
     * Returns the raw JSON value of [ryeFee].
     *
     * Unlike [ryeFee], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ryeFee") @ExcludeMissing fun _ryeFee(): JsonField<Money> = ryeFee

    /**
     * Returns the raw JSON value of [settlementDirection].
     *
     * Unlike [settlementDirection], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("settlementDirection")
    @ExcludeMissing
    fun _settlementDirection(): JsonField<SettlementDirection> = settlementDirection

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<CommissionStatus> = status

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<CommissionType> = type

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [finalizedAt].
     *
     * Unlike [finalizedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("finalizedAt")
    @ExcludeMissing
    fun _finalizedAt(): JsonField<OffsetDateTime> = finalizedAt

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
         * Returns a mutable builder for constructing an instance of [Commission].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .checkoutIntentId()
         * .createdAt()
         * .developerCommission()
         * .ryeFee()
         * .settlementDirection()
         * .status()
         * .type()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Commission]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var checkoutIntentId: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var developerCommission: JsonField<Money>? = null
        private var ryeFee: JsonField<Money>? = null
        private var settlementDirection: JsonField<SettlementDirection>? = null
        private var status: JsonField<CommissionStatus>? = null
        private var type: JsonField<CommissionType>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var finalizedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(commission: Commission) = apply {
            id = commission.id
            checkoutIntentId = commission.checkoutIntentId
            createdAt = commission.createdAt
            developerCommission = commission.developerCommission
            ryeFee = commission.ryeFee
            settlementDirection = commission.settlementDirection
            status = commission.status
            type = commission.type
            updatedAt = commission.updatedAt
            finalizedAt = commission.finalizedAt
            additionalProperties = commission.additionalProperties.toMutableMap()
        }

        /** Unique identifier for this commission. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The checkout intent this commission was generated from. */
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

        /** Time the commission was first recorded. */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Commission amount paid to the developer. */
        fun developerCommission(developerCommission: Money) =
            developerCommission(JsonField.of(developerCommission))

        /**
         * Sets [Builder.developerCommission] to an arbitrary JSON value.
         *
         * You should usually call [Builder.developerCommission] with a well-typed [Money] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun developerCommission(developerCommission: JsonField<Money>) = apply {
            this.developerCommission = developerCommission
        }

        /** Fee retained by Rye. */
        fun ryeFee(ryeFee: Money) = ryeFee(JsonField.of(ryeFee))

        /**
         * Sets [Builder.ryeFee] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ryeFee] with a well-typed [Money] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ryeFee(ryeFee: JsonField<Money>) = apply { this.ryeFee = ryeFee }

        /** Whether Rye owes the developer or vice versa once settled. */
        fun settlementDirection(settlementDirection: SettlementDirection) =
            settlementDirection(JsonField.of(settlementDirection))

        /**
         * Sets [Builder.settlementDirection] to an arbitrary JSON value.
         *
         * You should usually call [Builder.settlementDirection] with a well-typed
         * [SettlementDirection] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun settlementDirection(settlementDirection: JsonField<SettlementDirection>) = apply {
            this.settlementDirection = settlementDirection
        }

        /** Lifecycle status, e.g. pending, finalized, refunded. */
        fun status(status: CommissionStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [CommissionStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<CommissionStatus>) = apply { this.status = status }

        /** Kind of commission, e.g. surcharge, discount_code, affiliate. */
        fun type(type: CommissionType) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [CommissionType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonField<CommissionType>) = apply { this.type = type }

        /** Time the commission last changed (e.g. status transition). */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** Time the commission moved to a terminal status. Unset until finalized. */
        fun finalizedAt(finalizedAt: OffsetDateTime) = finalizedAt(JsonField.of(finalizedAt))

        /**
         * Sets [Builder.finalizedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.finalizedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun finalizedAt(finalizedAt: JsonField<OffsetDateTime>) = apply {
            this.finalizedAt = finalizedAt
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
         * Returns an immutable instance of [Commission].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .checkoutIntentId()
         * .createdAt()
         * .developerCommission()
         * .ryeFee()
         * .settlementDirection()
         * .status()
         * .type()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Commission =
            Commission(
                checkRequired("id", id),
                checkRequired("checkoutIntentId", checkoutIntentId),
                checkRequired("createdAt", createdAt),
                checkRequired("developerCommission", developerCommission),
                checkRequired("ryeFee", ryeFee),
                checkRequired("settlementDirection", settlementDirection),
                checkRequired("status", status),
                checkRequired("type", type),
                checkRequired("updatedAt", updatedAt),
                finalizedAt,
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
    fun validate(): Commission = apply {
        if (validated) {
            return@apply
        }

        id()
        checkoutIntentId()
        createdAt()
        developerCommission().validate()
        ryeFee().validate()
        settlementDirection().validate()
        status().validate()
        type().validate()
        updatedAt()
        finalizedAt()
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
            (developerCommission.asKnown().getOrNull()?.validity() ?: 0) +
            (ryeFee.asKnown().getOrNull()?.validity() ?: 0) +
            (settlementDirection.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (finalizedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Commission &&
            id == other.id &&
            checkoutIntentId == other.checkoutIntentId &&
            createdAt == other.createdAt &&
            developerCommission == other.developerCommission &&
            ryeFee == other.ryeFee &&
            settlementDirection == other.settlementDirection &&
            status == other.status &&
            type == other.type &&
            updatedAt == other.updatedAt &&
            finalizedAt == other.finalizedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            checkoutIntentId,
            createdAt,
            developerCommission,
            ryeFee,
            settlementDirection,
            status,
            type,
            updatedAt,
            finalizedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Commission{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, developerCommission=$developerCommission, ryeFee=$ryeFee, settlementDirection=$settlementDirection, status=$status, type=$type, updatedAt=$updatedAt, finalizedAt=$finalizedAt, additionalProperties=$additionalProperties}"
}
