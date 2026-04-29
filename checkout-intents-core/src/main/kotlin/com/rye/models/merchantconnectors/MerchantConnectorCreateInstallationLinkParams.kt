// File generated from our OpenAPI spec by Stainless.

package com.rye.models.merchantconnectors

import com.fasterxml.jackson.annotation.JsonCreator
import com.rye.core.Enum
import com.rye.core.JsonField
import com.rye.core.Params
import com.rye.core.checkRequired
import com.rye.core.http.Headers
import com.rye.core.http.QueryParams
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Generate an installation link for a merchant connector (e.g. Shopify).
 *
 * The returned URL begins the connector's OAuth handshake. Direct the merchant to it; once they
 * authorize the Rye app, the connector redirects back to Rye to complete the install. The merchant
 * is attributed to the calling developer and becomes available for checkout via this account.
 */
class MerchantConnectorCreateInstallationLinkParams
private constructor(
    private val connector: Connector?,
    private val storeUrl: String,
    private val private_: Boolean?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A merchant connector is a Rye integration with a third-party merchant platform (e.g. Shopify)
     * that lets developers onboard merchants to Rye. Today only Shopify is supported; this union
     * expands as we add support for additional connectors (Woocommerce, BigCommerce, etc.).
     */
    fun connector(): Optional<Connector> = Optional.ofNullable(connector)

    /** Domain or URL of the merchant store to generate the installation link for */
    fun storeUrl(): String = storeUrl

    /** If true, the merchant onboarded via this link is exclusive to the calling developer */
    fun private_(): Optional<Boolean> = Optional.ofNullable(private_)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [MerchantConnectorCreateInstallationLinkParams].
         *
         * The following fields are required:
         * ```java
         * .storeUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MerchantConnectorCreateInstallationLinkParams]. */
    class Builder internal constructor() {

        private var connector: Connector? = null
        private var storeUrl: String? = null
        private var private_: Boolean? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            merchantConnectorCreateInstallationLinkParams:
                MerchantConnectorCreateInstallationLinkParams
        ) = apply {
            connector = merchantConnectorCreateInstallationLinkParams.connector
            storeUrl = merchantConnectorCreateInstallationLinkParams.storeUrl
            private_ = merchantConnectorCreateInstallationLinkParams.private_
            additionalHeaders =
                merchantConnectorCreateInstallationLinkParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                merchantConnectorCreateInstallationLinkParams.additionalQueryParams.toBuilder()
        }

        /**
         * A merchant connector is a Rye integration with a third-party merchant platform (e.g.
         * Shopify) that lets developers onboard merchants to Rye. Today only Shopify is supported;
         * this union expands as we add support for additional connectors (Woocommerce, BigCommerce,
         * etc.).
         */
        fun connector(connector: Connector?) = apply { this.connector = connector }

        /** Alias for calling [Builder.connector] with `connector.orElse(null)`. */
        fun connector(connector: Optional<Connector>) = connector(connector.getOrNull())

        /** Domain or URL of the merchant store to generate the installation link for */
        fun storeUrl(storeUrl: String) = apply { this.storeUrl = storeUrl }

        /** If true, the merchant onboarded via this link is exclusive to the calling developer */
        fun private_(private_: Boolean?) = apply { this.private_ = private_ }

        /**
         * Alias for [Builder.private_].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun private_(private_: Boolean) = private_(private_ as Boolean?)

        /** Alias for calling [Builder.private_] with `private_.orElse(null)`. */
        fun private_(private_: Optional<Boolean>) = private_(private_.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [MerchantConnectorCreateInstallationLinkParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .storeUrl()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MerchantConnectorCreateInstallationLinkParams =
            MerchantConnectorCreateInstallationLinkParams(
                connector,
                checkRequired("storeUrl", storeUrl),
                private_,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> connector?.toString() ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("storeUrl", storeUrl)
                private_?.let { put("private", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * A merchant connector is a Rye integration with a third-party merchant platform (e.g. Shopify)
     * that lets developers onboard merchants to Rye. Today only Shopify is supported; this union
     * expands as we add support for additional connectors (Woocommerce, BigCommerce, etc.).
     */
    class Connector @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SHOPIFY = of("shopify")

            @JvmStatic fun of(value: String) = Connector(JsonField.of(value))
        }

        /** An enum containing [Connector]'s known values. */
        enum class Known {
            SHOPIFY
        }

        /**
         * An enum containing [Connector]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Connector] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SHOPIFY,
            /**
             * An enum member indicating that [Connector] was instantiated with an unknown value.
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
                SHOPIFY -> Value.SHOPIFY
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
                SHOPIFY -> Known.SHOPIFY
                else -> throw CheckoutIntentsInvalidDataException("Unknown Connector: $value")
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

        fun validate(): Connector = apply {
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

            return other is Connector && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MerchantConnectorCreateInstallationLinkParams &&
            connector == other.connector &&
            storeUrl == other.storeUrl &&
            private_ == other.private_ &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(connector, storeUrl, private_, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MerchantConnectorCreateInstallationLinkParams{connector=$connector, storeUrl=$storeUrl, private_=$private_, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
