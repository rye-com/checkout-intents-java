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
    private val deliveryDate: JsonField<DeliveryDate>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
        @JsonProperty("carrierName")
        @ExcludeMissing
        carrierName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("deliveryDate")
        @ExcludeMissing
        deliveryDate: JsonField<DeliveryDate> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(number, carrierName, deliveryDate, url, mutableMapOf())

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
    fun deliveryDate(): Optional<DeliveryDate> = deliveryDate.getOptional("deliveryDate")

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
     * Returns the raw JSON value of [deliveryDate].
     *
     * Unlike [deliveryDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deliveryDate")
    @ExcludeMissing
    fun _deliveryDate(): JsonField<DeliveryDate> = deliveryDate

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
        private var deliveryDate: JsonField<DeliveryDate> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(shipmentTracking: ShipmentTracking) = apply {
            number = shipmentTracking.number
            carrierName = shipmentTracking.carrierName
            deliveryDate = shipmentTracking.deliveryDate
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

        fun deliveryDate(deliveryDate: DeliveryDate?) =
            deliveryDate(JsonField.ofNullable(deliveryDate))

        /** Alias for calling [Builder.deliveryDate] with `deliveryDate.orElse(null)`. */
        fun deliveryDate(deliveryDate: Optional<DeliveryDate>) =
            deliveryDate(deliveryDate.getOrNull())

        /**
         * Sets [Builder.deliveryDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveryDate] with a well-typed [DeliveryDate] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deliveryDate(deliveryDate: JsonField<DeliveryDate>) = apply {
            this.deliveryDate = deliveryDate
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
                deliveryDate,
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
        deliveryDate().ifPresent { it.validate() }
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
            (deliveryDate.asKnown().getOrNull()?.validity() ?: 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    class DeliveryDate
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val estimated: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("estimated")
            @ExcludeMissing
            estimated: JsonField<OffsetDateTime> = JsonMissing.of()
        ) : this(estimated, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun estimated(): OffsetDateTime = estimated.getRequired("estimated")

        /**
         * Returns the raw JSON value of [estimated].
         *
         * Unlike [estimated], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("estimated")
        @ExcludeMissing
        fun _estimated(): JsonField<OffsetDateTime> = estimated

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
             * Returns a mutable builder for constructing an instance of [DeliveryDate].
             *
             * The following fields are required:
             * ```java
             * .estimated()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DeliveryDate]. */
        class Builder internal constructor() {

            private var estimated: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(deliveryDate: DeliveryDate) = apply {
                estimated = deliveryDate.estimated
                additionalProperties = deliveryDate.additionalProperties.toMutableMap()
            }

            fun estimated(estimated: OffsetDateTime) = estimated(JsonField.of(estimated))

            /**
             * Sets [Builder.estimated] to an arbitrary JSON value.
             *
             * You should usually call [Builder.estimated] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun estimated(estimated: JsonField<OffsetDateTime>) = apply {
                this.estimated = estimated
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
             * Returns an immutable instance of [DeliveryDate].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .estimated()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): DeliveryDate =
                DeliveryDate(
                    checkRequired("estimated", estimated),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): DeliveryDate = apply {
            if (validated) {
                return@apply
            }

            estimated()
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
        @JvmSynthetic internal fun validity(): Int = (if (estimated.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DeliveryDate &&
                estimated == other.estimated &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(estimated, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "DeliveryDate{estimated=$estimated, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ShipmentTracking &&
            number == other.number &&
            carrierName == other.carrierName &&
            deliveryDate == other.deliveryDate &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(number, carrierName, deliveryDate, url, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ShipmentTracking{number=$number, carrierName=$carrierName, deliveryDate=$deliveryDate, url=$url, additionalProperties=$additionalProperties}"
}
