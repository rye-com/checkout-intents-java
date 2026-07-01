// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

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
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents a completed order. Orders are created after a checkout intent reaches the `completed`
 * state.
 */
class Order
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val cancellation: JsonField<Cancellation>,
    private val checkoutIntentId: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val referenceId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cancellation")
        @ExcludeMissing
        cancellation: JsonField<Cancellation> = JsonMissing.of(),
        @JsonProperty("checkoutIntentId")
        @ExcludeMissing
        checkoutIntentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("referenceId")
        @ExcludeMissing
        referenceId: JsonField<String> = JsonMissing.of(),
    ) : this(id, cancellation, checkoutIntentId, createdAt, updatedAt, referenceId, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The cancellation for this order, or `null` if none has been requested. Populated by joining
     * the separate cancellations collection on the order's marketplace order id.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun cancellation(): Optional<Cancellation> = cancellation.getOptional("cancellation")

    /**
     * ID of the checkout intent that was responsible for creating this order.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

    /**
     * Timestamp the order was persisted to Rye.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): String = createdAt.getRequired("createdAt")

    /**
     * Timestamp the order was last updated at
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): String = updatedAt.getRequired("updatedAt")

    /**
     * The `referenceId` you supplied on the checkout intent, echoed back so you can reconcile this
     * order against your own records. Absent when none was supplied.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun referenceId(): Optional<String> = referenceId.getOptional("referenceId")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [cancellation].
     *
     * Unlike [cancellation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cancellation")
    @ExcludeMissing
    fun _cancellation(): JsonField<Cancellation> = cancellation

    /**
     * Returns the raw JSON value of [checkoutIntentId].
     *
     * Unlike [checkoutIntentId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("checkoutIntentId")
    @ExcludeMissing
    fun _checkoutIntentId(): JsonField<String> = checkoutIntentId

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

    /**
     * Returns the raw JSON value of [referenceId].
     *
     * Unlike [referenceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("referenceId") @ExcludeMissing fun _referenceId(): JsonField<String> = referenceId

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
         * Returns a mutable builder for constructing an instance of [Order].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .cancellation()
         * .checkoutIntentId()
         * .createdAt()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Order]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var cancellation: JsonField<Cancellation>? = null
        private var checkoutIntentId: JsonField<String>? = null
        private var createdAt: JsonField<String>? = null
        private var updatedAt: JsonField<String>? = null
        private var referenceId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(order: Order) = apply {
            id = order.id
            cancellation = order.cancellation
            checkoutIntentId = order.checkoutIntentId
            createdAt = order.createdAt
            updatedAt = order.updatedAt
            referenceId = order.referenceId
            additionalProperties = order.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The cancellation for this order, or `null` if none has been requested. Populated by
         * joining the separate cancellations collection on the order's marketplace order id.
         */
        fun cancellation(cancellation: Cancellation?) =
            cancellation(JsonField.ofNullable(cancellation))

        /** Alias for calling [Builder.cancellation] with `cancellation.orElse(null)`. */
        fun cancellation(cancellation: Optional<Cancellation>) =
            cancellation(cancellation.getOrNull())

        /**
         * Sets [Builder.cancellation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancellation] with a well-typed [Cancellation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cancellation(cancellation: JsonField<Cancellation>) = apply {
            this.cancellation = cancellation
        }

        /** Alias for calling [cancellation] with `Cancellation.ofRequested(requested)`. */
        fun cancellation(requested: Cancellation.RequestedCancellation) =
            cancellation(Cancellation.ofRequested(requested))

        /** Alias for calling [cancellation] with `Cancellation.ofCompleted(completed)`. */
        fun cancellation(completed: Cancellation.CompletedCancellation) =
            cancellation(Cancellation.ofCompleted(completed))

        /** Alias for calling [cancellation] with `Cancellation.ofDenied(denied)`. */
        fun cancellation(denied: Cancellation.DeniedCancellation) =
            cancellation(Cancellation.ofDenied(denied))

        /** ID of the checkout intent that was responsible for creating this order. */
        fun checkoutIntentId(checkoutIntentId: String) =
            checkoutIntentId(JsonField.of(checkoutIntentId))

        /**
         * Sets [Builder.checkoutIntentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.checkoutIntentId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun checkoutIntentId(checkoutIntentId: JsonField<String>) = apply {
            this.checkoutIntentId = checkoutIntentId
        }

        /** Timestamp the order was persisted to Rye. */
        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        /** Timestamp the order was last updated at */
        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

        /**
         * The `referenceId` you supplied on the checkout intent, echoed back so you can reconcile
         * this order against your own records. Absent when none was supplied.
         */
        fun referenceId(referenceId: String) = referenceId(JsonField.of(referenceId))

        /**
         * Sets [Builder.referenceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.referenceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun referenceId(referenceId: JsonField<String>) = apply { this.referenceId = referenceId }

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
         * Returns an immutable instance of [Order].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .cancellation()
         * .checkoutIntentId()
         * .createdAt()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Order =
            Order(
                checkRequired("id", id),
                checkRequired("cancellation", cancellation),
                checkRequired("checkoutIntentId", checkoutIntentId),
                checkRequired("createdAt", createdAt),
                checkRequired("updatedAt", updatedAt),
                referenceId,
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
    fun validate(): Order = apply {
        if (validated) {
            return@apply
        }

        id()
        cancellation().ifPresent { it.validate() }
        checkoutIntentId()
        createdAt()
        updatedAt()
        referenceId()
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
            (cancellation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (checkoutIntentId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (referenceId.asKnown().isPresent) 1 else 0)

    /**
     * The cancellation for this order, or `null` if none has been requested. Populated by joining
     * the separate cancellations collection on the order's marketplace order id.
     */
    @JsonDeserialize(using = Cancellation.Deserializer::class)
    @JsonSerialize(using = Cancellation.Serializer::class)
    class Cancellation
    private constructor(
        private val requested: RequestedCancellation? = null,
        private val completed: CompletedCancellation? = null,
        private val denied: DeniedCancellation? = null,
        private val _json: JsonValue? = null,
    ) {

        fun requested(): Optional<RequestedCancellation> = Optional.ofNullable(requested)

        fun completed(): Optional<CompletedCancellation> = Optional.ofNullable(completed)

        fun denied(): Optional<DeniedCancellation> = Optional.ofNullable(denied)

        fun isRequested(): Boolean = requested != null

        fun isCompleted(): Boolean = completed != null

        fun isDenied(): Boolean = denied != null

        fun asRequested(): RequestedCancellation = requested.getOrThrow("requested")

        fun asCompleted(): CompletedCancellation = completed.getOrThrow("completed")

        fun asDenied(): DeniedCancellation = denied.getOrThrow("denied")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.rye.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = cancellation.accept(new Cancellation.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitRequested(RequestedCancellation requested) {
         *         return Optional.of(requested.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws CheckoutIntentsInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                requested != null -> visitor.visitRequested(requested)
                completed != null -> visitor.visitCompleted(completed)
                denied != null -> visitor.visitDenied(denied)
                else -> visitor.unknown(_json)
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
        fun validate(): Cancellation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitRequested(requested: RequestedCancellation) {
                        requested.validate()
                    }

                    override fun visitCompleted(completed: CompletedCancellation) {
                        completed.validate()
                    }

                    override fun visitDenied(denied: DeniedCancellation) {
                        denied.validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitRequested(requested: RequestedCancellation) =
                        requested.validity()

                    override fun visitCompleted(completed: CompletedCancellation) =
                        completed.validity()

                    override fun visitDenied(denied: DeniedCancellation) = denied.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Cancellation &&
                requested == other.requested &&
                completed == other.completed &&
                denied == other.denied
        }

        override fun hashCode(): Int = Objects.hash(requested, completed, denied)

        override fun toString(): String =
            when {
                requested != null -> "Cancellation{requested=$requested}"
                completed != null -> "Cancellation{completed=$completed}"
                denied != null -> "Cancellation{denied=$denied}"
                _json != null -> "Cancellation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Cancellation")
            }

        companion object {

            @JvmStatic
            fun ofRequested(requested: RequestedCancellation) = Cancellation(requested = requested)

            @JvmStatic
            fun ofCompleted(completed: CompletedCancellation) = Cancellation(completed = completed)

            @JvmStatic fun ofDenied(denied: DeniedCancellation) = Cancellation(denied = denied)
        }

        /**
         * An interface that defines how to map each variant of [Cancellation] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitRequested(requested: RequestedCancellation): T

            fun visitCompleted(completed: CompletedCancellation): T

            fun visitDenied(denied: DeniedCancellation): T

            /**
             * Maps an unknown variant of [Cancellation] to a value of type [T].
             *
             * An instance of [Cancellation] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws CheckoutIntentsInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw CheckoutIntentsInvalidDataException("Unknown Cancellation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Cancellation>(Cancellation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Cancellation {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<RequestedCancellation>())?.let {
                                Cancellation(requested = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CompletedCancellation>())?.let {
                                Cancellation(completed = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<DeniedCancellation>())?.let {
                                Cancellation(denied = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Cancellation(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Cancellation>(Cancellation::class) {

            override fun serialize(
                value: Cancellation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.requested != null -> generator.writeObject(value.requested)
                    value.completed != null -> generator.writeObject(value.completed)
                    value.denied != null -> generator.writeObject(value.denied)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Cancellation")
                }
            }
        }

        class RequestedCancellation
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val checkoutIntentId: JsonField<String>,
            private val createdAt: JsonField<OffsetDateTime>,
            private val marketplaceOrderId: JsonField<String>,
            private val reason: JsonField<Reason>,
            private val state: JsonField<State>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("checkoutIntentId")
                @ExcludeMissing
                checkoutIntentId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("createdAt")
                @ExcludeMissing
                createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("marketplaceOrderId")
                @ExcludeMissing
                marketplaceOrderId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
            ) : this(
                id,
                checkoutIntentId,
                createdAt,
                marketplaceOrderId,
                reason,
                state,
                mutableMapOf(),
            )

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
            fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun marketplaceOrderId(): String = marketplaceOrderId.getRequired("marketplaceOrderId")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun reason(): Reason = reason.getRequired("reason")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
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
             * Returns the raw JSON value of [checkoutIntentId].
             *
             * Unlike [checkoutIntentId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("checkoutIntentId")
            @ExcludeMissing
            fun _checkoutIntentId(): JsonField<String> = checkoutIntentId

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("createdAt")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [marketplaceOrderId].
             *
             * Unlike [marketplaceOrderId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("marketplaceOrderId")
            @ExcludeMissing
            fun _marketplaceOrderId(): JsonField<String> = marketplaceOrderId

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

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
                 * [RequestedCancellation].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .checkoutIntentId()
                 * .createdAt()
                 * .marketplaceOrderId()
                 * .reason()
                 * .state()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RequestedCancellation]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var checkoutIntentId: JsonField<String>? = null
                private var createdAt: JsonField<OffsetDateTime>? = null
                private var marketplaceOrderId: JsonField<String>? = null
                private var reason: JsonField<Reason>? = null
                private var state: JsonField<State>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(requestedCancellation: RequestedCancellation) = apply {
                    id = requestedCancellation.id
                    checkoutIntentId = requestedCancellation.checkoutIntentId
                    createdAt = requestedCancellation.createdAt
                    marketplaceOrderId = requestedCancellation.marketplaceOrderId
                    reason = requestedCancellation.reason
                    state = requestedCancellation.state
                    additionalProperties = requestedCancellation.additionalProperties.toMutableMap()
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

                fun checkoutIntentId(checkoutIntentId: String) =
                    checkoutIntentId(JsonField.of(checkoutIntentId))

                /**
                 * Sets [Builder.checkoutIntentId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.checkoutIntentId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun checkoutIntentId(checkoutIntentId: JsonField<String>) = apply {
                    this.checkoutIntentId = checkoutIntentId
                }

                fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                    this.createdAt = createdAt
                }

                fun marketplaceOrderId(marketplaceOrderId: String) =
                    marketplaceOrderId(JsonField.of(marketplaceOrderId))

                /**
                 * Sets [Builder.marketplaceOrderId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.marketplaceOrderId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun marketplaceOrderId(marketplaceOrderId: JsonField<String>) = apply {
                    this.marketplaceOrderId = marketplaceOrderId
                }

                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /**
                 * Sets [Builder.reason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reason] with a well-typed [Reason] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                fun state(state: State) = state(JsonField.of(state))

                /**
                 * Sets [Builder.state] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.state] with a well-typed [State] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun state(state: JsonField<State>) = apply { this.state = state }

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
                 * Returns an immutable instance of [RequestedCancellation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .checkoutIntentId()
                 * .createdAt()
                 * .marketplaceOrderId()
                 * .reason()
                 * .state()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RequestedCancellation =
                    RequestedCancellation(
                        checkRequired("id", id),
                        checkRequired("checkoutIntentId", checkoutIntentId),
                        checkRequired("createdAt", createdAt),
                        checkRequired("marketplaceOrderId", marketplaceOrderId),
                        checkRequired("reason", reason),
                        checkRequired("state", state),
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): RequestedCancellation = apply {
                if (validated) {
                    return@apply
                }

                id()
                checkoutIntentId()
                createdAt()
                marketplaceOrderId()
                reason().validate()
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
                    (if (checkoutIntentId.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (marketplaceOrderId.asKnown().isPresent) 1 else 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (state.asKnown().getOrNull()?.validity() ?: 0)

            class Reason
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
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun code(): Code = code.getRequired("code")

                /**
                 * Optional free-text note explaining the cancellation, forwarded to the merchant
                 * when possible.
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun message(): Optional<String> = message.getOptional("message")

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of [Reason].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Reason]. */
                class Builder internal constructor() {

                    private var code: JsonField<Code>? = null
                    private var message: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(reason: Reason) = apply {
                        code = reason.code
                        message = reason.message
                        additionalProperties = reason.additionalProperties.toMutableMap()
                    }

                    fun code(code: Code) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [Code] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<Code>) = apply { this.code = code }

                    /**
                     * Optional free-text note explaining the cancellation, forwarded to the
                     * merchant when possible.
                     */
                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [Reason].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Reason =
                        Reason(
                            checkRequired("code", code),
                            message,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws CheckoutIntentsInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Reason = apply {
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

                class Code @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val REQUESTED_BY_CUSTOMER = of("requested_by_customer")

                        @JvmField val FRAUD = of("fraud")

                        @JvmField val INVENTORY = of("inventory")

                        @JvmField val PAYMENT_ISSUE = of("payment_issue")

                        @JvmField val STAFF_ERROR = of("staff_error")

                        @JvmField val OTHER = of("other")

                        @JvmStatic fun of(value: String) = Code(JsonField.of(value))
                    }

                    /** An enum containing [Code]'s known values. */
                    enum class Known {
                        REQUESTED_BY_CUSTOMER,
                        FRAUD,
                        INVENTORY,
                        PAYMENT_ISSUE,
                        STAFF_ERROR,
                        OTHER,
                    }

                    /**
                     * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Code] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        REQUESTED_BY_CUSTOMER,
                        FRAUD,
                        INVENTORY,
                        PAYMENT_ISSUE,
                        STAFF_ERROR,
                        OTHER,
                        /**
                         * An enum member indicating that [Code] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            REQUESTED_BY_CUSTOMER -> Value.REQUESTED_BY_CUSTOMER
                            FRAUD -> Value.FRAUD
                            INVENTORY -> Value.INVENTORY
                            PAYMENT_ISSUE -> Value.PAYMENT_ISSUE
                            STAFF_ERROR -> Value.STAFF_ERROR
                            OTHER -> Value.OTHER
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            REQUESTED_BY_CUSTOMER -> Known.REQUESTED_BY_CUSTOMER
                            FRAUD -> Known.FRAUD
                            INVENTORY -> Known.INVENTORY
                            PAYMENT_ISSUE -> Known.PAYMENT_ISSUE
                            STAFF_ERROR -> Known.STAFF_ERROR
                            OTHER -> Known.OTHER
                            else ->
                                throw CheckoutIntentsInvalidDataException("Unknown Code: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value
                     *   does not have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            CheckoutIntentsInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws CheckoutIntentsInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                    return other is Reason &&
                        code == other.code &&
                        message == other.message &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Reason{code=$code, message=$message, additionalProperties=$additionalProperties}"
            }

            class State @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val REQUESTED = of("requested")

                    @JvmStatic fun of(value: String) = State(JsonField.of(value))
                }

                /** An enum containing [State]'s known values. */
                enum class Known {
                    REQUESTED
                }

                /**
                 * An enum containing [State]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [State] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    REQUESTED,
                    /**
                     * An enum member indicating that [State] was instantiated with an unknown
                     * value.
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
                        REQUESTED -> Value.REQUESTED
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
                        REQUESTED -> Known.REQUESTED
                        else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws CheckoutIntentsInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
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

                return other is RequestedCancellation &&
                    id == other.id &&
                    checkoutIntentId == other.checkoutIntentId &&
                    createdAt == other.createdAt &&
                    marketplaceOrderId == other.marketplaceOrderId &&
                    reason == other.reason &&
                    state == other.state &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    checkoutIntentId,
                    createdAt,
                    marketplaceOrderId,
                    reason,
                    state,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RequestedCancellation{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, marketplaceOrderId=$marketplaceOrderId, reason=$reason, state=$state, additionalProperties=$additionalProperties}"
        }

        class CompletedCancellation
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val checkoutIntentId: JsonField<String>,
            private val createdAt: JsonField<OffsetDateTime>,
            private val marketplaceOrderId: JsonField<String>,
            private val reason: JsonField<Reason>,
            private val state: JsonField<State>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("checkoutIntentId")
                @ExcludeMissing
                checkoutIntentId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("createdAt")
                @ExcludeMissing
                createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("marketplaceOrderId")
                @ExcludeMissing
                marketplaceOrderId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
            ) : this(
                id,
                checkoutIntentId,
                createdAt,
                marketplaceOrderId,
                reason,
                state,
                mutableMapOf(),
            )

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
            fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun marketplaceOrderId(): String = marketplaceOrderId.getRequired("marketplaceOrderId")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun reason(): Reason = reason.getRequired("reason")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
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
             * Returns the raw JSON value of [checkoutIntentId].
             *
             * Unlike [checkoutIntentId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("checkoutIntentId")
            @ExcludeMissing
            fun _checkoutIntentId(): JsonField<String> = checkoutIntentId

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("createdAt")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [marketplaceOrderId].
             *
             * Unlike [marketplaceOrderId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("marketplaceOrderId")
            @ExcludeMissing
            fun _marketplaceOrderId(): JsonField<String> = marketplaceOrderId

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

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
                 * [CompletedCancellation].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .checkoutIntentId()
                 * .createdAt()
                 * .marketplaceOrderId()
                 * .reason()
                 * .state()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CompletedCancellation]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var checkoutIntentId: JsonField<String>? = null
                private var createdAt: JsonField<OffsetDateTime>? = null
                private var marketplaceOrderId: JsonField<String>? = null
                private var reason: JsonField<Reason>? = null
                private var state: JsonField<State>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(completedCancellation: CompletedCancellation) = apply {
                    id = completedCancellation.id
                    checkoutIntentId = completedCancellation.checkoutIntentId
                    createdAt = completedCancellation.createdAt
                    marketplaceOrderId = completedCancellation.marketplaceOrderId
                    reason = completedCancellation.reason
                    state = completedCancellation.state
                    additionalProperties = completedCancellation.additionalProperties.toMutableMap()
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

                fun checkoutIntentId(checkoutIntentId: String) =
                    checkoutIntentId(JsonField.of(checkoutIntentId))

                /**
                 * Sets [Builder.checkoutIntentId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.checkoutIntentId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun checkoutIntentId(checkoutIntentId: JsonField<String>) = apply {
                    this.checkoutIntentId = checkoutIntentId
                }

                fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                    this.createdAt = createdAt
                }

                fun marketplaceOrderId(marketplaceOrderId: String) =
                    marketplaceOrderId(JsonField.of(marketplaceOrderId))

                /**
                 * Sets [Builder.marketplaceOrderId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.marketplaceOrderId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun marketplaceOrderId(marketplaceOrderId: JsonField<String>) = apply {
                    this.marketplaceOrderId = marketplaceOrderId
                }

                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /**
                 * Sets [Builder.reason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reason] with a well-typed [Reason] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                fun state(state: State) = state(JsonField.of(state))

                /**
                 * Sets [Builder.state] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.state] with a well-typed [State] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun state(state: JsonField<State>) = apply { this.state = state }

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
                 * Returns an immutable instance of [CompletedCancellation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .checkoutIntentId()
                 * .createdAt()
                 * .marketplaceOrderId()
                 * .reason()
                 * .state()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CompletedCancellation =
                    CompletedCancellation(
                        checkRequired("id", id),
                        checkRequired("checkoutIntentId", checkoutIntentId),
                        checkRequired("createdAt", createdAt),
                        checkRequired("marketplaceOrderId", marketplaceOrderId),
                        checkRequired("reason", reason),
                        checkRequired("state", state),
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): CompletedCancellation = apply {
                if (validated) {
                    return@apply
                }

                id()
                checkoutIntentId()
                createdAt()
                marketplaceOrderId()
                reason().validate()
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
                    (if (checkoutIntentId.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (marketplaceOrderId.asKnown().isPresent) 1 else 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (state.asKnown().getOrNull()?.validity() ?: 0)

            class Reason
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
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun code(): Code = code.getRequired("code")

                /**
                 * Optional free-text note explaining the cancellation, forwarded to the merchant
                 * when possible.
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun message(): Optional<String> = message.getOptional("message")

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of [Reason].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Reason]. */
                class Builder internal constructor() {

                    private var code: JsonField<Code>? = null
                    private var message: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(reason: Reason) = apply {
                        code = reason.code
                        message = reason.message
                        additionalProperties = reason.additionalProperties.toMutableMap()
                    }

                    fun code(code: Code) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [Code] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<Code>) = apply { this.code = code }

                    /**
                     * Optional free-text note explaining the cancellation, forwarded to the
                     * merchant when possible.
                     */
                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [Reason].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Reason =
                        Reason(
                            checkRequired("code", code),
                            message,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws CheckoutIntentsInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Reason = apply {
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

                class Code @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val REQUESTED_BY_CUSTOMER = of("requested_by_customer")

                        @JvmField val FRAUD = of("fraud")

                        @JvmField val INVENTORY = of("inventory")

                        @JvmField val PAYMENT_ISSUE = of("payment_issue")

                        @JvmField val STAFF_ERROR = of("staff_error")

                        @JvmField val OTHER = of("other")

                        @JvmStatic fun of(value: String) = Code(JsonField.of(value))
                    }

                    /** An enum containing [Code]'s known values. */
                    enum class Known {
                        REQUESTED_BY_CUSTOMER,
                        FRAUD,
                        INVENTORY,
                        PAYMENT_ISSUE,
                        STAFF_ERROR,
                        OTHER,
                    }

                    /**
                     * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Code] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        REQUESTED_BY_CUSTOMER,
                        FRAUD,
                        INVENTORY,
                        PAYMENT_ISSUE,
                        STAFF_ERROR,
                        OTHER,
                        /**
                         * An enum member indicating that [Code] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            REQUESTED_BY_CUSTOMER -> Value.REQUESTED_BY_CUSTOMER
                            FRAUD -> Value.FRAUD
                            INVENTORY -> Value.INVENTORY
                            PAYMENT_ISSUE -> Value.PAYMENT_ISSUE
                            STAFF_ERROR -> Value.STAFF_ERROR
                            OTHER -> Value.OTHER
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            REQUESTED_BY_CUSTOMER -> Known.REQUESTED_BY_CUSTOMER
                            FRAUD -> Known.FRAUD
                            INVENTORY -> Known.INVENTORY
                            PAYMENT_ISSUE -> Known.PAYMENT_ISSUE
                            STAFF_ERROR -> Known.STAFF_ERROR
                            OTHER -> Known.OTHER
                            else ->
                                throw CheckoutIntentsInvalidDataException("Unknown Code: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value
                     *   does not have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            CheckoutIntentsInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws CheckoutIntentsInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                    return other is Reason &&
                        code == other.code &&
                        message == other.message &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Reason{code=$code, message=$message, additionalProperties=$additionalProperties}"
            }

            class State @JsonCreator private constructor(private val value: JsonField<String>) :
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
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    COMPLETED,
                    /**
                     * An enum member indicating that [State] was instantiated with an unknown
                     * value.
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
                        COMPLETED -> Value.COMPLETED
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
                        COMPLETED -> Known.COMPLETED
                        else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws CheckoutIntentsInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
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

                return other is CompletedCancellation &&
                    id == other.id &&
                    checkoutIntentId == other.checkoutIntentId &&
                    createdAt == other.createdAt &&
                    marketplaceOrderId == other.marketplaceOrderId &&
                    reason == other.reason &&
                    state == other.state &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    checkoutIntentId,
                    createdAt,
                    marketplaceOrderId,
                    reason,
                    state,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CompletedCancellation{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, marketplaceOrderId=$marketplaceOrderId, reason=$reason, state=$state, additionalProperties=$additionalProperties}"
        }

        class DeniedCancellation
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val checkoutIntentId: JsonField<String>,
            private val createdAt: JsonField<OffsetDateTime>,
            private val denialReason: JsonField<DenialReason>,
            private val marketplaceOrderId: JsonField<String>,
            private val reason: JsonField<Reason>,
            private val state: JsonField<State>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("checkoutIntentId")
                @ExcludeMissing
                checkoutIntentId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("createdAt")
                @ExcludeMissing
                createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("denialReason")
                @ExcludeMissing
                denialReason: JsonField<DenialReason> = JsonMissing.of(),
                @JsonProperty("marketplaceOrderId")
                @ExcludeMissing
                marketplaceOrderId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("state") @ExcludeMissing state: JsonField<State> = JsonMissing.of(),
            ) : this(
                id,
                checkoutIntentId,
                createdAt,
                denialReason,
                marketplaceOrderId,
                reason,
                state,
                mutableMapOf(),
            )

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
            fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun denialReason(): DenialReason = denialReason.getRequired("denialReason")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun marketplaceOrderId(): String = marketplaceOrderId.getRequired("marketplaceOrderId")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun reason(): Reason = reason.getRequired("reason")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
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
             * Returns the raw JSON value of [checkoutIntentId].
             *
             * Unlike [checkoutIntentId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("checkoutIntentId")
            @ExcludeMissing
            fun _checkoutIntentId(): JsonField<String> = checkoutIntentId

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("createdAt")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [denialReason].
             *
             * Unlike [denialReason], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("denialReason")
            @ExcludeMissing
            fun _denialReason(): JsonField<DenialReason> = denialReason

            /**
             * Returns the raw JSON value of [marketplaceOrderId].
             *
             * Unlike [marketplaceOrderId], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("marketplaceOrderId")
            @ExcludeMissing
            fun _marketplaceOrderId(): JsonField<String> = marketplaceOrderId

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

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
                 * Returns a mutable builder for constructing an instance of [DeniedCancellation].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .checkoutIntentId()
                 * .createdAt()
                 * .denialReason()
                 * .marketplaceOrderId()
                 * .reason()
                 * .state()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DeniedCancellation]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var checkoutIntentId: JsonField<String>? = null
                private var createdAt: JsonField<OffsetDateTime>? = null
                private var denialReason: JsonField<DenialReason>? = null
                private var marketplaceOrderId: JsonField<String>? = null
                private var reason: JsonField<Reason>? = null
                private var state: JsonField<State>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(deniedCancellation: DeniedCancellation) = apply {
                    id = deniedCancellation.id
                    checkoutIntentId = deniedCancellation.checkoutIntentId
                    createdAt = deniedCancellation.createdAt
                    denialReason = deniedCancellation.denialReason
                    marketplaceOrderId = deniedCancellation.marketplaceOrderId
                    reason = deniedCancellation.reason
                    state = deniedCancellation.state
                    additionalProperties = deniedCancellation.additionalProperties.toMutableMap()
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

                fun checkoutIntentId(checkoutIntentId: String) =
                    checkoutIntentId(JsonField.of(checkoutIntentId))

                /**
                 * Sets [Builder.checkoutIntentId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.checkoutIntentId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun checkoutIntentId(checkoutIntentId: JsonField<String>) = apply {
                    this.checkoutIntentId = checkoutIntentId
                }

                fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                    this.createdAt = createdAt
                }

                fun denialReason(denialReason: DenialReason) =
                    denialReason(JsonField.of(denialReason))

                /**
                 * Sets [Builder.denialReason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.denialReason] with a well-typed [DenialReason]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun denialReason(denialReason: JsonField<DenialReason>) = apply {
                    this.denialReason = denialReason
                }

                fun marketplaceOrderId(marketplaceOrderId: String) =
                    marketplaceOrderId(JsonField.of(marketplaceOrderId))

                /**
                 * Sets [Builder.marketplaceOrderId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.marketplaceOrderId] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun marketplaceOrderId(marketplaceOrderId: JsonField<String>) = apply {
                    this.marketplaceOrderId = marketplaceOrderId
                }

                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /**
                 * Sets [Builder.reason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reason] with a well-typed [Reason] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                fun state(state: State) = state(JsonField.of(state))

                /**
                 * Sets [Builder.state] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.state] with a well-typed [State] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun state(state: JsonField<State>) = apply { this.state = state }

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
                 * Returns an immutable instance of [DeniedCancellation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .checkoutIntentId()
                 * .createdAt()
                 * .denialReason()
                 * .marketplaceOrderId()
                 * .reason()
                 * .state()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): DeniedCancellation =
                    DeniedCancellation(
                        checkRequired("id", id),
                        checkRequired("checkoutIntentId", checkoutIntentId),
                        checkRequired("createdAt", createdAt),
                        checkRequired("denialReason", denialReason),
                        checkRequired("marketplaceOrderId", marketplaceOrderId),
                        checkRequired("reason", reason),
                        checkRequired("state", state),
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): DeniedCancellation = apply {
                if (validated) {
                    return@apply
                }

                id()
                checkoutIntentId()
                createdAt()
                denialReason().validate()
                marketplaceOrderId()
                reason().validate()
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
                    (if (checkoutIntentId.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (denialReason.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (marketplaceOrderId.asKnown().isPresent) 1 else 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (state.asKnown().getOrNull()?.validity() ?: 0)

            class DenialReason
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
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun code(): Code = code.getRequired("code")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun message(): String = message.getRequired("message")

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of [DenialReason].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * .message()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [DenialReason]. */
                class Builder internal constructor() {

                    private var code: JsonField<Code>? = null
                    private var message: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(denialReason: DenialReason) = apply {
                        code = denialReason.code
                        message = denialReason.message
                        additionalProperties = denialReason.additionalProperties.toMutableMap()
                    }

                    fun code(code: Code) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [Code] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<Code>) = apply { this.code = code }

                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [DenialReason].
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
                    fun build(): DenialReason =
                        DenialReason(
                            checkRequired("code", code),
                            checkRequired("message", message),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws CheckoutIntentsInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): DenialReason = apply {
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

                class Code @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val OTHER = of("other")

                        @JvmField val ALREADY_SHIPPED = of("already_shipped")

                        @JvmField val NON_CANCELLABLE_ITEM = of("non_cancellable_item")

                        @JvmField
                        val CANCELLATION_WINDOW_EXPIRED = of("cancellation_window_expired")

                        @JvmStatic fun of(value: String) = Code(JsonField.of(value))
                    }

                    /** An enum containing [Code]'s known values. */
                    enum class Known {
                        OTHER,
                        ALREADY_SHIPPED,
                        NON_CANCELLABLE_ITEM,
                        CANCELLATION_WINDOW_EXPIRED,
                    }

                    /**
                     * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Code] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        OTHER,
                        ALREADY_SHIPPED,
                        NON_CANCELLABLE_ITEM,
                        CANCELLATION_WINDOW_EXPIRED,
                        /**
                         * An enum member indicating that [Code] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            OTHER -> Value.OTHER
                            ALREADY_SHIPPED -> Value.ALREADY_SHIPPED
                            NON_CANCELLABLE_ITEM -> Value.NON_CANCELLABLE_ITEM
                            CANCELLATION_WINDOW_EXPIRED -> Value.CANCELLATION_WINDOW_EXPIRED
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            OTHER -> Known.OTHER
                            ALREADY_SHIPPED -> Known.ALREADY_SHIPPED
                            NON_CANCELLABLE_ITEM -> Known.NON_CANCELLABLE_ITEM
                            CANCELLATION_WINDOW_EXPIRED -> Known.CANCELLATION_WINDOW_EXPIRED
                            else ->
                                throw CheckoutIntentsInvalidDataException("Unknown Code: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value
                     *   does not have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            CheckoutIntentsInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws CheckoutIntentsInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                    return other is DenialReason &&
                        code == other.code &&
                        message == other.message &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "DenialReason{code=$code, message=$message, additionalProperties=$additionalProperties}"
            }

            class Reason
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
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun code(): Code = code.getRequired("code")

                /**
                 * Optional free-text note explaining the cancellation, forwarded to the merchant
                 * when possible.
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun message(): Optional<String> = message.getOptional("message")

                /**
                 * Returns the raw JSON value of [code].
                 *
                 * Unlike [code], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

                /**
                 * Returns the raw JSON value of [message].
                 *
                 * Unlike [message], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of [Reason].
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Reason]. */
                class Builder internal constructor() {

                    private var code: JsonField<Code>? = null
                    private var message: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(reason: Reason) = apply {
                        code = reason.code
                        message = reason.message
                        additionalProperties = reason.additionalProperties.toMutableMap()
                    }

                    fun code(code: Code) = code(JsonField.of(code))

                    /**
                     * Sets [Builder.code] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.code] with a well-typed [Code] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun code(code: JsonField<Code>) = apply { this.code = code }

                    /**
                     * Optional free-text note explaining the cancellation, forwarded to the
                     * merchant when possible.
                     */
                    fun message(message: String) = message(JsonField.of(message))

                    /**
                     * Sets [Builder.message] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.message] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [Reason].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .code()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Reason =
                        Reason(
                            checkRequired("code", code),
                            message,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws CheckoutIntentsInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Reason = apply {
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

                class Code @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val REQUESTED_BY_CUSTOMER = of("requested_by_customer")

                        @JvmField val FRAUD = of("fraud")

                        @JvmField val INVENTORY = of("inventory")

                        @JvmField val PAYMENT_ISSUE = of("payment_issue")

                        @JvmField val STAFF_ERROR = of("staff_error")

                        @JvmField val OTHER = of("other")

                        @JvmStatic fun of(value: String) = Code(JsonField.of(value))
                    }

                    /** An enum containing [Code]'s known values. */
                    enum class Known {
                        REQUESTED_BY_CUSTOMER,
                        FRAUD,
                        INVENTORY,
                        PAYMENT_ISSUE,
                        STAFF_ERROR,
                        OTHER,
                    }

                    /**
                     * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Code] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        REQUESTED_BY_CUSTOMER,
                        FRAUD,
                        INVENTORY,
                        PAYMENT_ISSUE,
                        STAFF_ERROR,
                        OTHER,
                        /**
                         * An enum member indicating that [Code] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            REQUESTED_BY_CUSTOMER -> Value.REQUESTED_BY_CUSTOMER
                            FRAUD -> Value.FRAUD
                            INVENTORY -> Value.INVENTORY
                            PAYMENT_ISSUE -> Value.PAYMENT_ISSUE
                            STAFF_ERROR -> Value.STAFF_ERROR
                            OTHER -> Value.OTHER
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            REQUESTED_BY_CUSTOMER -> Known.REQUESTED_BY_CUSTOMER
                            FRAUD -> Known.FRAUD
                            INVENTORY -> Known.INVENTORY
                            PAYMENT_ISSUE -> Known.PAYMENT_ISSUE
                            STAFF_ERROR -> Known.STAFF_ERROR
                            OTHER -> Known.OTHER
                            else ->
                                throw CheckoutIntentsInvalidDataException("Unknown Code: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws CheckoutIntentsInvalidDataException if this class instance's value
                     *   does not have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            CheckoutIntentsInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws CheckoutIntentsInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

                    return other is Reason &&
                        code == other.code &&
                        message == other.message &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(code, message, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Reason{code=$code, message=$message, additionalProperties=$additionalProperties}"
            }

            class State @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val DENIED = of("denied")

                    @JvmStatic fun of(value: String) = State(JsonField.of(value))
                }

                /** An enum containing [State]'s known values. */
                enum class Known {
                    DENIED
                }

                /**
                 * An enum containing [State]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [State] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    DENIED,
                    /**
                     * An enum member indicating that [State] was instantiated with an unknown
                     * value.
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
                        DENIED -> Value.DENIED
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
                        DENIED -> Known.DENIED
                        else -> throw CheckoutIntentsInvalidDataException("Unknown State: $value")
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

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws CheckoutIntentsInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
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

                return other is DeniedCancellation &&
                    id == other.id &&
                    checkoutIntentId == other.checkoutIntentId &&
                    createdAt == other.createdAt &&
                    denialReason == other.denialReason &&
                    marketplaceOrderId == other.marketplaceOrderId &&
                    reason == other.reason &&
                    state == other.state &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    checkoutIntentId,
                    createdAt,
                    denialReason,
                    marketplaceOrderId,
                    reason,
                    state,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "DeniedCancellation{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, denialReason=$denialReason, marketplaceOrderId=$marketplaceOrderId, reason=$reason, state=$state, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Order &&
            id == other.id &&
            cancellation == other.cancellation &&
            checkoutIntentId == other.checkoutIntentId &&
            createdAt == other.createdAt &&
            updatedAt == other.updatedAt &&
            referenceId == other.referenceId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            cancellation,
            checkoutIntentId,
            createdAt,
            updatedAt,
            referenceId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Order{id=$id, cancellation=$cancellation, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, updatedAt=$updatedAt, referenceId=$referenceId, additionalProperties=$additionalProperties}"
}
