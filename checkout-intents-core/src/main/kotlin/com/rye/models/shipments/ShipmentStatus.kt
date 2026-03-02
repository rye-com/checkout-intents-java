// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

import com.fasterxml.jackson.annotation.JsonCreator
import com.rye.core.Enum
import com.rye.core.JsonField
import com.rye.errors.CheckoutIntentsInvalidDataException

class ShipmentStatus @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val OUT_FOR_DELIVERY = of("out_for_delivery")

        @JvmField val DELIVERED = of("delivered")

        @JvmField val SHIPPED = of("shipped")

        @JvmField val CANCELED = of("canceled")

        @JvmField val DELAYED = of("delayed")

        @JvmField val ORDERED = of("ordered")

        @JvmStatic fun of(value: String) = ShipmentStatus(JsonField.of(value))
    }

    /** An enum containing [ShipmentStatus]'s known values. */
    enum class Known {
        OUT_FOR_DELIVERY,
        DELIVERED,
        SHIPPED,
        CANCELED,
        DELAYED,
        ORDERED,
    }

    /**
     * An enum containing [ShipmentStatus]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ShipmentStatus] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        OUT_FOR_DELIVERY,
        DELIVERED,
        SHIPPED,
        CANCELED,
        DELAYED,
        ORDERED,
        /**
         * An enum member indicating that [ShipmentStatus] was instantiated with an unknown value.
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
            OUT_FOR_DELIVERY -> Value.OUT_FOR_DELIVERY
            DELIVERED -> Value.DELIVERED
            SHIPPED -> Value.SHIPPED
            CANCELED -> Value.CANCELED
            DELAYED -> Value.DELAYED
            ORDERED -> Value.ORDERED
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
            OUT_FOR_DELIVERY -> Known.OUT_FOR_DELIVERY
            DELIVERED -> Known.DELIVERED
            SHIPPED -> Known.SHIPPED
            CANCELED -> Known.CANCELED
            DELAYED -> Known.DELAYED
            ORDERED -> Known.ORDERED
            else -> throw CheckoutIntentsInvalidDataException("Unknown ShipmentStatus: $value")
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

    fun validate(): ShipmentStatus = apply {
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

        return other is ShipmentStatus && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
