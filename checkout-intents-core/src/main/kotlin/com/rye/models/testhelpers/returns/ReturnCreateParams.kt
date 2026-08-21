// File generated from our OpenAPI spec by Stainless.

package com.rye.models.testhelpers.returns

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.Params
import com.rye.core.checkKnown
import com.rye.core.checkRequired
import com.rye.core.http.Headers
import com.rye.core.http.QueryParams
import com.rye.core.toImmutable
import com.rye.errors.CheckoutIntentsInvalidDataException
import com.rye.models.returns.ReturnReason
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a simulated return for an order, then drive it through its lifecycle with the
 * approve/deny/refund/fail helpers below.
 */
class ReturnCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Rye order id (`oi_<hex>` / `order_<hex>`) to open the simulated return against.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderId(): String = body.orderId()

    /**
     * Subset of order line items to return. Defaults to every order item at full quantity.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun lineItems(): Optional<List<LineItem>> = body.lineItems()

    /**
     * Defaults to `other` when omitted.
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun reason(): Optional<ReturnReason> = body.reason()

    /**
     * Returns the raw JSON value of [orderId].
     *
     * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _orderId(): JsonField<String> = body._orderId()

    /**
     * Returns the raw JSON value of [lineItems].
     *
     * Unlike [lineItems], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _lineItems(): JsonField<List<LineItem>> = body._lineItems()

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _reason(): JsonField<ReturnReason> = body._reason()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ReturnCreateParams].
         *
         * The following fields are required:
         * ```java
         * .orderId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ReturnCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(returnCreateParams: ReturnCreateParams) = apply {
            body = returnCreateParams.body.toBuilder()
            additionalHeaders = returnCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = returnCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [orderId]
         * - [lineItems]
         * - [reason]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Rye order id (`oi_<hex>` / `order_<hex>`) to open the simulated return against. */
        fun orderId(orderId: String) = apply { body.orderId(orderId) }

        /**
         * Sets [Builder.orderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orderId(orderId: JsonField<String>) = apply { body.orderId(orderId) }

        /** Subset of order line items to return. Defaults to every order item at full quantity. */
        fun lineItems(lineItems: List<LineItem>) = apply { body.lineItems(lineItems) }

        /**
         * Sets [Builder.lineItems] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lineItems] with a well-typed `List<LineItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun lineItems(lineItems: JsonField<List<LineItem>>) = apply { body.lineItems(lineItems) }

        /**
         * Adds a single [LineItem] to [lineItems].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLineItem(lineItem: LineItem) = apply { body.addLineItem(lineItem) }

        /** Defaults to `other` when omitted. */
        fun reason(reason: ReturnReason) = apply { body.reason(reason) }

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [ReturnReason] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reason(reason: JsonField<ReturnReason>) = apply { body.reason(reason) }

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
         * Returns an immutable instance of [ReturnCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .orderId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ReturnCreateParams =
            ReturnCreateParams(
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
        private val orderId: JsonField<String>,
        private val lineItems: JsonField<List<LineItem>>,
        private val reason: JsonField<ReturnReason>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("orderId") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lineItems")
            @ExcludeMissing
            lineItems: JsonField<List<LineItem>> = JsonMissing.of(),
            @JsonProperty("reason")
            @ExcludeMissing
            reason: JsonField<ReturnReason> = JsonMissing.of(),
        ) : this(orderId, lineItems, reason, mutableMapOf())

        /**
         * Rye order id (`oi_<hex>` / `order_<hex>`) to open the simulated return against.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun orderId(): String = orderId.getRequired("orderId")

        /**
         * Subset of order line items to return. Defaults to every order item at full quantity.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun lineItems(): Optional<List<LineItem>> = lineItems.getOptional("lineItems")

        /**
         * Defaults to `other` when omitted.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun reason(): Optional<ReturnReason> = reason.getOptional("reason")

        /**
         * Returns the raw JSON value of [orderId].
         *
         * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("orderId") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

        /**
         * Returns the raw JSON value of [lineItems].
         *
         * Unlike [lineItems], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lineItems")
        @ExcludeMissing
        fun _lineItems(): JsonField<List<LineItem>> = lineItems

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<ReturnReason> = reason

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
             * .orderId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var orderId: JsonField<String>? = null
            private var lineItems: JsonField<MutableList<LineItem>>? = null
            private var reason: JsonField<ReturnReason> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                orderId = body.orderId
                lineItems = body.lineItems.map { it.toMutableList() }
                reason = body.reason
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Rye order id (`oi_<hex>` / `order_<hex>`) to open the simulated return against. */
            fun orderId(orderId: String) = orderId(JsonField.of(orderId))

            /**
             * Sets [Builder.orderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

            /**
             * Subset of order line items to return. Defaults to every order item at full quantity.
             */
            fun lineItems(lineItems: List<LineItem>) = lineItems(JsonField.of(lineItems))

            /**
             * Sets [Builder.lineItems] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lineItems] with a well-typed `List<LineItem>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun lineItems(lineItems: JsonField<List<LineItem>>) = apply {
                this.lineItems = lineItems.map { it.toMutableList() }
            }

            /**
             * Adds a single [LineItem] to [lineItems].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLineItem(lineItem: LineItem) = apply {
                lineItems =
                    (lineItems ?: JsonField.of(mutableListOf())).also {
                        checkKnown("lineItems", it).add(lineItem)
                    }
            }

            /** Defaults to `other` when omitted. */
            fun reason(reason: ReturnReason) = reason(JsonField.of(reason))

            /**
             * Sets [Builder.reason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reason] with a well-typed [ReturnReason] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reason(reason: JsonField<ReturnReason>) = apply { this.reason = reason }

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
             * .orderId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("orderId", orderId),
                    (lineItems ?: JsonMissing.of()).map { it.toImmutable() },
                    reason,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            orderId()
            lineItems().ifPresent { it.forEach { it.validate() } }
            reason().ifPresent { it.validate() }
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
            (if (orderId.asKnown().isPresent) 1 else 0) +
                (lineItems.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (reason.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                orderId == other.orderId &&
                lineItems == other.lineItems &&
                reason == other.reason &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(orderId, lineItems, reason, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{orderId=$orderId, lineItems=$lineItems, reason=$reason, additionalProperties=$additionalProperties}"
    }

    class LineItem
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val orderLineItemId: JsonField<String>,
        private val quantity: JsonField<Int>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("orderLineItemId")
            @ExcludeMissing
            orderLineItemId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Int> = JsonMissing.of(),
        ) : this(orderLineItemId, quantity, mutableMapOf())

        /**
         * Order line item id (`oi_<hex>`) to return.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun orderLineItemId(): String = orderLineItemId.getRequired("orderLineItemId")

        /**
         * Units of this line item to return.
         *
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun quantity(): Int = quantity.getRequired("quantity")

        /**
         * Returns the raw JSON value of [orderLineItemId].
         *
         * Unlike [orderLineItemId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("orderLineItemId")
        @ExcludeMissing
        fun _orderLineItemId(): JsonField<String> = orderLineItemId

        /**
         * Returns the raw JSON value of [quantity].
         *
         * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Int> = quantity

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
             * Returns a mutable builder for constructing an instance of [LineItem].
             *
             * The following fields are required:
             * ```java
             * .orderLineItemId()
             * .quantity()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LineItem]. */
        class Builder internal constructor() {

            private var orderLineItemId: JsonField<String>? = null
            private var quantity: JsonField<Int>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(lineItem: LineItem) = apply {
                orderLineItemId = lineItem.orderLineItemId
                quantity = lineItem.quantity
                additionalProperties = lineItem.additionalProperties.toMutableMap()
            }

            /** Order line item id (`oi_<hex>`) to return. */
            fun orderLineItemId(orderLineItemId: String) =
                orderLineItemId(JsonField.of(orderLineItemId))

            /**
             * Sets [Builder.orderLineItemId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderLineItemId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderLineItemId(orderLineItemId: JsonField<String>) = apply {
                this.orderLineItemId = orderLineItemId
            }

            /** Units of this line item to return. */
            fun quantity(quantity: Int) = quantity(JsonField.of(quantity))

            /**
             * Sets [Builder.quantity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quantity] with a well-typed [Int] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quantity(quantity: JsonField<Int>) = apply { this.quantity = quantity }

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
             * Returns an immutable instance of [LineItem].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .orderLineItemId()
             * .quantity()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): LineItem =
                LineItem(
                    checkRequired("orderLineItemId", orderLineItemId),
                    checkRequired("quantity", quantity),
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): LineItem = apply {
            if (validated) {
                return@apply
            }

            orderLineItemId()
            quantity()
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
            (if (orderLineItemId.asKnown().isPresent) 1 else 0) +
                (if (quantity.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LineItem &&
                orderLineItemId == other.orderLineItemId &&
                quantity == other.quantity &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(orderLineItemId, quantity, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LineItem{orderLineItemId=$orderLineItemId, quantity=$quantity, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ReturnCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ReturnCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
