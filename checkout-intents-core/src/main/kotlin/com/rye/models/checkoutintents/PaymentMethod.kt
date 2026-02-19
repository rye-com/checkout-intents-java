// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.BaseDeserializer
import com.rye.core.BaseSerializer
import com.rye.core.Enum
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.allMaxBy
import com.rye.core.checkRequired
import com.rye.core.getOrThrow
import com.rye.core.toImmutable
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = PaymentMethod.Deserializer::class)
@JsonSerialize(using = PaymentMethod.Serializer::class)
class PaymentMethod
private constructor(
    private val stripeToken: StripeTokenPaymentMethod? = null,
    private val basisTheory: BasisTheoryPaymentMethod? = null,
    private val nekuda: NekudaPaymentMethod? = null,
    private val drawdown: DrawdownPaymentMethod? = null,
    private val _json: JsonValue? = null,
) {

    fun stripeToken(): Optional<StripeTokenPaymentMethod> = Optional.ofNullable(stripeToken)

    fun basisTheory(): Optional<BasisTheoryPaymentMethod> = Optional.ofNullable(basisTheory)

    fun nekuda(): Optional<NekudaPaymentMethod> = Optional.ofNullable(nekuda)

    fun drawdown(): Optional<DrawdownPaymentMethod> = Optional.ofNullable(drawdown)

    fun isStripeToken(): Boolean = stripeToken != null

    fun isBasisTheory(): Boolean = basisTheory != null

    fun isNekuda(): Boolean = nekuda != null

    fun isDrawdown(): Boolean = drawdown != null

    fun asStripeToken(): StripeTokenPaymentMethod = stripeToken.getOrThrow("stripeToken")

    fun asBasisTheory(): BasisTheoryPaymentMethod = basisTheory.getOrThrow("basisTheory")

    fun asNekuda(): NekudaPaymentMethod = nekuda.getOrThrow("nekuda")

    fun asDrawdown(): DrawdownPaymentMethod = drawdown.getOrThrow("drawdown")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            stripeToken != null -> visitor.visitStripeToken(stripeToken)
            basisTheory != null -> visitor.visitBasisTheory(basisTheory)
            nekuda != null -> visitor.visitNekuda(nekuda)
            drawdown != null -> visitor.visitDrawdown(drawdown)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): PaymentMethod = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitStripeToken(stripeToken: StripeTokenPaymentMethod) {
                    stripeToken.validate()
                }

                override fun visitBasisTheory(basisTheory: BasisTheoryPaymentMethod) {
                    basisTheory.validate()
                }

                override fun visitNekuda(nekuda: NekudaPaymentMethod) {
                    nekuda.validate()
                }

                override fun visitDrawdown(drawdown: DrawdownPaymentMethod) {
                    drawdown.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitStripeToken(stripeToken: StripeTokenPaymentMethod) =
                    stripeToken.validity()

                override fun visitBasisTheory(basisTheory: BasisTheoryPaymentMethod) =
                    basisTheory.validity()

                override fun visitNekuda(nekuda: NekudaPaymentMethod) = nekuda.validity()

                override fun visitDrawdown(drawdown: DrawdownPaymentMethod) = drawdown.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaymentMethod &&
            stripeToken == other.stripeToken &&
            basisTheory == other.basisTheory &&
            nekuda == other.nekuda &&
            drawdown == other.drawdown
    }

    override fun hashCode(): Int = Objects.hash(stripeToken, basisTheory, nekuda, drawdown)

    override fun toString(): String =
        when {
            stripeToken != null -> "PaymentMethod{stripeToken=$stripeToken}"
            basisTheory != null -> "PaymentMethod{basisTheory=$basisTheory}"
            nekuda != null -> "PaymentMethod{nekuda=$nekuda}"
            drawdown != null -> "PaymentMethod{drawdown=$drawdown}"
            _json != null -> "PaymentMethod{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid PaymentMethod")
        }

    companion object {

        @JvmStatic
        fun ofStripeToken(stripeToken: StripeTokenPaymentMethod) =
            PaymentMethod(stripeToken = stripeToken)

        @JvmStatic
        fun ofBasisTheory(basisTheory: BasisTheoryPaymentMethod) =
            PaymentMethod(basisTheory = basisTheory)

        @JvmStatic fun ofNekuda(nekuda: NekudaPaymentMethod) = PaymentMethod(nekuda = nekuda)

        @JvmStatic
        fun ofDrawdown(drawdown: DrawdownPaymentMethod) = PaymentMethod(drawdown = drawdown)
    }

    /**
     * An interface that defines how to map each variant of [PaymentMethod] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitStripeToken(stripeToken: StripeTokenPaymentMethod): T

        fun visitBasisTheory(basisTheory: BasisTheoryPaymentMethod): T

        fun visitNekuda(nekuda: NekudaPaymentMethod): T

        fun visitDrawdown(drawdown: DrawdownPaymentMethod): T

        /**
         * Maps an unknown variant of [PaymentMethod] to a value of type [T].
         *
         * An instance of [PaymentMethod] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws CheckoutIntentsInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw CheckoutIntentsInvalidDataException("Unknown PaymentMethod: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<PaymentMethod>(PaymentMethod::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): PaymentMethod {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<StripeTokenPaymentMethod>())?.let {
                            PaymentMethod(stripeToken = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<BasisTheoryPaymentMethod>())?.let {
                            PaymentMethod(basisTheory = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<NekudaPaymentMethod>())?.let {
                            PaymentMethod(nekuda = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<DrawdownPaymentMethod>())?.let {
                            PaymentMethod(drawdown = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> PaymentMethod(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<PaymentMethod>(PaymentMethod::class) {

        override fun serialize(
            value: PaymentMethod,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.stripeToken != null -> generator.writeObject(value.stripeToken)
                value.basisTheory != null -> generator.writeObject(value.basisTheory)
                value.nekuda != null -> generator.writeObject(value.nekuda)
                value.drawdown != null -> generator.writeObject(value.drawdown)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid PaymentMethod")
            }
        }
    }

    class StripeTokenPaymentMethod
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val stripeToken: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("stripeToken")
            @ExcludeMissing
            stripeToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(stripeToken, type, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun stripeToken(): String = stripeToken.getRequired("stripeToken")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * Returns the raw JSON value of [stripeToken].
         *
         * Unlike [stripeToken], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stripeToken")
        @ExcludeMissing
        fun _stripeToken(): JsonField<String> = stripeToken

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
             * Returns a mutable builder for constructing an instance of [StripeTokenPaymentMethod].
             *
             * The following fields are required:
             * ```java
             * .stripeToken()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [StripeTokenPaymentMethod]. */
        class Builder internal constructor() {

            private var stripeToken: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stripeTokenPaymentMethod: StripeTokenPaymentMethod) = apply {
                stripeToken = stripeTokenPaymentMethod.stripeToken
                type = stripeTokenPaymentMethod.type
                additionalProperties = stripeTokenPaymentMethod.additionalProperties.toMutableMap()
            }

            fun stripeToken(stripeToken: String) = stripeToken(JsonField.of(stripeToken))

            /**
             * Sets [Builder.stripeToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stripeToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stripeToken(stripeToken: JsonField<String>) = apply {
                this.stripeToken = stripeToken
            }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [StripeTokenPaymentMethod].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .stripeToken()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): StripeTokenPaymentMethod =
                StripeTokenPaymentMethod(
                    checkRequired("stripeToken", stripeToken),
                    checkRequired("type", type),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): StripeTokenPaymentMethod = apply {
            if (validated) {
                return@apply
            }

            stripeToken()
            type().validate()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (stripeToken.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val STRIPE_TOKEN = of("stripe_token")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                STRIPE_TOKEN
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                STRIPE_TOKEN,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    STRIPE_TOKEN -> Value.STRIPE_TOKEN
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    STRIPE_TOKEN -> Known.STRIPE_TOKEN
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    CheckoutIntentsInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StripeTokenPaymentMethod &&
                stripeToken == other.stripeToken &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(stripeToken, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StripeTokenPaymentMethod{stripeToken=$stripeToken, type=$type, additionalProperties=$additionalProperties}"
    }

    class BasisTheoryPaymentMethod
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val basisTheoryToken: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("basisTheoryToken")
            @ExcludeMissing
            basisTheoryToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(basisTheoryToken, type, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun basisTheoryToken(): String = basisTheoryToken.getRequired("basisTheoryToken")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * Returns the raw JSON value of [basisTheoryToken].
         *
         * Unlike [basisTheoryToken], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("basisTheoryToken")
        @ExcludeMissing
        fun _basisTheoryToken(): JsonField<String> = basisTheoryToken

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
             * Returns a mutable builder for constructing an instance of [BasisTheoryPaymentMethod].
             *
             * The following fields are required:
             * ```java
             * .basisTheoryToken()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BasisTheoryPaymentMethod]. */
        class Builder internal constructor() {

            private var basisTheoryToken: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(basisTheoryPaymentMethod: BasisTheoryPaymentMethod) = apply {
                basisTheoryToken = basisTheoryPaymentMethod.basisTheoryToken
                type = basisTheoryPaymentMethod.type
                additionalProperties = basisTheoryPaymentMethod.additionalProperties.toMutableMap()
            }

            fun basisTheoryToken(basisTheoryToken: String) =
                basisTheoryToken(JsonField.of(basisTheoryToken))

            /**
             * Sets [Builder.basisTheoryToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.basisTheoryToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun basisTheoryToken(basisTheoryToken: JsonField<String>) = apply {
                this.basisTheoryToken = basisTheoryToken
            }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [BasisTheoryPaymentMethod].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .basisTheoryToken()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): BasisTheoryPaymentMethod =
                BasisTheoryPaymentMethod(
                    checkRequired("basisTheoryToken", basisTheoryToken),
                    checkRequired("type", type),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): BasisTheoryPaymentMethod = apply {
            if (validated) {
                return@apply
            }

            basisTheoryToken()
            type().validate()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (basisTheoryToken.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val BASIS_THEORY_TOKEN = of("basis_theory_token")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                BASIS_THEORY_TOKEN
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                BASIS_THEORY_TOKEN,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    BASIS_THEORY_TOKEN -> Value.BASIS_THEORY_TOKEN
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    BASIS_THEORY_TOKEN -> Known.BASIS_THEORY_TOKEN
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    CheckoutIntentsInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BasisTheoryPaymentMethod &&
                basisTheoryToken == other.basisTheoryToken &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(basisTheoryToken, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BasisTheoryPaymentMethod{basisTheoryToken=$basisTheoryToken, type=$type, additionalProperties=$additionalProperties}"
    }

    class NekudaPaymentMethod
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val nekudaUserId: JsonField<String>,
        private val type: JsonField<Type>,
        private val nekudaMandateData: JsonField<NekudaMandateData>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("nekudaUserId")
            @ExcludeMissing
            nekudaUserId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("nekudaMandateData")
            @ExcludeMissing
            nekudaMandateData: JsonField<NekudaMandateData> = JsonMissing.of(),
        ) : this(nekudaUserId, type, nekudaMandateData, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun nekudaUserId(): String = nekudaUserId.getRequired("nekudaUserId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * Construct a type with a set of properties K of type T
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun nekudaMandateData(): Optional<NekudaMandateData> =
            nekudaMandateData.getOptional("nekudaMandateData")

        /**
         * Returns the raw JSON value of [nekudaUserId].
         *
         * Unlike [nekudaUserId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("nekudaUserId")
        @ExcludeMissing
        fun _nekudaUserId(): JsonField<String> = nekudaUserId

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [nekudaMandateData].
         *
         * Unlike [nekudaMandateData], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("nekudaMandateData")
        @ExcludeMissing
        fun _nekudaMandateData(): JsonField<NekudaMandateData> = nekudaMandateData

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
             * Returns a mutable builder for constructing an instance of [NekudaPaymentMethod].
             *
             * The following fields are required:
             * ```java
             * .nekudaUserId()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NekudaPaymentMethod]. */
        class Builder internal constructor() {

            private var nekudaUserId: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var nekudaMandateData: JsonField<NekudaMandateData> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(nekudaPaymentMethod: NekudaPaymentMethod) = apply {
                nekudaUserId = nekudaPaymentMethod.nekudaUserId
                type = nekudaPaymentMethod.type
                nekudaMandateData = nekudaPaymentMethod.nekudaMandateData
                additionalProperties = nekudaPaymentMethod.additionalProperties.toMutableMap()
            }

            fun nekudaUserId(nekudaUserId: String) = nekudaUserId(JsonField.of(nekudaUserId))

            /**
             * Sets [Builder.nekudaUserId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nekudaUserId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nekudaUserId(nekudaUserId: JsonField<String>) = apply {
                this.nekudaUserId = nekudaUserId
            }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /** Construct a type with a set of properties K of type T */
            fun nekudaMandateData(nekudaMandateData: NekudaMandateData) =
                nekudaMandateData(JsonField.of(nekudaMandateData))

            /**
             * Sets [Builder.nekudaMandateData] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nekudaMandateData] with a well-typed
             * [NekudaMandateData] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun nekudaMandateData(nekudaMandateData: JsonField<NekudaMandateData>) = apply {
                this.nekudaMandateData = nekudaMandateData
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
             * Returns an immutable instance of [NekudaPaymentMethod].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .nekudaUserId()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): NekudaPaymentMethod =
                NekudaPaymentMethod(
                    checkRequired("nekudaUserId", nekudaUserId),
                    checkRequired("type", type),
                    nekudaMandateData,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): NekudaPaymentMethod = apply {
            if (validated) {
                return@apply
            }

            nekudaUserId()
            type().validate()
            nekudaMandateData().ifPresent { it.validate() }
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (nekudaUserId.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (nekudaMandateData.asKnown().getOrNull()?.validity() ?: 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val NEKUDA_TOKEN = of("nekuda_token")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                NEKUDA_TOKEN
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NEKUDA_TOKEN,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    NEKUDA_TOKEN -> Value.NEKUDA_TOKEN
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    NEKUDA_TOKEN -> Known.NEKUDA_TOKEN
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    CheckoutIntentsInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

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

        /** Construct a type with a set of properties K of type T */
        class NekudaMandateData
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [NekudaMandateData].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [NekudaMandateData]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(nekudaMandateData: NekudaMandateData) = apply {
                    additionalProperties = nekudaMandateData.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [NekudaMandateData].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): NekudaMandateData =
                    NekudaMandateData(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): NekudaMandateData = apply {
                if (validated) {
                    return@apply
                }

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
            @JvmSynthetic
            internal fun validity(): Int =
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is NekudaMandateData &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "NekudaMandateData{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NekudaPaymentMethod &&
                nekudaUserId == other.nekudaUserId &&
                type == other.type &&
                nekudaMandateData == other.nekudaMandateData &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(nekudaUserId, type, nekudaMandateData, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NekudaPaymentMethod{nekudaUserId=$nekudaUserId, type=$type, nekudaMandateData=$nekudaMandateData, additionalProperties=$additionalProperties}"
    }

    class DrawdownPaymentMethod
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
        ) : this(type, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
             * Returns a mutable builder for constructing an instance of [DrawdownPaymentMethod].
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DrawdownPaymentMethod]. */
        class Builder internal constructor() {

            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(drawdownPaymentMethod: DrawdownPaymentMethod) = apply {
                type = drawdownPaymentMethod.type
                additionalProperties = drawdownPaymentMethod.additionalProperties.toMutableMap()
            }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [DrawdownPaymentMethod].
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
            fun build(): DrawdownPaymentMethod =
                DrawdownPaymentMethod(
                    checkRequired("type", type),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): DrawdownPaymentMethod = apply {
            if (validated) {
                return@apply
            }

            type().validate()
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
        @JvmSynthetic internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val DRAWDOWN = of("drawdown")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                DRAWDOWN
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                DRAWDOWN,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    DRAWDOWN -> Value.DRAWDOWN
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    DRAWDOWN -> Known.DRAWDOWN
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws CheckoutIntentsInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    CheckoutIntentsInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DrawdownPaymentMethod &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "DrawdownPaymentMethod{type=$type, additionalProperties=$additionalProperties}"
    }
}
