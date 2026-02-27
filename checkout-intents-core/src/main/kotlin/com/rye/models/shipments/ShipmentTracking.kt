// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ShipmentTracking
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val number: JsonField<String>,
    private val carrierName: JsonField<String>,
    private val estimatedDeliveryDate: JsonField<OffsetDateTime>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
        @JsonProperty("carrierName")
        @ExcludeMissing
        carrierName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("estimatedDeliveryDate")
        @ExcludeMissing
        estimatedDeliveryDate: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(number, carrierName, estimatedDeliveryDate, url, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun number(): Optional<String> = number.getOptional("number")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun carrierName(): Optional<String> = carrierName.getOptional("carrierName")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun estimatedDeliveryDate(): Optional<OffsetDateTime> =
        estimatedDeliveryDate.getOptional("estimatedDeliveryDate")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * Returns the raw JSON value of [number].
     *
     * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

    /**
     * Returns the raw JSON value of [carrierName].
     *
     * Unlike [carrierName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("carrierName") @ExcludeMissing fun _carrierName(): JsonField<String> = carrierName

    /**
     * Returns the raw JSON value of [estimatedDeliveryDate].
     *
     * Unlike [estimatedDeliveryDate], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("estimatedDeliveryDate")
    @ExcludeMissing
    fun _estimatedDeliveryDate(): JsonField<OffsetDateTime> = estimatedDeliveryDate

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
         * Returns a mutable builder for constructing an instance of [ShipmentTracking].
         *
         * The following fields are required:
         * ```java
         * .number()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ShipmentTracking]. */
    class Builder internal constructor() {

        private var number: JsonField<String>? = null
        private var carrierName: JsonField<String> = JsonMissing.of()
        private var estimatedDeliveryDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(shipmentTracking: ShipmentTracking) = apply {
            number = shipmentTracking.number
            carrierName = shipmentTracking.carrierName
            estimatedDeliveryDate = shipmentTracking.estimatedDeliveryDate
            url = shipmentTracking.url
            additionalProperties = shipmentTracking.additionalProperties.toMutableMap()
        }

        fun number(number: String?) = number(JsonField.ofNullable(number))

        /** Alias for calling [Builder.number] with `number.orElse(null)`. */
        fun number(number: Optional<String>) = number(number.getOrNull())

        /**
         * Sets [Builder.number] to an arbitrary JSON value.
         *
         * You should usually call [Builder.number] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun number(number: JsonField<String>) = apply { this.number = number }

        fun carrierName(carrierName: String?) = carrierName(JsonField.ofNullable(carrierName))

        /** Alias for calling [Builder.carrierName] with `carrierName.orElse(null)`. */
        fun carrierName(carrierName: Optional<String>) = carrierName(carrierName.getOrNull())

        /**
         * Sets [Builder.carrierName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.carrierName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun carrierName(carrierName: JsonField<String>) = apply { this.carrierName = carrierName }

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

        fun url(url: String?) = url(JsonField.ofNullable(url))

        /** Alias for calling [Builder.url] with `url.orElse(null)`. */
        fun url(url: Optional<String>) = url(url.getOrNull())

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

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
         * Returns an immutable instance of [ShipmentTracking].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .number()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ShipmentTracking =
            ShipmentTracking(
                checkRequired("number", number),
                carrierName,
                estimatedDeliveryDate,
                url,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ShipmentTracking = apply {
        if (validated) {
            return@apply
        }

        number()
        carrierName()
        estimatedDeliveryDate()
        url()
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
        (if (number.asKnown().isPresent) 1 else 0) +
            (if (carrierName.asKnown().isPresent) 1 else 0) +
            (if (estimatedDeliveryDate.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ShipmentTracking &&
            number == other.number &&
            carrierName == other.carrierName &&
            estimatedDeliveryDate == other.estimatedDeliveryDate &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(number, carrierName, estimatedDeliveryDate, url, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ShipmentTracking{number=$number, carrierName=$carrierName, estimatedDeliveryDate=$estimatedDeliveryDate, url=$url, additionalProperties=$additionalProperties}"
}
