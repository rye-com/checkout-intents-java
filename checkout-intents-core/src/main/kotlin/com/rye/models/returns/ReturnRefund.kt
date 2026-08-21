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
import com.rye.models.checkoutintents.Money
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A single refund issued against a `refunded` Return. */
class ReturnRefund
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val refundedAt: JsonField<OffsetDateTime>,
    private val shopperRefundTotal: JsonField<Money>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("refundedAt")
        @ExcludeMissing
        refundedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("shopperRefundTotal")
        @ExcludeMissing
        shopperRefundTotal: JsonField<Money> = JsonMissing.of(),
    ) : this(id, refundedAt, shopperRefundTotal, mutableMapOf())

    /**
     * Rye refund id.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * When this refund was reconciled.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun refundedAt(): OffsetDateTime = refundedAt.getRequired("refundedAt")

    /**
     * Amount returned to the shopper, in the shopper's presentment currency.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun shopperRefundTotal(): Money = shopperRefundTotal.getRequired("shopperRefundTotal")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [refundedAt].
     *
     * Unlike [refundedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("refundedAt")
    @ExcludeMissing
    fun _refundedAt(): JsonField<OffsetDateTime> = refundedAt

    /**
     * Returns the raw JSON value of [shopperRefundTotal].
     *
     * Unlike [shopperRefundTotal], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("shopperRefundTotal")
    @ExcludeMissing
    fun _shopperRefundTotal(): JsonField<Money> = shopperRefundTotal

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
         * Returns a mutable builder for constructing an instance of [ReturnRefund].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .refundedAt()
         * .shopperRefundTotal()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ReturnRefund]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var refundedAt: JsonField<OffsetDateTime>? = null
        private var shopperRefundTotal: JsonField<Money>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(returnRefund: ReturnRefund) = apply {
            id = returnRefund.id
            refundedAt = returnRefund.refundedAt
            shopperRefundTotal = returnRefund.shopperRefundTotal
            additionalProperties = returnRefund.additionalProperties.toMutableMap()
        }

        /** Rye refund id. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** When this refund was reconciled. */
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

        /** Amount returned to the shopper, in the shopper's presentment currency. */
        fun shopperRefundTotal(shopperRefundTotal: Money) =
            shopperRefundTotal(JsonField.of(shopperRefundTotal))

        /**
         * Sets [Builder.shopperRefundTotal] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shopperRefundTotal] with a well-typed [Money] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun shopperRefundTotal(shopperRefundTotal: JsonField<Money>) = apply {
            this.shopperRefundTotal = shopperRefundTotal
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
         * Returns an immutable instance of [ReturnRefund].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .refundedAt()
         * .shopperRefundTotal()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ReturnRefund =
            ReturnRefund(
                checkRequired("id", id),
                checkRequired("refundedAt", refundedAt),
                checkRequired("shopperRefundTotal", shopperRefundTotal),
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
    fun validate(): ReturnRefund = apply {
        if (validated) {
            return@apply
        }

        id()
        refundedAt()
        shopperRefundTotal().validate()
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
            (if (refundedAt.asKnown().isPresent) 1 else 0) +
            (shopperRefundTotal.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ReturnRefund &&
            id == other.id &&
            refundedAt == other.refundedAt &&
            shopperRefundTotal == other.shopperRefundTotal &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, refundedAt, shopperRefundTotal, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ReturnRefund{id=$id, refundedAt=$refundedAt, shopperRefundTotal=$shopperRefundTotal, additionalProperties=$additionalProperties}"
}
