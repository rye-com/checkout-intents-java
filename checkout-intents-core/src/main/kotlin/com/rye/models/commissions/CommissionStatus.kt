// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.fasterxml.jackson.annotation.JsonCreator
import com.rye.core.Enum
import com.rye.core.JsonField
import com.rye.errors.CheckoutIntentsInvalidDataException

/** Lifecycle status of a commission record. */
class CommissionStatus @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val PENDING = of("pending")

        @JvmField val CONFIRMED = of("confirmed")

        @JvmField val UPDATED = of("updated")

        @JvmField val FINALIZED = of("finalized")

        @JvmField val REFUNDED = of("refunded")

        @JvmField val EXPIRED = of("expired")

        @JvmStatic fun of(value: String) = CommissionStatus(JsonField.of(value))
    }

    /** An enum containing [CommissionStatus]'s known values. */
    enum class Known {
        PENDING,
        CONFIRMED,
        UPDATED,
        FINALIZED,
        REFUNDED,
        EXPIRED,
    }

    /**
     * An enum containing [CommissionStatus]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [CommissionStatus] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        PENDING,
        CONFIRMED,
        UPDATED,
        FINALIZED,
        REFUNDED,
        EXPIRED,
        /**
         * An enum member indicating that [CommissionStatus] was instantiated with an unknown value.
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
            PENDING -> Value.PENDING
            CONFIRMED -> Value.CONFIRMED
            UPDATED -> Value.UPDATED
            FINALIZED -> Value.FINALIZED
            REFUNDED -> Value.REFUNDED
            EXPIRED -> Value.EXPIRED
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
            PENDING -> Known.PENDING
            CONFIRMED -> Known.CONFIRMED
            UPDATED -> Known.UPDATED
            FINALIZED -> Known.FINALIZED
            REFUNDED -> Known.REFUNDED
            EXPIRED -> Known.EXPIRED
            else -> throw CheckoutIntentsInvalidDataException("Unknown CommissionStatus: $value")
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
    fun validate(): CommissionStatus = apply {
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

        return other is CommissionStatus && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
