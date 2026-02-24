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
import com.rye.core.checkKnown
import com.rye.core.checkRequired
import com.rye.core.getOrThrow
import com.rye.core.toImmutable
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = CheckoutIntent.Deserializer::class)
@JsonSerialize(using = CheckoutIntent.Serializer::class)
class CheckoutIntent
private constructor(
    private val retrievingOffer: RetrievingOfferCheckoutIntent? = null,
    private val awaitingConfirmation: AwaitingConfirmationCheckoutIntent? = null,
    private val placingOrder: PlacingOrderCheckoutIntent? = null,
    private val completed: CompletedCheckoutIntent? = null,
    private val failed: FailedCheckoutIntent? = null,
    private val _json: JsonValue? = null,
) {

    fun retrievingOffer(): Optional<RetrievingOfferCheckoutIntent> =
        Optional.ofNullable(retrievingOffer)

    fun awaitingConfirmation(): Optional<AwaitingConfirmationCheckoutIntent> =
        Optional.ofNullable(awaitingConfirmation)

    fun placingOrder(): Optional<PlacingOrderCheckoutIntent> = Optional.ofNullable(placingOrder)

    fun completed(): Optional<CompletedCheckoutIntent> = Optional.ofNullable(completed)

    fun failed(): Optional<FailedCheckoutIntent> = Optional.ofNullable(failed)

    fun isRetrievingOffer(): Boolean = retrievingOffer != null

    fun isAwaitingConfirmation(): Boolean = awaitingConfirmation != null

    fun isPlacingOrder(): Boolean = placingOrder != null

    fun isCompleted(): Boolean = completed != null

    fun isFailed(): Boolean = failed != null

    fun asRetrievingOffer(): RetrievingOfferCheckoutIntent =
        retrievingOffer.getOrThrow("retrievingOffer")

    fun asAwaitingConfirmation(): AwaitingConfirmationCheckoutIntent =
        awaitingConfirmation.getOrThrow("awaitingConfirmation")

    fun asPlacingOrder(): PlacingOrderCheckoutIntent = placingOrder.getOrThrow("placingOrder")

    fun asCompleted(): CompletedCheckoutIntent = completed.getOrThrow("completed")

    fun asFailed(): FailedCheckoutIntent = failed.getOrThrow("failed")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            retrievingOffer != null -> visitor.visitRetrievingOffer(retrievingOffer)
            awaitingConfirmation != null -> visitor.visitAwaitingConfirmation(awaitingConfirmation)
            placingOrder != null -> visitor.visitPlacingOrder(placingOrder)
            completed != null -> visitor.visitCompleted(completed)
            failed != null -> visitor.visitFailed(failed)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): CheckoutIntent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitRetrievingOffer(retrievingOffer: RetrievingOfferCheckoutIntent) {
                    retrievingOffer.validate()
                }

                override fun visitAwaitingConfirmation(
                    awaitingConfirmation: AwaitingConfirmationCheckoutIntent
                ) {
                    awaitingConfirmation.validate()
                }

                override fun visitPlacingOrder(placingOrder: PlacingOrderCheckoutIntent) {
                    placingOrder.validate()
                }

                override fun visitCompleted(completed: CompletedCheckoutIntent) {
                    completed.validate()
                }

                override fun visitFailed(failed: FailedCheckoutIntent) {
                    failed.validate()
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
                override fun visitRetrievingOffer(retrievingOffer: RetrievingOfferCheckoutIntent) =
                    retrievingOffer.validity()

                override fun visitAwaitingConfirmation(
                    awaitingConfirmation: AwaitingConfirmationCheckoutIntent
                ) = awaitingConfirmation.validity()

                override fun visitPlacingOrder(placingOrder: PlacingOrderCheckoutIntent) =
                    placingOrder.validity()

                override fun visitCompleted(completed: CompletedCheckoutIntent) =
                    completed.validity()

                override fun visitFailed(failed: FailedCheckoutIntent) = failed.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CheckoutIntent &&
            retrievingOffer == other.retrievingOffer &&
            awaitingConfirmation == other.awaitingConfirmation &&
            placingOrder == other.placingOrder &&
            completed == other.completed &&
            failed == other.failed
    }

    override fun hashCode(): Int =
        Objects.hash(retrievingOffer, awaitingConfirmation, placingOrder, completed, failed)

    override fun toString(): String =
        when {
            retrievingOffer != null -> "CheckoutIntent{retrievingOffer=$retrievingOffer}"
            awaitingConfirmation != null ->
                "CheckoutIntent{awaitingConfirmation=$awaitingConfirmation}"
            placingOrder != null -> "CheckoutIntent{placingOrder=$placingOrder}"
            completed != null -> "CheckoutIntent{completed=$completed}"
            failed != null -> "CheckoutIntent{failed=$failed}"
            _json != null -> "CheckoutIntent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid CheckoutIntent")
        }

    companion object {

        @JvmStatic
        fun ofRetrievingOffer(retrievingOffer: RetrievingOfferCheckoutIntent) =
            CheckoutIntent(retrievingOffer = retrievingOffer)

        @JvmStatic
        fun ofAwaitingConfirmation(awaitingConfirmation: AwaitingConfirmationCheckoutIntent) =
            CheckoutIntent(awaitingConfirmation = awaitingConfirmation)

        @JvmStatic
        fun ofPlacingOrder(placingOrder: PlacingOrderCheckoutIntent) =
            CheckoutIntent(placingOrder = placingOrder)

        @JvmStatic
        fun ofCompleted(completed: CompletedCheckoutIntent) = CheckoutIntent(completed = completed)

        @JvmStatic fun ofFailed(failed: FailedCheckoutIntent) = CheckoutIntent(failed = failed)
    }

    /**
     * An interface that defines how to map each variant of [CheckoutIntent] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitRetrievingOffer(retrievingOffer: RetrievingOfferCheckoutIntent): T

        fun visitAwaitingConfirmation(awaitingConfirmation: AwaitingConfirmationCheckoutIntent): T

        fun visitPlacingOrder(placingOrder: PlacingOrderCheckoutIntent): T

        fun visitCompleted(completed: CompletedCheckoutIntent): T

        fun visitFailed(failed: FailedCheckoutIntent): T

        /**
         * Maps an unknown variant of [CheckoutIntent] to a value of type [T].
         *
         * An instance of [CheckoutIntent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws CheckoutIntentsInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw CheckoutIntentsInvalidDataException("Unknown CheckoutIntent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<CheckoutIntent>(CheckoutIntent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): CheckoutIntent {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<RetrievingOfferCheckoutIntent>())?.let {
                            CheckoutIntent(retrievingOffer = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<AwaitingConfirmationCheckoutIntent>())
                            ?.let { CheckoutIntent(awaitingConfirmation = it, _json = json) },
                        tryDeserialize(node, jacksonTypeRef<PlacingOrderCheckoutIntent>())?.let {
                            CheckoutIntent(placingOrder = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<CompletedCheckoutIntent>())?.let {
                            CheckoutIntent(completed = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<FailedCheckoutIntent>())?.let {
                            CheckoutIntent(failed = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> CheckoutIntent(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<CheckoutIntent>(CheckoutIntent::class) {

        override fun serialize(
            value: CheckoutIntent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.retrievingOffer != null -> generator.writeObject(value.retrievingOffer)
                value.awaitingConfirmation != null ->
                    generator.writeObject(value.awaitingConfirmation)
                value.placingOrder != null -> generator.writeObject(value.placingOrder)
                value.completed != null -> generator.writeObject(value.completed)
                value.failed != null -> generator.writeObject(value.failed)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid CheckoutIntent")
            }
        }
    }

    class RetrievingOfferCheckoutIntent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val buyer: JsonField<Buyer>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val productUrl: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val constraints: JsonField<BaseCheckoutIntent.Constraints>,
        private val discoverPromoCodes: JsonField<Boolean>,
        private val promoCodes: JsonField<List<String>>,
        private val variantSelections: JsonField<List<VariantSelection>>,
        private val state: JsonField<State>,
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
            constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of(),
            @JsonProperty("discoverPromoCodes")
            @ExcludeMissing
            discoverPromoCodes: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("promoCodes")
            @ExcludeMissing
            promoCodes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("variantSelections")
            @ExcludeMissing
            variantSelections: JsonField<List<VariantSelection>> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
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
            state,
            mutableMapOf(),
        )

        fun toBaseCheckoutIntent(): BaseCheckoutIntent =
            BaseCheckoutIntent.builder()
                .id(id)
                .buyer(buyer)
                .createdAt(createdAt)
                .productUrl(productUrl)
                .quantity(quantity)
                .constraints(constraints)
                .discoverPromoCodes(discoverPromoCodes)
                .promoCodes(promoCodes)
                .variantSelections(variantSelections)
                .build()

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

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
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

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
        fun constraints(): Optional<BaseCheckoutIntent.Constraints> =
            constraints.getOptional("constraints")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun discoverPromoCodes(): Optional<Boolean> =
            discoverPromoCodes.getOptional("discoverPromoCodes")

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
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun state(): State = state.getRequired("state")

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
        fun _constraints(): JsonField<BaseCheckoutIntent.Constraints> = constraints

        /**
         * Returns the raw JSON value of [discoverPromoCodes].
         *
         * Unlike [discoverPromoCodes], this method doesn't throw if the JSON field has an
         * unexpected type.
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

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<State> = state

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
             * Returns a mutable builder for constructing an instance of
             * [RetrievingOfferCheckoutIntent].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .buyer()
             * .createdAt()
             * .productUrl()
             * .quantity()
             * .state()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RetrievingOfferCheckoutIntent]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var buyer: JsonField<Buyer>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var productUrl: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of()
            private var discoverPromoCodes: JsonField<Boolean> = JsonMissing.of()
            private var promoCodes: JsonField<MutableList<String>>? = null
            private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
            private var state: JsonField<State>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(retrievingOfferCheckoutIntent: RetrievingOfferCheckoutIntent) =
                apply {
                    id = retrievingOfferCheckoutIntent.id
                    buyer = retrievingOfferCheckoutIntent.buyer
                    createdAt = retrievingOfferCheckoutIntent.createdAt
                    productUrl = retrievingOfferCheckoutIntent.productUrl
                    quantity = retrievingOfferCheckoutIntent.quantity
                    constraints = retrievingOfferCheckoutIntent.constraints
                    discoverPromoCodes = retrievingOfferCheckoutIntent.discoverPromoCodes
                    promoCodes = retrievingOfferCheckoutIntent.promoCodes.map { it.toMutableList() }
                    variantSelections =
                        retrievingOfferCheckoutIntent.variantSelections.map { it.toMutableList() }
                    state = retrievingOfferCheckoutIntent.state
                    additionalProperties =
                        retrievingOfferCheckoutIntent.additionalProperties.toMutableMap()
                }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

            /**
             * Sets [Builder.buyer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
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

            fun constraints(constraints: BaseCheckoutIntent.Constraints) =
                constraints(JsonField.of(constraints))

            /**
             * Sets [Builder.constraints] to an arbitrary JSON value.
             *
             * You should usually call [Builder.constraints] with a well-typed
             * [BaseCheckoutIntent.Constraints] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun constraints(constraints: JsonField<BaseCheckoutIntent.Constraints>) = apply {
                this.constraints = constraints
            }

            fun discoverPromoCodes(discoverPromoCodes: Boolean) =
                discoverPromoCodes(JsonField.of(discoverPromoCodes))

            /**
             * Sets [Builder.discoverPromoCodes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.discoverPromoCodes] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            fun state(state: State) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [State] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun state(state: JsonField<State>) = apply { this.state = state }

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
             * Returns an immutable instance of [RetrievingOfferCheckoutIntent].
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
             * .state()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): RetrievingOfferCheckoutIntent =
                RetrievingOfferCheckoutIntent(
                    checkRequired("id", id),
                    checkRequired("buyer", buyer),
                    checkRequired("createdAt", createdAt),
                    checkRequired("productUrl", productUrl),
                    checkRequired("quantity", quantity),
                    constraints,
                    discoverPromoCodes,
                    (promoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                    (variantSelections ?: JsonMissing.of()).map { it.toImmutable() },
                    checkRequired("state", state),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): RetrievingOfferCheckoutIntent = apply {
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
            state().validate()
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
                (buyer.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (productUrl.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0) +
                (constraints.asKnown().getOrNull()?.validity() ?: 0) +
                (if (discoverPromoCodes.asKnown().isPresent) 1 else 0) +
                (promoCodes.asKnown().getOrNull()?.size ?: 0) +
                (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (state.asKnown().getOrNull()?.validity() ?: 0)

        class State @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val RETRIEVING_OFFER = of("retrieving_offer")

                @JvmStatic fun of(value: String) = State(JsonField.of(value))
            }

            /** An enum containing [State]'s known values. */
            enum class Known {
                RETRIEVING_OFFER
            }

            /**
             * An enum containing [State]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [State] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                RETRIEVING_OFFER,
                /**
                 * An enum member indicating that [State] was instantiated with an unknown value.
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
                    RETRIEVING_OFFER -> Value.RETRIEVING_OFFER
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
                    RETRIEVING_OFFER -> Known.RETRIEVING_OFFER
                    else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

            fun validate(): State = apply {
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

                return other is State && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RetrievingOfferCheckoutIntent &&
                id == other.id &&
                buyer == other.buyer &&
                createdAt == other.createdAt &&
                productUrl == other.productUrl &&
                quantity == other.quantity &&
                constraints == other.constraints &&
                discoverPromoCodes == other.discoverPromoCodes &&
                promoCodes == other.promoCodes &&
                variantSelections == other.variantSelections &&
                state == other.state &&
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
                state,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RetrievingOfferCheckoutIntent{id=$id, buyer=$buyer, createdAt=$createdAt, productUrl=$productUrl, quantity=$quantity, constraints=$constraints, discoverPromoCodes=$discoverPromoCodes, promoCodes=$promoCodes, variantSelections=$variantSelections, state=$state, additionalProperties=$additionalProperties}"
    }

    class AwaitingConfirmationCheckoutIntent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val buyer: JsonField<Buyer>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val productUrl: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val constraints: JsonField<BaseCheckoutIntent.Constraints>,
        private val discoverPromoCodes: JsonField<Boolean>,
        private val promoCodes: JsonField<List<String>>,
        private val variantSelections: JsonField<List<VariantSelection>>,
        private val offer: JsonField<Offer>,
        private val state: JsonField<State>,
        private val paymentMethod: JsonField<PaymentMethod>,
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
            constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of(),
            @JsonProperty("discoverPromoCodes")
            @ExcludeMissing
            discoverPromoCodes: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("promoCodes")
            @ExcludeMissing
            promoCodes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("variantSelections")
            @ExcludeMissing
            variantSelections: JsonField<List<VariantSelection>> = JsonMissing.of(),
            @JsonProperty("offer") @ExcludeMissing offer: JsonField<Offer> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
            @JsonProperty("paymentMethod")
            @ExcludeMissing
            paymentMethod: JsonField<PaymentMethod> = JsonMissing.of(),
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
            offer,
            state,
            paymentMethod,
            mutableMapOf(),
        )

        fun toBaseCheckoutIntent(): BaseCheckoutIntent =
            BaseCheckoutIntent.builder()
                .id(id)
                .buyer(buyer)
                .createdAt(createdAt)
                .productUrl(productUrl)
                .quantity(quantity)
                .constraints(constraints)
                .discoverPromoCodes(discoverPromoCodes)
                .promoCodes(promoCodes)
                .variantSelections(variantSelections)
                .build()

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

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
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

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
        fun constraints(): Optional<BaseCheckoutIntent.Constraints> =
            constraints.getOptional("constraints")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun discoverPromoCodes(): Optional<Boolean> =
            discoverPromoCodes.getOptional("discoverPromoCodes")

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
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun offer(): Offer = offer.getRequired("offer")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun state(): State = state.getRequired("state")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun paymentMethod(): Optional<PaymentMethod> = paymentMethod.getOptional("paymentMethod")

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
        fun _constraints(): JsonField<BaseCheckoutIntent.Constraints> = constraints

        /**
         * Returns the raw JSON value of [discoverPromoCodes].
         *
         * Unlike [discoverPromoCodes], this method doesn't throw if the JSON field has an
         * unexpected type.
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

        /**
         * Returns the raw JSON value of [offer].
         *
         * Unlike [offer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("offer") @ExcludeMissing fun _offer(): JsonField<Offer> = offer

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<State> = state

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
             * Returns a mutable builder for constructing an instance of
             * [AwaitingConfirmationCheckoutIntent].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .buyer()
             * .createdAt()
             * .productUrl()
             * .quantity()
             * .offer()
             * .state()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AwaitingConfirmationCheckoutIntent]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var buyer: JsonField<Buyer>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var productUrl: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of()
            private var discoverPromoCodes: JsonField<Boolean> = JsonMissing.of()
            private var promoCodes: JsonField<MutableList<String>>? = null
            private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
            private var offer: JsonField<Offer>? = null
            private var state: JsonField<State>? = null
            private var paymentMethod: JsonField<PaymentMethod> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                awaitingConfirmationCheckoutIntent: AwaitingConfirmationCheckoutIntent
            ) = apply {
                id = awaitingConfirmationCheckoutIntent.id
                buyer = awaitingConfirmationCheckoutIntent.buyer
                createdAt = awaitingConfirmationCheckoutIntent.createdAt
                productUrl = awaitingConfirmationCheckoutIntent.productUrl
                quantity = awaitingConfirmationCheckoutIntent.quantity
                constraints = awaitingConfirmationCheckoutIntent.constraints
                discoverPromoCodes = awaitingConfirmationCheckoutIntent.discoverPromoCodes
                promoCodes =
                    awaitingConfirmationCheckoutIntent.promoCodes.map { it.toMutableList() }
                variantSelections =
                    awaitingConfirmationCheckoutIntent.variantSelections.map { it.toMutableList() }
                offer = awaitingConfirmationCheckoutIntent.offer
                state = awaitingConfirmationCheckoutIntent.state
                paymentMethod = awaitingConfirmationCheckoutIntent.paymentMethod
                additionalProperties =
                    awaitingConfirmationCheckoutIntent.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

            /**
             * Sets [Builder.buyer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
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

            fun constraints(constraints: BaseCheckoutIntent.Constraints) =
                constraints(JsonField.of(constraints))

            /**
             * Sets [Builder.constraints] to an arbitrary JSON value.
             *
             * You should usually call [Builder.constraints] with a well-typed
             * [BaseCheckoutIntent.Constraints] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun constraints(constraints: JsonField<BaseCheckoutIntent.Constraints>) = apply {
                this.constraints = constraints
            }

            fun discoverPromoCodes(discoverPromoCodes: Boolean) =
                discoverPromoCodes(JsonField.of(discoverPromoCodes))

            /**
             * Sets [Builder.discoverPromoCodes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.discoverPromoCodes] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            fun offer(offer: Offer) = offer(JsonField.of(offer))

            /**
             * Sets [Builder.offer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.offer] with a well-typed [Offer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun offer(offer: JsonField<Offer>) = apply { this.offer = offer }

            fun state(state: State) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [State] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun state(state: JsonField<State>) = apply { this.state = state }

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

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofPrava(prava)`. */
            fun paymentMethod(prava: PaymentMethod.PravaPaymentMethod) =
                paymentMethod(PaymentMethod.ofPrava(prava))

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
             * Returns an immutable instance of [AwaitingConfirmationCheckoutIntent].
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
             * .offer()
             * .state()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AwaitingConfirmationCheckoutIntent =
                AwaitingConfirmationCheckoutIntent(
                    checkRequired("id", id),
                    checkRequired("buyer", buyer),
                    checkRequired("createdAt", createdAt),
                    checkRequired("productUrl", productUrl),
                    checkRequired("quantity", quantity),
                    constraints,
                    discoverPromoCodes,
                    (promoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                    (variantSelections ?: JsonMissing.of()).map { it.toImmutable() },
                    checkRequired("offer", offer),
                    checkRequired("state", state),
                    paymentMethod,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AwaitingConfirmationCheckoutIntent = apply {
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
            offer().validate()
            state().validate()
            paymentMethod().ifPresent { it.validate() }
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
                (buyer.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (productUrl.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0) +
                (constraints.asKnown().getOrNull()?.validity() ?: 0) +
                (if (discoverPromoCodes.asKnown().isPresent) 1 else 0) +
                (promoCodes.asKnown().getOrNull()?.size ?: 0) +
                (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (offer.asKnown().getOrNull()?.validity() ?: 0) +
                (state.asKnown().getOrNull()?.validity() ?: 0) +
                (paymentMethod.asKnown().getOrNull()?.validity() ?: 0)

        class State @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val AWAITING_CONFIRMATION = of("awaiting_confirmation")

                @JvmStatic fun of(value: String) = State(JsonField.of(value))
            }

            /** An enum containing [State]'s known values. */
            enum class Known {
                AWAITING_CONFIRMATION
            }

            /**
             * An enum containing [State]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [State] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AWAITING_CONFIRMATION,
                /**
                 * An enum member indicating that [State] was instantiated with an unknown value.
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
                    AWAITING_CONFIRMATION -> Value.AWAITING_CONFIRMATION
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
                    AWAITING_CONFIRMATION -> Known.AWAITING_CONFIRMATION
                    else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

            fun validate(): State = apply {
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

                return other is State && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AwaitingConfirmationCheckoutIntent &&
                id == other.id &&
                buyer == other.buyer &&
                createdAt == other.createdAt &&
                productUrl == other.productUrl &&
                quantity == other.quantity &&
                constraints == other.constraints &&
                discoverPromoCodes == other.discoverPromoCodes &&
                promoCodes == other.promoCodes &&
                variantSelections == other.variantSelections &&
                offer == other.offer &&
                state == other.state &&
                paymentMethod == other.paymentMethod &&
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
                offer,
                state,
                paymentMethod,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AwaitingConfirmationCheckoutIntent{id=$id, buyer=$buyer, createdAt=$createdAt, productUrl=$productUrl, quantity=$quantity, constraints=$constraints, discoverPromoCodes=$discoverPromoCodes, promoCodes=$promoCodes, variantSelections=$variantSelections, offer=$offer, state=$state, paymentMethod=$paymentMethod, additionalProperties=$additionalProperties}"
    }

    class PlacingOrderCheckoutIntent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val buyer: JsonField<Buyer>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val productUrl: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val constraints: JsonField<BaseCheckoutIntent.Constraints>,
        private val discoverPromoCodes: JsonField<Boolean>,
        private val promoCodes: JsonField<List<String>>,
        private val variantSelections: JsonField<List<VariantSelection>>,
        private val offer: JsonField<Offer>,
        private val paymentMethod: JsonField<PaymentMethod>,
        private val state: JsonField<State>,
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
            constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of(),
            @JsonProperty("discoverPromoCodes")
            @ExcludeMissing
            discoverPromoCodes: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("promoCodes")
            @ExcludeMissing
            promoCodes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("variantSelections")
            @ExcludeMissing
            variantSelections: JsonField<List<VariantSelection>> = JsonMissing.of(),
            @JsonProperty("offer") @ExcludeMissing offer: JsonField<Offer> = JsonMissing.of(),
            @JsonProperty("paymentMethod")
            @ExcludeMissing
            paymentMethod: JsonField<PaymentMethod> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
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
            offer,
            paymentMethod,
            state,
            mutableMapOf(),
        )

        fun toBaseCheckoutIntent(): BaseCheckoutIntent =
            BaseCheckoutIntent.builder()
                .id(id)
                .buyer(buyer)
                .createdAt(createdAt)
                .productUrl(productUrl)
                .quantity(quantity)
                .constraints(constraints)
                .discoverPromoCodes(discoverPromoCodes)
                .promoCodes(promoCodes)
                .variantSelections(variantSelections)
                .build()

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

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
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

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
        fun constraints(): Optional<BaseCheckoutIntent.Constraints> =
            constraints.getOptional("constraints")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun discoverPromoCodes(): Optional<Boolean> =
            discoverPromoCodes.getOptional("discoverPromoCodes")

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
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun offer(): Offer = offer.getRequired("offer")

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
        fun state(): State = state.getRequired("state")

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
        fun _constraints(): JsonField<BaseCheckoutIntent.Constraints> = constraints

        /**
         * Returns the raw JSON value of [discoverPromoCodes].
         *
         * Unlike [discoverPromoCodes], this method doesn't throw if the JSON field has an
         * unexpected type.
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

        /**
         * Returns the raw JSON value of [offer].
         *
         * Unlike [offer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("offer") @ExcludeMissing fun _offer(): JsonField<Offer> = offer

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
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<State> = state

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
             * Returns a mutable builder for constructing an instance of
             * [PlacingOrderCheckoutIntent].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .buyer()
             * .createdAt()
             * .productUrl()
             * .quantity()
             * .offer()
             * .paymentMethod()
             * .state()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PlacingOrderCheckoutIntent]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var buyer: JsonField<Buyer>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var productUrl: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of()
            private var discoverPromoCodes: JsonField<Boolean> = JsonMissing.of()
            private var promoCodes: JsonField<MutableList<String>>? = null
            private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
            private var offer: JsonField<Offer>? = null
            private var paymentMethod: JsonField<PaymentMethod>? = null
            private var state: JsonField<State>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(placingOrderCheckoutIntent: PlacingOrderCheckoutIntent) = apply {
                id = placingOrderCheckoutIntent.id
                buyer = placingOrderCheckoutIntent.buyer
                createdAt = placingOrderCheckoutIntent.createdAt
                productUrl = placingOrderCheckoutIntent.productUrl
                quantity = placingOrderCheckoutIntent.quantity
                constraints = placingOrderCheckoutIntent.constraints
                discoverPromoCodes = placingOrderCheckoutIntent.discoverPromoCodes
                promoCodes = placingOrderCheckoutIntent.promoCodes.map { it.toMutableList() }
                variantSelections =
                    placingOrderCheckoutIntent.variantSelections.map { it.toMutableList() }
                offer = placingOrderCheckoutIntent.offer
                paymentMethod = placingOrderCheckoutIntent.paymentMethod
                state = placingOrderCheckoutIntent.state
                additionalProperties =
                    placingOrderCheckoutIntent.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

            /**
             * Sets [Builder.buyer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
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

            fun constraints(constraints: BaseCheckoutIntent.Constraints) =
                constraints(JsonField.of(constraints))

            /**
             * Sets [Builder.constraints] to an arbitrary JSON value.
             *
             * You should usually call [Builder.constraints] with a well-typed
             * [BaseCheckoutIntent.Constraints] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun constraints(constraints: JsonField<BaseCheckoutIntent.Constraints>) = apply {
                this.constraints = constraints
            }

            fun discoverPromoCodes(discoverPromoCodes: Boolean) =
                discoverPromoCodes(JsonField.of(discoverPromoCodes))

            /**
             * Sets [Builder.discoverPromoCodes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.discoverPromoCodes] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            fun offer(offer: Offer) = offer(JsonField.of(offer))

            /**
             * Sets [Builder.offer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.offer] with a well-typed [Offer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun offer(offer: JsonField<Offer>) = apply { this.offer = offer }

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

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofPrava(prava)`. */
            fun paymentMethod(prava: PaymentMethod.PravaPaymentMethod) =
                paymentMethod(PaymentMethod.ofPrava(prava))

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofDrawdown(drawdown)`. */
            fun paymentMethod(drawdown: PaymentMethod.DrawdownPaymentMethod) =
                paymentMethod(PaymentMethod.ofDrawdown(drawdown))

            fun state(state: State) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [State] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun state(state: JsonField<State>) = apply { this.state = state }

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
             * Returns an immutable instance of [PlacingOrderCheckoutIntent].
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
             * .offer()
             * .paymentMethod()
             * .state()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PlacingOrderCheckoutIntent =
                PlacingOrderCheckoutIntent(
                    checkRequired("id", id),
                    checkRequired("buyer", buyer),
                    checkRequired("createdAt", createdAt),
                    checkRequired("productUrl", productUrl),
                    checkRequired("quantity", quantity),
                    constraints,
                    discoverPromoCodes,
                    (promoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                    (variantSelections ?: JsonMissing.of()).map { it.toImmutable() },
                    checkRequired("offer", offer),
                    checkRequired("paymentMethod", paymentMethod),
                    checkRequired("state", state),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PlacingOrderCheckoutIntent = apply {
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
            offer().validate()
            paymentMethod().validate()
            state().validate()
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
                (buyer.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (productUrl.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0) +
                (constraints.asKnown().getOrNull()?.validity() ?: 0) +
                (if (discoverPromoCodes.asKnown().isPresent) 1 else 0) +
                (promoCodes.asKnown().getOrNull()?.size ?: 0) +
                (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (offer.asKnown().getOrNull()?.validity() ?: 0) +
                (paymentMethod.asKnown().getOrNull()?.validity() ?: 0) +
                (state.asKnown().getOrNull()?.validity() ?: 0)

        class State @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val PLACING_ORDER = of("placing_order")

                @JvmStatic fun of(value: String) = State(JsonField.of(value))
            }

            /** An enum containing [State]'s known values. */
            enum class Known {
                PLACING_ORDER
            }

            /**
             * An enum containing [State]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [State] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PLACING_ORDER,
                /**
                 * An enum member indicating that [State] was instantiated with an unknown value.
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
                    PLACING_ORDER -> Value.PLACING_ORDER
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
                    PLACING_ORDER -> Known.PLACING_ORDER
                    else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

            fun validate(): State = apply {
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

                return other is State && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PlacingOrderCheckoutIntent &&
                id == other.id &&
                buyer == other.buyer &&
                createdAt == other.createdAt &&
                productUrl == other.productUrl &&
                quantity == other.quantity &&
                constraints == other.constraints &&
                discoverPromoCodes == other.discoverPromoCodes &&
                promoCodes == other.promoCodes &&
                variantSelections == other.variantSelections &&
                offer == other.offer &&
                paymentMethod == other.paymentMethod &&
                state == other.state &&
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
                offer,
                paymentMethod,
                state,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PlacingOrderCheckoutIntent{id=$id, buyer=$buyer, createdAt=$createdAt, productUrl=$productUrl, quantity=$quantity, constraints=$constraints, discoverPromoCodes=$discoverPromoCodes, promoCodes=$promoCodes, variantSelections=$variantSelections, offer=$offer, paymentMethod=$paymentMethod, state=$state, additionalProperties=$additionalProperties}"
    }

    class CompletedCheckoutIntent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val buyer: JsonField<Buyer>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val productUrl: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val constraints: JsonField<BaseCheckoutIntent.Constraints>,
        private val discoverPromoCodes: JsonField<Boolean>,
        private val promoCodes: JsonField<List<String>>,
        private val variantSelections: JsonField<List<VariantSelection>>,
        private val estimatedDeliveryDate: JsonField<OffsetDateTime>,
        private val offer: JsonField<Offer>,
        private val orderId: JsonField<String>,
        private val paymentMethod: JsonField<PaymentMethod>,
        private val state: JsonField<State>,
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
            constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of(),
            @JsonProperty("discoverPromoCodes")
            @ExcludeMissing
            discoverPromoCodes: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("promoCodes")
            @ExcludeMissing
            promoCodes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("variantSelections")
            @ExcludeMissing
            variantSelections: JsonField<List<VariantSelection>> = JsonMissing.of(),
            @JsonProperty("estimatedDeliveryDate")
            @ExcludeMissing
            estimatedDeliveryDate: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("offer") @ExcludeMissing offer: JsonField<Offer> = JsonMissing.of(),
            @JsonProperty("orderId") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("paymentMethod")
            @ExcludeMissing
            paymentMethod: JsonField<PaymentMethod> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
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
            estimatedDeliveryDate,
            offer,
            orderId,
            paymentMethod,
            state,
            mutableMapOf(),
        )

        fun toBaseCheckoutIntent(): BaseCheckoutIntent =
            BaseCheckoutIntent.builder()
                .id(id)
                .buyer(buyer)
                .createdAt(createdAt)
                .productUrl(productUrl)
                .quantity(quantity)
                .constraints(constraints)
                .discoverPromoCodes(discoverPromoCodes)
                .promoCodes(promoCodes)
                .variantSelections(variantSelections)
                .build()

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

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
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

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
        fun constraints(): Optional<BaseCheckoutIntent.Constraints> =
            constraints.getOptional("constraints")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun discoverPromoCodes(): Optional<Boolean> =
            discoverPromoCodes.getOptional("discoverPromoCodes")

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
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun estimatedDeliveryDate(): Optional<OffsetDateTime> =
            estimatedDeliveryDate.getOptional("estimatedDeliveryDate")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun offer(): Offer = offer.getRequired("offer")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun orderId(): Optional<String> = orderId.getOptional("orderId")

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
        fun state(): State = state.getRequired("state")

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
        fun _constraints(): JsonField<BaseCheckoutIntent.Constraints> = constraints

        /**
         * Returns the raw JSON value of [discoverPromoCodes].
         *
         * Unlike [discoverPromoCodes], this method doesn't throw if the JSON field has an
         * unexpected type.
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

        /**
         * Returns the raw JSON value of [estimatedDeliveryDate].
         *
         * Unlike [estimatedDeliveryDate], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("estimatedDeliveryDate")
        @ExcludeMissing
        fun _estimatedDeliveryDate(): JsonField<OffsetDateTime> = estimatedDeliveryDate

        /**
         * Returns the raw JSON value of [offer].
         *
         * Unlike [offer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("offer") @ExcludeMissing fun _offer(): JsonField<Offer> = offer

        /**
         * Returns the raw JSON value of [orderId].
         *
         * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("orderId") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

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
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<State> = state

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
             * Returns a mutable builder for constructing an instance of [CompletedCheckoutIntent].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .buyer()
             * .createdAt()
             * .productUrl()
             * .quantity()
             * .estimatedDeliveryDate()
             * .offer()
             * .orderId()
             * .paymentMethod()
             * .state()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CompletedCheckoutIntent]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var buyer: JsonField<Buyer>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var productUrl: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of()
            private var discoverPromoCodes: JsonField<Boolean> = JsonMissing.of()
            private var promoCodes: JsonField<MutableList<String>>? = null
            private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
            private var estimatedDeliveryDate: JsonField<OffsetDateTime>? = null
            private var offer: JsonField<Offer>? = null
            private var orderId: JsonField<String>? = null
            private var paymentMethod: JsonField<PaymentMethod>? = null
            private var state: JsonField<State>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(completedCheckoutIntent: CompletedCheckoutIntent) = apply {
                id = completedCheckoutIntent.id
                buyer = completedCheckoutIntent.buyer
                createdAt = completedCheckoutIntent.createdAt
                productUrl = completedCheckoutIntent.productUrl
                quantity = completedCheckoutIntent.quantity
                constraints = completedCheckoutIntent.constraints
                discoverPromoCodes = completedCheckoutIntent.discoverPromoCodes
                promoCodes = completedCheckoutIntent.promoCodes.map { it.toMutableList() }
                variantSelections =
                    completedCheckoutIntent.variantSelections.map { it.toMutableList() }
                estimatedDeliveryDate = completedCheckoutIntent.estimatedDeliveryDate
                offer = completedCheckoutIntent.offer
                orderId = completedCheckoutIntent.orderId
                paymentMethod = completedCheckoutIntent.paymentMethod
                state = completedCheckoutIntent.state
                additionalProperties = completedCheckoutIntent.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

            /**
             * Sets [Builder.buyer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
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

            fun constraints(constraints: BaseCheckoutIntent.Constraints) =
                constraints(JsonField.of(constraints))

            /**
             * Sets [Builder.constraints] to an arbitrary JSON value.
             *
             * You should usually call [Builder.constraints] with a well-typed
             * [BaseCheckoutIntent.Constraints] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun constraints(constraints: JsonField<BaseCheckoutIntent.Constraints>) = apply {
                this.constraints = constraints
            }

            fun discoverPromoCodes(discoverPromoCodes: Boolean) =
                discoverPromoCodes(JsonField.of(discoverPromoCodes))

            /**
             * Sets [Builder.discoverPromoCodes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.discoverPromoCodes] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            fun estimatedDeliveryDate(estimatedDeliveryDate: OffsetDateTime?) =
                estimatedDeliveryDate(JsonField.ofNullable(estimatedDeliveryDate))

            /**
             * Alias for calling [Builder.estimatedDeliveryDate] with
             * `estimatedDeliveryDate.orElse(null)`.
             */
            fun estimatedDeliveryDate(estimatedDeliveryDate: Optional<OffsetDateTime>) =
                estimatedDeliveryDate(estimatedDeliveryDate.getOrNull())

            /**
             * Sets [Builder.estimatedDeliveryDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.estimatedDeliveryDate] with a well-typed
             * [OffsetDateTime] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun estimatedDeliveryDate(estimatedDeliveryDate: JsonField<OffsetDateTime>) = apply {
                this.estimatedDeliveryDate = estimatedDeliveryDate
            }

            fun offer(offer: Offer) = offer(JsonField.of(offer))

            /**
             * Sets [Builder.offer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.offer] with a well-typed [Offer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun offer(offer: JsonField<Offer>) = apply { this.offer = offer }

            fun orderId(orderId: String?) = orderId(JsonField.ofNullable(orderId))

            /** Alias for calling [Builder.orderId] with `orderId.orElse(null)`. */
            fun orderId(orderId: Optional<String>) = orderId(orderId.getOrNull())

            /**
             * Sets [Builder.orderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

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

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofPrava(prava)`. */
            fun paymentMethod(prava: PaymentMethod.PravaPaymentMethod) =
                paymentMethod(PaymentMethod.ofPrava(prava))

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofDrawdown(drawdown)`. */
            fun paymentMethod(drawdown: PaymentMethod.DrawdownPaymentMethod) =
                paymentMethod(PaymentMethod.ofDrawdown(drawdown))

            fun state(state: State) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [State] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun state(state: JsonField<State>) = apply { this.state = state }

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
             * Returns an immutable instance of [CompletedCheckoutIntent].
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
             * .estimatedDeliveryDate()
             * .offer()
             * .orderId()
             * .paymentMethod()
             * .state()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CompletedCheckoutIntent =
                CompletedCheckoutIntent(
                    checkRequired("id", id),
                    checkRequired("buyer", buyer),
                    checkRequired("createdAt", createdAt),
                    checkRequired("productUrl", productUrl),
                    checkRequired("quantity", quantity),
                    constraints,
                    discoverPromoCodes,
                    (promoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                    (variantSelections ?: JsonMissing.of()).map { it.toImmutable() },
                    checkRequired("estimatedDeliveryDate", estimatedDeliveryDate),
                    checkRequired("offer", offer),
                    checkRequired("orderId", orderId),
                    checkRequired("paymentMethod", paymentMethod),
                    checkRequired("state", state),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CompletedCheckoutIntent = apply {
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
            estimatedDeliveryDate()
            offer().validate()
            orderId()
            paymentMethod().validate()
            state().validate()
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
                (buyer.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (productUrl.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0) +
                (constraints.asKnown().getOrNull()?.validity() ?: 0) +
                (if (discoverPromoCodes.asKnown().isPresent) 1 else 0) +
                (promoCodes.asKnown().getOrNull()?.size ?: 0) +
                (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (estimatedDeliveryDate.asKnown().isPresent) 1 else 0) +
                (offer.asKnown().getOrNull()?.validity() ?: 0) +
                (if (orderId.asKnown().isPresent) 1 else 0) +
                (paymentMethod.asKnown().getOrNull()?.validity() ?: 0) +
                (state.asKnown().getOrNull()?.validity() ?: 0)

        class State @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val COMPLETED = of("completed")

                @JvmStatic fun of(value: String) = State(JsonField.of(value))
            }

            /** An enum containing [State]'s known values. */
            enum class Known {
                COMPLETED
            }

            /**
             * An enum containing [State]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [State] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                COMPLETED,
                /**
                 * An enum member indicating that [State] was instantiated with an unknown value.
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
                    COMPLETED -> Value.COMPLETED
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
                    COMPLETED -> Known.COMPLETED
                    else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

            fun validate(): State = apply {
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

                return other is State && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CompletedCheckoutIntent &&
                id == other.id &&
                buyer == other.buyer &&
                createdAt == other.createdAt &&
                productUrl == other.productUrl &&
                quantity == other.quantity &&
                constraints == other.constraints &&
                discoverPromoCodes == other.discoverPromoCodes &&
                promoCodes == other.promoCodes &&
                variantSelections == other.variantSelections &&
                estimatedDeliveryDate == other.estimatedDeliveryDate &&
                offer == other.offer &&
                orderId == other.orderId &&
                paymentMethod == other.paymentMethod &&
                state == other.state &&
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
                estimatedDeliveryDate,
                offer,
                orderId,
                paymentMethod,
                state,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CompletedCheckoutIntent{id=$id, buyer=$buyer, createdAt=$createdAt, productUrl=$productUrl, quantity=$quantity, constraints=$constraints, discoverPromoCodes=$discoverPromoCodes, promoCodes=$promoCodes, variantSelections=$variantSelections, estimatedDeliveryDate=$estimatedDeliveryDate, offer=$offer, orderId=$orderId, paymentMethod=$paymentMethod, state=$state, additionalProperties=$additionalProperties}"
    }

    class FailedCheckoutIntent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val buyer: JsonField<Buyer>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val productUrl: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val constraints: JsonField<BaseCheckoutIntent.Constraints>,
        private val discoverPromoCodes: JsonField<Boolean>,
        private val promoCodes: JsonField<List<String>>,
        private val variantSelections: JsonField<List<VariantSelection>>,
        private val failureReason: JsonField<FailureReason>,
        private val state: JsonField<State>,
        private val offer: JsonField<Offer>,
        private val paymentMethod: JsonField<PaymentMethod>,
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
            constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of(),
            @JsonProperty("discoverPromoCodes")
            @ExcludeMissing
            discoverPromoCodes: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("promoCodes")
            @ExcludeMissing
            promoCodes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("variantSelections")
            @ExcludeMissing
            variantSelections: JsonField<List<VariantSelection>> = JsonMissing.of(),
            @JsonProperty("failureReason")
            @ExcludeMissing
            failureReason: JsonField<FailureReason> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
            @JsonProperty("offer") @ExcludeMissing offer: JsonField<Offer> = JsonMissing.of(),
            @JsonProperty("paymentMethod")
            @ExcludeMissing
            paymentMethod: JsonField<PaymentMethod> = JsonMissing.of(),
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
            failureReason,
            state,
            offer,
            paymentMethod,
            mutableMapOf(),
        )

        fun toBaseCheckoutIntent(): BaseCheckoutIntent =
            BaseCheckoutIntent.builder()
                .id(id)
                .buyer(buyer)
                .createdAt(createdAt)
                .productUrl(productUrl)
                .quantity(quantity)
                .constraints(constraints)
                .discoverPromoCodes(discoverPromoCodes)
                .promoCodes(promoCodes)
                .variantSelections(variantSelections)
                .build()

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

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
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

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
        fun constraints(): Optional<BaseCheckoutIntent.Constraints> =
            constraints.getOptional("constraints")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun discoverPromoCodes(): Optional<Boolean> =
            discoverPromoCodes.getOptional("discoverPromoCodes")

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
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun failureReason(): FailureReason = failureReason.getRequired("failureReason")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun state(): State = state.getRequired("state")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun offer(): Optional<Offer> = offer.getOptional("offer")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun paymentMethod(): Optional<PaymentMethod> = paymentMethod.getOptional("paymentMethod")

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
        fun _constraints(): JsonField<BaseCheckoutIntent.Constraints> = constraints

        /**
         * Returns the raw JSON value of [discoverPromoCodes].
         *
         * Unlike [discoverPromoCodes], this method doesn't throw if the JSON field has an
         * unexpected type.
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

        /**
         * Returns the raw JSON value of [failureReason].
         *
         * Unlike [failureReason], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("failureReason")
        @ExcludeMissing
        fun _failureReason(): JsonField<FailureReason> = failureReason

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<State> = state

        /**
         * Returns the raw JSON value of [offer].
         *
         * Unlike [offer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("offer") @ExcludeMissing fun _offer(): JsonField<Offer> = offer

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
             * Returns a mutable builder for constructing an instance of [FailedCheckoutIntent].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .buyer()
             * .createdAt()
             * .productUrl()
             * .quantity()
             * .failureReason()
             * .state()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FailedCheckoutIntent]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var buyer: JsonField<Buyer>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var productUrl: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var constraints: JsonField<BaseCheckoutIntent.Constraints> = JsonMissing.of()
            private var discoverPromoCodes: JsonField<Boolean> = JsonMissing.of()
            private var promoCodes: JsonField<MutableList<String>>? = null
            private var variantSelections: JsonField<MutableList<VariantSelection>>? = null
            private var failureReason: JsonField<FailureReason>? = null
            private var state: JsonField<State>? = null
            private var offer: JsonField<Offer> = JsonMissing.of()
            private var paymentMethod: JsonField<PaymentMethod> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(failedCheckoutIntent: FailedCheckoutIntent) = apply {
                id = failedCheckoutIntent.id
                buyer = failedCheckoutIntent.buyer
                createdAt = failedCheckoutIntent.createdAt
                productUrl = failedCheckoutIntent.productUrl
                quantity = failedCheckoutIntent.quantity
                constraints = failedCheckoutIntent.constraints
                discoverPromoCodes = failedCheckoutIntent.discoverPromoCodes
                promoCodes = failedCheckoutIntent.promoCodes.map { it.toMutableList() }
                variantSelections =
                    failedCheckoutIntent.variantSelections.map { it.toMutableList() }
                failureReason = failedCheckoutIntent.failureReason
                state = failedCheckoutIntent.state
                offer = failedCheckoutIntent.offer
                paymentMethod = failedCheckoutIntent.paymentMethod
                additionalProperties = failedCheckoutIntent.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun buyer(buyer: Buyer) = buyer(JsonField.of(buyer))

            /**
             * Sets [Builder.buyer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buyer] with a well-typed [Buyer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
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

            fun constraints(constraints: BaseCheckoutIntent.Constraints) =
                constraints(JsonField.of(constraints))

            /**
             * Sets [Builder.constraints] to an arbitrary JSON value.
             *
             * You should usually call [Builder.constraints] with a well-typed
             * [BaseCheckoutIntent.Constraints] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun constraints(constraints: JsonField<BaseCheckoutIntent.Constraints>) = apply {
                this.constraints = constraints
            }

            fun discoverPromoCodes(discoverPromoCodes: Boolean) =
                discoverPromoCodes(JsonField.of(discoverPromoCodes))

            /**
             * Sets [Builder.discoverPromoCodes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.discoverPromoCodes] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            fun failureReason(failureReason: FailureReason) =
                failureReason(JsonField.of(failureReason))

            /**
             * Sets [Builder.failureReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.failureReason] with a well-typed [FailureReason]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun failureReason(failureReason: JsonField<FailureReason>) = apply {
                this.failureReason = failureReason
            }

            fun state(state: State) = state(JsonField.of(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [State] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun state(state: JsonField<State>) = apply { this.state = state }

            fun offer(offer: Offer) = offer(JsonField.of(offer))

            /**
             * Sets [Builder.offer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.offer] with a well-typed [Offer] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun offer(offer: JsonField<Offer>) = apply { this.offer = offer }

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

            /** Alias for calling [paymentMethod] with `PaymentMethod.ofPrava(prava)`. */
            fun paymentMethod(prava: PaymentMethod.PravaPaymentMethod) =
                paymentMethod(PaymentMethod.ofPrava(prava))

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
             * Returns an immutable instance of [FailedCheckoutIntent].
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
             * .failureReason()
             * .state()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FailedCheckoutIntent =
                FailedCheckoutIntent(
                    checkRequired("id", id),
                    checkRequired("buyer", buyer),
                    checkRequired("createdAt", createdAt),
                    checkRequired("productUrl", productUrl),
                    checkRequired("quantity", quantity),
                    constraints,
                    discoverPromoCodes,
                    (promoCodes ?: JsonMissing.of()).map { it.toImmutable() },
                    (variantSelections ?: JsonMissing.of()).map { it.toImmutable() },
                    checkRequired("failureReason", failureReason),
                    checkRequired("state", state),
                    offer,
                    paymentMethod,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): FailedCheckoutIntent = apply {
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
            failureReason().validate()
            state().validate()
            offer().ifPresent { it.validate() }
            paymentMethod().ifPresent { it.validate() }
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
                (buyer.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (productUrl.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0) +
                (constraints.asKnown().getOrNull()?.validity() ?: 0) +
                (if (discoverPromoCodes.asKnown().isPresent) 1 else 0) +
                (promoCodes.asKnown().getOrNull()?.size ?: 0) +
                (variantSelections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (failureReason.asKnown().getOrNull()?.validity() ?: 0) +
                (state.asKnown().getOrNull()?.validity() ?: 0) +
                (offer.asKnown().getOrNull()?.validity() ?: 0) +
                (paymentMethod.asKnown().getOrNull()?.validity() ?: 0)

        class FailureReason
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val code: JsonField<Code>,
            private val message: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("code") @ExcludeMissing code: JsonField<Code> = JsonMissing.of(),
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<String> = JsonMissing.of(),
            ) : this(code, message, mutableMapOf())

            /**
             * Type derived from runtime array - always in sync
             *
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun code(): Code = code.getRequired("code")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun message(): String = message.getRequired("message")

            /**
             * Returns the raw JSON value of [code].
             *
             * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
                 * Returns a mutable builder for constructing an instance of [FailureReason].
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FailureReason]. */
            class Builder internal constructor() {

                private var code: JsonField<Code>? = null
                private var message: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(failureReason: FailureReason) = apply {
                    code = failureReason.code
                    message = failureReason.message
                    additionalProperties = failureReason.additionalProperties.toMutableMap()
                }

                /** Type derived from runtime array - always in sync */
                fun code(code: Code) = code(JsonField.of(code))

                /**
                 * Sets [Builder.code] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.code] with a well-typed [Code] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun code(code: JsonField<Code>) = apply { this.code = code }

                fun message(message: String) = message(JsonField.of(message))

                /**
                 * Sets [Builder.message] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.message] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun message(message: JsonField<String>) = apply { this.message = message }

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
                 * Returns an immutable instance of [FailureReason].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FailureReason =
                    FailureReason(
                        checkRequired("code", code),
                        checkRequired("message", message),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FailureReason = apply {
                if (validated) {
                    return@apply
                }

                code().validate()
                message()
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
                (code.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (message.asKnown().isPresent) 1 else 0)

            /** Type derived from runtime array - always in sync */
            class Code @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val CHECKOUT_INTENT_EXPIRED = of("checkout_intent_expired")

                    @JvmField val PAYMENT_FAILED = of("payment_failed")

                    @JvmField val INSUFFICIENT_STOCK = of("insufficient_stock")

                    @JvmField val PRODUCT_OUT_OF_STOCK = of("product_out_of_stock")

                    @JvmField val OFFER_RETRIEVAL_FAILED = of("offer_retrieval_failed")

                    @JvmField val ORDER_PLACEMENT_FAILED = of("order_placement_failed")

                    @JvmField val DEVELOPER_NOT_FOUND = of("developer_not_found")

                    @JvmField val MISSING_SHIPPING_METHOD = of("missing_shipping_method")

                    @JvmField val UNSUPPORTED_CURRENCY = of("unsupported_currency")

                    @JvmField val INVALID_INPUT = of("invalid_input")

                    @JvmField val INCORRECT_COST_BREAKDOWN = of("incorrect_cost_breakdown")

                    @JvmField
                    val UNSUPPORTED_STORE_NO_GUEST_CHECKOUT =
                        of("unsupported_store_no_guest_checkout")

                    @JvmField val WORKFLOW_INVOCATION_FAILED = of("workflow_invocation_failed")

                    @JvmField val VARIANT_SELECTIONS_INVALID = of("variant_selections_invalid")

                    @JvmField val VARIANT_SELECTIONS_REQUIRED = of("variant_selections_required")

                    @JvmField val FORM_VALIDATION_ERROR = of("form_validation_error")

                    @JvmField val CAPTCHA_BLOCKED = of("captcha_blocked")

                    @JvmField val BOT_PROTECTION_BLOCKED = of("bot_protection_blocked")

                    @JvmField
                    val CONSTRAINT_TOTAL_PRICE_EXCEEDED = of("constraint_total_price_exceeded")

                    @JvmField
                    val CONSTRAINT_SHIPPING_COST_EXCEEDED = of("constraint_shipping_cost_exceeded")

                    @JvmField
                    val PROMO_CODE_DISCOVERY_NOT_ENABLED = of("promo_code_discovery_not_enabled")

                    @JvmField val UNKNOWN = of("unknown")

                    @JvmStatic fun of(value: String) = Code(JsonField.of(value))
                }

                /** An enum containing [Code]'s known values. */
                enum class Known {
                    CHECKOUT_INTENT_EXPIRED,
                    PAYMENT_FAILED,
                    INSUFFICIENT_STOCK,
                    PRODUCT_OUT_OF_STOCK,
                    OFFER_RETRIEVAL_FAILED,
                    ORDER_PLACEMENT_FAILED,
                    DEVELOPER_NOT_FOUND,
                    MISSING_SHIPPING_METHOD,
                    UNSUPPORTED_CURRENCY,
                    INVALID_INPUT,
                    INCORRECT_COST_BREAKDOWN,
                    UNSUPPORTED_STORE_NO_GUEST_CHECKOUT,
                    WORKFLOW_INVOCATION_FAILED,
                    VARIANT_SELECTIONS_INVALID,
                    VARIANT_SELECTIONS_REQUIRED,
                    FORM_VALIDATION_ERROR,
                    CAPTCHA_BLOCKED,
                    BOT_PROTECTION_BLOCKED,
                    CONSTRAINT_TOTAL_PRICE_EXCEEDED,
                    CONSTRAINT_SHIPPING_COST_EXCEEDED,
                    PROMO_CODE_DISCOVERY_NOT_ENABLED,
                    UNKNOWN,
                }

                /**
                 * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Code] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    CHECKOUT_INTENT_EXPIRED,
                    PAYMENT_FAILED,
                    INSUFFICIENT_STOCK,
                    PRODUCT_OUT_OF_STOCK,
                    OFFER_RETRIEVAL_FAILED,
                    ORDER_PLACEMENT_FAILED,
                    DEVELOPER_NOT_FOUND,
                    MISSING_SHIPPING_METHOD,
                    UNSUPPORTED_CURRENCY,
                    INVALID_INPUT,
                    INCORRECT_COST_BREAKDOWN,
                    UNSUPPORTED_STORE_NO_GUEST_CHECKOUT,
                    WORKFLOW_INVOCATION_FAILED,
                    VARIANT_SELECTIONS_INVALID,
                    VARIANT_SELECTIONS_REQUIRED,
                    FORM_VALIDATION_ERROR,
                    CAPTCHA_BLOCKED,
                    BOT_PROTECTION_BLOCKED,
                    CONSTRAINT_TOTAL_PRICE_EXCEEDED,
                    CONSTRAINT_SHIPPING_COST_EXCEEDED,
                    PROMO_CODE_DISCOVERY_NOT_ENABLED,
                    UNKNOWN,
                    /**
                     * An enum member indicating that [Code] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        CHECKOUT_INTENT_EXPIRED -> Value.CHECKOUT_INTENT_EXPIRED
                        PAYMENT_FAILED -> Value.PAYMENT_FAILED
                        INSUFFICIENT_STOCK -> Value.INSUFFICIENT_STOCK
                        PRODUCT_OUT_OF_STOCK -> Value.PRODUCT_OUT_OF_STOCK
                        OFFER_RETRIEVAL_FAILED -> Value.OFFER_RETRIEVAL_FAILED
                        ORDER_PLACEMENT_FAILED -> Value.ORDER_PLACEMENT_FAILED
                        DEVELOPER_NOT_FOUND -> Value.DEVELOPER_NOT_FOUND
                        MISSING_SHIPPING_METHOD -> Value.MISSING_SHIPPING_METHOD
                        UNSUPPORTED_CURRENCY -> Value.UNSUPPORTED_CURRENCY
                        INVALID_INPUT -> Value.INVALID_INPUT
                        INCORRECT_COST_BREAKDOWN -> Value.INCORRECT_COST_BREAKDOWN
                        UNSUPPORTED_STORE_NO_GUEST_CHECKOUT ->
                            Value.UNSUPPORTED_STORE_NO_GUEST_CHECKOUT
                        WORKFLOW_INVOCATION_FAILED -> Value.WORKFLOW_INVOCATION_FAILED
                        VARIANT_SELECTIONS_INVALID -> Value.VARIANT_SELECTIONS_INVALID
                        VARIANT_SELECTIONS_REQUIRED -> Value.VARIANT_SELECTIONS_REQUIRED
                        FORM_VALIDATION_ERROR -> Value.FORM_VALIDATION_ERROR
                        CAPTCHA_BLOCKED -> Value.CAPTCHA_BLOCKED
                        BOT_PROTECTION_BLOCKED -> Value.BOT_PROTECTION_BLOCKED
                        CONSTRAINT_TOTAL_PRICE_EXCEEDED -> Value.CONSTRAINT_TOTAL_PRICE_EXCEEDED
                        CONSTRAINT_SHIPPING_COST_EXCEEDED -> Value.CONSTRAINT_SHIPPING_COST_EXCEEDED
                        PROMO_CODE_DISCOVERY_NOT_ENABLED -> Value.PROMO_CODE_DISCOVERY_NOT_ENABLED
                        UNKNOWN -> Value.UNKNOWN
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws CheckoutIntentsInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        CHECKOUT_INTENT_EXPIRED -> Known.CHECKOUT_INTENT_EXPIRED
                        PAYMENT_FAILED -> Known.PAYMENT_FAILED
                        INSUFFICIENT_STOCK -> Known.INSUFFICIENT_STOCK
                        PRODUCT_OUT_OF_STOCK -> Known.PRODUCT_OUT_OF_STOCK
                        OFFER_RETRIEVAL_FAILED -> Known.OFFER_RETRIEVAL_FAILED
                        ORDER_PLACEMENT_FAILED -> Known.ORDER_PLACEMENT_FAILED
                        DEVELOPER_NOT_FOUND -> Known.DEVELOPER_NOT_FOUND
                        MISSING_SHIPPING_METHOD -> Known.MISSING_SHIPPING_METHOD
                        UNSUPPORTED_CURRENCY -> Known.UNSUPPORTED_CURRENCY
                        INVALID_INPUT -> Known.INVALID_INPUT
                        INCORRECT_COST_BREAKDOWN -> Known.INCORRECT_COST_BREAKDOWN
                        UNSUPPORTED_STORE_NO_GUEST_CHECKOUT ->
                            Known.UNSUPPORTED_STORE_NO_GUEST_CHECKOUT
                        WORKFLOW_INVOCATION_FAILED -> Known.WORKFLOW_INVOCATION_FAILED
                        VARIANT_SELECTIONS_INVALID -> Known.VARIANT_SELECTIONS_INVALID
                        VARIANT_SELECTIONS_REQUIRED -> Known.VARIANT_SELECTIONS_REQUIRED
                        FORM_VALIDATION_ERROR -> Known.FORM_VALIDATION_ERROR
                        CAPTCHA_BLOCKED -> Known.CAPTCHA_BLOCKED
                        BOT_PROTECTION_BLOCKED -> Known.BOT_PROTECTION_BLOCKED
                        CONSTRAINT_TOTAL_PRICE_EXCEEDED -> Known.CONSTRAINT_TOTAL_PRICE_EXCEEDED
                        CONSTRAINT_SHIPPING_COST_EXCEEDED -> Known.CONSTRAINT_SHIPPING_COST_EXCEEDED
                        PROMO_CODE_DISCOVERY_NOT_ENABLED -> Known.PROMO_CODE_DISCOVERY_NOT_ENABLED
                        UNKNOWN -> Known.UNKNOWN
                        else -> throw CheckoutIntentsInvalidDataException("Unknown Code: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws CheckoutIntentsInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        CheckoutIntentsInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): Code = apply {
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

                    return other is Code && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is FailureReason &&
                    code == other.code &&
                    message == other.message &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(code, message, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FailureReason{code=$code, message=$message, additionalProperties=$additionalProperties}"
        }

        class State @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = State(JsonField.of(value))
            }

            /** An enum containing [State]'s known values. */
            enum class Known {
                FAILED
            }

            /**
             * An enum containing [State]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [State] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FAILED,
                /**
                 * An enum member indicating that [State] was instantiated with an unknown value.
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
                    FAILED -> Value.FAILED
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
                    FAILED -> Known.FAILED
                    else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

            fun validate(): State = apply {
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

                return other is State && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FailedCheckoutIntent &&
                id == other.id &&
                buyer == other.buyer &&
                createdAt == other.createdAt &&
                productUrl == other.productUrl &&
                quantity == other.quantity &&
                constraints == other.constraints &&
                discoverPromoCodes == other.discoverPromoCodes &&
                promoCodes == other.promoCodes &&
                variantSelections == other.variantSelections &&
                failureReason == other.failureReason &&
                state == other.state &&
                offer == other.offer &&
                paymentMethod == other.paymentMethod &&
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
                failureReason,
                state,
                offer,
                paymentMethod,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FailedCheckoutIntent{id=$id, buyer=$buyer, createdAt=$createdAt, productUrl=$productUrl, quantity=$quantity, constraints=$constraints, discoverPromoCodes=$discoverPromoCodes, promoCodes=$promoCodes, variantSelections=$variantSelections, failureReason=$failureReason, state=$state, offer=$offer, paymentMethod=$paymentMethod, additionalProperties=$additionalProperties}"
    }
}
