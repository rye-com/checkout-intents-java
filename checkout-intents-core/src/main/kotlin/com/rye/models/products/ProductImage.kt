// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

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
import java.util.Collections
import java.util.Objects

class ProductImage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val isFeatured: JsonField<Boolean>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("isFeatured")
        @ExcludeMissing
        isFeatured: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(isFeatured, url, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isFeatured(): Boolean = isFeatured.getRequired("isFeatured")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun url(): String = url.getRequired("url")

    /**
     * Returns the raw JSON value of [isFeatured].
     *
     * Unlike [isFeatured], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isFeatured") @ExcludeMissing fun _isFeatured(): JsonField<Boolean> = isFeatured

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
         * Returns a mutable builder for constructing an instance of [ProductImage].
         *
         * The following fields are required:
         * ```java
         * .isFeatured()
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProductImage]. */
    class Builder internal constructor() {

        private var isFeatured: JsonField<Boolean>? = null
        private var url: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(productImage: ProductImage) = apply {
            isFeatured = productImage.isFeatured
            url = productImage.url
            additionalProperties = productImage.additionalProperties.toMutableMap()
        }

        fun isFeatured(isFeatured: Boolean) = isFeatured(JsonField.of(isFeatured))

        /**
         * Sets [Builder.isFeatured] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isFeatured] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isFeatured(isFeatured: JsonField<Boolean>) = apply { this.isFeatured = isFeatured }

        fun url(url: String) = url(JsonField.of(url))

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
         * Returns an immutable instance of [ProductImage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .isFeatured()
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProductImage =
            ProductImage(
                checkRequired("isFeatured", isFeatured),
                checkRequired("url", url),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ProductImage = apply {
        if (validated) {
            return@apply
        }

        isFeatured()
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
        (if (isFeatured.asKnown().isPresent) 1 else 0) + (if (url.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProductImage &&
            isFeatured == other.isFeatured &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(isFeatured, url, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProductImage{isFeatured=$isFeatured, url=$url, additionalProperties=$additionalProperties}"
}
