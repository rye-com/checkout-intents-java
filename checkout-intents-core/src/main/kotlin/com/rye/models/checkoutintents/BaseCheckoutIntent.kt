// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.Enum
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.checkKnown
import com.rye.core.checkRequired
import com.rye.core.toImmutable
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BaseCheckoutIntent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val buyer: JsonField<Buyer>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val productUrl: JsonField<String>,
    private val quantity: JsonField<Int>,
    private val constraints: JsonField<Constraints>,
    private val discoverPromoCodes: JsonField<Boolean>,
    private val promoCodes: JsonField<List<String>>,
    private val variantSelections: JsonField<List<VariantSelection>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("buyer") @ExcludeMissing buyer: JsonField<Buyer> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("productUrl")
        @ExcludeMissing
        productUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("constraints")
        @ExcludeMissing
        constraints: JsonField<Constraints> = JsonMissing.of(),
        @JsonProperty("discoverPromoCodes")
        @ExcludeMissing
        discoverPromoCodes: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("promoCodes")
        @ExcludeMissing
        promoCodes: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("variantSelections")
        @ExcludeMissing
        variantSelections: JsonField<List<VariantSelection>> = JsonMissing.of(),
    ) : this(
        id,
        buyer,
        createdAt,
        productUrl,
        quantity,
        constraints,
        discoverPromoCodes,
        promoCodes,
        variantSelections,
        mutableMapOf(),
    )

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun buyer(): Buyer = buyer.getRequired("buyer")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun productUrl(): String = productUrl.getRequired("productUrl")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quantity(): Int = quantity.getRequired("quantity")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun constraints(): Optional<Constraints> = constraints.getOptional("constraints")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun discoverPromoCodes(): Optional<Boolean> =
        discoverPromoCodes.getOptional("discoverPromoCodes")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun promoCodes(): Optional<List<String>> = promoCodes.getOptional("promoCodes")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun variantSelections(): Optional<List<VariantSelection>> =
        variantSelections.getOptional("variantSelections")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [buyer].
     *
     * Unlike [buyer], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("buyer") @ExcludeMissing fun _buyer(): JsonField<Buyer> = buyer

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [productUrl].
     *
     * Unlike [productUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("productUrl") @ExcludeMissing fun _productUrl(): JsonField<String> = productUrl

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
     * Returns the raw JSON value of [discoverPromoCodes].
     *
     * Unlike [discoverPromoCodes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("discoverPromoCodes")
    @ExcludeMissing
    fun _discoverPromoCodes(): JsonField<Boolean> = discoverPromoCodes

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
         * Returns a mutable builder for constructing an instance of [BaseCheckoutIntent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .buyer()
         * .createdAt()
         * .productUrl()
         * .quantity()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BaseCheckoutIntent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var buyer: JsonField<Buyer>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var productUrl: JsonField<String>? = null
        private var quantity: JsonField<Int>? = null
        private var constraints: JsonField<Constraints> = JsonMissing.of()
        private var discoverPromoCodes: JsonField<Boolean> = JsonMissing.of()
        private var promoCodes: JsonField<MutableList<String>>? = null
        private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(baseCheckoutIntent: BaseCheckoutIntent) = apply {
            id = baseCheckoutIntent.id
            buyer = baseCheckoutIntent.buyer
            createdAt = baseCheckoutIntent.createdAt
            productUrl = baseCheckoutIntent.productUrl
            quantity = baseCheckoutIntent.quantity
            constraints = baseCheckoutIntent.constraints
            discoverPromoCodes = baseCheckoutIntent.discoverPromoCodes
            promoCodes = baseCheckoutIntent.promoCodes.map { it.toMutableList() }
            variantSelections = baseCheckoutIntent.variantSelections.map { it.toMutableList() }
            additionalProperties = baseCheckoutIntent.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

        /**
         * Sets [Builder.buyer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun buyer(buyer: JsonField<Buyer>) = apply { this.buyer = buyer }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun productUrl(productUrl: String) = productUrl(JsonField.of(productUrl))

        /**
         * Sets [Builder.productUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.productUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun productUrl(productUrl: JsonField<String>) = apply { this.productUrl = productUrl }

        fun quantity(quantity: Int) = quantity(JsonField.of(quantity))

        /**
         * Sets [Builder.quantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quantity] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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

        fun discoverPromoCodes(discoverPromoCodes: Boolean) =
            discoverPromoCodes(JsonField.of(discoverPromoCodes))

        /**
         * Sets [Builder.discoverPromoCodes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.discoverPromoCodes] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun discoverPromoCodes(discoverPromoCodes: JsonField<Boolean>) = apply {
            this.discoverPromoCodes = discoverPromoCodes
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
         * `List<VariantSelection>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
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
         * Returns an immutable instance of [BaseCheckoutIntent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .buyer()
         * .createdAt()
         * .productUrl()
         * .quantity()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BaseCheckoutIntent =
            BaseCheckoutIntent(
                checkRequired("id", id),
                checkRequired("buyer", buyer),
                checkRequired("createdAt", createdAt),
                checkRequired("productUrl", productUrl),
                checkRequired("quantity", quantity),
                constraints,
                discoverPromoCodes,
                (promoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                (variantSelections ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BaseCheckoutIntent = apply {
        if (validated) {
            return@apply
        }

        id()
        buyer().validate()
        createdAt()
        productUrl()
        quantity()
        constraints().ifPresent { it.validate() }
        discoverPromoCodes()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (buyer.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (productUrl.asKnown().isPresent) 1 else 0) +
            (if (quantity.asKnown().isPresent) 1 else 0) +
            (constraints.asKnown().getOrNull()?.validity() ?: 0) +
            (if (discoverPromoCodes.asKnown().isPresent) 1 else 0) +
            (promoCodes.asKnown().getOrNull()?.size ?: 0) +
            (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

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

        return other is BaseCheckoutIntent &&
            id == other.id &&
            buyer == other.buyer &&
            createdAt == other.createdAt &&
            productUrl == other.productUrl &&
            quantity == other.quantity &&
            constraints == other.constraints &&
            discoverPromoCodes == other.discoverPromoCodes &&
            promoCodes == other.promoCodes &&
            variantSelections == other.variantSelections &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            buyer,
            createdAt,
            productUrl,
            quantity,
            constraints,
            discoverPromoCodes,
            promoCodes,
            variantSelections,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BaseCheckoutIntent{id=$id, buyer=$buyer, createdAt=$createdAt, productUrl=$productUrl, quantity=$quantity, constraints=$constraints, discoverPromoCodes=$discoverPromoCodes, promoCodes=$promoCodes, variantSelections=$variantSelections, additionalProperties=$additionalProperties}"
}
