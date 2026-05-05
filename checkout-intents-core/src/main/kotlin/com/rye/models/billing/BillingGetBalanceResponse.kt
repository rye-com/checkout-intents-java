// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

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
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class BillingGetBalanceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val balance: JsonField<Money>,
    private val drawdownEnabled: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("balance") @ExcludeMissing balance: JsonField<Money> = JsonMissing.of(),
        @JsonProperty("drawdownEnabled")
        @ExcludeMissing
        drawdownEnabled: JsonField<Boolean> = JsonMissing.of(),
    ) : this(balance, drawdownEnabled, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun balance(): Money = balance.getRequired("balance")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun drawdownEnabled(): Boolean = drawdownEnabled.getRequired("drawdownEnabled")

    /**
     * Returns the raw JSON value of [balance].
     *
     * Unlike [balance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("balance") @ExcludeMissing fun _balance(): JsonField<Money> = balance

    /**
     * Returns the raw JSON value of [drawdownEnabled].
     *
     * Unlike [drawdownEnabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("drawdownEnabled")
    @ExcludeMissing
    fun _drawdownEnabled(): JsonField<Boolean> = drawdownEnabled

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
         * Returns a mutable builder for constructing an instance of [BillingGetBalanceResponse].
         *
         * The following fields are required:
         * ```java
         * .balance()
         * .drawdownEnabled()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BillingGetBalanceResponse]. */
    class Builder internal constructor() {

        private var balance: JsonField<Money>? = null
        private var drawdownEnabled: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(billingGetBalanceResponse: BillingGetBalanceResponse) = apply {
            balance = billingGetBalanceResponse.balance
            drawdownEnabled = billingGetBalanceResponse.drawdownEnabled
            additionalProperties = billingGetBalanceResponse.additionalProperties.toMutableMap()
        }

        fun balance(balance: Money) = balance(JsonField.of(balance))

        /**
         * Sets [Builder.balance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.balance] with a well-typed [Money] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun balance(balance: JsonField<Money>) = apply { this.balance = balance }

        fun drawdownEnabled(drawdownEnabled: Boolean) =
            drawdownEnabled(JsonField.of(drawdownEnabled))

        /**
         * Sets [Builder.drawdownEnabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.drawdownEnabled] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun drawdownEnabled(drawdownEnabled: JsonField<Boolean>) = apply {
            this.drawdownEnabled = drawdownEnabled
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
         * Returns an immutable instance of [BillingGetBalanceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .balance()
         * .drawdownEnabled()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BillingGetBalanceResponse =
            BillingGetBalanceResponse(
                checkRequired("balance", balance),
                checkRequired("drawdownEnabled", drawdownEnabled),
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
    fun validate(): BillingGetBalanceResponse = apply {
        if (validated) {
            return@apply
        }

        balance().validate()
        drawdownEnabled()
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
        (balance.asKnown().getOrNull()?.validity() ?: 0) +
            (if (drawdownEnabled.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BillingGetBalanceResponse &&
            balance == other.balance &&
            drawdownEnabled == other.drawdownEnabled &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(balance, drawdownEnabled, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BillingGetBalanceResponse{balance=$balance, drawdownEnabled=$drawdownEnabled, additionalProperties=$additionalProperties}"
}
