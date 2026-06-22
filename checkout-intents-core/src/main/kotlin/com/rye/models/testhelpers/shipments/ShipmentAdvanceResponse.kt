// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.shipments

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.checkRequired
import com.rye.errors.CheckoutIntentsInvalidDataException
import com.rye.models.shipments.Shipment
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class ShipmentAdvanceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val shipment: JsonField<Shipment>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("shipment") @ExcludeMissing shipment: JsonField<Shipment> = JsonMissing.of()
    ) : this(shipment, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun shipment(): Shipment = shipment.getRequired("shipment")

    /**
     * Returns the raw JSON value of [shipment].
     *
     * Unlike [shipment], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("shipment") @ExcludeMissing fun _shipment(): JsonField<Shipment> = shipment

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
         * Returns a mutable builder for constructing an instance of [ShipmentAdvanceResponse].
         *
         * The following fields are required:
         * ```java
         * .shipment()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ShipmentAdvanceResponse]. */
    class Builder internal constructor() {

        private var shipment: JsonField<Shipment>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(shipmentAdvanceResponse: ShipmentAdvanceResponse) = apply {
            shipment = shipmentAdvanceResponse.shipment
            additionalProperties = shipmentAdvanceResponse.additionalProperties.toMutableMap()
        }

        fun shipment(shipment: Shipment) = shipment(JsonField.of(shipment))

        /**
         * Sets [Builder.shipment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shipment] with a well-typed [Shipment] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun shipment(shipment: JsonField<Shipment>) = apply { this.shipment = shipment }

        /**
         * Alias for calling [shipment] with
         * `Shipment.ofWithStatusBaseShipmentWithTrackingShipped(withStatusBaseShipmentWithTrackingShipped)`.
         */
        fun shipment(
            withStatusBaseShipmentWithTrackingShipped:
                Shipment.WithStatusBaseShipmentWithTrackingShipped
        ) =
            shipment(
                Shipment.ofWithStatusBaseShipmentWithTrackingShipped(
                    withStatusBaseShipmentWithTrackingShipped
                )
            )

        /** Alias for calling [shipment] with `Shipment.ofDelivered(delivered)`. */
        fun shipment(delivered: Shipment.DeliveredShipment) =
            shipment(Shipment.ofDelivered(delivered))

        /**
         * Alias for calling [shipment] with
         * `Shipment.ofWithStatusBaseShipmentWithTrackingDelayed(withStatusBaseShipmentWithTrackingDelayed)`.
         */
        fun shipment(
            withStatusBaseShipmentWithTrackingDelayed:
                Shipment.WithStatusBaseShipmentWithTrackingDelayed
        ) =
            shipment(
                Shipment.ofWithStatusBaseShipmentWithTrackingDelayed(
                    withStatusBaseShipmentWithTrackingDelayed
                )
            )

        /**
         * Alias for calling [shipment] with
         * `Shipment.ofWithStatusBaseShipmentWithTrackingOutForDelivery(withStatusBaseShipmentWithTrackingOutForDelivery)`.
         */
        fun shipment(
            withStatusBaseShipmentWithTrackingOutForDelivery:
                Shipment.WithStatusBaseShipmentWithTrackingOutForDelivery
        ) =
            shipment(
                Shipment.ofWithStatusBaseShipmentWithTrackingOutForDelivery(
                    withStatusBaseShipmentWithTrackingOutForDelivery
                )
            )

        /**
         * Alias for calling [shipment] with
         * `Shipment.ofWithStatusBaseShipmentOrdered(withStatusBaseShipmentOrdered)`.
         */
        fun shipment(withStatusBaseShipmentOrdered: Shipment.WithStatusBaseShipmentOrdered) =
            shipment(Shipment.ofWithStatusBaseShipmentOrdered(withStatusBaseShipmentOrdered))

        /**
         * Alias for calling [shipment] with
         * `Shipment.ofWithStatusBaseShipmentCanceled(withStatusBaseShipmentCanceled)`.
         */
        fun shipment(withStatusBaseShipmentCanceled: Shipment.WithStatusBaseShipmentCanceled) =
            shipment(Shipment.ofWithStatusBaseShipmentCanceled(withStatusBaseShipmentCanceled))

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
         * Returns an immutable instance of [ShipmentAdvanceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .shipment()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ShipmentAdvanceResponse =
            ShipmentAdvanceResponse(
                checkRequired("shipment", shipment),
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
    fun validate(): ShipmentAdvanceResponse = apply {
        if (validated) {
            return@apply
        }

        shipment().validate()
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
    @JvmSynthetic internal fun validity(): Int = (shipment.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ShipmentAdvanceResponse &&
            shipment == other.shipment &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(shipment, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ShipmentAdvanceResponse{shipment=$shipment, additionalProperties=$additionalProperties}"
}
