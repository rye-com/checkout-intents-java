// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.brands

import com.checkout_intents.api.core.Enum
import com.checkout_intents.api.core.ExcludeMissing
import com.checkout_intents.api.core.JsonField
import com.checkout_intents.api.core.JsonMissing
import com.checkout_intents.api.core.JsonValue
import com.checkout_intents.api.core.checkRequired
import com.checkout_intents.api.errors.CheckoutIntentsInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class BrandRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val marketplace: JsonField<Marketplace>,
    private val supported: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("marketplace")
        @ExcludeMissing
        marketplace: JsonField<Marketplace> = JsonMissing.of(),
        @JsonProperty("supported") @ExcludeMissing supported: JsonField<Boolean> = JsonMissing.of(),
    ) : this(id, marketplace, supported, mutableMapOf())

    /**
     * A unique identifier for the brand.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Indicates what ecommerce platform the brand uses.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun marketplace(): Marketplace = marketplace.getRequired("marketplace")

    /**
     * If `false`, then products from this brand cannot be purchased through the Sell Anything API.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun supported(): Boolean = supported.getRequired("supported")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [marketplace].
     *
     * Unlike [marketplace], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("marketplace")
    @ExcludeMissing
    fun _marketplace(): JsonField<Marketplace> = marketplace

    /**
     * Returns the raw JSON value of [supported].
     *
     * Unlike [supported], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("supported") @ExcludeMissing fun _supported(): JsonField<Boolean> = supported

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
         * Returns a mutable builder for constructing an instance of [BrandRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .marketplace()
         * .supported()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var marketplace: JsonField<Marketplace>? = null
        private var supported: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandRetrieveResponse: BrandRetrieveResponse) = apply {
            id = brandRetrieveResponse.id
            marketplace = brandRetrieveResponse.marketplace
            supported = brandRetrieveResponse.supported
            additionalProperties = brandRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** A unique identifier for the brand. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Indicates what ecommerce platform the brand uses. */
        fun marketplace(marketplace: Marketplace) = marketplace(JsonField.of(marketplace))

        /**
         * Sets [Builder.marketplace] to an arbitrary JSON value.
         *
         * You should usually call [Builder.marketplace] with a well-typed [Marketplace] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun marketplace(marketplace: JsonField<Marketplace>) = apply {
            this.marketplace = marketplace
        }

        /**
         * If `false`, then products from this brand cannot be purchased through the Sell Anything
         * API.
         */
        fun supported(supported: Boolean) = supported(JsonField.of(supported))

        /**
         * Sets [Builder.supported] to an arbitrary JSON value.
         *
         * You should usually call [Builder.supported] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun supported(supported: JsonField<Boolean>) = apply { this.supported = supported }

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
         * Returns an immutable instance of [BrandRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .marketplace()
         * .supported()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BrandRetrieveResponse =
            BrandRetrieveResponse(
                checkRequired("id", id),
                checkRequired("marketplace", marketplace),
                checkRequired("supported", supported),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BrandRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        marketplace().validate()
        supported()
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
            (marketplace.asKnown().getOrNull()?.validity() ?: 0) +
            (if (supported.asKnown().isPresent) 1 else 0)

    /** Indicates what ecommerce platform the brand uses. */
    class Marketplace @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AMAZON = of("AMAZON")

            @JvmField val SHOPIFY = of("SHOPIFY")

            @JvmField val BESTBUY = of("BESTBUY")

            @JvmField val UNKNOWN = of("UNKNOWN")

            @JvmStatic fun of(value: String) = Marketplace(JsonField.of(value))
        }

        /** An enum containing [Marketplace]'s known values. */
        enum class Known {
            AMAZON,
            SHOPIFY,
            BESTBUY,
            UNKNOWN,
        }

        /**
         * An enum containing [Marketplace]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Marketplace] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AMAZON,
            SHOPIFY,
            BESTBUY,
            UNKNOWN,
            /**
             * An enum member indicating that [Marketplace] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AMAZON -> Value.AMAZON
                SHOPIFY -> Value.SHOPIFY
                BESTBUY -> Value.BESTBUY
                UNKNOWN -> Value.UNKNOWN
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws CheckoutIntentsInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                AMAZON -> Known.AMAZON
                SHOPIFY -> Known.SHOPIFY
                BESTBUY -> Known.BESTBUY
                UNKNOWN -> Known.UNKNOWN
                else -> throw CheckoutIntentsInvalidDataException("Unknown Marketplace: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws CheckoutIntentsInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                CheckoutIntentsInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Marketplace = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Marketplace && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandRetrieveResponse &&
            id == other.id &&
            marketplace == other.marketplace &&
            supported == other.supported &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, marketplace, supported, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BrandRetrieveResponse{id=$id, marketplace=$marketplace, supported=$supported, additionalProperties=$additionalProperties}"
}
