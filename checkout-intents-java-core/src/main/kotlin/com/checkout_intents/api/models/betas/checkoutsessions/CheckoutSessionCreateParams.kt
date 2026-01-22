// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.betas.checkoutsessions

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
import com.checkout_intents.api.models.checkoutintents.VariantSelection
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a new checkout session.
 *
 * Checkout sessions are hosted checkout forms your shoppers can use to complete their purchases.
 */
class CheckoutSessionCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

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
     * Optional buyer information, used to pre-fill the checkout form with the buyer's information.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun buyer(): Optional<Buyer> = body.buyer()

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
     * Returns the raw JSON value of [buyer].
     *
     * Unlike [buyer], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _buyer(): JsonField<Buyer> = body._buyer()

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
         * Returns a mutable builder for constructing an instance of [CheckoutSessionCreateParams].
         *
         * The following fields are required:
         * ```java
         * .productUrl()
         * .quantity()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CheckoutSessionCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(checkoutSessionCreateParams: CheckoutSessionCreateParams) = apply {
            body = checkoutSessionCreateParams.body.toBuilder()
            additionalHeaders = checkoutSessionCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = checkoutSessionCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [productUrl]
         * - [quantity]
         * - [buyer]
         * - [constraints]
         * - [promoCodes]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

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

        /**
         * Optional buyer information, used to pre-fill the checkout form with the buyer's
         * information.
         */
        fun buyer(buyer: Buyer) = apply { body.buyer(buyer) }

        /**
         * Sets [Builder.buyer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun buyer(buyer: JsonField<Buyer>) = apply { body.buyer(buyer) }

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
         * Returns an immutable instance of [CheckoutSessionCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .productUrl()
         * .quantity()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CheckoutSessionCreateParams =
            CheckoutSessionCreateParams(
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
        private val productUrl: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val buyer: JsonField<Buyer>,
        private val constraints: JsonField<Constraints>,
        private val promoCodes: JsonField<List<String>>,
        private val variantSelections: JsonField<List<VariantSelection>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("productUrl")
            @ExcludeMissing
            productUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("buyer") @ExcludeMissing buyer: JsonField<Buyer> = JsonMissing.of(),
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
            productUrl,
            quantity,
            buyer,
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
        fun productUrl(): String = productUrl.getRequired("productUrl")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun quantity(): Int = quantity.getRequired("quantity")

        /**
         * Optional buyer information, used to pre-fill the checkout form with the buyer's
         * information.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun buyer(): Optional<Buyer> = buyer.getOptional("buyer")

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
         * Returns the raw JSON value of [buyer].
         *
         * Unlike [buyer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("buyer") @ExcludeMissing fun _buyer(): JsonField<Buyer> = buyer

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
             * .productUrl()
             * .quantity()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var productUrl: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var buyer: JsonField<Buyer> = JsonMissing.of()
            private var constraints: JsonField<Constraints> = JsonMissing.of()
            private var promoCodes: JsonField<MutableList<String>>? = null
            private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                productUrl = body.productUrl
                quantity = body.quantity
                buyer = body.buyer
                constraints = body.constraints
                promoCodes = body.promoCodes.map { it.toMutableList() }
                variantSelections = body.variantSelections.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

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

            /**
             * Optional buyer information, used to pre-fill the checkout form with the buyer's
             * information.
             */
            fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

            /**
             * Sets [Builder.buyer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun buyer(buyer: JsonField<Buyer>) = apply { this.buyer = buyer }

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
             * .productUrl()
             * .quantity()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("productUrl", productUrl),
                    checkRequired("quantity", quantity),
                    buyer,
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

            productUrl()
            quantity()
            buyer().ifPresent { it.validate() }
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
            (if (productUrl.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0) +
                (buyer.asKnown().getOrNull()?.validity() ?: 0) +
                (constraints.asKnown().getOrNull()?.validity() ?: 0) +
                (promoCodes.asKnown().getOrNull()?.size ?: 0) +
                (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                productUrl == other.productUrl &&
                quantity == other.quantity &&
                buyer == other.buyer &&
                constraints == other.constraints &&
                promoCodes == other.promoCodes &&
                variantSelections == other.variantSelections &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                productUrl,
                quantity,
                buyer,
                constraints,
                promoCodes,
                variantSelections,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{productUrl=$productUrl, quantity=$quantity, buyer=$buyer, constraints=$constraints, promoCodes=$promoCodes, variantSelections=$variantSelections, additionalProperties=$additionalProperties}"
    }

    /**
     * Optional buyer information, used to pre-fill the checkout form with the buyer's information.
     */
    class Buyer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val address1: JsonField<String>,
        private val address2: JsonField<String>,
        private val city: JsonField<String>,
        private val country: JsonField<String>,
        private val email: JsonField<String>,
        private val firstName: JsonField<String>,
        private val lastName: JsonField<String>,
        private val phone: JsonField<String>,
        private val postalCode: JsonField<String>,
        private val province: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address1")
            @ExcludeMissing
            address1: JsonField<String> = JsonMissing.of(),
            @JsonProperty("address2")
            @ExcludeMissing
            address2: JsonField<String> = JsonMissing.of(),
            @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("firstName")
            @ExcludeMissing
            firstName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lastName")
            @ExcludeMissing
            lastName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
            @JsonProperty("postalCode")
            @ExcludeMissing
            postalCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("province") @ExcludeMissing province: JsonField<String> = JsonMissing.of(),
        ) : this(
            address1,
            address2,
            city,
            country,
            email,
            firstName,
            lastName,
            phone,
            postalCode,
            province,
            mutableMapOf(),
        )

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun address1(): Optional<String> = address1.getOptional("address1")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun address2(): Optional<String> = address2.getOptional("address2")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun city(): Optional<String> = city.getOptional("city")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun firstName(): Optional<String> = firstName.getOptional("firstName")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun lastName(): Optional<String> = lastName.getOptional("lastName")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun phone(): Optional<String> = phone.getOptional("phone")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun postalCode(): Optional<String> = postalCode.getOptional("postalCode")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun province(): Optional<String> = province.getOptional("province")

        /**
         * Returns the raw JSON value of [address1].
         *
         * Unlike [address1], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address1") @ExcludeMissing fun _address1(): JsonField<String> = address1

        /**
         * Returns the raw JSON value of [address2].
         *
         * Unlike [address2], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address2") @ExcludeMissing fun _address2(): JsonField<String> = address2

        /**
         * Returns the raw JSON value of [city].
         *
         * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [firstName].
         *
         * Unlike [firstName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("firstName") @ExcludeMissing fun _firstName(): JsonField<String> = firstName

        /**
         * Returns the raw JSON value of [lastName].
         *
         * Unlike [lastName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lastName") @ExcludeMissing fun _lastName(): JsonField<String> = lastName

        /**
         * Returns the raw JSON value of [phone].
         *
         * Unlike [phone], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("phone") @ExcludeMissing fun _phone(): JsonField<String> = phone

        /**
         * Returns the raw JSON value of [postalCode].
         *
         * Unlike [postalCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postalCode")
        @ExcludeMissing
        fun _postalCode(): JsonField<String> = postalCode

        /**
         * Returns the raw JSON value of [province].
         *
         * Unlike [province], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("province") @ExcludeMissing fun _province(): JsonField<String> = province

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

            /** Returns a mutable builder for constructing an instance of [Buyer]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Buyer]. */
        class Builder internal constructor() {

            private var address1: JsonField<String> = JsonMissing.of()
            private var address2: JsonField<String> = JsonMissing.of()
            private var city: JsonField<String> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var firstName: JsonField<String> = JsonMissing.of()
            private var lastName: JsonField<String> = JsonMissing.of()
            private var phone: JsonField<String> = JsonMissing.of()
            private var postalCode: JsonField<String> = JsonMissing.of()
            private var province: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(buyer: Buyer) = apply {
                address1 = buyer.address1
                address2 = buyer.address2
                city = buyer.city
                country = buyer.country
                email = buyer.email
                firstName = buyer.firstName
                lastName = buyer.lastName
                phone = buyer.phone
                postalCode = buyer.postalCode
                province = buyer.province
                additionalProperties = buyer.additionalProperties.toMutableMap()
            }

            fun address1(address1: String) = address1(JsonField.of(address1))

            /**
             * Sets [Builder.address1] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address1] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address1(address1: JsonField<String>) = apply { this.address1 = address1 }

            fun address2(address2: String) = address2(JsonField.of(address2))

            /**
             * Sets [Builder.address2] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address2] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address2(address2: JsonField<String>) = apply { this.address2 = address2 }

            fun city(city: String) = city(JsonField.of(city))

            /**
             * Sets [Builder.city] to an arbitrary JSON value.
             *
             * You should usually call [Builder.city] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun city(city: JsonField<String>) = apply { this.city = city }

            fun country(country: String) = country(JsonField.of(country))

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            fun email(email: String) = email(JsonField.of(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            fun firstName(firstName: String) = firstName(JsonField.of(firstName))

            /**
             * Sets [Builder.firstName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.firstName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

            fun lastName(lastName: String) = lastName(JsonField.of(lastName))

            /**
             * Sets [Builder.lastName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lastName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

            fun phone(phone: String) = phone(JsonField.of(phone))

            /**
             * Sets [Builder.phone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phone] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phone(phone: JsonField<String>) = apply { this.phone = phone }

            fun postalCode(postalCode: String) = postalCode(JsonField.of(postalCode))

            /**
             * Sets [Builder.postalCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.postalCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun postalCode(postalCode: JsonField<String>) = apply { this.postalCode = postalCode }

            fun province(province: String) = province(JsonField.of(province))

            /**
             * Sets [Builder.province] to an arbitrary JSON value.
             *
             * You should usually call [Builder.province] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun province(province: JsonField<String>) = apply { this.province = province }

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
             * Returns an immutable instance of [Buyer].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Buyer =
                Buyer(
                    address1,
                    address2,
                    city,
                    country,
                    email,
                    firstName,
                    lastName,
                    phone,
                    postalCode,
                    province,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Buyer = apply {
            if (validated) {
                return@apply
            }

            address1()
            address2()
            city()
            country()
            email()
            firstName()
            lastName()
            phone()
            postalCode()
            province()
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
            (if (address1.asKnown().isPresent) 1 else 0) +
                (if (address2.asKnown().isPresent) 1 else 0) +
                (if (city.asKnown().isPresent) 1 else 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (firstName.asKnown().isPresent) 1 else 0) +
                (if (lastName.asKnown().isPresent) 1 else 0) +
                (if (phone.asKnown().isPresent) 1 else 0) +
                (if (postalCode.asKnown().isPresent) 1 else 0) +
                (if (province.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Buyer &&
                address1 == other.address1 &&
                address2 == other.address2 &&
                city == other.city &&
                country == other.country &&
                email == other.email &&
                firstName == other.firstName &&
                lastName == other.lastName &&
                phone == other.phone &&
                postalCode == other.postalCode &&
                province == other.province &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                address1,
                address2,
                city,
                country,
                email,
                firstName,
                lastName,
                phone,
                postalCode,
                province,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Buyer{address1=$address1, address2=$address2, city=$city, country=$country, email=$email, firstName=$firstName, lastName=$lastName, phone=$phone, postalCode=$postalCode, province=$province, additionalProperties=$additionalProperties}"
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

        return other is CheckoutSessionCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CheckoutSessionCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
