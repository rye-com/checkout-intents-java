// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

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

class Money
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val amountSubunits: JsonField<Int>,
    private val currencyCode: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("amountSubunits")
        @ExcludeMissing
        amountSubunits: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("currencyCode")
        @ExcludeMissing
        currencyCode: JsonField<String> = JsonMissing.of(),
    ) : this(amountSubunits, currencyCode, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun amountSubunits(): Int = amountSubunits.getRequired("amountSubunits")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun currencyCode(): String = currencyCode.getRequired("currencyCode")

    /**
     * Returns the raw JSON value of [amountSubunits].
     *
     * Unlike [amountSubunits], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amountSubunits")
    @ExcludeMissing
    fun _amountSubunits(): JsonField<Int> = amountSubunits

    /**
     * Returns the raw JSON value of [currencyCode].
     *
     * Unlike [currencyCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currencyCode")
    @ExcludeMissing
    fun _currencyCode(): JsonField<String> = currencyCode

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
         * Returns a mutable builder for constructing an instance of [Money].
         *
         * The following fields are required:
         * ```java
         * .amountSubunits()
         * .currencyCode()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Money]. */
    class Builder internal constructor() {

        private var amountSubunits: JsonField<Int>? = null
        private var currencyCode: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(money: Money) = apply {
            amountSubunits = money.amountSubunits
            currencyCode = money.currencyCode
            additionalProperties = money.additionalProperties.toMutableMap()
        }

        fun amountSubunits(amountSubunits: Int) = amountSubunits(JsonField.of(amountSubunits))

        /**
         * Sets [Builder.amountSubunits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amountSubunits] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun amountSubunits(amountSubunits: JsonField<Int>) = apply {
            this.amountSubunits = amountSubunits
        }

        fun currencyCode(currencyCode: String) = currencyCode(JsonField.of(currencyCode))

        /**
         * Sets [Builder.currencyCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currencyCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun currencyCode(currencyCode: JsonField<String>) = apply {
            this.currencyCode = currencyCode
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
         * Returns an immutable instance of [Money].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .amountSubunits()
         * .currencyCode()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Money =
            Money(
                checkRequired("amountSubunits", amountSubunits),
                checkRequired("currencyCode", currencyCode),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Money = apply {
        if (validated) {
            return@apply
        }

        amountSubunits()
        currencyCode()
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
        (if (amountSubunits.asKnown().isPresent) 1 else 0) +
            (if (currencyCode.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Money &&
            amountSubunits == other.amountSubunits &&
            currencyCode == other.currencyCode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(amountSubunits, currencyCode, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Money{amountSubunits=$amountSubunits, currencyCode=$currencyCode, additionalProperties=$additionalProperties}"
}
