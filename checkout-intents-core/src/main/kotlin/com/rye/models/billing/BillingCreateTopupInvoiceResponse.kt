// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.Enum
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.checkRequired
import com.rye.errors.CheckoutIntentsInvalidDataException
import com.rye.models.checkoutintents.Money
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BillingCreateTopupInvoiceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val amount: JsonField<Money>,
    private val bankTransferDetails: JsonField<BankTransferDetails>,
    private val status: JsonField<Status>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("amount") @ExcludeMissing amount: JsonField<Money> = JsonMissing.of(),
        @JsonProperty("bankTransferDetails")
        @ExcludeMissing
        bankTransferDetails: JsonField<BankTransferDetails> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(id, amount, bankTransferDetails, status, url, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun amount(): Money = amount.getRequired("amount")

    /**
     * Vendor-agnostic bank transfer details for push-based payment
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bankTransferDetails(): BankTransferDetails =
        bankTransferDetails.getRequired("bankTransferDetails")

    /**
     * Vendor-agnostic provider types
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [amount].
     *
     * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Money> = amount

    /**
     * Returns the raw JSON value of [bankTransferDetails].
     *
     * Unlike [bankTransferDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("bankTransferDetails")
    @ExcludeMissing
    fun _bankTransferDetails(): JsonField<BankTransferDetails> = bankTransferDetails

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * Returns a mutable builder for constructing an instance of
         * [BillingCreateTopupInvoiceResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .amount()
         * .bankTransferDetails()
         * .status()
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BillingCreateTopupInvoiceResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var amount: JsonField<Money>? = null
        private var bankTransferDetails: JsonField<BankTransferDetails>? = null
        private var status: JsonField<Status>? = null
        private var url: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(billingCreateTopupInvoiceResponse: BillingCreateTopupInvoiceResponse) =
            apply {
                id = billingCreateTopupInvoiceResponse.id
                amount = billingCreateTopupInvoiceResponse.amount
                bankTransferDetails = billingCreateTopupInvoiceResponse.bankTransferDetails
                status = billingCreateTopupInvoiceResponse.status
                url = billingCreateTopupInvoiceResponse.url
                additionalProperties =
                    billingCreateTopupInvoiceResponse.additionalProperties.toMutableMap()
            }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun amount(amount: Money) = amount(JsonField.of(amount))

        /**
         * Sets [Builder.amount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amount] with a well-typed [Money] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun amount(amount: JsonField<Money>) = apply { this.amount = amount }

        /** Vendor-agnostic bank transfer details for push-based payment */
        fun bankTransferDetails(bankTransferDetails: BankTransferDetails) =
            bankTransferDetails(JsonField.of(bankTransferDetails))

        /**
         * Sets [Builder.bankTransferDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bankTransferDetails] with a well-typed
         * [BankTransferDetails] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun bankTransferDetails(bankTransferDetails: JsonField<BankTransferDetails>) = apply {
            this.bankTransferDetails = bankTransferDetails
        }

        /** Vendor-agnostic provider types */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

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
         * Returns an immutable instance of [BillingCreateTopupInvoiceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .amount()
         * .bankTransferDetails()
         * .status()
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BillingCreateTopupInvoiceResponse =
            BillingCreateTopupInvoiceResponse(
                checkRequired("id", id),
                checkRequired("amount", amount),
                checkRequired("bankTransferDetails", bankTransferDetails),
                checkRequired("status", status),
                checkRequired("url", url),
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
    fun validate(): BillingCreateTopupInvoiceResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        amount().validate()
        bankTransferDetails().validate()
        status().validate()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (amount.asKnown().getOrNull()?.validity() ?: 0) +
            (bankTransferDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    /** Vendor-agnostic bank transfer details for push-based payment */
    class BankTransferDetails
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val accountHolderName: JsonField<String>,
        private val accountNumber: JsonField<String>,
        private val bankName: JsonField<String>,
        private val routingNumber: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("accountHolderName")
            @ExcludeMissing
            accountHolderName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("accountNumber")
            @ExcludeMissing
            accountNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bankName")
            @ExcludeMissing
            bankName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("routingNumber")
            @ExcludeMissing
            routingNumber: JsonField<String> = JsonMissing.of(),
        ) : this(accountHolderName, accountNumber, bankName, routingNumber, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun accountHolderName(): String = accountHolderName.getRequired("accountHolderName")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun accountNumber(): String = accountNumber.getRequired("accountNumber")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun bankName(): String = bankName.getRequired("bankName")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun routingNumber(): String = routingNumber.getRequired("routingNumber")

        /**
         * Returns the raw JSON value of [accountHolderName].
         *
         * Unlike [accountHolderName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("accountHolderName")
        @ExcludeMissing
        fun _accountHolderName(): JsonField<String> = accountHolderName

        /**
         * Returns the raw JSON value of [accountNumber].
         *
         * Unlike [accountNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("accountNumber")
        @ExcludeMissing
        fun _accountNumber(): JsonField<String> = accountNumber

        /**
         * Returns the raw JSON value of [bankName].
         *
         * Unlike [bankName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bankName") @ExcludeMissing fun _bankName(): JsonField<String> = bankName

        /**
         * Returns the raw JSON value of [routingNumber].
         *
         * Unlike [routingNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("routingNumber")
        @ExcludeMissing
        fun _routingNumber(): JsonField<String> = routingNumber

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
             * Returns a mutable builder for constructing an instance of [BankTransferDetails].
             *
             * The following fields are required:
             * ```java
             * .accountHolderName()
             * .accountNumber()
             * .bankName()
             * .routingNumber()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BankTransferDetails]. */
        class Builder internal constructor() {

            private var accountHolderName: JsonField<String>? = null
            private var accountNumber: JsonField<String>? = null
            private var bankName: JsonField<String>? = null
            private var routingNumber: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(bankTransferDetails: BankTransferDetails) = apply {
                accountHolderName = bankTransferDetails.accountHolderName
                accountNumber = bankTransferDetails.accountNumber
                bankName = bankTransferDetails.bankName
                routingNumber = bankTransferDetails.routingNumber
                additionalProperties = bankTransferDetails.additionalProperties.toMutableMap()
            }

            fun accountHolderName(accountHolderName: String) =
                accountHolderName(JsonField.of(accountHolderName))

            /**
             * Sets [Builder.accountHolderName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accountHolderName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accountHolderName(accountHolderName: JsonField<String>) = apply {
                this.accountHolderName = accountHolderName
            }

            fun accountNumber(accountNumber: String) = accountNumber(JsonField.of(accountNumber))

            /**
             * Sets [Builder.accountNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accountNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accountNumber(accountNumber: JsonField<String>) = apply {
                this.accountNumber = accountNumber
            }

            fun bankName(bankName: String) = bankName(JsonField.of(bankName))

            /**
             * Sets [Builder.bankName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bankName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bankName(bankName: JsonField<String>) = apply { this.bankName = bankName }

            fun routingNumber(routingNumber: String) = routingNumber(JsonField.of(routingNumber))

            /**
             * Sets [Builder.routingNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.routingNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun routingNumber(routingNumber: JsonField<String>) = apply {
                this.routingNumber = routingNumber
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
             * Returns an immutable instance of [BankTransferDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .accountHolderName()
             * .accountNumber()
             * .bankName()
             * .routingNumber()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): BankTransferDetails =
                BankTransferDetails(
                    checkRequired("accountHolderName", accountHolderName),
                    checkRequired("accountNumber", accountNumber),
                    checkRequired("bankName", bankName),
                    checkRequired("routingNumber", routingNumber),
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
        fun validate(): BankTransferDetails = apply {
            if (validated) {
                return@apply
            }

            accountHolderName()
            accountNumber()
            bankName()
            routingNumber()
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
            (if (accountHolderName.asKnown().isPresent) 1 else 0) +
                (if (accountNumber.asKnown().isPresent) 1 else 0) +
                (if (bankName.asKnown().isPresent) 1 else 0) +
                (if (routingNumber.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BankTransferDetails &&
                accountHolderName == other.accountHolderName &&
                accountNumber == other.accountNumber &&
                bankName == other.bankName &&
                routingNumber == other.routingNumber &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                accountHolderName,
                accountNumber,
                bankName,
                routingNumber,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BankTransferDetails{accountHolderName=$accountHolderName, accountNumber=$accountNumber, bankName=$bankName, routingNumber=$routingNumber, additionalProperties=$additionalProperties}"
    }

    /** Vendor-agnostic provider types */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val DRAFT = of("draft")

            @JvmField val OPEN = of("open")

            @JvmField val PAID = of("paid")

            @JvmField val UNCOLLECTIBLE = of("uncollectible")

            @JvmField val VOID = of("void")

            @JvmField val UNKNOWN = of("unknown")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            DRAFT,
            OPEN,
            PAID,
            UNCOLLECTIBLE,
            VOID,
            UNKNOWN,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DRAFT,
            OPEN,
            PAID,
            UNCOLLECTIBLE,
            VOID,
            UNKNOWN,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                DRAFT -> Value.DRAFT
                OPEN -> Value.OPEN
                PAID -> Value.PAID
                UNCOLLECTIBLE -> Value.UNCOLLECTIBLE
                VOID -> Value.VOID
                UNKNOWN -> Value.UNKNOWN
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws CheckoutIntentsInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                DRAFT -> Known.DRAFT
                OPEN -> Known.OPEN
                PAID -> Known.PAID
                UNCOLLECTIBLE -> Known.UNCOLLECTIBLE
                VOID -> Known.VOID
                UNKNOWN -> Known.UNKNOWN
                else -> throw CheckoutIntentsInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws CheckoutIntentsInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws CheckoutIntentsInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
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

        return other is BillingCreateTopupInvoiceResponse &&
            id == other.id &&
            amount == other.amount &&
            bankTransferDetails == other.bankTransferDetails &&
            status == other.status &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, amount, bankTransferDetails, status, url, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BillingCreateTopupInvoiceResponse{id=$id, amount=$amount, bankTransferDetails=$bankTransferDetails, status=$status, url=$url, additionalProperties=$additionalProperties}"
}
