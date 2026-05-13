// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.fasterxml.jackson.annotation.JsonCreator
import com.rye.core.Enum
import com.rye.core.JsonField
import com.rye.errors.CheckoutIntentsInvalidDataException

/**
 * Type of commission earned on an order. Canonical definition used by both the API contract and the
 * internal `@rye-com/ci-commissions` package.
 */
class CommissionType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val SURCHARGE = of("surcharge")

        @JvmField val PROMO_ARBITRAGE = of("promo_arbitrage")

        @JvmField val DISCOUNT_CODE = of("discount_code")

        @JvmField val AFFILIATE = of("affiliate")

        @JvmField val OUT_OF_BAND = of("out_of_band")

        @JvmStatic fun of(value: String) = CommissionType(JsonField.of(value))
    }

    /** An enum containing [CommissionType]'s known values. */
    enum class Known {
        SURCHARGE,
        PROMO_ARBITRAGE,
        DISCOUNT_CODE,
        AFFILIATE,
        OUT_OF_BAND,
    }

    /**
     * An enum containing [CommissionType]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [CommissionType] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        SURCHARGE,
        PROMO_ARBITRAGE,
        DISCOUNT_CODE,
        AFFILIATE,
        OUT_OF_BAND,
        /**
         * An enum member indicating that [CommissionType] was instantiated with an unknown value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            SURCHARGE -> Value.SURCHARGE
            PROMO_ARBITRAGE -> Value.PROMO_ARBITRAGE
            DISCOUNT_CODE -> Value.DISCOUNT_CODE
            AFFILIATE -> Value.AFFILIATE
            OUT_OF_BAND -> Value.OUT_OF_BAND
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws CheckoutIntentsInvalidDataException if this class instance's value is a not a known
     *   member.
     */
    fun known(): Known =
        when (this) {
            SURCHARGE -> Known.SURCHARGE
            PROMO_ARBITRAGE -> Known.PROMO_ARBITRAGE
            DISCOUNT_CODE -> Known.DISCOUNT_CODE
            AFFILIATE -> Known.AFFILIATE
            OUT_OF_BAND -> Known.OUT_OF_BAND
            else -> throw CheckoutIntentsInvalidDataException("Unknown CommissionType: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws CheckoutIntentsInvalidDataException if this class instance's value does not have the
     *   expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow {
            CheckoutIntentsInvalidDataException("Value is not a String")
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
    fun validate(): CommissionType = apply {
        if (validated) {
            return@apply
        }

        known()
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
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommissionType && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
