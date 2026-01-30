// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.annotation.JsonCreator
import com.rye.core.Enum
import com.rye.core.JsonField
import com.rye.errors.CheckoutIntentsInvalidDataException

/**
 * The availability status of a product.
 * - `in_stock`: Product is available for immediate purchase
 * - `out_of_stock`: Product is currently unavailable
 * - `preorder`: Product is available for pre-order before release
 * - `backorder`: Product is temporarily out of stock but can be ordered
 * - `unknown`: Availability could not be determined
 */
class ProductAvailability @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val IN_STOCK = of("in_stock")

        @JvmField val OUT_OF_STOCK = of("out_of_stock")

        @JvmField val PREORDER = of("preorder")

        @JvmField val BACKORDER = of("backorder")

        @JvmField val UNKNOWN = of("unknown")

        @JvmStatic fun of(value: String) = ProductAvailability(JsonField.of(value))
    }

    /** An enum containing [ProductAvailability]'s known values. */
    enum class Known {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        BACKORDER,
        UNKNOWN,
    }

    /**
     * An enum containing [ProductAvailability]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ProductAvailability] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        BACKORDER,
        UNKNOWN,
        /**
         * An enum member indicating that [ProductAvailability] was instantiated with an unknown
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
            IN_STOCK -> Value.IN_STOCK
            OUT_OF_STOCK -> Value.OUT_OF_STOCK
            PREORDER -> Value.PREORDER
            BACKORDER -> Value.BACKORDER
            UNKNOWN -> Value.UNKNOWN
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
            IN_STOCK -> Known.IN_STOCK
            OUT_OF_STOCK -> Known.OUT_OF_STOCK
            PREORDER -> Known.PREORDER
            BACKORDER -> Known.BACKORDER
            UNKNOWN -> Known.UNKNOWN
            else -> throw CheckoutIntentsInvalidDataException("Unknown ProductAvailability: $value")
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

    fun validate(): ProductAvailability = apply {
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

        return other is ProductAvailability && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
