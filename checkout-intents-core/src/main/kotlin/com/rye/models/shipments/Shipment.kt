// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

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

@JsonDeserialize(using = Shipment.Deserializer::class)
@JsonSerialize(using = Shipment.Serializer::class)
class Shipment
private constructor(
    private val withStatusBaseShipmentWithTrackingShipped:
        WithStatusBaseShipmentWithTrackingShipped? =
        null,
    private val delivered: DeliveredShipment? = null,
    private val withStatusBaseShipmentWithTrackingDelayed:
        WithStatusBaseShipmentWithTrackingDelayed? =
        null,
    private val withStatusBaseShipmentWithTrackingOutForDelivery:
        WithStatusBaseShipmentWithTrackingOutForDelivery? =
        null,
    private val withStatusBaseShipmentOrdered: WithStatusBaseShipmentOrdered? = null,
    private val withStatusBaseShipmentCanceled: WithStatusBaseShipmentCanceled? = null,
    private val _json: JsonValue? = null,
) {

    fun withStatusBaseShipmentWithTrackingShipped():
        Optional<WithStatusBaseShipmentWithTrackingShipped> =
        Optional.ofNullable(withStatusBaseShipmentWithTrackingShipped)

    fun delivered(): Optional<DeliveredShipment> = Optional.ofNullable(delivered)

    fun withStatusBaseShipmentWithTrackingDelayed():
        Optional<WithStatusBaseShipmentWithTrackingDelayed> =
        Optional.ofNullable(withStatusBaseShipmentWithTrackingDelayed)

    fun withStatusBaseShipmentWithTrackingOutForDelivery():
        Optional<WithStatusBaseShipmentWithTrackingOutForDelivery> =
        Optional.ofNullable(withStatusBaseShipmentWithTrackingOutForDelivery)

    fun withStatusBaseShipmentOrdered(): Optional<WithStatusBaseShipmentOrdered> =
        Optional.ofNullable(withStatusBaseShipmentOrdered)

    fun withStatusBaseShipmentCanceled(): Optional<WithStatusBaseShipmentCanceled> =
        Optional.ofNullable(withStatusBaseShipmentCanceled)

    fun isWithStatusBaseShipmentWithTrackingShipped(): Boolean =
        withStatusBaseShipmentWithTrackingShipped != null

    fun isDelivered(): Boolean = delivered != null

    fun isWithStatusBaseShipmentWithTrackingDelayed(): Boolean =
        withStatusBaseShipmentWithTrackingDelayed != null

    fun isWithStatusBaseShipmentWithTrackingOutForDelivery(): Boolean =
        withStatusBaseShipmentWithTrackingOutForDelivery != null

    fun isWithStatusBaseShipmentOrdered(): Boolean = withStatusBaseShipmentOrdered != null

    fun isWithStatusBaseShipmentCanceled(): Boolean = withStatusBaseShipmentCanceled != null

    fun asWithStatusBaseShipmentWithTrackingShipped(): WithStatusBaseShipmentWithTrackingShipped =
        withStatusBaseShipmentWithTrackingShipped.getOrThrow(
            "withStatusBaseShipmentWithTrackingShipped"
        )

    fun asDelivered(): DeliveredShipment = delivered.getOrThrow("delivered")

    fun asWithStatusBaseShipmentWithTrackingDelayed(): WithStatusBaseShipmentWithTrackingDelayed =
        withStatusBaseShipmentWithTrackingDelayed.getOrThrow(
            "withStatusBaseShipmentWithTrackingDelayed"
        )

    fun asWithStatusBaseShipmentWithTrackingOutForDelivery():
        WithStatusBaseShipmentWithTrackingOutForDelivery =
        withStatusBaseShipmentWithTrackingOutForDelivery.getOrThrow(
            "withStatusBaseShipmentWithTrackingOutForDelivery"
        )

    fun asWithStatusBaseShipmentOrdered(): WithStatusBaseShipmentOrdered =
        withStatusBaseShipmentOrdered.getOrThrow("withStatusBaseShipmentOrdered")

    fun asWithStatusBaseShipmentCanceled(): WithStatusBaseShipmentCanceled =
        withStatusBaseShipmentCanceled.getOrThrow("withStatusBaseShipmentCanceled")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            withStatusBaseShipmentWithTrackingShipped != null ->
                visitor.visitWithStatusBaseShipmentWithTrackingShipped(
                    withStatusBaseShipmentWithTrackingShipped
                )
            delivered != null -> visitor.visitDelivered(delivered)
            withStatusBaseShipmentWithTrackingDelayed != null ->
                visitor.visitWithStatusBaseShipmentWithTrackingDelayed(
                    withStatusBaseShipmentWithTrackingDelayed
                )
            withStatusBaseShipmentWithTrackingOutForDelivery != null ->
                visitor.visitWithStatusBaseShipmentWithTrackingOutForDelivery(
                    withStatusBaseShipmentWithTrackingOutForDelivery
                )
            withStatusBaseShipmentOrdered != null ->
                visitor.visitWithStatusBaseShipmentOrdered(withStatusBaseShipmentOrdered)
            withStatusBaseShipmentCanceled != null ->
                visitor.visitWithStatusBaseShipmentCanceled(withStatusBaseShipmentCanceled)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): Shipment = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitWithStatusBaseShipmentWithTrackingShipped(
                    withStatusBaseShipmentWithTrackingShipped:
                        WithStatusBaseShipmentWithTrackingShipped
                ) {
                    withStatusBaseShipmentWithTrackingShipped.validate()
                }

                override fun visitDelivered(delivered: DeliveredShipment) {
                    delivered.validate()
                }

                override fun visitWithStatusBaseShipmentWithTrackingDelayed(
                    withStatusBaseShipmentWithTrackingDelayed:
                        WithStatusBaseShipmentWithTrackingDelayed
                ) {
                    withStatusBaseShipmentWithTrackingDelayed.validate()
                }

                override fun visitWithStatusBaseShipmentWithTrackingOutForDelivery(
                    withStatusBaseShipmentWithTrackingOutForDelivery:
                        WithStatusBaseShipmentWithTrackingOutForDelivery
                ) {
                    withStatusBaseShipmentWithTrackingOutForDelivery.validate()
                }

                override fun visitWithStatusBaseShipmentOrdered(
                    withStatusBaseShipmentOrdered: WithStatusBaseShipmentOrdered
                ) {
                    withStatusBaseShipmentOrdered.validate()
                }

                override fun visitWithStatusBaseShipmentCanceled(
                    withStatusBaseShipmentCanceled: WithStatusBaseShipmentCanceled
                ) {
                    withStatusBaseShipmentCanceled.validate()
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
                override fun visitWithStatusBaseShipmentWithTrackingShipped(
                    withStatusBaseShipmentWithTrackingShipped:
                        WithStatusBaseShipmentWithTrackingShipped
                ) = withStatusBaseShipmentWithTrackingShipped.validity()

                override fun visitDelivered(delivered: DeliveredShipment) = delivered.validity()

                override fun visitWithStatusBaseShipmentWithTrackingDelayed(
                    withStatusBaseShipmentWithTrackingDelayed:
                        WithStatusBaseShipmentWithTrackingDelayed
                ) = withStatusBaseShipmentWithTrackingDelayed.validity()

                override fun visitWithStatusBaseShipmentWithTrackingOutForDelivery(
                    withStatusBaseShipmentWithTrackingOutForDelivery:
                        WithStatusBaseShipmentWithTrackingOutForDelivery
                ) = withStatusBaseShipmentWithTrackingOutForDelivery.validity()

                override fun visitWithStatusBaseShipmentOrdered(
                    withStatusBaseShipmentOrdered: WithStatusBaseShipmentOrdered
                ) = withStatusBaseShipmentOrdered.validity()

                override fun visitWithStatusBaseShipmentCanceled(
                    withStatusBaseShipmentCanceled: WithStatusBaseShipmentCanceled
                ) = withStatusBaseShipmentCanceled.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Shipment &&
            withStatusBaseShipmentWithTrackingShipped ==
                other.withStatusBaseShipmentWithTrackingShipped &&
            delivered == other.delivered &&
            withStatusBaseShipmentWithTrackingDelayed ==
                other.withStatusBaseShipmentWithTrackingDelayed &&
            withStatusBaseShipmentWithTrackingOutForDelivery ==
                other.withStatusBaseShipmentWithTrackingOutForDelivery &&
            withStatusBaseShipmentOrdered == other.withStatusBaseShipmentOrdered &&
            withStatusBaseShipmentCanceled == other.withStatusBaseShipmentCanceled
    }

    override fun hashCode(): Int =
        Objects.hash(
            withStatusBaseShipmentWithTrackingShipped,
            delivered,
            withStatusBaseShipmentWithTrackingDelayed,
            withStatusBaseShipmentWithTrackingOutForDelivery,
            withStatusBaseShipmentOrdered,
            withStatusBaseShipmentCanceled,
        )

    override fun toString(): String =
        when {
            withStatusBaseShipmentWithTrackingShipped != null ->
                "Shipment{withStatusBaseShipmentWithTrackingShipped=$withStatusBaseShipmentWithTrackingShipped}"
            delivered != null -> "Shipment{delivered=$delivered}"
            withStatusBaseShipmentWithTrackingDelayed != null ->
                "Shipment{withStatusBaseShipmentWithTrackingDelayed=$withStatusBaseShipmentWithTrackingDelayed}"
            withStatusBaseShipmentWithTrackingOutForDelivery != null ->
                "Shipment{withStatusBaseShipmentWithTrackingOutForDelivery=$withStatusBaseShipmentWithTrackingOutForDelivery}"
            withStatusBaseShipmentOrdered != null ->
                "Shipment{withStatusBaseShipmentOrdered=$withStatusBaseShipmentOrdered}"
            withStatusBaseShipmentCanceled != null ->
                "Shipment{withStatusBaseShipmentCanceled=$withStatusBaseShipmentCanceled}"
            _json != null -> "Shipment{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Shipment")
        }

    companion object {

        @JvmStatic
        fun ofWithStatusBaseShipmentWithTrackingShipped(
            withStatusBaseShipmentWithTrackingShipped: WithStatusBaseShipmentWithTrackingShipped
        ) =
            Shipment(
                withStatusBaseShipmentWithTrackingShipped =
                    withStatusBaseShipmentWithTrackingShipped
            )

        @JvmStatic fun ofDelivered(delivered: DeliveredShipment) = Shipment(delivered = delivered)

        @JvmStatic
        fun ofWithStatusBaseShipmentWithTrackingDelayed(
            withStatusBaseShipmentWithTrackingDelayed: WithStatusBaseShipmentWithTrackingDelayed
        ) =
            Shipment(
                withStatusBaseShipmentWithTrackingDelayed =
                    withStatusBaseShipmentWithTrackingDelayed
            )

        @JvmStatic
        fun ofWithStatusBaseShipmentWithTrackingOutForDelivery(
            withStatusBaseShipmentWithTrackingOutForDelivery:
                WithStatusBaseShipmentWithTrackingOutForDelivery
        ) =
            Shipment(
                withStatusBaseShipmentWithTrackingOutForDelivery =
                    withStatusBaseShipmentWithTrackingOutForDelivery
            )

        @JvmStatic
        fun ofWithStatusBaseShipmentOrdered(
            withStatusBaseShipmentOrdered: WithStatusBaseShipmentOrdered
        ) = Shipment(withStatusBaseShipmentOrdered = withStatusBaseShipmentOrdered)

        @JvmStatic
        fun ofWithStatusBaseShipmentCanceled(
            withStatusBaseShipmentCanceled: WithStatusBaseShipmentCanceled
        ) = Shipment(withStatusBaseShipmentCanceled = withStatusBaseShipmentCanceled)
    }

    /** An interface that defines how to map each variant of [Shipment] to a value of type [T]. */
    interface Visitor<out T> {

        fun visitWithStatusBaseShipmentWithTrackingShipped(
            withStatusBaseShipmentWithTrackingShipped: WithStatusBaseShipmentWithTrackingShipped
        ): T

        fun visitDelivered(delivered: DeliveredShipment): T

        fun visitWithStatusBaseShipmentWithTrackingDelayed(
            withStatusBaseShipmentWithTrackingDelayed: WithStatusBaseShipmentWithTrackingDelayed
        ): T

        fun visitWithStatusBaseShipmentWithTrackingOutForDelivery(
            withStatusBaseShipmentWithTrackingOutForDelivery:
                WithStatusBaseShipmentWithTrackingOutForDelivery
        ): T

        fun visitWithStatusBaseShipmentOrdered(
            withStatusBaseShipmentOrdered: WithStatusBaseShipmentOrdered
        ): T

        fun visitWithStatusBaseShipmentCanceled(
            withStatusBaseShipmentCanceled: WithStatusBaseShipmentCanceled
        ): T

        /**
         * Maps an unknown variant of [Shipment] to a value of type [T].
         *
         * An instance of [Shipment] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws CheckoutIntentsInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw CheckoutIntentsInvalidDataException("Unknown Shipment: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Shipment>(Shipment::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Shipment {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(
                                node,
                                jacksonTypeRef<WithStatusBaseShipmentWithTrackingShipped>(),
                            )
                            ?.let {
                                Shipment(
                                    withStatusBaseShipmentWithTrackingShipped = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<DeliveredShipment>())?.let {
                            Shipment(delivered = it, _json = json)
                        },
                        tryDeserialize(
                                node,
                                jacksonTypeRef<WithStatusBaseShipmentWithTrackingDelayed>(),
                            )
                            ?.let {
                                Shipment(
                                    withStatusBaseShipmentWithTrackingDelayed = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(
                                node,
                                jacksonTypeRef<WithStatusBaseShipmentWithTrackingOutForDelivery>(),
                            )
                            ?.let {
                                Shipment(
                                    withStatusBaseShipmentWithTrackingOutForDelivery = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<WithStatusBaseShipmentOrdered>())?.let {
                            Shipment(withStatusBaseShipmentOrdered = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<WithStatusBaseShipmentCanceled>())
                            ?.let { Shipment(withStatusBaseShipmentCanceled = it, _json = json) },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> Shipment(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<Shipment>(Shipment::class) {

        override fun serialize(
            value: Shipment,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.withStatusBaseShipmentWithTrackingShipped != null ->
                    generator.writeObject(value.withStatusBaseShipmentWithTrackingShipped)
                value.delivered != null -> generator.writeObject(value.delivered)
                value.withStatusBaseShipmentWithTrackingDelayed != null ->
                    generator.writeObject(value.withStatusBaseShipmentWithTrackingDelayed)
                value.withStatusBaseShipmentWithTrackingOutForDelivery != null ->
                    generator.writeObject(value.withStatusBaseShipmentWithTrackingOutForDelivery)
                value.withStatusBaseShipmentOrdered != null ->
                    generator.writeObject(value.withStatusBaseShipmentOrdered)
                value.withStatusBaseShipmentCanceled != null ->
                    generator.writeObject(value.withStatusBaseShipmentCanceled)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Shipment")
            }
        }
    }

    class WithStatusBaseShipmentWithTrackingShipped
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val checkoutIntentId: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val externalId: JsonField<String>,
        private val shippedAt: JsonField<OffsetDateTime>,
        private val status: JsonField<Status>,
        private val tracking: JsonField<ShipmentTracking>,
        private val trackingEvents: JsonField<List<TrackingEvent>>,
        private val updatedAt: JsonField<OffsetDateTime>,
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
            @JsonProperty("externalId")
            @ExcludeMissing
            externalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shippedAt")
            @ExcludeMissing
            shippedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("tracking")
            @ExcludeMissing
            tracking: JsonField<ShipmentTracking> = JsonMissing.of(),
            @JsonProperty("trackingEvents")
            @ExcludeMissing
            trackingEvents: JsonField<List<TrackingEvent>> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            id,
            checkoutIntentId,
            createdAt,
            externalId,
            shippedAt,
            status,
            tracking,
            trackingEvents,
            updatedAt,
            mutableMapOf(),
        )

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
        fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * The external ID is provided by the marketplace and matches the shipment to their system.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun externalId(): String = externalId.getRequired("externalId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun shippedAt(): OffsetDateTime = shippedAt.getRequired("shippedAt")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun tracking(): ShipmentTracking = tracking.getRequired("tracking")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun trackingEvents(): List<TrackingEvent> = trackingEvents.getRequired("trackingEvents")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [externalId].
         *
         * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("externalId")
        @ExcludeMissing
        fun _externalId(): JsonField<String> = externalId

        /**
         * Returns the raw JSON value of [shippedAt].
         *
         * Unlike [shippedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shippedAt")
        @ExcludeMissing
        fun _shippedAt(): JsonField<OffsetDateTime> = shippedAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [tracking].
         *
         * Unlike [tracking], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tracking")
        @ExcludeMissing
        fun _tracking(): JsonField<ShipmentTracking> = tracking

        /**
         * Returns the raw JSON value of [trackingEvents].
         *
         * Unlike [trackingEvents], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("trackingEvents")
        @ExcludeMissing
        fun _trackingEvents(): JsonField<List<TrackingEvent>> = trackingEvents

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * [WithStatusBaseShipmentWithTrackingShipped].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WithStatusBaseShipmentWithTrackingShipped]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var checkoutIntentId: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var externalId: JsonField<String>? = null
            private var shippedAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<Status>? = null
            private var tracking: JsonField<ShipmentTracking>? = null
            private var trackingEvents: JsonField<MutableList<TrackingEvent>>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                withStatusBaseShipmentWithTrackingShipped: WithStatusBaseShipmentWithTrackingShipped
            ) = apply {
                id = withStatusBaseShipmentWithTrackingShipped.id
                checkoutIntentId = withStatusBaseShipmentWithTrackingShipped.checkoutIntentId
                createdAt = withStatusBaseShipmentWithTrackingShipped.createdAt
                externalId = withStatusBaseShipmentWithTrackingShipped.externalId
                shippedAt = withStatusBaseShipmentWithTrackingShipped.shippedAt
                status = withStatusBaseShipmentWithTrackingShipped.status
                tracking = withStatusBaseShipmentWithTrackingShipped.tracking
                trackingEvents =
                    withStatusBaseShipmentWithTrackingShipped.trackingEvents.map {
                        it.toMutableList()
                    }
                updatedAt = withStatusBaseShipmentWithTrackingShipped.updatedAt
                additionalProperties =
                    withStatusBaseShipmentWithTrackingShipped.additionalProperties.toMutableMap()
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

            /**
             * The external ID is provided by the marketplace and matches the shipment to their
             * system.
             */
            fun externalId(externalId: String) = externalId(JsonField.of(externalId))

            /**
             * Sets [Builder.externalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.externalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun externalId(externalId: JsonField<String>) = apply { this.externalId = externalId }

            fun shippedAt(shippedAt: OffsetDateTime) = shippedAt(JsonField.of(shippedAt))

            /**
             * Sets [Builder.shippedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shippedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shippedAt(shippedAt: JsonField<OffsetDateTime>) = apply {
                this.shippedAt = shippedAt
            }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun tracking(tracking: ShipmentTracking) = tracking(JsonField.of(tracking))

            /**
             * Sets [Builder.tracking] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tracking] with a well-typed [ShipmentTracking] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tracking(tracking: JsonField<ShipmentTracking>) = apply { this.tracking = tracking }

            fun trackingEvents(trackingEvents: List<TrackingEvent>) =
                trackingEvents(JsonField.of(trackingEvents))

            /**
             * Sets [Builder.trackingEvents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.trackingEvents] with a well-typed
             * `List<TrackingEvent>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun trackingEvents(trackingEvents: JsonField<List<TrackingEvent>>) = apply {
                this.trackingEvents = trackingEvents.map { it.toMutableList() }
            }

            /**
             * Adds a single [TrackingEvent] to [trackingEvents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTrackingEvent(trackingEvent: TrackingEvent) = apply {
                trackingEvents =
                    (trackingEvents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("trackingEvents", it).add(trackingEvent)
                    }
            }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [WithStatusBaseShipmentWithTrackingShipped].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WithStatusBaseShipmentWithTrackingShipped =
                WithStatusBaseShipmentWithTrackingShipped(
                    checkRequired("id", id),
                    checkRequired("checkoutIntentId", checkoutIntentId),
                    checkRequired("createdAt", createdAt),
                    checkRequired("externalId", externalId),
                    checkRequired("shippedAt", shippedAt),
                    checkRequired("status", status),
                    checkRequired("tracking", tracking),
                    checkRequired("trackingEvents", trackingEvents).map { it.toImmutable() },
                    checkRequired("updatedAt", updatedAt),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WithStatusBaseShipmentWithTrackingShipped = apply {
            if (validated) {
                return@apply
            }

            id()
            checkoutIntentId()
            createdAt()
            externalId()
            shippedAt()
            status().validate()
            tracking().validate()
            trackingEvents().forEach { it.validate() }
            updatedAt()
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
                (if (externalId.asKnown().isPresent) 1 else 0) +
                (if (shippedAt.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (tracking.asKnown().getOrNull()?.validity() ?: 0) +
                (trackingEvents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val SHIPPED = of("shipped")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                SHIPPED
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SHIPPED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    SHIPPED -> Value.SHIPPED
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
                    SHIPPED -> Known.SHIPPED
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Status: $value")
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

            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class TrackingEvent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val description: JsonField<String>,
            private val location: JsonField<Location>,
            private val timestamp: JsonField<Timestamp>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("location")
                @ExcludeMissing
                location: JsonField<Location> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<Timestamp> = JsonMissing.of(),
            ) : this(description, location, timestamp, mutableMapOf())

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun location(): Location = location.getRequired("location")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun timestamp(): Optional<Timestamp> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [location].
             *
             * Unlike [location], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("location")
            @ExcludeMissing
            fun _location(): JsonField<Location> = location

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<Timestamp> = timestamp

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
                 * Returns a mutable builder for constructing an instance of [TrackingEvent].
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TrackingEvent]. */
            class Builder internal constructor() {

                private var description: JsonField<String>? = null
                private var location: JsonField<Location>? = null
                private var timestamp: JsonField<Timestamp>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(trackingEvent: TrackingEvent) = apply {
                    description = trackingEvent.description
                    location = trackingEvent.location
                    timestamp = trackingEvent.timestamp
                    additionalProperties = trackingEvent.additionalProperties.toMutableMap()
                }

                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun location(location: Location) = location(JsonField.of(location))

                /**
                 * Sets [Builder.location] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.location] with a well-typed [Location] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun location(location: JsonField<Location>) = apply { this.location = location }

                fun timestamp(timestamp: Timestamp?) = timestamp(JsonField.ofNullable(timestamp))

                /** Alias for calling [Builder.timestamp] with `timestamp.orElse(null)`. */
                fun timestamp(timestamp: Optional<Timestamp>) = timestamp(timestamp.getOrNull())

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [Timestamp] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timestamp(timestamp: JsonField<Timestamp>) = apply {
                    this.timestamp = timestamp
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
                 * Returns an immutable instance of [TrackingEvent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): TrackingEvent =
                    TrackingEvent(
                        checkRequired("description", description),
                        checkRequired("location", location),
                        checkRequired("timestamp", timestamp),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TrackingEvent = apply {
                if (validated) {
                    return@apply
                }

                description()
                location().validate()
                timestamp().ifPresent { it.validate() }
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
                (if (description.asKnown().isPresent) 1 else 0) +
                    (location.asKnown().getOrNull()?.validity() ?: 0) +
                    (timestamp.asKnown().getOrNull()?.validity() ?: 0)

            class Location
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val city: JsonField<String>,
                private val country: JsonField<String>,
                private val province: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("city")
                    @ExcludeMissing
                    city: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("country")
                    @ExcludeMissing
                    country: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("province")
                    @ExcludeMissing
                    province: JsonField<String> = JsonMissing.of(),
                ) : this(city, country, province, mutableMapOf())

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun city(): Optional<String> = city.getOptional("city")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun country(): Optional<String> = country.getOptional("country")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun province(): Optional<String> = province.getOptional("province")

                /**
                 * Returns the raw JSON value of [city].
                 *
                 * Unlike [city], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

                /**
                 * Returns the raw JSON value of [country].
                 *
                 * Unlike [country], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

                /**
                 * Returns the raw JSON value of [province].
                 *
                 * Unlike [province], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("province")
                @ExcludeMissing
                fun _province(): JsonField<String> = province

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

                    /** Returns a mutable builder for constructing an instance of [Location]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Location]. */
                class Builder internal constructor() {

                    private var city: JsonField<String> = JsonMissing.of()
                    private var country: JsonField<String> = JsonMissing.of()
                    private var province: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(location: Location) = apply {
                        city = location.city
                        country = location.country
                        province = location.province
                        additionalProperties = location.additionalProperties.toMutableMap()
                    }

                    fun city(city: String?) = city(JsonField.ofNullable(city))

                    /** Alias for calling [Builder.city] with `city.orElse(null)`. */
                    fun city(city: Optional<String>) = city(city.getOrNull())

                    /**
                     * Sets [Builder.city] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.city] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun city(city: JsonField<String>) = apply { this.city = city }

                    fun country(country: String?) = country(JsonField.ofNullable(country))

                    /** Alias for calling [Builder.country] with `country.orElse(null)`. */
                    fun country(country: Optional<String>) = country(country.getOrNull())

                    /**
                     * Sets [Builder.country] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.country] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun country(country: JsonField<String>) = apply { this.country = country }

                    fun province(province: String?) = province(JsonField.ofNullable(province))

                    /** Alias for calling [Builder.province] with `province.orElse(null)`. */
                    fun province(province: Optional<String>) = province(province.getOrNull())

                    /**
                     * Sets [Builder.province] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.province] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun province(province: JsonField<String>) = apply { this.province = province }

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
                     * Returns an immutable instance of [Location].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Location =
                        Location(city, country, province, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Location = apply {
                    if (validated) {
                        return@apply
                    }

                    city()
                    country()
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
                    (if (city.asKnown().isPresent) 1 else 0) +
                        (if (country.asKnown().isPresent) 1 else 0) +
                        (if (province.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Location &&
                        city == other.city &&
                        country == other.country &&
                        province == other.province &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(city, country, province, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Location{city=$city, country=$country, province=$province, additionalProperties=$additionalProperties}"
            }

            class Timestamp
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val local: JsonField<String>,
                private val utc: JsonField<OffsetDateTime>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("local")
                    @ExcludeMissing
                    local: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("utc")
                    @ExcludeMissing
                    utc: JsonField<OffsetDateTime> = JsonMissing.of(),
                ) : this(local, utc, mutableMapOf())

                /**
                 * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun local(): String = local.getRequired("local")

                /**
                 * UTC timestamp
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun utc(): OffsetDateTime = utc.getRequired("utc")

                /**
                 * Returns the raw JSON value of [local].
                 *
                 * Unlike [local], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("local") @ExcludeMissing fun _local(): JsonField<String> = local

                /**
                 * Returns the raw JSON value of [utc].
                 *
                 * Unlike [utc], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("utc") @ExcludeMissing fun _utc(): JsonField<OffsetDateTime> = utc

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
                     * Returns a mutable builder for constructing an instance of [Timestamp].
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Timestamp]. */
                class Builder internal constructor() {

                    private var local: JsonField<String>? = null
                    private var utc: JsonField<OffsetDateTime>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(timestamp: Timestamp) = apply {
                        local = timestamp.local
                        utc = timestamp.utc
                        additionalProperties = timestamp.additionalProperties.toMutableMap()
                    }

                    /**
                     * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                     */
                    fun local(local: String) = local(JsonField.of(local))

                    /**
                     * Sets [Builder.local] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.local] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun local(local: JsonField<String>) = apply { this.local = local }

                    /** UTC timestamp */
                    fun utc(utc: OffsetDateTime) = utc(JsonField.of(utc))

                    /**
                     * Sets [Builder.utc] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.utc] with a well-typed [OffsetDateTime]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun utc(utc: JsonField<OffsetDateTime>) = apply { this.utc = utc }

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
                     * Returns an immutable instance of [Timestamp].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Timestamp =
                        Timestamp(
                            checkRequired("local", local),
                            checkRequired("utc", utc),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Timestamp = apply {
                    if (validated) {
                        return@apply
                    }

                    local()
                    utc()
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
                    (if (local.asKnown().isPresent) 1 else 0) +
                        (if (utc.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Timestamp &&
                        local == other.local &&
                        utc == other.utc &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(local, utc, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Timestamp{local=$local, utc=$utc, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TrackingEvent &&
                    description == other.description &&
                    location == other.location &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(description, location, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TrackingEvent{description=$description, location=$location, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WithStatusBaseShipmentWithTrackingShipped &&
                id == other.id &&
                checkoutIntentId == other.checkoutIntentId &&
                createdAt == other.createdAt &&
                externalId == other.externalId &&
                shippedAt == other.shippedAt &&
                status == other.status &&
                tracking == other.tracking &&
                trackingEvents == other.trackingEvents &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                checkoutIntentId,
                createdAt,
                externalId,
                shippedAt,
                status,
                tracking,
                trackingEvents,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WithStatusBaseShipmentWithTrackingShipped{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, externalId=$externalId, shippedAt=$shippedAt, status=$status, tracking=$tracking, trackingEvents=$trackingEvents, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    class DeliveredShipment
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val checkoutIntentId: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val deliveredAt: JsonField<OffsetDateTime>,
        private val externalId: JsonField<String>,
        private val shippedAt: JsonField<OffsetDateTime>,
        private val status: JsonField<Status>,
        private val tracking: JsonField<ShipmentTracking>,
        private val trackingEvents: JsonField<List<TrackingEvent>>,
        private val updatedAt: JsonField<OffsetDateTime>,
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
            @JsonProperty("deliveredAt")
            @ExcludeMissing
            deliveredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("externalId")
            @ExcludeMissing
            externalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shippedAt")
            @ExcludeMissing
            shippedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("tracking")
            @ExcludeMissing
            tracking: JsonField<ShipmentTracking> = JsonMissing.of(),
            @JsonProperty("trackingEvents")
            @ExcludeMissing
            trackingEvents: JsonField<List<TrackingEvent>> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            id,
            checkoutIntentId,
            createdAt,
            deliveredAt,
            externalId,
            shippedAt,
            status,
            tracking,
            trackingEvents,
            updatedAt,
            mutableMapOf(),
        )

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
        fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

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
        fun deliveredAt(): OffsetDateTime = deliveredAt.getRequired("deliveredAt")

        /**
         * The external ID is provided by the marketplace and matches the shipment to their system.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun externalId(): String = externalId.getRequired("externalId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun shippedAt(): OffsetDateTime = shippedAt.getRequired("shippedAt")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun tracking(): ShipmentTracking = tracking.getRequired("tracking")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun trackingEvents(): List<TrackingEvent> = trackingEvents.getRequired("trackingEvents")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [deliveredAt].
         *
         * Unlike [deliveredAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("deliveredAt")
        @ExcludeMissing
        fun _deliveredAt(): JsonField<OffsetDateTime> = deliveredAt

        /**
         * Returns the raw JSON value of [externalId].
         *
         * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("externalId")
        @ExcludeMissing
        fun _externalId(): JsonField<String> = externalId

        /**
         * Returns the raw JSON value of [shippedAt].
         *
         * Unlike [shippedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shippedAt")
        @ExcludeMissing
        fun _shippedAt(): JsonField<OffsetDateTime> = shippedAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [tracking].
         *
         * Unlike [tracking], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tracking")
        @ExcludeMissing
        fun _tracking(): JsonField<ShipmentTracking> = tracking

        /**
         * Returns the raw JSON value of [trackingEvents].
         *
         * Unlike [trackingEvents], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("trackingEvents")
        @ExcludeMissing
        fun _trackingEvents(): JsonField<List<TrackingEvent>> = trackingEvents

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * Returns a mutable builder for constructing an instance of [DeliveredShipment].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .deliveredAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DeliveredShipment]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var checkoutIntentId: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var deliveredAt: JsonField<OffsetDateTime>? = null
            private var externalId: JsonField<String>? = null
            private var shippedAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<Status>? = null
            private var tracking: JsonField<ShipmentTracking>? = null
            private var trackingEvents: JsonField<MutableList<TrackingEvent>>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(deliveredShipment: DeliveredShipment) = apply {
                id = deliveredShipment.id
                checkoutIntentId = deliveredShipment.checkoutIntentId
                createdAt = deliveredShipment.createdAt
                deliveredAt = deliveredShipment.deliveredAt
                externalId = deliveredShipment.externalId
                shippedAt = deliveredShipment.shippedAt
                status = deliveredShipment.status
                tracking = deliveredShipment.tracking
                trackingEvents = deliveredShipment.trackingEvents.map { it.toMutableList() }
                updatedAt = deliveredShipment.updatedAt
                additionalProperties = deliveredShipment.additionalProperties.toMutableMap()
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

            fun deliveredAt(deliveredAt: OffsetDateTime) = deliveredAt(JsonField.of(deliveredAt))

            /**
             * Sets [Builder.deliveredAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deliveredAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun deliveredAt(deliveredAt: JsonField<OffsetDateTime>) = apply {
                this.deliveredAt = deliveredAt
            }

            /**
             * The external ID is provided by the marketplace and matches the shipment to their
             * system.
             */
            fun externalId(externalId: String) = externalId(JsonField.of(externalId))

            /**
             * Sets [Builder.externalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.externalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun externalId(externalId: JsonField<String>) = apply { this.externalId = externalId }

            fun shippedAt(shippedAt: OffsetDateTime) = shippedAt(JsonField.of(shippedAt))

            /**
             * Sets [Builder.shippedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shippedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shippedAt(shippedAt: JsonField<OffsetDateTime>) = apply {
                this.shippedAt = shippedAt
            }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun tracking(tracking: ShipmentTracking) = tracking(JsonField.of(tracking))

            /**
             * Sets [Builder.tracking] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tracking] with a well-typed [ShipmentTracking] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tracking(tracking: JsonField<ShipmentTracking>) = apply { this.tracking = tracking }

            fun trackingEvents(trackingEvents: List<TrackingEvent>) =
                trackingEvents(JsonField.of(trackingEvents))

            /**
             * Sets [Builder.trackingEvents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.trackingEvents] with a well-typed
             * `List<TrackingEvent>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun trackingEvents(trackingEvents: JsonField<List<TrackingEvent>>) = apply {
                this.trackingEvents = trackingEvents.map { it.toMutableList() }
            }

            /**
             * Adds a single [TrackingEvent] to [trackingEvents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTrackingEvent(trackingEvent: TrackingEvent) = apply {
                trackingEvents =
                    (trackingEvents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("trackingEvents", it).add(trackingEvent)
                    }
            }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [DeliveredShipment].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .deliveredAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): DeliveredShipment =
                DeliveredShipment(
                    checkRequired("id", id),
                    checkRequired("checkoutIntentId", checkoutIntentId),
                    checkRequired("createdAt", createdAt),
                    checkRequired("deliveredAt", deliveredAt),
                    checkRequired("externalId", externalId),
                    checkRequired("shippedAt", shippedAt),
                    checkRequired("status", status),
                    checkRequired("tracking", tracking),
                    checkRequired("trackingEvents", trackingEvents).map { it.toImmutable() },
                    checkRequired("updatedAt", updatedAt),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): DeliveredShipment = apply {
            if (validated) {
                return@apply
            }

            id()
            checkoutIntentId()
            createdAt()
            deliveredAt()
            externalId()
            shippedAt()
            status().validate()
            tracking().validate()
            trackingEvents().forEach { it.validate() }
            updatedAt()
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
                (if (deliveredAt.asKnown().isPresent) 1 else 0) +
                (if (externalId.asKnown().isPresent) 1 else 0) +
                (if (shippedAt.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (tracking.asKnown().getOrNull()?.validity() ?: 0) +
                (trackingEvents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val DELIVERED = of("delivered")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                DELIVERED
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                DELIVERED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    DELIVERED -> Value.DELIVERED
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
                    DELIVERED -> Known.DELIVERED
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Status: $value")
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

            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class TrackingEvent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val description: JsonField<String>,
            private val location: JsonField<Location>,
            private val timestamp: JsonField<Timestamp>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("location")
                @ExcludeMissing
                location: JsonField<Location> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<Timestamp> = JsonMissing.of(),
            ) : this(description, location, timestamp, mutableMapOf())

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun location(): Location = location.getRequired("location")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun timestamp(): Optional<Timestamp> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [location].
             *
             * Unlike [location], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("location")
            @ExcludeMissing
            fun _location(): JsonField<Location> = location

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<Timestamp> = timestamp

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
                 * Returns a mutable builder for constructing an instance of [TrackingEvent].
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TrackingEvent]. */
            class Builder internal constructor() {

                private var description: JsonField<String>? = null
                private var location: JsonField<Location>? = null
                private var timestamp: JsonField<Timestamp>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(trackingEvent: TrackingEvent) = apply {
                    description = trackingEvent.description
                    location = trackingEvent.location
                    timestamp = trackingEvent.timestamp
                    additionalProperties = trackingEvent.additionalProperties.toMutableMap()
                }

                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun location(location: Location) = location(JsonField.of(location))

                /**
                 * Sets [Builder.location] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.location] with a well-typed [Location] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun location(location: JsonField<Location>) = apply { this.location = location }

                fun timestamp(timestamp: Timestamp?) = timestamp(JsonField.ofNullable(timestamp))

                /** Alias for calling [Builder.timestamp] with `timestamp.orElse(null)`. */
                fun timestamp(timestamp: Optional<Timestamp>) = timestamp(timestamp.getOrNull())

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [Timestamp] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timestamp(timestamp: JsonField<Timestamp>) = apply {
                    this.timestamp = timestamp
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
                 * Returns an immutable instance of [TrackingEvent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): TrackingEvent =
                    TrackingEvent(
                        checkRequired("description", description),
                        checkRequired("location", location),
                        checkRequired("timestamp", timestamp),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TrackingEvent = apply {
                if (validated) {
                    return@apply
                }

                description()
                location().validate()
                timestamp().ifPresent { it.validate() }
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
                (if (description.asKnown().isPresent) 1 else 0) +
                    (location.asKnown().getOrNull()?.validity() ?: 0) +
                    (timestamp.asKnown().getOrNull()?.validity() ?: 0)

            class Location
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val city: JsonField<String>,
                private val country: JsonField<String>,
                private val province: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("city")
                    @ExcludeMissing
                    city: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("country")
                    @ExcludeMissing
                    country: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("province")
                    @ExcludeMissing
                    province: JsonField<String> = JsonMissing.of(),
                ) : this(city, country, province, mutableMapOf())

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun city(): Optional<String> = city.getOptional("city")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun country(): Optional<String> = country.getOptional("country")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun province(): Optional<String> = province.getOptional("province")

                /**
                 * Returns the raw JSON value of [city].
                 *
                 * Unlike [city], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

                /**
                 * Returns the raw JSON value of [country].
                 *
                 * Unlike [country], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

                /**
                 * Returns the raw JSON value of [province].
                 *
                 * Unlike [province], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("province")
                @ExcludeMissing
                fun _province(): JsonField<String> = province

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

                    /** Returns a mutable builder for constructing an instance of [Location]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Location]. */
                class Builder internal constructor() {

                    private var city: JsonField<String> = JsonMissing.of()
                    private var country: JsonField<String> = JsonMissing.of()
                    private var province: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(location: Location) = apply {
                        city = location.city
                        country = location.country
                        province = location.province
                        additionalProperties = location.additionalProperties.toMutableMap()
                    }

                    fun city(city: String?) = city(JsonField.ofNullable(city))

                    /** Alias for calling [Builder.city] with `city.orElse(null)`. */
                    fun city(city: Optional<String>) = city(city.getOrNull())

                    /**
                     * Sets [Builder.city] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.city] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun city(city: JsonField<String>) = apply { this.city = city }

                    fun country(country: String?) = country(JsonField.ofNullable(country))

                    /** Alias for calling [Builder.country] with `country.orElse(null)`. */
                    fun country(country: Optional<String>) = country(country.getOrNull())

                    /**
                     * Sets [Builder.country] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.country] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun country(country: JsonField<String>) = apply { this.country = country }

                    fun province(province: String?) = province(JsonField.ofNullable(province))

                    /** Alias for calling [Builder.province] with `province.orElse(null)`. */
                    fun province(province: Optional<String>) = province(province.getOrNull())

                    /**
                     * Sets [Builder.province] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.province] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun province(province: JsonField<String>) = apply { this.province = province }

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
                     * Returns an immutable instance of [Location].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Location =
                        Location(city, country, province, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Location = apply {
                    if (validated) {
                        return@apply
                    }

                    city()
                    country()
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
                    (if (city.asKnown().isPresent) 1 else 0) +
                        (if (country.asKnown().isPresent) 1 else 0) +
                        (if (province.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Location &&
                        city == other.city &&
                        country == other.country &&
                        province == other.province &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(city, country, province, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Location{city=$city, country=$country, province=$province, additionalProperties=$additionalProperties}"
            }

            class Timestamp
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val local: JsonField<String>,
                private val utc: JsonField<OffsetDateTime>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("local")
                    @ExcludeMissing
                    local: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("utc")
                    @ExcludeMissing
                    utc: JsonField<OffsetDateTime> = JsonMissing.of(),
                ) : this(local, utc, mutableMapOf())

                /**
                 * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun local(): String = local.getRequired("local")

                /**
                 * UTC timestamp
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun utc(): OffsetDateTime = utc.getRequired("utc")

                /**
                 * Returns the raw JSON value of [local].
                 *
                 * Unlike [local], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("local") @ExcludeMissing fun _local(): JsonField<String> = local

                /**
                 * Returns the raw JSON value of [utc].
                 *
                 * Unlike [utc], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("utc") @ExcludeMissing fun _utc(): JsonField<OffsetDateTime> = utc

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
                     * Returns a mutable builder for constructing an instance of [Timestamp].
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Timestamp]. */
                class Builder internal constructor() {

                    private var local: JsonField<String>? = null
                    private var utc: JsonField<OffsetDateTime>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(timestamp: Timestamp) = apply {
                        local = timestamp.local
                        utc = timestamp.utc
                        additionalProperties = timestamp.additionalProperties.toMutableMap()
                    }

                    /**
                     * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                     */
                    fun local(local: String) = local(JsonField.of(local))

                    /**
                     * Sets [Builder.local] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.local] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun local(local: JsonField<String>) = apply { this.local = local }

                    /** UTC timestamp */
                    fun utc(utc: OffsetDateTime) = utc(JsonField.of(utc))

                    /**
                     * Sets [Builder.utc] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.utc] with a well-typed [OffsetDateTime]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun utc(utc: JsonField<OffsetDateTime>) = apply { this.utc = utc }

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
                     * Returns an immutable instance of [Timestamp].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Timestamp =
                        Timestamp(
                            checkRequired("local", local),
                            checkRequired("utc", utc),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Timestamp = apply {
                    if (validated) {
                        return@apply
                    }

                    local()
                    utc()
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
                    (if (local.asKnown().isPresent) 1 else 0) +
                        (if (utc.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Timestamp &&
                        local == other.local &&
                        utc == other.utc &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(local, utc, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Timestamp{local=$local, utc=$utc, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TrackingEvent &&
                    description == other.description &&
                    location == other.location &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(description, location, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TrackingEvent{description=$description, location=$location, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DeliveredShipment &&
                id == other.id &&
                checkoutIntentId == other.checkoutIntentId &&
                createdAt == other.createdAt &&
                deliveredAt == other.deliveredAt &&
                externalId == other.externalId &&
                shippedAt == other.shippedAt &&
                status == other.status &&
                tracking == other.tracking &&
                trackingEvents == other.trackingEvents &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                checkoutIntentId,
                createdAt,
                deliveredAt,
                externalId,
                shippedAt,
                status,
                tracking,
                trackingEvents,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "DeliveredShipment{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, deliveredAt=$deliveredAt, externalId=$externalId, shippedAt=$shippedAt, status=$status, tracking=$tracking, trackingEvents=$trackingEvents, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    class WithStatusBaseShipmentWithTrackingDelayed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val checkoutIntentId: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val externalId: JsonField<String>,
        private val shippedAt: JsonField<OffsetDateTime>,
        private val status: JsonField<Status>,
        private val tracking: JsonField<ShipmentTracking>,
        private val trackingEvents: JsonField<List<TrackingEvent>>,
        private val updatedAt: JsonField<OffsetDateTime>,
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
            @JsonProperty("externalId")
            @ExcludeMissing
            externalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shippedAt")
            @ExcludeMissing
            shippedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("tracking")
            @ExcludeMissing
            tracking: JsonField<ShipmentTracking> = JsonMissing.of(),
            @JsonProperty("trackingEvents")
            @ExcludeMissing
            trackingEvents: JsonField<List<TrackingEvent>> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            id,
            checkoutIntentId,
            createdAt,
            externalId,
            shippedAt,
            status,
            tracking,
            trackingEvents,
            updatedAt,
            mutableMapOf(),
        )

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
        fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * The external ID is provided by the marketplace and matches the shipment to their system.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun externalId(): String = externalId.getRequired("externalId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun shippedAt(): OffsetDateTime = shippedAt.getRequired("shippedAt")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun tracking(): ShipmentTracking = tracking.getRequired("tracking")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun trackingEvents(): List<TrackingEvent> = trackingEvents.getRequired("trackingEvents")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [externalId].
         *
         * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("externalId")
        @ExcludeMissing
        fun _externalId(): JsonField<String> = externalId

        /**
         * Returns the raw JSON value of [shippedAt].
         *
         * Unlike [shippedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shippedAt")
        @ExcludeMissing
        fun _shippedAt(): JsonField<OffsetDateTime> = shippedAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [tracking].
         *
         * Unlike [tracking], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tracking")
        @ExcludeMissing
        fun _tracking(): JsonField<ShipmentTracking> = tracking

        /**
         * Returns the raw JSON value of [trackingEvents].
         *
         * Unlike [trackingEvents], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("trackingEvents")
        @ExcludeMissing
        fun _trackingEvents(): JsonField<List<TrackingEvent>> = trackingEvents

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * [WithStatusBaseShipmentWithTrackingDelayed].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WithStatusBaseShipmentWithTrackingDelayed]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var checkoutIntentId: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var externalId: JsonField<String>? = null
            private var shippedAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<Status>? = null
            private var tracking: JsonField<ShipmentTracking>? = null
            private var trackingEvents: JsonField<MutableList<TrackingEvent>>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                withStatusBaseShipmentWithTrackingDelayed: WithStatusBaseShipmentWithTrackingDelayed
            ) = apply {
                id = withStatusBaseShipmentWithTrackingDelayed.id
                checkoutIntentId = withStatusBaseShipmentWithTrackingDelayed.checkoutIntentId
                createdAt = withStatusBaseShipmentWithTrackingDelayed.createdAt
                externalId = withStatusBaseShipmentWithTrackingDelayed.externalId
                shippedAt = withStatusBaseShipmentWithTrackingDelayed.shippedAt
                status = withStatusBaseShipmentWithTrackingDelayed.status
                tracking = withStatusBaseShipmentWithTrackingDelayed.tracking
                trackingEvents =
                    withStatusBaseShipmentWithTrackingDelayed.trackingEvents.map {
                        it.toMutableList()
                    }
                updatedAt = withStatusBaseShipmentWithTrackingDelayed.updatedAt
                additionalProperties =
                    withStatusBaseShipmentWithTrackingDelayed.additionalProperties.toMutableMap()
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

            /**
             * The external ID is provided by the marketplace and matches the shipment to their
             * system.
             */
            fun externalId(externalId: String) = externalId(JsonField.of(externalId))

            /**
             * Sets [Builder.externalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.externalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun externalId(externalId: JsonField<String>) = apply { this.externalId = externalId }

            fun shippedAt(shippedAt: OffsetDateTime) = shippedAt(JsonField.of(shippedAt))

            /**
             * Sets [Builder.shippedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shippedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shippedAt(shippedAt: JsonField<OffsetDateTime>) = apply {
                this.shippedAt = shippedAt
            }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun tracking(tracking: ShipmentTracking) = tracking(JsonField.of(tracking))

            /**
             * Sets [Builder.tracking] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tracking] with a well-typed [ShipmentTracking] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tracking(tracking: JsonField<ShipmentTracking>) = apply { this.tracking = tracking }

            fun trackingEvents(trackingEvents: List<TrackingEvent>) =
                trackingEvents(JsonField.of(trackingEvents))

            /**
             * Sets [Builder.trackingEvents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.trackingEvents] with a well-typed
             * `List<TrackingEvent>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun trackingEvents(trackingEvents: JsonField<List<TrackingEvent>>) = apply {
                this.trackingEvents = trackingEvents.map { it.toMutableList() }
            }

            /**
             * Adds a single [TrackingEvent] to [trackingEvents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTrackingEvent(trackingEvent: TrackingEvent) = apply {
                trackingEvents =
                    (trackingEvents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("trackingEvents", it).add(trackingEvent)
                    }
            }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [WithStatusBaseShipmentWithTrackingDelayed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WithStatusBaseShipmentWithTrackingDelayed =
                WithStatusBaseShipmentWithTrackingDelayed(
                    checkRequired("id", id),
                    checkRequired("checkoutIntentId", checkoutIntentId),
                    checkRequired("createdAt", createdAt),
                    checkRequired("externalId", externalId),
                    checkRequired("shippedAt", shippedAt),
                    checkRequired("status", status),
                    checkRequired("tracking", tracking),
                    checkRequired("trackingEvents", trackingEvents).map { it.toImmutable() },
                    checkRequired("updatedAt", updatedAt),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WithStatusBaseShipmentWithTrackingDelayed = apply {
            if (validated) {
                return@apply
            }

            id()
            checkoutIntentId()
            createdAt()
            externalId()
            shippedAt()
            status().validate()
            tracking().validate()
            trackingEvents().forEach { it.validate() }
            updatedAt()
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
                (if (externalId.asKnown().isPresent) 1 else 0) +
                (if (shippedAt.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (tracking.asKnown().getOrNull()?.validity() ?: 0) +
                (trackingEvents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val DELAYED = of("delayed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                DELAYED
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                DELAYED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    DELAYED -> Value.DELAYED
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
                    DELAYED -> Known.DELAYED
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Status: $value")
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

            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class TrackingEvent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val description: JsonField<String>,
            private val location: JsonField<Location>,
            private val timestamp: JsonField<Timestamp>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("location")
                @ExcludeMissing
                location: JsonField<Location> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<Timestamp> = JsonMissing.of(),
            ) : this(description, location, timestamp, mutableMapOf())

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun location(): Location = location.getRequired("location")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun timestamp(): Optional<Timestamp> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [location].
             *
             * Unlike [location], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("location")
            @ExcludeMissing
            fun _location(): JsonField<Location> = location

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<Timestamp> = timestamp

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
                 * Returns a mutable builder for constructing an instance of [TrackingEvent].
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TrackingEvent]. */
            class Builder internal constructor() {

                private var description: JsonField<String>? = null
                private var location: JsonField<Location>? = null
                private var timestamp: JsonField<Timestamp>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(trackingEvent: TrackingEvent) = apply {
                    description = trackingEvent.description
                    location = trackingEvent.location
                    timestamp = trackingEvent.timestamp
                    additionalProperties = trackingEvent.additionalProperties.toMutableMap()
                }

                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun location(location: Location) = location(JsonField.of(location))

                /**
                 * Sets [Builder.location] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.location] with a well-typed [Location] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun location(location: JsonField<Location>) = apply { this.location = location }

                fun timestamp(timestamp: Timestamp?) = timestamp(JsonField.ofNullable(timestamp))

                /** Alias for calling [Builder.timestamp] with `timestamp.orElse(null)`. */
                fun timestamp(timestamp: Optional<Timestamp>) = timestamp(timestamp.getOrNull())

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [Timestamp] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timestamp(timestamp: JsonField<Timestamp>) = apply {
                    this.timestamp = timestamp
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
                 * Returns an immutable instance of [TrackingEvent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): TrackingEvent =
                    TrackingEvent(
                        checkRequired("description", description),
                        checkRequired("location", location),
                        checkRequired("timestamp", timestamp),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TrackingEvent = apply {
                if (validated) {
                    return@apply
                }

                description()
                location().validate()
                timestamp().ifPresent { it.validate() }
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
                (if (description.asKnown().isPresent) 1 else 0) +
                    (location.asKnown().getOrNull()?.validity() ?: 0) +
                    (timestamp.asKnown().getOrNull()?.validity() ?: 0)

            class Location
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val city: JsonField<String>,
                private val country: JsonField<String>,
                private val province: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("city")
                    @ExcludeMissing
                    city: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("country")
                    @ExcludeMissing
                    country: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("province")
                    @ExcludeMissing
                    province: JsonField<String> = JsonMissing.of(),
                ) : this(city, country, province, mutableMapOf())

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun city(): Optional<String> = city.getOptional("city")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun country(): Optional<String> = country.getOptional("country")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun province(): Optional<String> = province.getOptional("province")

                /**
                 * Returns the raw JSON value of [city].
                 *
                 * Unlike [city], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

                /**
                 * Returns the raw JSON value of [country].
                 *
                 * Unlike [country], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

                /**
                 * Returns the raw JSON value of [province].
                 *
                 * Unlike [province], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("province")
                @ExcludeMissing
                fun _province(): JsonField<String> = province

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

                    /** Returns a mutable builder for constructing an instance of [Location]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Location]. */
                class Builder internal constructor() {

                    private var city: JsonField<String> = JsonMissing.of()
                    private var country: JsonField<String> = JsonMissing.of()
                    private var province: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(location: Location) = apply {
                        city = location.city
                        country = location.country
                        province = location.province
                        additionalProperties = location.additionalProperties.toMutableMap()
                    }

                    fun city(city: String?) = city(JsonField.ofNullable(city))

                    /** Alias for calling [Builder.city] with `city.orElse(null)`. */
                    fun city(city: Optional<String>) = city(city.getOrNull())

                    /**
                     * Sets [Builder.city] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.city] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun city(city: JsonField<String>) = apply { this.city = city }

                    fun country(country: String?) = country(JsonField.ofNullable(country))

                    /** Alias for calling [Builder.country] with `country.orElse(null)`. */
                    fun country(country: Optional<String>) = country(country.getOrNull())

                    /**
                     * Sets [Builder.country] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.country] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun country(country: JsonField<String>) = apply { this.country = country }

                    fun province(province: String?) = province(JsonField.ofNullable(province))

                    /** Alias for calling [Builder.province] with `province.orElse(null)`. */
                    fun province(province: Optional<String>) = province(province.getOrNull())

                    /**
                     * Sets [Builder.province] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.province] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun province(province: JsonField<String>) = apply { this.province = province }

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
                     * Returns an immutable instance of [Location].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Location =
                        Location(city, country, province, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Location = apply {
                    if (validated) {
                        return@apply
                    }

                    city()
                    country()
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
                    (if (city.asKnown().isPresent) 1 else 0) +
                        (if (country.asKnown().isPresent) 1 else 0) +
                        (if (province.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Location &&
                        city == other.city &&
                        country == other.country &&
                        province == other.province &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(city, country, province, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Location{city=$city, country=$country, province=$province, additionalProperties=$additionalProperties}"
            }

            class Timestamp
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val local: JsonField<String>,
                private val utc: JsonField<OffsetDateTime>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("local")
                    @ExcludeMissing
                    local: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("utc")
                    @ExcludeMissing
                    utc: JsonField<OffsetDateTime> = JsonMissing.of(),
                ) : this(local, utc, mutableMapOf())

                /**
                 * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun local(): String = local.getRequired("local")

                /**
                 * UTC timestamp
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun utc(): OffsetDateTime = utc.getRequired("utc")

                /**
                 * Returns the raw JSON value of [local].
                 *
                 * Unlike [local], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("local") @ExcludeMissing fun _local(): JsonField<String> = local

                /**
                 * Returns the raw JSON value of [utc].
                 *
                 * Unlike [utc], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("utc") @ExcludeMissing fun _utc(): JsonField<OffsetDateTime> = utc

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
                     * Returns a mutable builder for constructing an instance of [Timestamp].
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Timestamp]. */
                class Builder internal constructor() {

                    private var local: JsonField<String>? = null
                    private var utc: JsonField<OffsetDateTime>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(timestamp: Timestamp) = apply {
                        local = timestamp.local
                        utc = timestamp.utc
                        additionalProperties = timestamp.additionalProperties.toMutableMap()
                    }

                    /**
                     * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                     */
                    fun local(local: String) = local(JsonField.of(local))

                    /**
                     * Sets [Builder.local] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.local] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun local(local: JsonField<String>) = apply { this.local = local }

                    /** UTC timestamp */
                    fun utc(utc: OffsetDateTime) = utc(JsonField.of(utc))

                    /**
                     * Sets [Builder.utc] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.utc] with a well-typed [OffsetDateTime]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun utc(utc: JsonField<OffsetDateTime>) = apply { this.utc = utc }

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
                     * Returns an immutable instance of [Timestamp].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Timestamp =
                        Timestamp(
                            checkRequired("local", local),
                            checkRequired("utc", utc),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Timestamp = apply {
                    if (validated) {
                        return@apply
                    }

                    local()
                    utc()
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
                    (if (local.asKnown().isPresent) 1 else 0) +
                        (if (utc.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Timestamp &&
                        local == other.local &&
                        utc == other.utc &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(local, utc, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Timestamp{local=$local, utc=$utc, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TrackingEvent &&
                    description == other.description &&
                    location == other.location &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(description, location, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TrackingEvent{description=$description, location=$location, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WithStatusBaseShipmentWithTrackingDelayed &&
                id == other.id &&
                checkoutIntentId == other.checkoutIntentId &&
                createdAt == other.createdAt &&
                externalId == other.externalId &&
                shippedAt == other.shippedAt &&
                status == other.status &&
                tracking == other.tracking &&
                trackingEvents == other.trackingEvents &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                checkoutIntentId,
                createdAt,
                externalId,
                shippedAt,
                status,
                tracking,
                trackingEvents,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WithStatusBaseShipmentWithTrackingDelayed{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, externalId=$externalId, shippedAt=$shippedAt, status=$status, tracking=$tracking, trackingEvents=$trackingEvents, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    class WithStatusBaseShipmentWithTrackingOutForDelivery
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val checkoutIntentId: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val externalId: JsonField<String>,
        private val shippedAt: JsonField<OffsetDateTime>,
        private val status: JsonField<Status>,
        private val tracking: JsonField<ShipmentTracking>,
        private val trackingEvents: JsonField<List<TrackingEvent>>,
        private val updatedAt: JsonField<OffsetDateTime>,
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
            @JsonProperty("externalId")
            @ExcludeMissing
            externalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shippedAt")
            @ExcludeMissing
            shippedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("tracking")
            @ExcludeMissing
            tracking: JsonField<ShipmentTracking> = JsonMissing.of(),
            @JsonProperty("trackingEvents")
            @ExcludeMissing
            trackingEvents: JsonField<List<TrackingEvent>> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            id,
            checkoutIntentId,
            createdAt,
            externalId,
            shippedAt,
            status,
            tracking,
            trackingEvents,
            updatedAt,
            mutableMapOf(),
        )

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
        fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * The external ID is provided by the marketplace and matches the shipment to their system.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun externalId(): String = externalId.getRequired("externalId")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun shippedAt(): OffsetDateTime = shippedAt.getRequired("shippedAt")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun tracking(): ShipmentTracking = tracking.getRequired("tracking")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun trackingEvents(): List<TrackingEvent> = trackingEvents.getRequired("trackingEvents")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [externalId].
         *
         * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("externalId")
        @ExcludeMissing
        fun _externalId(): JsonField<String> = externalId

        /**
         * Returns the raw JSON value of [shippedAt].
         *
         * Unlike [shippedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shippedAt")
        @ExcludeMissing
        fun _shippedAt(): JsonField<OffsetDateTime> = shippedAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [tracking].
         *
         * Unlike [tracking], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tracking")
        @ExcludeMissing
        fun _tracking(): JsonField<ShipmentTracking> = tracking

        /**
         * Returns the raw JSON value of [trackingEvents].
         *
         * Unlike [trackingEvents], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("trackingEvents")
        @ExcludeMissing
        fun _trackingEvents(): JsonField<List<TrackingEvent>> = trackingEvents

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * [WithStatusBaseShipmentWithTrackingOutForDelivery].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WithStatusBaseShipmentWithTrackingOutForDelivery]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var checkoutIntentId: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var externalId: JsonField<String>? = null
            private var shippedAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<Status>? = null
            private var tracking: JsonField<ShipmentTracking>? = null
            private var trackingEvents: JsonField<MutableList<TrackingEvent>>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                withStatusBaseShipmentWithTrackingOutForDelivery:
                    WithStatusBaseShipmentWithTrackingOutForDelivery
            ) = apply {
                id = withStatusBaseShipmentWithTrackingOutForDelivery.id
                checkoutIntentId = withStatusBaseShipmentWithTrackingOutForDelivery.checkoutIntentId
                createdAt = withStatusBaseShipmentWithTrackingOutForDelivery.createdAt
                externalId = withStatusBaseShipmentWithTrackingOutForDelivery.externalId
                shippedAt = withStatusBaseShipmentWithTrackingOutForDelivery.shippedAt
                status = withStatusBaseShipmentWithTrackingOutForDelivery.status
                tracking = withStatusBaseShipmentWithTrackingOutForDelivery.tracking
                trackingEvents =
                    withStatusBaseShipmentWithTrackingOutForDelivery.trackingEvents.map {
                        it.toMutableList()
                    }
                updatedAt = withStatusBaseShipmentWithTrackingOutForDelivery.updatedAt
                additionalProperties =
                    withStatusBaseShipmentWithTrackingOutForDelivery.additionalProperties
                        .toMutableMap()
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

            /**
             * The external ID is provided by the marketplace and matches the shipment to their
             * system.
             */
            fun externalId(externalId: String) = externalId(JsonField.of(externalId))

            /**
             * Sets [Builder.externalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.externalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun externalId(externalId: JsonField<String>) = apply { this.externalId = externalId }

            fun shippedAt(shippedAt: OffsetDateTime) = shippedAt(JsonField.of(shippedAt))

            /**
             * Sets [Builder.shippedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shippedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shippedAt(shippedAt: JsonField<OffsetDateTime>) = apply {
                this.shippedAt = shippedAt
            }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun tracking(tracking: ShipmentTracking) = tracking(JsonField.of(tracking))

            /**
             * Sets [Builder.tracking] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tracking] with a well-typed [ShipmentTracking] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tracking(tracking: JsonField<ShipmentTracking>) = apply { this.tracking = tracking }

            fun trackingEvents(trackingEvents: List<TrackingEvent>) =
                trackingEvents(JsonField.of(trackingEvents))

            /**
             * Sets [Builder.trackingEvents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.trackingEvents] with a well-typed
             * `List<TrackingEvent>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun trackingEvents(trackingEvents: JsonField<List<TrackingEvent>>) = apply {
                this.trackingEvents = trackingEvents.map { it.toMutableList() }
            }

            /**
             * Adds a single [TrackingEvent] to [trackingEvents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTrackingEvent(trackingEvent: TrackingEvent) = apply {
                trackingEvents =
                    (trackingEvents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("trackingEvents", it).add(trackingEvent)
                    }
            }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [WithStatusBaseShipmentWithTrackingOutForDelivery].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .externalId()
             * .shippedAt()
             * .status()
             * .tracking()
             * .trackingEvents()
             * .updatedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WithStatusBaseShipmentWithTrackingOutForDelivery =
                WithStatusBaseShipmentWithTrackingOutForDelivery(
                    checkRequired("id", id),
                    checkRequired("checkoutIntentId", checkoutIntentId),
                    checkRequired("createdAt", createdAt),
                    checkRequired("externalId", externalId),
                    checkRequired("shippedAt", shippedAt),
                    checkRequired("status", status),
                    checkRequired("tracking", tracking),
                    checkRequired("trackingEvents", trackingEvents).map { it.toImmutable() },
                    checkRequired("updatedAt", updatedAt),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WithStatusBaseShipmentWithTrackingOutForDelivery = apply {
            if (validated) {
                return@apply
            }

            id()
            checkoutIntentId()
            createdAt()
            externalId()
            shippedAt()
            status().validate()
            tracking().validate()
            trackingEvents().forEach { it.validate() }
            updatedAt()
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
                (if (externalId.asKnown().isPresent) 1 else 0) +
                (if (shippedAt.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (tracking.asKnown().getOrNull()?.validity() ?: 0) +
                (trackingEvents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val OUT_FOR_DELIVERY = of("out_for_delivery")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                OUT_FOR_DELIVERY
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                OUT_FOR_DELIVERY,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    OUT_FOR_DELIVERY -> Value.OUT_FOR_DELIVERY
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
                    OUT_FOR_DELIVERY -> Known.OUT_FOR_DELIVERY
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Status: $value")
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

            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class TrackingEvent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val description: JsonField<String>,
            private val location: JsonField<Location>,
            private val timestamp: JsonField<Timestamp>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("location")
                @ExcludeMissing
                location: JsonField<Location> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<Timestamp> = JsonMissing.of(),
            ) : this(description, location, timestamp, mutableMapOf())

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun location(): Location = location.getRequired("location")

            /**
             * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun timestamp(): Optional<Timestamp> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [location].
             *
             * Unlike [location], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("location")
            @ExcludeMissing
            fun _location(): JsonField<Location> = location

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<Timestamp> = timestamp

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
                 * Returns a mutable builder for constructing an instance of [TrackingEvent].
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TrackingEvent]. */
            class Builder internal constructor() {

                private var description: JsonField<String>? = null
                private var location: JsonField<Location>? = null
                private var timestamp: JsonField<Timestamp>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(trackingEvent: TrackingEvent) = apply {
                    description = trackingEvent.description
                    location = trackingEvent.location
                    timestamp = trackingEvent.timestamp
                    additionalProperties = trackingEvent.additionalProperties.toMutableMap()
                }

                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun location(location: Location) = location(JsonField.of(location))

                /**
                 * Sets [Builder.location] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.location] with a well-typed [Location] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun location(location: JsonField<Location>) = apply { this.location = location }

                fun timestamp(timestamp: Timestamp?) = timestamp(JsonField.ofNullable(timestamp))

                /** Alias for calling [Builder.timestamp] with `timestamp.orElse(null)`. */
                fun timestamp(timestamp: Optional<Timestamp>) = timestamp(timestamp.getOrNull())

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [Timestamp] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timestamp(timestamp: JsonField<Timestamp>) = apply {
                    this.timestamp = timestamp
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
                 * Returns an immutable instance of [TrackingEvent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .location()
                 * .timestamp()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): TrackingEvent =
                    TrackingEvent(
                        checkRequired("description", description),
                        checkRequired("location", location),
                        checkRequired("timestamp", timestamp),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TrackingEvent = apply {
                if (validated) {
                    return@apply
                }

                description()
                location().validate()
                timestamp().ifPresent { it.validate() }
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
                (if (description.asKnown().isPresent) 1 else 0) +
                    (location.asKnown().getOrNull()?.validity() ?: 0) +
                    (timestamp.asKnown().getOrNull()?.validity() ?: 0)

            class Location
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val city: JsonField<String>,
                private val country: JsonField<String>,
                private val province: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("city")
                    @ExcludeMissing
                    city: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("country")
                    @ExcludeMissing
                    country: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("province")
                    @ExcludeMissing
                    province: JsonField<String> = JsonMissing.of(),
                ) : this(city, country, province, mutableMapOf())

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun city(): Optional<String> = city.getOptional("city")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun country(): Optional<String> = country.getOptional("country")

                /**
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun province(): Optional<String> = province.getOptional("province")

                /**
                 * Returns the raw JSON value of [city].
                 *
                 * Unlike [city], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

                /**
                 * Returns the raw JSON value of [country].
                 *
                 * Unlike [country], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

                /**
                 * Returns the raw JSON value of [province].
                 *
                 * Unlike [province], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("province")
                @ExcludeMissing
                fun _province(): JsonField<String> = province

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

                    /** Returns a mutable builder for constructing an instance of [Location]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Location]. */
                class Builder internal constructor() {

                    private var city: JsonField<String> = JsonMissing.of()
                    private var country: JsonField<String> = JsonMissing.of()
                    private var province: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(location: Location) = apply {
                        city = location.city
                        country = location.country
                        province = location.province
                        additionalProperties = location.additionalProperties.toMutableMap()
                    }

                    fun city(city: String?) = city(JsonField.ofNullable(city))

                    /** Alias for calling [Builder.city] with `city.orElse(null)`. */
                    fun city(city: Optional<String>) = city(city.getOrNull())

                    /**
                     * Sets [Builder.city] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.city] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun city(city: JsonField<String>) = apply { this.city = city }

                    fun country(country: String?) = country(JsonField.ofNullable(country))

                    /** Alias for calling [Builder.country] with `country.orElse(null)`. */
                    fun country(country: Optional<String>) = country(country.getOrNull())

                    /**
                     * Sets [Builder.country] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.country] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun country(country: JsonField<String>) = apply { this.country = country }

                    fun province(province: String?) = province(JsonField.ofNullable(province))

                    /** Alias for calling [Builder.province] with `province.orElse(null)`. */
                    fun province(province: Optional<String>) = province(province.getOrNull())

                    /**
                     * Sets [Builder.province] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.province] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun province(province: JsonField<String>) = apply { this.province = province }

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
                     * Returns an immutable instance of [Location].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Location =
                        Location(city, country, province, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Location = apply {
                    if (validated) {
                        return@apply
                    }

                    city()
                    country()
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
                    (if (city.asKnown().isPresent) 1 else 0) +
                        (if (country.asKnown().isPresent) 1 else 0) +
                        (if (province.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Location &&
                        city == other.city &&
                        country == other.country &&
                        province == other.province &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(city, country, province, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Location{city=$city, country=$country, province=$province, additionalProperties=$additionalProperties}"
            }

            class Timestamp
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val local: JsonField<String>,
                private val utc: JsonField<OffsetDateTime>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("local")
                    @ExcludeMissing
                    local: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("utc")
                    @ExcludeMissing
                    utc: JsonField<OffsetDateTime> = JsonMissing.of(),
                ) : this(local, utc, mutableMapOf())

                /**
                 * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun local(): String = local.getRequired("local")

                /**
                 * UTC timestamp
                 *
                 * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun utc(): OffsetDateTime = utc.getRequired("utc")

                /**
                 * Returns the raw JSON value of [local].
                 *
                 * Unlike [local], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("local") @ExcludeMissing fun _local(): JsonField<String> = local

                /**
                 * Returns the raw JSON value of [utc].
                 *
                 * Unlike [utc], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("utc") @ExcludeMissing fun _utc(): JsonField<OffsetDateTime> = utc

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
                     * Returns a mutable builder for constructing an instance of [Timestamp].
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Timestamp]. */
                class Builder internal constructor() {

                    private var local: JsonField<String>? = null
                    private var utc: JsonField<OffsetDateTime>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(timestamp: Timestamp) = apply {
                        local = timestamp.local
                        utc = timestamp.utc
                        additionalProperties = timestamp.additionalProperties.toMutableMap()
                    }

                    /**
                     * ISO 8601 string with timezone offset, e.g. "2025-02-05T17:02:00.000-05:00"
                     */
                    fun local(local: String) = local(JsonField.of(local))

                    /**
                     * Sets [Builder.local] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.local] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun local(local: JsonField<String>) = apply { this.local = local }

                    /** UTC timestamp */
                    fun utc(utc: OffsetDateTime) = utc(JsonField.of(utc))

                    /**
                     * Sets [Builder.utc] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.utc] with a well-typed [OffsetDateTime]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun utc(utc: JsonField<OffsetDateTime>) = apply { this.utc = utc }

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
                     * Returns an immutable instance of [Timestamp].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .local()
                     * .utc()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Timestamp =
                        Timestamp(
                            checkRequired("local", local),
                            checkRequired("utc", utc),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Timestamp = apply {
                    if (validated) {
                        return@apply
                    }

                    local()
                    utc()
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
                    (if (local.asKnown().isPresent) 1 else 0) +
                        (if (utc.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Timestamp &&
                        local == other.local &&
                        utc == other.utc &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(local, utc, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Timestamp{local=$local, utc=$utc, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is TrackingEvent &&
                    description == other.description &&
                    location == other.location &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(description, location, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TrackingEvent{description=$description, location=$location, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WithStatusBaseShipmentWithTrackingOutForDelivery &&
                id == other.id &&
                checkoutIntentId == other.checkoutIntentId &&
                createdAt == other.createdAt &&
                externalId == other.externalId &&
                shippedAt == other.shippedAt &&
                status == other.status &&
                tracking == other.tracking &&
                trackingEvents == other.trackingEvents &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                checkoutIntentId,
                createdAt,
                externalId,
                shippedAt,
                status,
                tracking,
                trackingEvents,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WithStatusBaseShipmentWithTrackingOutForDelivery{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, externalId=$externalId, shippedAt=$shippedAt, status=$status, tracking=$tracking, trackingEvents=$trackingEvents, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    class WithStatusBaseShipmentOrdered
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val checkoutIntentId: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val status: JsonField<Status>,
        private val updatedAt: JsonField<OffsetDateTime>,
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
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(id, checkoutIntentId, createdAt, status, updatedAt, mutableMapOf())

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
        fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

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
        fun status(): Status = status.getRequired("status")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * [WithStatusBaseShipmentOrdered].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .status()
             * .updatedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WithStatusBaseShipmentOrdered]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var checkoutIntentId: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<Status>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(withStatusBaseShipmentOrdered: WithStatusBaseShipmentOrdered) =
                apply {
                    id = withStatusBaseShipmentOrdered.id
                    checkoutIntentId = withStatusBaseShipmentOrdered.checkoutIntentId
                    createdAt = withStatusBaseShipmentOrdered.createdAt
                    status = withStatusBaseShipmentOrdered.status
                    updatedAt = withStatusBaseShipmentOrdered.updatedAt
                    additionalProperties =
                        withStatusBaseShipmentOrdered.additionalProperties.toMutableMap()
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

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [WithStatusBaseShipmentOrdered].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .status()
             * .updatedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WithStatusBaseShipmentOrdered =
                WithStatusBaseShipmentOrdered(
                    checkRequired("id", id),
                    checkRequired("checkoutIntentId", checkoutIntentId),
                    checkRequired("createdAt", createdAt),
                    checkRequired("status", status),
                    checkRequired("updatedAt", updatedAt),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WithStatusBaseShipmentOrdered = apply {
            if (validated) {
                return@apply
            }

            id()
            checkoutIntentId()
            createdAt()
            status().validate()
            updatedAt()
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
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val ORDERED = of("ordered")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                ORDERED
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                ORDERED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    ORDERED -> Value.ORDERED
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
                    ORDERED -> Known.ORDERED
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Status: $value")
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

            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WithStatusBaseShipmentOrdered &&
                id == other.id &&
                checkoutIntentId == other.checkoutIntentId &&
                createdAt == other.createdAt &&
                status == other.status &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, checkoutIntentId, createdAt, status, updatedAt, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WithStatusBaseShipmentOrdered{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, status=$status, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    class WithStatusBaseShipmentCanceled
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val checkoutIntentId: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val status: JsonField<Status>,
        private val updatedAt: JsonField<OffsetDateTime>,
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
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(id, checkoutIntentId, createdAt, status, updatedAt, mutableMapOf())

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
        fun checkoutIntentId(): String = checkoutIntentId.getRequired("checkoutIntentId")

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
        fun status(): Status = status.getRequired("status")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * [WithStatusBaseShipmentCanceled].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .status()
             * .updatedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WithStatusBaseShipmentCanceled]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var checkoutIntentId: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<Status>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(withStatusBaseShipmentCanceled: WithStatusBaseShipmentCanceled) =
                apply {
                    id = withStatusBaseShipmentCanceled.id
                    checkoutIntentId = withStatusBaseShipmentCanceled.checkoutIntentId
                    createdAt = withStatusBaseShipmentCanceled.createdAt
                    status = withStatusBaseShipmentCanceled.status
                    updatedAt = withStatusBaseShipmentCanceled.updatedAt
                    additionalProperties =
                        withStatusBaseShipmentCanceled.additionalProperties.toMutableMap()
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

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /**
             * Sets [Builder.updatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [WithStatusBaseShipmentCanceled].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .checkoutIntentId()
             * .createdAt()
             * .status()
             * .updatedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WithStatusBaseShipmentCanceled =
                WithStatusBaseShipmentCanceled(
                    checkRequired("id", id),
                    checkRequired("checkoutIntentId", checkoutIntentId),
                    checkRequired("createdAt", createdAt),
                    checkRequired("status", status),
                    checkRequired("updatedAt", updatedAt),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): WithStatusBaseShipmentCanceled = apply {
            if (validated) {
                return@apply
            }

            id()
            checkoutIntentId()
            createdAt()
            status().validate()
            updatedAt()
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
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val CANCELED = of("canceled")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                CANCELED
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                CANCELED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    CANCELED -> Value.CANCELED
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
                    CANCELED -> Known.CANCELED
                    else -> throw CheckoutIntentsInvalidDataException("Unknown Status: $value")
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

            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WithStatusBaseShipmentCanceled &&
                id == other.id &&
                checkoutIntentId == other.checkoutIntentId &&
                createdAt == other.createdAt &&
                status == other.status &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, checkoutIntentId, createdAt, status, updatedAt, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WithStatusBaseShipmentCanceled{id=$id, checkoutIntentId=$checkoutIntentId, createdAt=$createdAt, status=$status, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }
}
