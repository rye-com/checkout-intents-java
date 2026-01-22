// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import com.checkout_intents.api.core.ExcludeMissing
import com.checkout_intents.api.core.JsonField
import com.checkout_intents.api.core.JsonMissing
import com.checkout_intents.api.core.JsonValue
import com.checkout_intents.api.core.checkKnown
import com.checkout_intents.api.core.checkRequired
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

class Offer
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val cost: JsonField<Cost>,
    private val shipping: JsonField<Shipping>,
    private val appliedPromoCodes: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cost") @ExcludeMissing cost: JsonField<Cost> = JsonMissing.of(),
        @JsonProperty("shipping") @ExcludeMissing shipping: JsonField<Shipping> = JsonMissing.of(),
        @JsonProperty("appliedPromoCodes")
        @ExcludeMissing
        appliedPromoCodes: JsonField<List<String>> = JsonMissing.of(),
    ) : this(cost, shipping, appliedPromoCodes, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cost(): Cost = cost.getRequired("cost")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun shipping(): Shipping = shipping.getRequired("shipping")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun appliedPromoCodes(): Optional<List<String>> =
        appliedPromoCodes.getOptional("appliedPromoCodes")

    /**
     * Returns the raw JSON value of [cost].
     *
     * Unlike [cost], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cost") @ExcludeMissing fun _cost(): JsonField<Cost> = cost

    /**
     * Returns the raw JSON value of [shipping].
     *
     * Unlike [shipping], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("shipping") @ExcludeMissing fun _shipping(): JsonField<Shipping> = shipping

    /**
     * Returns the raw JSON value of [appliedPromoCodes].
     *
     * Unlike [appliedPromoCodes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("appliedPromoCodes")
    @ExcludeMissing
    fun _appliedPromoCodes(): JsonField<List<String>> = appliedPromoCodes

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
         * Returns a mutable builder for constructing an instance of [Offer].
         *
         * The following fields are required:
         * ```java
         * .cost()
         * .shipping()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Offer]. */
    class Builder internal constructor() {

        private var cost: JsonField<Cost>? = null
        private var shipping: JsonField<Shipping>? = null
        private var appliedPromoCodes: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(offer: Offer) = apply {
            cost = offer.cost
            shipping = offer.shipping
            appliedPromoCodes = offer.appliedPromoCodes.map { it.toMutableList() }
            additionalProperties = offer.additionalProperties.toMutableMap()
        }

        fun cost(cost: Cost) = cost(JsonField.of(cost))

        /**
         * Sets [Builder.cost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cost] with a well-typed [Cost] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cost(cost: JsonField<Cost>) = apply { this.cost = cost }

        fun shipping(shipping: Shipping) = shipping(JsonField.of(shipping))

        /**
         * Sets [Builder.shipping] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shipping] with a well-typed [Shipping] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun shipping(shipping: JsonField<Shipping>) = apply { this.shipping = shipping }

        fun appliedPromoCodes(appliedPromoCodes: List<String>) =
            appliedPromoCodes(JsonField.of(appliedPromoCodes))

        /**
         * Sets [Builder.appliedPromoCodes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.appliedPromoCodes] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun appliedPromoCodes(appliedPromoCodes: JsonField<List<String>>) = apply {
            this.appliedPromoCodes = appliedPromoCodes.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [appliedPromoCodes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAppliedPromoCode(appliedPromoCode: String) = apply {
            appliedPromoCodes =
                (appliedPromoCodes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("appliedPromoCodes", it).add(appliedPromoCode)
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
         * Returns an immutable instance of [Offer].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .cost()
         * .shipping()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Offer =
            Offer(
                checkRequired("cost", cost),
                checkRequired("shipping", shipping),
                (appliedPromoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Offer = apply {
        if (validated) {
            return@apply
        }

        cost().validate()
        shipping().validate()
        appliedPromoCodes()
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
        (cost.asKnown().getOrNull()?.validity() ?: 0) +
            (shipping.asKnown().getOrNull()?.validity() ?: 0) +
            (appliedPromoCodes.asKnown().getOrNull()?.size ?: 0)

    class Cost
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val subtotal: JsonField<Money>,
        private val total: JsonField<Money>,
        private val discount: JsonField<Money>,
        private val shipping: JsonField<Money>,
        private val surcharge: JsonField<Money>,
        private val tax: JsonField<Money>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("subtotal") @ExcludeMissing subtotal: JsonField<Money> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Money> = JsonMissing.of(),
            @JsonProperty("discount") @ExcludeMissing discount: JsonField<Money> = JsonMissing.of(),
            @JsonProperty("shipping") @ExcludeMissing shipping: JsonField<Money> = JsonMissing.of(),
            @JsonProperty("surcharge")
            @ExcludeMissing
            surcharge: JsonField<Money> = JsonMissing.of(),
            @JsonProperty("tax") @ExcludeMissing tax: JsonField<Money> = JsonMissing.of(),
        ) : this(subtotal, total, discount, shipping, surcharge, tax, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun subtotal(): Money = subtotal.getRequired("subtotal")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun total(): Money = total.getRequired("total")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun discount(): Optional<Money> = discount.getOptional("discount")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun shipping(): Optional<Money> = shipping.getOptional("shipping")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun surcharge(): Optional<Money> = surcharge.getOptional("surcharge")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun tax(): Optional<Money> = tax.getOptional("tax")

        /**
         * Returns the raw JSON value of [subtotal].
         *
         * Unlike [subtotal], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subtotal") @ExcludeMissing fun _subtotal(): JsonField<Money> = subtotal

        /**
         * Returns the raw JSON value of [total].
         *
         * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Money> = total

        /**
         * Returns the raw JSON value of [discount].
         *
         * Unlike [discount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("discount") @ExcludeMissing fun _discount(): JsonField<Money> = discount

        /**
         * Returns the raw JSON value of [shipping].
         *
         * Unlike [shipping], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shipping") @ExcludeMissing fun _shipping(): JsonField<Money> = shipping

        /**
         * Returns the raw JSON value of [surcharge].
         *
         * Unlike [surcharge], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("surcharge") @ExcludeMissing fun _surcharge(): JsonField<Money> = surcharge

        /**
         * Returns the raw JSON value of [tax].
         *
         * Unlike [tax], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tax") @ExcludeMissing fun _tax(): JsonField<Money> = tax

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
             * Returns a mutable builder for constructing an instance of [Cost].
             *
             * The following fields are required:
             * ```java
             * .subtotal()
             * .total()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Cost]. */
        class Builder internal constructor() {

            private var subtotal: JsonField<Money>? = null
            private var total: JsonField<Money>? = null
            private var discount: JsonField<Money> = JsonMissing.of()
            private var shipping: JsonField<Money> = JsonMissing.of()
            private var surcharge: JsonField<Money> = JsonMissing.of()
            private var tax: JsonField<Money> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cost: Cost) = apply {
                subtotal = cost.subtotal
                total = cost.total
                discount = cost.discount
                shipping = cost.shipping
                surcharge = cost.surcharge
                tax = cost.tax
                additionalProperties = cost.additionalProperties.toMutableMap()
            }

            fun subtotal(subtotal: Money) = subtotal(JsonField.of(subtotal))

            /**
             * Sets [Builder.subtotal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subtotal] with a well-typed [Money] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subtotal(subtotal: JsonField<Money>) = apply { this.subtotal = subtotal }

            fun total(total: Money) = total(JsonField.of(total))

            /**
             * Sets [Builder.total] to an arbitrary JSON value.
             *
             * You should usually call [Builder.total] with a well-typed [Money] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun total(total: JsonField<Money>) = apply { this.total = total }

            fun discount(discount: Money) = discount(JsonField.of(discount))

            /**
             * Sets [Builder.discount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.discount] with a well-typed [Money] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun discount(discount: JsonField<Money>) = apply { this.discount = discount }

            fun shipping(shipping: Money) = shipping(JsonField.of(shipping))

            /**
             * Sets [Builder.shipping] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shipping] with a well-typed [Money] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shipping(shipping: JsonField<Money>) = apply { this.shipping = shipping }

            fun surcharge(surcharge: Money) = surcharge(JsonField.of(surcharge))

            /**
             * Sets [Builder.surcharge] to an arbitrary JSON value.
             *
             * You should usually call [Builder.surcharge] with a well-typed [Money] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun surcharge(surcharge: JsonField<Money>) = apply { this.surcharge = surcharge }

            fun tax(tax: Money) = tax(JsonField.of(tax))

            /**
             * Sets [Builder.tax] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tax] with a well-typed [Money] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun tax(tax: JsonField<Money>) = apply { this.tax = tax }

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
             * Returns an immutable instance of [Cost].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .subtotal()
             * .total()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Cost =
                Cost(
                    checkRequired("subtotal", subtotal),
                    checkRequired("total", total),
                    discount,
                    shipping,
                    surcharge,
                    tax,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Cost = apply {
            if (validated) {
                return@apply
            }

            subtotal().validate()
            total().validate()
            discount().ifPresent { it.validate() }
            shipping().ifPresent { it.validate() }
            surcharge().ifPresent { it.validate() }
            tax().ifPresent { it.validate() }
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
            (subtotal.asKnown().getOrNull()?.validity() ?: 0) +
                (total.asKnown().getOrNull()?.validity() ?: 0) +
                (discount.asKnown().getOrNull()?.validity() ?: 0) +
                (shipping.asKnown().getOrNull()?.validity() ?: 0) +
                (surcharge.asKnown().getOrNull()?.validity() ?: 0) +
                (tax.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Cost &&
                subtotal == other.subtotal &&
                total == other.total &&
                discount == other.discount &&
                shipping == other.shipping &&
                surcharge == other.surcharge &&
                tax == other.tax &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(subtotal, total, discount, shipping, surcharge, tax, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Cost{subtotal=$subtotal, total=$total, discount=$discount, shipping=$shipping, surcharge=$surcharge, tax=$tax, additionalProperties=$additionalProperties}"
    }

    class Shipping
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val availableOptions: JsonField<List<AvailableOption>>,
        private val selectedOptionId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("availableOptions")
            @ExcludeMissing
            availableOptions: JsonField<List<AvailableOption>> = JsonMissing.of(),
            @JsonProperty("selectedOptionId")
            @ExcludeMissing
            selectedOptionId: JsonField<String> = JsonMissing.of(),
        ) : this(availableOptions, selectedOptionId, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun availableOptions(): List<AvailableOption> =
            availableOptions.getRequired("availableOptions")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun selectedOptionId(): Optional<String> = selectedOptionId.getOptional("selectedOptionId")

        /**
         * Returns the raw JSON value of [availableOptions].
         *
         * Unlike [availableOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("availableOptions")
        @ExcludeMissing
        fun _availableOptions(): JsonField<List<AvailableOption>> = availableOptions

        /**
         * Returns the raw JSON value of [selectedOptionId].
         *
         * Unlike [selectedOptionId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("selectedOptionId")
        @ExcludeMissing
        fun _selectedOptionId(): JsonField<String> = selectedOptionId

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
             * Returns a mutable builder for constructing an instance of [Shipping].
             *
             * The following fields are required:
             * ```java
             * .availableOptions()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Shipping]. */
        class Builder internal constructor() {

            private var availableOptions: JsonField<MutableList<AvailableOption>>? = null
            private var selectedOptionId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(shipping: Shipping) = apply {
                availableOptions = shipping.availableOptions.map { it.toMutableList() }
                selectedOptionId = shipping.selectedOptionId
                additionalProperties = shipping.additionalProperties.toMutableMap()
            }

            fun availableOptions(availableOptions: List<AvailableOption>) =
                availableOptions(JsonField.of(availableOptions))

            /**
             * Sets [Builder.availableOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.availableOptions] with a well-typed
             * `List<AvailableOption>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun availableOptions(availableOptions: JsonField<List<AvailableOption>>) = apply {
                this.availableOptions = availableOptions.map { it.toMutableList() }
            }

            /**
             * Adds a single [AvailableOption] to [availableOptions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAvailableOption(availableOption: AvailableOption) = apply {
                availableOptions =
                    (availableOptions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("availableOptions", it).add(availableOption)
                    }
            }

            fun selectedOptionId(selectedOptionId: String) =
                selectedOptionId(JsonField.of(selectedOptionId))

            /**
             * Sets [Builder.selectedOptionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.selectedOptionId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun selectedOptionId(selectedOptionId: JsonField<String>) = apply {
                this.selectedOptionId = selectedOptionId
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
             * Returns an immutable instance of [Shipping].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .availableOptions()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Shipping =
                Shipping(
                    checkRequired("availableOptions", availableOptions).map { it.toImmutable() },
                    selectedOptionId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Shipping = apply {
            if (validated) {
                return@apply
            }

            availableOptions().forEach { it.validate() }
            selectedOptionId()
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
            (availableOptions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (selectedOptionId.asKnown().isPresent) 1 else 0)

        class AvailableOption
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val cost: JsonField<Money>,
            private val discount: JsonField<Money>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("cost") @ExcludeMissing cost: JsonField<Money> = JsonMissing.of(),
                @JsonProperty("discount")
                @ExcludeMissing
                discount: JsonField<Money> = JsonMissing.of(),
            ) : this(id, cost, discount, mutableMapOf())

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cost(): Money = cost.getRequired("cost")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun discount(): Optional<Money> = discount.getOptional("discount")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [cost].
             *
             * Unlike [cost], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cost") @ExcludeMissing fun _cost(): JsonField<Money> = cost

            /**
             * Returns the raw JSON value of [discount].
             *
             * Unlike [discount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("discount") @ExcludeMissing fun _discount(): JsonField<Money> = discount

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
                 * Returns a mutable builder for constructing an instance of [AvailableOption].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .cost()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AvailableOption]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var cost: JsonField<Money>? = null
                private var discount: JsonField<Money> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(availableOption: AvailableOption) = apply {
                    id = availableOption.id
                    cost = availableOption.cost
                    discount = availableOption.discount
                    additionalProperties = availableOption.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun cost(cost: Money) = cost(JsonField.of(cost))

                /**
                 * Sets [Builder.cost] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cost] with a well-typed [Money] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun cost(cost: JsonField<Money>) = apply { this.cost = cost }

                fun discount(discount: Money) = discount(JsonField.of(discount))

                /**
                 * Sets [Builder.discount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.discount] with a well-typed [Money] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun discount(discount: JsonField<Money>) = apply { this.discount = discount }

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
                 * Returns an immutable instance of [AvailableOption].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .cost()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): AvailableOption =
                    AvailableOption(
                        checkRequired("id", id),
                        checkRequired("cost", cost),
                        discount,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): AvailableOption = apply {
                if (validated) {
                    return@apply
                }

                id()
                cost().validate()
                discount().ifPresent { it.validate() }
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (cost.asKnown().getOrNull()?.validity() ?: 0) +
                    (discount.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AvailableOption &&
                    id == other.id &&
                    cost == other.cost &&
                    discount == other.discount &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, cost, discount, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AvailableOption{id=$id, cost=$cost, discount=$discount, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Shipping &&
                availableOptions == other.availableOptions &&
                selectedOptionId == other.selectedOptionId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(availableOptions, selectedOptionId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Shipping{availableOptions=$availableOptions, selectedOptionId=$selectedOptionId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Offer &&
            cost == other.cost &&
            shipping == other.shipping &&
            appliedPromoCodes == other.appliedPromoCodes &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(cost, shipping, appliedPromoCodes, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Offer{cost=$cost, shipping=$shipping, appliedPromoCodes=$appliedPromoCodes, additionalProperties=$additionalProperties}"
}
