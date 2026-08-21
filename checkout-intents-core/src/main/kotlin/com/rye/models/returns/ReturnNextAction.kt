// File generated from our OpenAPI spec by Stainless.

package com.rye.models.returns

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.Enum
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.checkRequired
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * What the shopper has to do next to complete the return. Present once the Return is approved.
 *
 * `type` is the discriminator: `ship_items_to_merchant` carries the matching `shipItemsToMerchant`
 * payload (a prepaid label); `no_action_required` means the merchant approved a keep-the-item /
 * no-ship return and the shopper just waits for the refund (no payload). The `requires_action`
 * state is reached only for `ship_items_to_merchant`; a `no_action_required` approval skips
 * straight to `processing`.
 */
class ReturnNextAction
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonField<Type>,
    private val shipItemsToMerchant: JsonField<ShipItemsToMerchant>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("shipItemsToMerchant")
        @ExcludeMissing
        shipItemsToMerchant: JsonField<ShipItemsToMerchant> = JsonMissing.of(),
    ) : this(type, shipItemsToMerchant, mutableMapOf())

    /**
     * Discriminator for the action the shopper must take.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Prepaid return label. Present only when `type` is `ship_items_to_merchant`.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun shipItemsToMerchant(): Optional<ShipItemsToMerchant> =
        shipItemsToMerchant.getOptional("shipItemsToMerchant")

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [shipItemsToMerchant].
     *
     * Unlike [shipItemsToMerchant], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("shipItemsToMerchant")
    @ExcludeMissing
    fun _shipItemsToMerchant(): JsonField<ShipItemsToMerchant> = shipItemsToMerchant

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
         * Returns a mutable builder for constructing an instance of [ReturnNextAction].
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ReturnNextAction]. */
    class Builder internal constructor() {

        private var type: JsonField<Type>? = null
        private var shipItemsToMerchant: JsonField<ShipItemsToMerchant> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(returnNextAction: ReturnNextAction) = apply {
            type = returnNextAction.type
            shipItemsToMerchant = returnNextAction.shipItemsToMerchant
            additionalProperties = returnNextAction.additionalProperties.toMutableMap()
        }

        /** Discriminator for the action the shopper must take. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** Prepaid return label. Present only when `type` is `ship_items_to_merchant`. */
        fun shipItemsToMerchant(shipItemsToMerchant: ShipItemsToMerchant) =
            shipItemsToMerchant(JsonField.of(shipItemsToMerchant))

        /**
         * Sets [Builder.shipItemsToMerchant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shipItemsToMerchant] with a well-typed
         * [ShipItemsToMerchant] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun shipItemsToMerchant(shipItemsToMerchant: JsonField<ShipItemsToMerchant>) = apply {
            this.shipItemsToMerchant = shipItemsToMerchant
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
         * Returns an immutable instance of [ReturnNextAction].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ReturnNextAction =
            ReturnNextAction(
                checkRequired("type", type),
                shipItemsToMerchant,
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
    fun validate(): ReturnNextAction = apply {
        if (validated) {
            return@apply
        }

        type().validate()
        shipItemsToMerchant().ifPresent { it.validate() }
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
        (type.asKnown().getOrNull()?.validity() ?: 0) +
            (shipItemsToMerchant.asKnown().getOrNull()?.validity() ?: 0)

    /** Discriminator for the action the shopper must take. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SHIP_ITEMS_TO_MERCHANT = of("ship_items_to_merchant")

            @JvmField val NO_ACTION_REQUIRED = of("no_action_required")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            SHIP_ITEMS_TO_MERCHANT,
            NO_ACTION_REQUIRED,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SHIP_ITEMS_TO_MERCHANT,
            NO_ACTION_REQUIRED,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                SHIP_ITEMS_TO_MERCHANT -> Value.SHIP_ITEMS_TO_MERCHANT
                NO_ACTION_REQUIRED -> Value.NO_ACTION_REQUIRED
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
                SHIP_ITEMS_TO_MERCHANT -> Known.SHIP_ITEMS_TO_MERCHANT
                NO_ACTION_REQUIRED -> Known.NO_ACTION_REQUIRED
                else -> throw CheckoutIntentsInvalidDataException("Unknown Type: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws CheckoutIntentsInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Prepaid return label. Present only when `type` is `ship_items_to_merchant`. */
    class ShipItemsToMerchant
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val label: JsonField<Label>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("label") @ExcludeMissing label: JsonField<Label> = JsonMissing.of()
        ) : this(label, mutableMapOf())

        /**
         * A prepaid return shipping label the shopper uses to send items back.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun label(): Label = label.getRequired("label")

        /**
         * Returns the raw JSON value of [label].
         *
         * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<Label> = label

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
             * Returns a mutable builder for constructing an instance of [ShipItemsToMerchant].
             *
             * The following fields are required:
             * ```java
             * .label()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ShipItemsToMerchant]. */
        class Builder internal constructor() {

            private var label: JsonField<Label>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(shipItemsToMerchant: ShipItemsToMerchant) = apply {
                label = shipItemsToMerchant.label
                additionalProperties = shipItemsToMerchant.additionalProperties.toMutableMap()
            }

            /** A prepaid return shipping label the shopper uses to send items back. */
            fun label(label: Label) = label(JsonField.of(label))

            /**
             * Sets [Builder.label] to an arbitrary JSON value.
             *
             * You should usually call [Builder.label] with a well-typed [Label] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun label(label: JsonField<Label>) = apply { this.label = label }

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
             * Returns an immutable instance of [ShipItemsToMerchant].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .label()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ShipItemsToMerchant =
                ShipItemsToMerchant(
                    checkRequired("label", label),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws CheckoutIntentsInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): ShipItemsToMerchant = apply {
            if (validated) {
                return@apply
            }

            label().validate()
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
        @JvmSynthetic internal fun validity(): Int = (label.asKnown().getOrNull()?.validity() ?: 0)

        /** A prepaid return shipping label the shopper uses to send items back. */
        class Label
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of()
            ) : this(url, mutableMapOf())

            /**
             * URL to the downloadable/printable label.
             *
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun url(): String = url.getRequired("url")

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                 * Returns a mutable builder for constructing an instance of [Label].
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Label]. */
            class Builder internal constructor() {

                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(label: Label) = apply {
                    url = label.url
                    additionalProperties = label.additionalProperties.toMutableMap()
                }

                /** URL to the downloadable/printable label. */
                fun url(url: String) = url(JsonField.of(url))

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Label].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Label =
                    Label(checkRequired("url", url), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws CheckoutIntentsInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Label = apply {
                if (validated) {
                    return@apply
                }

                url()
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
            @JvmSynthetic internal fun validity(): Int = (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Label &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(url, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Label{url=$url, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ShipItemsToMerchant &&
                label == other.label &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(label, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ShipItemsToMerchant{label=$label, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ReturnNextAction &&
            type == other.type &&
            shipItemsToMerchant == other.shipItemsToMerchant &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, shipItemsToMerchant, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ReturnNextAction{type=$type, shipItemsToMerchant=$shipItemsToMerchant, additionalProperties=$additionalProperties}"
}
