// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.rye.core.ExcludeMissing
import com.rye.core.JsonField
import com.rye.core.JsonMissing
import com.rye.core.JsonValue
import com.rye.core.checkKnown
import com.rye.core.checkRequired
import com.rye.core.toImmutable
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BillingListTransactionsPageResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<List<BillingListTransactionsResponse>>,
    private val pageInfo: JsonField<PageInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        data: JsonField<List<BillingListTransactionsResponse>> = JsonMissing.of(),
        @JsonProperty("pageInfo") @ExcludeMissing pageInfo: JsonField<PageInfo> = JsonMissing.of(),
    ) : this(data, pageInfo, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<BillingListTransactionsResponse> = data.getRequired("data")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pageInfo(): PageInfo = pageInfo.getRequired("pageInfo")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data")
    @ExcludeMissing
    fun _data(): JsonField<List<BillingListTransactionsResponse>> = data

    /**
     * Returns the raw JSON value of [pageInfo].
     *
     * Unlike [pageInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pageInfo") @ExcludeMissing fun _pageInfo(): JsonField<PageInfo> = pageInfo

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
         * [BillingListTransactionsPageResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .pageInfo()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BillingListTransactionsPageResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<BillingListTransactionsResponse>>? = null
        private var pageInfo: JsonField<PageInfo>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            billingListTransactionsPageResponse: BillingListTransactionsPageResponse
        ) = apply {
            data = billingListTransactionsPageResponse.data.map { it.toMutableList() }
            pageInfo = billingListTransactionsPageResponse.pageInfo
            additionalProperties =
                billingListTransactionsPageResponse.additionalProperties.toMutableMap()
        }

        fun data(data: List<BillingListTransactionsResponse>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed
         * `List<BillingListTransactionsResponse>` value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<List<BillingListTransactionsResponse>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [BillingListTransactionsResponse] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: BillingListTransactionsResponse) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

        /**
         * Sets [Builder.pageInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pageInfo] with a well-typed [PageInfo] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pageInfo(pageInfo: JsonField<PageInfo>) = apply { this.pageInfo = pageInfo }

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
         * Returns an immutable instance of [BillingListTransactionsPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .pageInfo()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BillingListTransactionsPageResponse =
            BillingListTransactionsPageResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("pageInfo", pageInfo),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BillingListTransactionsPageResponse = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        pageInfo().validate()
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
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (pageInfo.asKnown().getOrNull()?.validity() ?: 0)

    class PageInfo
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hasNextPage: JsonField<Boolean>,
        private val hasPreviousPage: JsonField<Boolean>,
        private val endCursor: JsonField<String>,
        private val startCursor: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hasNextPage")
            @ExcludeMissing
            hasNextPage: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("hasPreviousPage")
            @ExcludeMissing
            hasPreviousPage: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("endCursor")
            @ExcludeMissing
            endCursor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("startCursor")
            @ExcludeMissing
            startCursor: JsonField<String> = JsonMissing.of(),
        ) : this(hasNextPage, hasPreviousPage, endCursor, startCursor, mutableMapOf())

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun hasNextPage(): Boolean = hasNextPage.getRequired("hasNextPage")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun hasPreviousPage(): Boolean = hasPreviousPage.getRequired("hasPreviousPage")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun endCursor(): Optional<String> = endCursor.getOptional("endCursor")

        /**
         * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun startCursor(): Optional<String> = startCursor.getOptional("startCursor")

        /**
         * Returns the raw JSON value of [hasNextPage].
         *
         * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasNextPage")
        @ExcludeMissing
        fun _hasNextPage(): JsonField<Boolean> = hasNextPage

        /**
         * Returns the raw JSON value of [hasPreviousPage].
         *
         * Unlike [hasPreviousPage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("hasPreviousPage")
        @ExcludeMissing
        fun _hasPreviousPage(): JsonField<Boolean> = hasPreviousPage

        /**
         * Returns the raw JSON value of [endCursor].
         *
         * Unlike [endCursor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("endCursor") @ExcludeMissing fun _endCursor(): JsonField<String> = endCursor

        /**
         * Returns the raw JSON value of [startCursor].
         *
         * Unlike [startCursor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("startCursor")
        @ExcludeMissing
        fun _startCursor(): JsonField<String> = startCursor

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
             * Returns a mutable builder for constructing an instance of [PageInfo].
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .hasPreviousPage()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PageInfo]. */
        class Builder internal constructor() {

            private var hasNextPage: JsonField<Boolean>? = null
            private var hasPreviousPage: JsonField<Boolean>? = null
            private var endCursor: JsonField<String> = JsonMissing.of()
            private var startCursor: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(pageInfo: PageInfo) = apply {
                hasNextPage = pageInfo.hasNextPage
                hasPreviousPage = pageInfo.hasPreviousPage
                endCursor = pageInfo.endCursor
                startCursor = pageInfo.startCursor
                additionalProperties = pageInfo.additionalProperties.toMutableMap()
            }

            fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

            /**
             * Sets [Builder.hasNextPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasNextPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply {
                this.hasNextPage = hasNextPage
            }

            fun hasPreviousPage(hasPreviousPage: Boolean) =
                hasPreviousPage(JsonField.of(hasPreviousPage))

            /**
             * Sets [Builder.hasPreviousPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasPreviousPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasPreviousPage(hasPreviousPage: JsonField<Boolean>) = apply {
                this.hasPreviousPage = hasPreviousPage
            }

            fun endCursor(endCursor: String) = endCursor(JsonField.of(endCursor))

            /**
             * Sets [Builder.endCursor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endCursor] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endCursor(endCursor: JsonField<String>) = apply { this.endCursor = endCursor }

            fun startCursor(startCursor: String) = startCursor(JsonField.of(startCursor))

            /**
             * Sets [Builder.startCursor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.startCursor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun startCursor(startCursor: JsonField<String>) = apply {
                this.startCursor = startCursor
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
             * Returns an immutable instance of [PageInfo].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .hasPreviousPage()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PageInfo =
                PageInfo(
                    checkRequired("hasNextPage", hasNextPage),
                    checkRequired("hasPreviousPage", hasPreviousPage),
                    endCursor,
                    startCursor,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PageInfo = apply {
            if (validated) {
                return@apply
            }

            hasNextPage()
            hasPreviousPage()
            endCursor()
            startCursor()
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
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
                (if (hasPreviousPage.asKnown().isPresent) 1 else 0) +
                (if (endCursor.asKnown().isPresent) 1 else 0) +
                (if (startCursor.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PageInfo &&
                hasNextPage == other.hasNextPage &&
                hasPreviousPage == other.hasPreviousPage &&
                endCursor == other.endCursor &&
                startCursor == other.startCursor &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(hasNextPage, hasPreviousPage, endCursor, startCursor, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PageInfo{hasNextPage=$hasNextPage, hasPreviousPage=$hasPreviousPage, endCursor=$endCursor, startCursor=$startCursor, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BillingListTransactionsPageResponse &&
            data == other.data &&
            pageInfo == other.pageInfo &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(data, pageInfo, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BillingListTransactionsPageResponse{data=$data, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"
}
