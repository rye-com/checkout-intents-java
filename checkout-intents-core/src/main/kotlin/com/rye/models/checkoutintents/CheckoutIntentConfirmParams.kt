// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.Params
import com.rye.core.checkRequired
import com.rye.core.http.Headers
import com.rye.core.http.QueryParams
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Confirm a checkout intent with provided payment information
 *
 * Confirm means we have buyer's name, address and payment info, so we can move forward to place the
 * order.
 */
class CheckoutIntentConfirmParams
private constructor(
    private val id: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentMethod(): PaymentMethod = body.paymentMethod()

    /**
     * Returns the raw JSON value of [paymentMethod].
     *
     * Unlike [paymentMethod], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _paymentMethod(): JsonField<PaymentMethod> = body._paymentMethod()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CheckoutIntentConfirmParams].
         *
         * The following fields are required:
         * ```java
         * .paymentMethod()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CheckoutIntentConfirmParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(checkoutIntentConfirmParams: CheckoutIntentConfirmParams) = apply {
            id = checkoutIntentConfirmParams.id
            body = checkoutIntentConfirmParams.body.toBuilder()
            additionalHeaders = checkoutIntentConfirmParams.additionalHeaders.toBuilder()
            additionalQueryParams = checkoutIntentConfirmParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [paymentMethod]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun paymentMethod(paymentMethod: PaymentMethod) = apply {
            body.paymentMethod(paymentMethod)
        }

        /**
         * Sets [Builder.paymentMethod] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentMethod] with a well-typed [PaymentMethod] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentMethod(paymentMethod: JsonField<PaymentMethod>) = apply {
            body.paymentMethod(paymentMethod)
        }

        /** Alias for calling [paymentMethod] with `PaymentMethod.ofStripeToken(stripeToken)`. */
        fun paymentMethod(stripeToken: PaymentMethod.StripeTokenPaymentMethod) = apply {
            body.paymentMethod(stripeToken)
        }

        /** Alias for calling [paymentMethod] with `PaymentMethod.ofBasisTheory(basisTheory)`. */
        fun paymentMethod(basisTheory: PaymentMethod.BasisTheoryPaymentMethod) = apply {
            body.paymentMethod(basisTheory)
        }

        /** Alias for calling [paymentMethod] with `PaymentMethod.ofNekuda(nekuda)`. */
        fun paymentMethod(nekuda: PaymentMethod.NekudaPaymentMethod) = apply {
            body.paymentMethod(nekuda)
        }

        /** Alias for calling [paymentMethod] with `PaymentMethod.ofDrawdown(drawdown)`. */
        fun paymentMethod(drawdown: PaymentMethod.DrawdownPaymentMethod) = apply {
            body.paymentMethod(drawdown)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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
         * Returns an immutable instance of [CheckoutIntentConfirmParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .paymentMethod()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CheckoutIntentConfirmParams =
            CheckoutIntentConfirmParams(
                id,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val paymentMethod: JsonField<PaymentMethod>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("paymentMethod")
            @ExcludeMissing
            paymentMethod: JsonField<PaymentMethod> = JsonMissing.of()
        ) : this(paymentMethod, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun paymentMethod(): PaymentMethod = paymentMethod.getRequired("paymentMethod")

        /**
         * Returns the raw JSON value of [paymentMethod].
         *
         * Unlike [paymentMethod], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("paymentMethod")
        @ExcludeMissing
        fun _paymentMethod(): JsonField<PaymentMethod> = paymentMethod

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .paymentMethod()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var paymentMethod: JsonField<PaymentMethod>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                paymentMethod = body.paymentMethod
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun paymentMethod(paymentMethod: PaymentMethod) =
                paymentMethod(JsonField.of(paymentMethod))

            /**
             * Sets [Builder.paymentMethod] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentMethod] with a well-typed [PaymentMethod]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun paymentMethod(paymentMethod: JsonField<PaymentMethod>) = apply {
                this.paymentMethod = paymentMethod
            }

            /**
             * Alias for calling [paymentMethod] with `PaymentMethod.ofStripeToken(stripeToken)`.
             */
            fun paymentMethod(stripeToken: PaymentMethod.StripeTokenPaymentMethod) =
                paymentMethod(PaymentMethod.ofStripeToken(stripeToken))

            /**
             * Alias for calling [paymentMethod] with `PaymentMethod.ofBasisTheory(basisTheory)`.
             */
            fun paymentMethod(basisTheory: PaymentMethod.BasisTheoryPaymentMethod) =
                paymentMethod(PaymentMethod.ofBasisTheory(basisTheory))

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofNekuda(nekuda)`. */
            fun paymentMethod(nekuda: PaymentMethod.NekudaPaymentMethod) =
                paymentMethod(PaymentMethod.ofNekuda(nekuda))

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofDrawdown(drawdown)`. */
            fun paymentMethod(drawdown: PaymentMethod.DrawdownPaymentMethod) =
                paymentMethod(PaymentMethod.ofDrawdown(drawdown))

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .paymentMethod()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("paymentMethod", paymentMethod),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            paymentMethod().validate()
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
        internal fun validity(): Int = (paymentMethod.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                paymentMethod == other.paymentMethod &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(paymentMethod, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{paymentMethod=$paymentMethod, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CheckoutIntentConfirmParams &&
            id == other.id &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(id, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CheckoutIntentConfirmParams{id=$id, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
