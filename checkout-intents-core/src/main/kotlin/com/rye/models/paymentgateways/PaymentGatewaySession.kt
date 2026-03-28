// File generated from our OpenAPI spec by Stainless.

package com.rye.models.paymentgateways

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
import kotlin.jvm.optionals.getOrNull

class PaymentGatewaySession
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val container: JsonField<String>,
    private val gateway: JsonField<Gateway>,
    private val sessionKey: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("container") @ExcludeMissing container: JsonField<String> = JsonMissing.of(),
        @JsonProperty("gateway") @ExcludeMissing gateway: JsonField<Gateway> = JsonMissing.of(),
        @JsonProperty("sessionKey") @ExcludeMissing sessionKey: JsonField<String> = JsonMissing.of(),
    ) : this(container, gateway, sessionKey, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun container(): String = container.getRequired("container")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun gateway(): Gateway = gateway.getRequired("gateway")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sessionKey(): String = sessionKey.getRequired("sessionKey")

    /**
     * Returns the raw JSON value of [container].
     *
     * Unlike [container], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("container") @ExcludeMissing fun _container(): JsonField<String> = container

    /**
     * Returns the raw JSON value of [gateway].
     *
     * Unlike [gateway], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("gateway") @ExcludeMissing fun _gateway(): JsonField<Gateway> = gateway

    /**
     * Returns the raw JSON value of [sessionKey].
     *
     * Unlike [sessionKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sessionKey") @ExcludeMissing fun _sessionKey(): JsonField<String> = sessionKey

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
         * Returns a mutable builder for constructing an instance of [PaymentGatewaySession].
         *
         * The following fields are required:
         * ```java
         * .container()
         * .gateway()
         * .sessionKey()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PaymentGatewaySession]. */
    class Builder internal constructor() {

        private var container: JsonField<String>? = null
        private var gateway: JsonField<Gateway>? = null
        private var sessionKey: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(paymentGatewaySession: PaymentGatewaySession) = apply {
            container = paymentGatewaySession.container
            gateway = paymentGatewaySession.gateway
            sessionKey = paymentGatewaySession.sessionKey
            additionalProperties = paymentGatewaySession.additionalProperties.toMutableMap()
        }

        fun container(container: String) = container(JsonField.of(container))

        /**
         * Sets [Builder.container] to an arbitrary JSON value.
         *
         * You should usually call [Builder.container] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun container(container: JsonField<String>) = apply { this.container = container }

        fun gateway(gateway: Gateway) = gateway(JsonField.of(gateway))

        /**
         * Sets [Builder.gateway] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gateway] with a well-typed [Gateway] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun gateway(gateway: JsonField<Gateway>) = apply { this.gateway = gateway }

        fun sessionKey(sessionKey: String) = sessionKey(JsonField.of(sessionKey))

        /**
         * Sets [Builder.sessionKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sessionKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sessionKey(sessionKey: JsonField<String>) = apply { this.sessionKey = sessionKey }

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
         * Returns an immutable instance of [PaymentGatewaySession].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .container()
         * .gateway()
         * .sessionKey()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): PaymentGatewaySession =
            PaymentGatewaySession(
                checkRequired("container", container),
                checkRequired("gateway", gateway),
                checkRequired("sessionKey", sessionKey),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PaymentGatewaySession = apply {
        if (validated) {
            return@apply
        }

        container()
        gateway().validate()
        sessionKey()
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
        (if (container.asKnown().isPresent) 1 else 0) +
            (gateway.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sessionKey.asKnown().isPresent) 1 else 0)

    class Gateway @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val BASIS_THEORY = of("basis_theory")

            @JvmStatic fun of(value: String) = Gateway(JsonField.of(value))
        }

        /** An enum containing [Gateway]'s known values. */
        enum class Known {
            BASIS_THEORY
        }

        /**
         * An enum containing [Gateway]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Gateway] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            BASIS_THEORY,
            /** An enum member indicating that [Gateway] was instantiated with an unknown value. */
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
                BASIS_THEORY -> Value.BASIS_THEORY
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
                BASIS_THEORY -> Known.BASIS_THEORY
                else -> throw CheckoutIntentsInvalidDataException("Unknown Gateway: $value")
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

        fun validate(): Gateway = apply {
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

            return other is Gateway && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaymentGatewaySession &&
            container == other.container &&
            gateway == other.gateway &&
            sessionKey == other.sessionKey &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(container, gateway, sessionKey, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PaymentGatewaySession{container=$container, gateway=$gateway, sessionKey=$sessionKey, additionalProperties=$additionalProperties}"
}
