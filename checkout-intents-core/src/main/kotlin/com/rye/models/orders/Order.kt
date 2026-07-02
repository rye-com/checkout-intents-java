// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents a completed order. Orders are created after a checkout intent reaches the `completed`
 * state.
 */
class Order
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val cancellation: JsonField<Cancellation>,
    private val checkoutIntentId: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val referenceId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cancellation")
        @ExcludeMissing
        cancellation: JsonField<Cancellation> = JsonMissing.of(),
        @JsonProperty("checkoutIntentId")
        @ExcludeMissing
        checkoutIntentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("referenceId")
        @ExcludeMissing
        referenceId: JsonField<String> = JsonMissing.of(),
    ) : this(id, cancellation, checkoutIntentId, createdAt, updatedAt, referenceId, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The cancellation for this order, or `null` if none has been requested. Populated by joining
     * the separate cancellations collection on the order's marketplace order id.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun cancellation(): Optional<Cancellation> = cancellation.getOptional("cancellation")

    /**
     * ID of the checkout intent that was responsible for creating this order.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

    /**
     * Timestamp the order was persisted to Rye.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): String = createdAt.getRequired("createdAt")

    /**
     * Timestamp the order was last updated at
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): String = updatedAt.getRequired("updatedAt")

    /**
     * The `referenceId` you supplied on the checkout intent, echoed back so you can reconcile this
     * order against your own records. Absent when none was supplied.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun referenceId(): Optional<String> = referenceId.getOptional("referenceId")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [cancellation].
     *
     * Unlike [cancellation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cancellation")
    @ExcludeMissing
    fun _cancellation(): JsonField<Cancellation> = cancellation

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
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

    /**
     * Returns the raw JSON value of [referenceId].
     *
     * Unlike [referenceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("referenceId") @ExcludeMissing fun _referenceId(): JsonField<String> = referenceId

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
         * Returns a mutable builder for constructing an instance of [Order].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .cancellation()
         * .checkoutIntentId()
         * .createdAt()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Order]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var cancellation: JsonField<Cancellation>? = null
        private var checkoutIntentId: JsonField<String>? = null
        private var createdAt: JsonField<String>? = null
        private var updatedAt: JsonField<String>? = null
        private var referenceId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(order: Order) = apply {
            id = order.id
            cancellation = order.cancellation
            checkoutIntentId = order.checkoutIntentId
            createdAt = order.createdAt
            updatedAt = order.updatedAt
            referenceId = order.referenceId
            additionalProperties = order.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The cancellation for this order, or `null` if none has been requested. Populated by
         * joining the separate cancellations collection on the order's marketplace order id.
         */
        fun cancellation(cancellation: Cancellation?) =
            cancellation(JsonField.ofNullable(cancellation))

        /** Alias for calling [Builder.cancellation] with `cancellation.orElse(null)`. */
        fun cancellation(cancellation: Optional<Cancellation>) =
            cancellation(cancellation.getOrNull())

        /**
         * Sets [Builder.cancellation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancellation] with a well-typed [Cancellation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cancellation(cancellation: JsonField<Cancellation>) = apply {
            this.cancellation = cancellation
        }

        /** Alias for calling [cancellation] with `Cancellation.ofRequested(requested)`. */
        fun cancellation(requested: Cancellation.RequestedCancellation) =
            cancellation(Cancellation.ofRequested(requested))

        /** Alias for calling [cancellation] with `Cancellation.ofCompleted(completed)`. */
        fun cancellation(completed: Cancellation.CompletedCancellation) =
            cancellation(Cancellation.ofCompleted(completed))

        /** Alias for calling [cancellation] with `Cancellation.ofDenied(denied)`. */
        fun cancellation(denied: Cancellation.DeniedCancellation) =
            cancellation(Cancellation.ofDenied(denied))

        /** ID of the checkout intent that was responsible for creating this order. */
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

        /** Timestamp the order was persisted to Rye. */
        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        /** Timestamp the order was last updated at */
        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

        /**
         * The `referenceId` you supplied on the checkout intent, echoed back so you can reconcile
         * this order against your own records. Absent when none was supplied.
         */
        fun referenceId(referenceId: String) = referenceId(JsonField.of(referenceId))

        /**
         * Sets [Builder.referenceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.referenceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun referenceId(referenceId: JsonField<String>) = apply { this.referenceId = referenceId }

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
         * Returns an immutable instance of [Order].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .cancellation()
         * .checkoutIntentId()
         * .createdAt()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Order =
            Order(
                checkRequired("id", id),
                checkRequired("cancellation", cancellation),
                checkRequired("checkoutIntentId", checkoutIntentId),
                checkRequired("createdAt", createdAt),
                checkRequired("updatedAt", updatedAt),
                referenceId,
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
    fun validate(): Order = apply {
        if (validated) {
            return@apply
        }

        id()
        cancellation().ifPresent { it.validate() }
        checkoutIntentId()
        createdAt()
        updatedAt()
        referenceId()
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
            (cancellation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (checkoutIntentId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (referenceId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Order &&
            id == other.id &&
            cancellation == other.cancellation &&
            checkoutIntentId == other.checkoutIntentId &&
            createdAt == other.createdAt &&
            updatedAt == other.updatedAt &&
            referenceId == other.referenceId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            cancellation,
            checkoutIntentId,
            createdAt,
            updatedAt,
            referenceId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Order{id=$id, cancellation=$cancellation, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, updatedAt=$updatedAt, referenceId=$referenceId, additionalProperties=$additionalProperties}"
}
