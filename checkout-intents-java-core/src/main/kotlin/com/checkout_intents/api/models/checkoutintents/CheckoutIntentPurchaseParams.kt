// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import com.checkout_intents.api.core.Enum
import com.checkout_intents.api.core.ExcludeMissing
import com.checkout_intents.api.core.JsonField
import com.checkout_intents.api.core.JsonMissing
import com.checkout_intents.api.core.JsonValue
import com.checkout_intents.api.core.Params
import com.checkout_intents.api.core.checkKnown
import com.checkout_intents.api.core.checkRequired
import com.checkout_intents.api.core.http.Headers
import com.checkout_intents.api.core.http.QueryParams
import com.checkout_intents.api.core.toImmutable
import com.checkout_intents.api.errors.CheckoutIntentsInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a checkout intent and immediately trigger the purchase workflow.
 *
 * This is a "fire-and-forget" endpoint that combines create + confirm in one step. The workflow
 * handles offer retrieval, payment authorization, and order placement asynchronously. Poll the GET
 * endpoint to check status.
 */
class CheckoutIntentPurchaseParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun buyer(): Buyer = body.buyer()

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentMethod(): PaymentMethod = body.paymentMethod()

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun productUrl(): String = body.productUrl()

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quantity(): Int = body.quantity()

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun constraints(): Optional<Constraints> = body.constraints()

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun promoCodes(): Optional<List<String>> = body.promoCodes()

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun variantSelections(): Optional<List<VariantSelection>> = body.variantSelections()

    /**
     * Returns the raw JSON value of [buyer].
     *
     * Unlike [buyer], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _buyer(): JsonField<Buyer> = body._buyer()

    /**
     * Returns the raw JSON value of [paymentMethod].
     *
     * Unlike [paymentMethod], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _paymentMethod(): JsonField<PaymentMethod> = body._paymentMethod()

    /**
     * Returns the raw JSON value of [productUrl].
     *
     * Unlike [productUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _productUrl(): JsonField<String> = body._productUrl()

    /**
     * Returns the raw JSON value of [quantity].
     *
     * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quantity(): JsonField<Int> = body._quantity()

    /**
     * Returns the raw JSON value of [constraints].
     *
     * Unlike [constraints], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _constraints(): JsonField<Constraints> = body._constraints()

    /**
     * Returns the raw JSON value of [promoCodes].
     *
     * Unlike [promoCodes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _promoCodes(): JsonField<List<String>> = body._promoCodes()

    /**
     * Returns the raw JSON value of [variantSelections].
     *
     * Unlike [variantSelections], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _variantSelections(): JsonField<List<VariantSelection>> = body._variantSelections()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CheckoutIntentPurchaseParams].
         *
         * The following fields are required:
         * ```java
         * .buyer()
         * .paymentMethod()
         * .productUrl()
         * .quantity()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CheckoutIntentPurchaseParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(checkoutIntentPurchaseParams: CheckoutIntentPurchaseParams) = apply {
            body = checkoutIntentPurchaseParams.body.toBuilder()
            additionalHeaders = checkoutIntentPurchaseParams.additionalHeaders.toBuilder()
            additionalQueryParams = checkoutIntentPurchaseParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [buyer]
         * - [paymentMethod]
         * - [productUrl]
         * - [quantity]
         * - [constraints]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun buyer(buyer: Buyer) = apply { body.buyer(buyer) }

        /**
         * Sets [Builder.buyer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun buyer(buyer: JsonField<Buyer>) = apply { body.buyer(buyer) }

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

        fun productUrl(productUrl: String) = apply { body.productUrl(productUrl) }

        /**
         * Sets [Builder.productUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.productUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun productUrl(productUrl: JsonField<String>) = apply { body.productUrl(productUrl) }

        fun quantity(quantity: Int) = apply { body.quantity(quantity) }

        /**
         * Sets [Builder.quantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quantity] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quantity(quantity: JsonField<Int>) = apply { body.quantity(quantity) }

        fun constraints(constraints: Constraints) = apply { body.constraints(constraints) }

        /**
         * Sets [Builder.constraints] to an arbitrary JSON value.
         *
         * You should usually call [Builder.constraints] with a well-typed [Constraints] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun constraints(constraints: JsonField<Constraints>) = apply {
            body.constraints(constraints)
        }

        fun promoCodes(promoCodes: List<String>) = apply { body.promoCodes(promoCodes) }

        /**
         * Sets [Builder.promoCodes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promoCodes] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun promoCodes(promoCodes: JsonField<List<String>>) = apply { body.promoCodes(promoCodes) }

        /**
         * Adds a single [String] to [promoCodes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPromoCode(promoCode: String) = apply { body.addPromoCode(promoCode) }

        fun variantSelections(variantSelections: List<VariantSelection>) = apply {
            body.variantSelections(variantSelections)
        }

        /**
         * Sets [Builder.variantSelections] to an arbitrary JSON value.
         *
         * You should usually call [Builder.variantSelections] with a well-typed
         * `List<VariantSelection>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun variantSelections(variantSelections: JsonField<List<VariantSelection>>) = apply {
            body.variantSelections(variantSelections)
        }

        /**
         * Adds a single [VariantSelection] to [variantSelections].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVariantSelection(variantSelection: VariantSelection) = apply {
            body.addVariantSelection(variantSelection)
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
         * Returns an immutable instance of [CheckoutIntentPurchaseParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .buyer()
         * .paymentMethod()
         * .productUrl()
         * .quantity()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CheckoutIntentPurchaseParams =
            CheckoutIntentPurchaseParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val buyer: JsonField<Buyer>,
        private val paymentMethod: JsonField<PaymentMethod>,
        private val productUrl: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val constraints: JsonField<Constraints>,
        private val promoCodes: JsonField<List<String>>,
        private val variantSelections: JsonField<List<VariantSelection>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("buyer") @ExcludeMissing buyer: JsonField<Buyer> = JsonMissing.of(),
            @JsonProperty("paymentMethod")
            @ExcludeMissing
            paymentMethod: JsonField<PaymentMethod> = JsonMissing.of(),
            @JsonProperty("productUrl")
            @ExcludeMissing
            productUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("constraints")
            @ExcludeMissing
            constraints: JsonField<Constraints> = JsonMissing.of(),
            @JsonProperty("promoCodes")
            @ExcludeMissing
            promoCodes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("variantSelections")
            @ExcludeMissing
            variantSelections: JsonField<List<VariantSelection>> = JsonMissing.of(),
        ) : this(
            buyer,
            paymentMethod,
            productUrl,
            quantity,
            constraints,
            promoCodes,
            variantSelections,
            mutableMapOf(),
        )

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun buyer(): Buyer = buyer.getRequired("buyer")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun paymentMethod(): PaymentMethod = paymentMethod.getRequired("paymentMethod")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun productUrl(): String = productUrl.getRequired("productUrl")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun quantity(): Int = quantity.getRequired("quantity")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun constraints(): Optional<Constraints> = constraints.getOptional("constraints")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun promoCodes(): Optional<List<String>> = promoCodes.getOptional("promoCodes")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun variantSelections(): Optional<List<VariantSelection>> =
            variantSelections.getOptional("variantSelections")

        /**
         * Returns the raw JSON value of [buyer].
         *
         * Unlike [buyer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("buyer") @ExcludeMissing fun _buyer(): JsonField<Buyer> = buyer

        /**
         * Returns the raw JSON value of [paymentMethod].
         *
         * Unlike [paymentMethod], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("paymentMethod")
        @ExcludeMissing
        fun _paymentMethod(): JsonField<PaymentMethod> = paymentMethod

        /**
         * Returns the raw JSON value of [productUrl].
         *
         * Unlike [productUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("productUrl")
        @ExcludeMissing
        fun _productUrl(): JsonField<String> = productUrl

        /**
         * Returns the raw JSON value of [quantity].
         *
         * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Int> = quantity

        /**
         * Returns the raw JSON value of [constraints].
         *
         * Unlike [constraints], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("constraints")
        @ExcludeMissing
        fun _constraints(): JsonField<Constraints> = constraints

        /**
         * Returns the raw JSON value of [promoCodes].
         *
         * Unlike [promoCodes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("promoCodes")
        @ExcludeMissing
        fun _promoCodes(): JsonField<List<String>> = promoCodes

        /**
         * Returns the raw JSON value of [variantSelections].
         *
         * Unlike [variantSelections], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("variantSelections")
        @ExcludeMissing
        fun _variantSelections(): JsonField<List<VariantSelection>> = variantSelections

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
             * .buyer()
             * .paymentMethod()
             * .productUrl()
             * .quantity()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var buyer: JsonField<Buyer>? = null
            private var paymentMethod: JsonField<PaymentMethod>? = null
            private var productUrl: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var constraints: JsonField<Constraints> = JsonMissing.of()
            private var promoCodes: JsonField<MutableList<String>>? = null
            private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                buyer = body.buyer
                paymentMethod = body.paymentMethod
                productUrl = body.productUrl
                quantity = body.quantity
                constraints = body.constraints
                promoCodes = body.promoCodes.map { it.toMutableList() }
                variantSelections = body.variantSelections.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

            /**
             * Sets [Builder.buyer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun buyer(buyer: JsonField<Buyer>) = apply { this.buyer = buyer }

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

            fun productUrl(productUrl: String) = productUrl(JsonField.of(productUrl))

            /**
             * Sets [Builder.productUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.productUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun productUrl(productUrl: JsonField<String>) = apply { this.productUrl = productUrl }

            fun quantity(quantity: Int) = quantity(JsonField.of(quantity))

            /**
             * Sets [Builder.quantity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quantity] with a well-typed [Int] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quantity(quantity: JsonField<Int>) = apply { this.quantity = quantity }

            fun constraints(constraints: Constraints) = constraints(JsonField.of(constraints))

            /**
             * Sets [Builder.constraints] to an arbitrary JSON value.
             *
             * You should usually call [Builder.constraints] with a well-typed [Constraints] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun constraints(constraints: JsonField<Constraints>) = apply {
                this.constraints = constraints
            }

            fun promoCodes(promoCodes: List<String>) = promoCodes(JsonField.of(promoCodes))

            /**
             * Sets [Builder.promoCodes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.promoCodes] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun promoCodes(promoCodes: JsonField<List<String>>) = apply {
                this.promoCodes = promoCodes.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [promoCodes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPromoCode(promoCode: String) = apply {
                promoCodes =
                    (promoCodes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("promoCodes", it).add(promoCode)
                    }
            }

            fun variantSelections(variantSelections: List<VariantSelection>) =
                variantSelections(JsonField.of(variantSelections))

            /**
             * Sets [Builder.variantSelections] to an arbitrary JSON value.
             *
             * You should usually call [Builder.variantSelections] with a well-typed
             * `List<VariantSelection>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun variantSelections(variantSelections: JsonField<List<VariantSelection>>) = apply {
                this.variantSelections = variantSelections.map { it.toMutableList() }
            }

            /**
             * Adds a single [VariantSelection] to [variantSelections].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addVariantSelection(variantSelection: VariantSelection) = apply {
                variantSelections =
                    (variantSelections ?: JsonField.of(mutableListOf())).also {
                        checkKnown("variantSelections", it).add(variantSelection)
                    }
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .buyer()
             * .paymentMethod()
             * .productUrl()
             * .quantity()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("buyer", buyer),
                    checkRequired("paymentMethod", paymentMethod),
                    checkRequired("productUrl", productUrl),
                    checkRequired("quantity", quantity),
                    constraints,
                    (promoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                    (variantSelections ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            buyer().validate()
            paymentMethod().validate()
            productUrl()
            quantity()
            constraints().ifPresent { it.validate() }
            promoCodes()
            variantSelections().ifPresent { it.forEach { it.validate() } }
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
            (buyer.asKnown().getOrNull()?.validity() ?: 0) +
                (paymentMethod.asKnown().getOrNull()?.validity() ?: 0) +
                (if (productUrl.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0) +
                (constraints.asKnown().getOrNull()?.validity() ?: 0) +
                (promoCodes.asKnown().getOrNull()?.size ?: 0) +
                (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                buyer == other.buyer &&
                paymentMethod == other.paymentMethod &&
                productUrl == other.productUrl &&
                quantity == other.quantity &&
                constraints == other.constraints &&
                promoCodes == other.promoCodes &&
                variantSelections == other.variantSelections &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                buyer,
                paymentMethod,
                productUrl,
                quantity,
                constraints,
                promoCodes,
                variantSelections,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{buyer=$buyer, paymentMethod=$paymentMethod, productUrl=$productUrl, quantity=$quantity, constraints=$constraints, promoCodes=$promoCodes, variantSelections=$variantSelections, additionalProperties=$additionalProperties}"
    }

    class Constraints
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val maxShippingPrice: JsonField<Int>,
        private val maxTotalPrice: JsonField<Int>,
        private val offerRetrievalEffort: JsonField<OfferRetrievalEffort>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("maxShippingPrice")
            @ExcludeMissing
            maxShippingPrice: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("maxTotalPrice")
            @ExcludeMissing
            maxTotalPrice: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("offerRetrievalEffort")
            @ExcludeMissing
            offerRetrievalEffort: JsonField<OfferRetrievalEffort> = JsonMissing.of(),
        ) : this(maxShippingPrice, maxTotalPrice, offerRetrievalEffort, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxShippingPrice(): Optional<Int> = maxShippingPrice.getOptional("maxShippingPrice")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxTotalPrice(): Optional<Int> = maxTotalPrice.getOptional("maxTotalPrice")

        /**
         * Controls how much effort the system should spend retrieving an offer.
         * - 'max': Full effort including AI agent fallback (slower, higher success rate)
         * - 'low': Fast API-only retrieval, fails if API unavailable (faster, lower success rate)
         *
         * Default: 'max'
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun offerRetrievalEffort(): Optional<OfferRetrievalEffort> =
            offerRetrievalEffort.getOptional("offerRetrievalEffort")

        /**
         * Returns the raw JSON value of [maxShippingPrice].
         *
         * Unlike [maxShippingPrice], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxShippingPrice")
        @ExcludeMissing
        fun _maxShippingPrice(): JsonField<Int> = maxShippingPrice

        /**
         * Returns the raw JSON value of [maxTotalPrice].
         *
         * Unlike [maxTotalPrice], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxTotalPrice")
        @ExcludeMissing
        fun _maxTotalPrice(): JsonField<Int> = maxTotalPrice

        /**
         * Returns the raw JSON value of [offerRetrievalEffort].
         *
         * Unlike [offerRetrievalEffort], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("offerRetrievalEffort")
        @ExcludeMissing
        fun _offerRetrievalEffort(): JsonField<OfferRetrievalEffort> = offerRetrievalEffort

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

            /** Returns a mutable builder for constructing an instance of [Constraints]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Constraints]. */
        class Builder internal constructor() {

            private var maxShippingPrice: JsonField<Int> = JsonMissing.of()
            private var maxTotalPrice: JsonField<Int> = JsonMissing.of()
            private var offerRetrievalEffort: JsonField<OfferRetrievalEffort> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(constraints: Constraints) = apply {
                maxShippingPrice = constraints.maxShippingPrice
                maxTotalPrice = constraints.maxTotalPrice
                offerRetrievalEffort = constraints.offerRetrievalEffort
                additionalProperties = constraints.additionalProperties.toMutableMap()
            }

            fun maxShippingPrice(maxShippingPrice: Int) =
                maxShippingPrice(JsonField.of(maxShippingPrice))

            /**
             * Sets [Builder.maxShippingPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxShippingPrice] with a well-typed [Int] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxShippingPrice(maxShippingPrice: JsonField<Int>) = apply {
                this.maxShippingPrice = maxShippingPrice
            }

            fun maxTotalPrice(maxTotalPrice: Int) = maxTotalPrice(JsonField.of(maxTotalPrice))

            /**
             * Sets [Builder.maxTotalPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxTotalPrice] with a well-typed [Int] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxTotalPrice(maxTotalPrice: JsonField<Int>) = apply {
                this.maxTotalPrice = maxTotalPrice
            }

            /**
             * Controls how much effort the system should spend retrieving an offer.
             * - 'max': Full effort including AI agent fallback (slower, higher success rate)
             * - 'low': Fast API-only retrieval, fails if API unavailable (faster, lower success
             *   rate)
             *
             * Default: 'max'
             */
            fun offerRetrievalEffort(offerRetrievalEffort: OfferRetrievalEffort) =
                offerRetrievalEffort(JsonField.of(offerRetrievalEffort))

            /**
             * Sets [Builder.offerRetrievalEffort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.offerRetrievalEffort] with a well-typed
             * [OfferRetrievalEffort] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun offerRetrievalEffort(offerRetrievalEffort: JsonField<OfferRetrievalEffort>) =
                apply {
                    this.offerRetrievalEffort = offerRetrievalEffort
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
             * Returns an immutable instance of [Constraints].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Constraints =
                Constraints(
                    maxShippingPrice,
                    maxTotalPrice,
                    offerRetrievalEffort,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Constraints = apply {
            if (validated) {
                return@apply
            }

            maxShippingPrice()
            maxTotalPrice()
            offerRetrievalEffort().ifPresent { it.validate() }
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
            (if (maxShippingPrice.asKnown().isPresent) 1 else 0) +
                (if (maxTotalPrice.asKnown().isPresent) 1 else 0) +
                (offerRetrievalEffort.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Controls how much effort the system should spend retrieving an offer.
         * - 'max': Full effort including AI agent fallback (slower, higher success rate)
         * - 'low': Fast API-only retrieval, fails if API unavailable (faster, lower success rate)
         *
         * Default: 'max'
         */
        class OfferRetrievalEffort
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val MAX = of("max")

                @JvmField val LOW = of("low")

                @JvmStatic fun of(value: String) = OfferRetrievalEffort(JsonField.of(value))
            }

            /** An enum containing [OfferRetrievalEffort]'s known values. */
            enum class Known {
                MAX,
                LOW,
            }

            /**
             * An enum containing [OfferRetrievalEffort]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [OfferRetrievalEffort] can contain an unknown value in a couple of
             * cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                MAX,
                LOW,
                /**
                 * An enum member indicating that [OfferRetrievalEffort] was instantiated with an
                 * unknown value.
                 */
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
                    MAX -> Value.MAX
                    LOW -> Value.LOW
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
                    MAX -> Known.MAX
                    LOW -> Known.LOW
                    else ->
                        throw CheckoutIntentsInvalidDataException(
                            "Unknown OfferRetrievalEffort: $value"
                        )
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

            fun validate(): OfferRetrievalEffort = apply {
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

                return other is OfferRetrievalEffort && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Constraints &&
                maxShippingPrice == other.maxShippingPrice &&
                maxTotalPrice == other.maxTotalPrice &&
                offerRetrievalEffort == other.offerRetrievalEffort &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                maxShippingPrice,
                maxTotalPrice,
                offerRetrievalEffort,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Constraints{maxShippingPrice=$maxShippingPrice, maxTotalPrice=$maxTotalPrice, offerRetrievalEffort=$offerRetrievalEffort, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CheckoutIntentPurchaseParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CheckoutIntentPurchaseParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
