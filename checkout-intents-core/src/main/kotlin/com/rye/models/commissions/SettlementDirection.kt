// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.fasterxml.jackson.annotation.JsonCreator
import com.rye.core.Enum
import com.rye.core.JsonField
import com.rye.errors.CheckoutIntentsInvalidDataException

/** Direction of settlement: who owes whom once the commission is finalized. */
class SettlementDirection @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val RYE_OWES_DEVELOPER = of("rye_owes_developer")

        @JvmField val DEVELOPER_OWES_RYE = of("developer_owes_rye")

        @JvmStatic fun of(value: String) = SettlementDirection(JsonField.of(value))
    }

    /** An enum containing [SettlementDirection]'s known values. */
    enum class Known {
        RYE_OWES_DEVELOPER,
        DEVELOPER_OWES_RYE,
    }

    /**
     * An enum containing [SettlementDirection]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [SettlementDirection] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        RYE_OWES_DEVELOPER,
        DEVELOPER_OWES_RYE,
        /**
         * An enum member indicating that [SettlementDirection] was instantiated with an unknown
         * value.
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
            RYE_OWES_DEVELOPER -> Value.RYE_OWES_DEVELOPER
            DEVELOPER_OWES_RYE -> Value.DEVELOPER_OWES_RYE
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
            RYE_OWES_DEVELOPER -> Known.RYE_OWES_DEVELOPER
            DEVELOPER_OWES_RYE -> Known.DEVELOPER_OWES_RYE
            else -> throw CheckoutIntentsInvalidDataException("Unknown SettlementDirection: $value")
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
    fun validate(): SettlementDirection = apply {
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

        return other is SettlementDirection && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
