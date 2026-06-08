// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.annotation.JsonCreator
import com.rye.core.Enum
import com.rye.core.JsonField
import com.rye.errors.CheckoutIntentsInvalidDataException

/**
 * Reason a shopper is returning an order, supplied on the create-return call: `defective` (arrived
 * damaged or faulty), `wrong_item` (not what was ordered), `unwanted` (changed their mind), `color`
 * / `size_too_large` / `size_too_small` / `style` (wrong color, size, or style), `not_as_described`
 * (differs from the listing), and `other` (anything else).
 */
class ReturnReason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val DEFECTIVE = of("defective")

        @JvmField val WRONG_ITEM = of("wrong_item")

        @JvmField val UNWANTED = of("unwanted")

        @JvmField val COLOR = of("color")

        @JvmField val NOT_AS_DESCRIBED = of("not_as_described")

        @JvmField val SIZE_TOO_LARGE = of("size_too_large")

        @JvmField val SIZE_TOO_SMALL = of("size_too_small")

        @JvmField val STYLE = of("style")

        @JvmField val OTHER = of("other")

        @JvmStatic fun of(value: String) = ReturnReason(JsonField.of(value))
    }

    /** An enum containing [ReturnReason]'s known values. */
    enum class Known {
        DEFECTIVE,
        WRONG_ITEM,
        UNWANTED,
        COLOR,
        NOT_AS_DESCRIBED,
        SIZE_TOO_LARGE,
        SIZE_TOO_SMALL,
        STYLE,
        OTHER,
    }

    /**
     * An enum containing [ReturnReason]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ReturnReason] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        DEFECTIVE,
        WRONG_ITEM,
        UNWANTED,
        COLOR,
        NOT_AS_DESCRIBED,
        SIZE_TOO_LARGE,
        SIZE_TOO_SMALL,
        STYLE,
        OTHER,
        /** An enum member indicating that [ReturnReason] was instantiated with an unknown value. */
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
            DEFECTIVE -> Value.DEFECTIVE
            WRONG_ITEM -> Value.WRONG_ITEM
            UNWANTED -> Value.UNWANTED
            COLOR -> Value.COLOR
            NOT_AS_DESCRIBED -> Value.NOT_AS_DESCRIBED
            SIZE_TOO_LARGE -> Value.SIZE_TOO_LARGE
            SIZE_TOO_SMALL -> Value.SIZE_TOO_SMALL
            STYLE -> Value.STYLE
            OTHER -> Value.OTHER
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
            DEFECTIVE -> Known.DEFECTIVE
            WRONG_ITEM -> Known.WRONG_ITEM
            UNWANTED -> Known.UNWANTED
            COLOR -> Known.COLOR
            NOT_AS_DESCRIBED -> Known.NOT_AS_DESCRIBED
            SIZE_TOO_LARGE -> Known.SIZE_TOO_LARGE
            SIZE_TOO_SMALL -> Known.SIZE_TOO_SMALL
            STYLE -> Known.STYLE
            OTHER -> Known.OTHER
            else -> throw CheckoutIntentsInvalidDataException("Unknown ReturnReason: $value")
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
    fun validate(): ReturnReason = apply {
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

        return other is ReturnReason && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
