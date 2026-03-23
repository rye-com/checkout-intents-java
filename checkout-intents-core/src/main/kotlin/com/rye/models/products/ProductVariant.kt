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
import com.rye.core.checkKnown
import com.rye.core.checkRequired
import com.rye.core.toImmutable
import com.rye.errors.CheckoutIntentsInvalidDataException
import com.rye.models.checkoutintents.Money
import com.rye.models.checkoutintents.VariantSelection
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ProductVariant
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val availability: JsonField<ProductAvailability>,
    private val dimensions: JsonField<List<VariantSelection>>,
    private val images: JsonField<List<ProductImage>>,
    private val name: JsonField<String>,
    private val price: JsonField<Money>,
    private val sku: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("availability")
        @ExcludeMissing
        availability: JsonField<ProductAvailability> = JsonMissing.of(),
        @JsonProperty("dimensions")
        @ExcludeMissing
        dimensions: JsonField<List<VariantSelection>> = JsonMissing.of(),
        @JsonProperty("images")
        @ExcludeMissing
        images: JsonField<List<ProductImage>> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<Money> = JsonMissing.of(),
        @JsonProperty("sku") @ExcludeMissing sku: JsonField<String> = JsonMissing.of(),
    ) : this(id, availability, dimensions, images, name, price, sku, mutableMapOf())

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * The availability status of a product.
     * - `in_stock`: Product is available for immediate purchase
     * - `out_of_stock`: Product is currently unavailable
     * - `preorder`: Product is available for pre-order before release
     * - `backorder`: Product is temporarily out of stock but can be ordered
     * - `unknown`: Availability could not be determined
     *
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun availability(): ProductAvailability = availability.getRequired("availability")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun dimensions(): List<VariantSelection> = dimensions.getRequired("dimensions")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun images(): List<ProductImage> = images.getRequired("images")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun price(): Money = price.getRequired("price")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sku(): Optional<String> = sku.getOptional("sku")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [availability].
     *
     * Unlike [availability], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("availability")
    @ExcludeMissing
    fun _availability(): JsonField<ProductAvailability> = availability

    /**
     * Returns the raw JSON value of [dimensions].
     *
     * Unlike [dimensions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("dimensions")
    @ExcludeMissing
    fun _dimensions(): JsonField<List<VariantSelection>> = dimensions

    /**
     * Returns the raw JSON value of [images].
     *
     * Unlike [images], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("images") @ExcludeMissing fun _images(): JsonField<List<ProductImage>> = images

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [price].
     *
     * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Money> = price

    /**
     * Returns the raw JSON value of [sku].
     *
     * Unlike [sku], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sku") @ExcludeMissing fun _sku(): JsonField<String> = sku

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
         * Returns a mutable builder for constructing an instance of [ProductVariant].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .availability()
         * .dimensions()
         * .images()
         * .name()
         * .price()
         * .sku()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProductVariant]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var availability: JsonField<ProductAvailability>? = null
        private var dimensions: JsonField<MutableList<VariantSelection>>? = null
        private var images: JsonField<MutableList<ProductImage>>? = null
        private var name: JsonField<String>? = null
        private var price: JsonField<Money>? = null
        private var sku: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(productVariant: ProductVariant) = apply {
            id = productVariant.id
            availability = productVariant.availability
            dimensions = productVariant.dimensions.map { it.toMutableList() }
            images = productVariant.images.map { it.toMutableList() }
            name = productVariant.name
            price = productVariant.price
            sku = productVariant.sku
            additionalProperties = productVariant.additionalProperties.toMutableMap()
        }

        fun id(id: String?) = id(JsonField.ofNullable(id))

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * The availability status of a product.
         * - `in_stock`: Product is available for immediate purchase
         * - `out_of_stock`: Product is currently unavailable
         * - `preorder`: Product is available for pre-order before release
         * - `backorder`: Product is temporarily out of stock but can be ordered
         * - `unknown`: Availability could not be determined
         */
        fun availability(availability: ProductAvailability) =
            availability(JsonField.of(availability))

        /**
         * Sets [Builder.availability] to an arbitrary JSON value.
         *
         * You should usually call [Builder.availability] with a well-typed [ProductAvailability]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun availability(availability: JsonField<ProductAvailability>) = apply {
            this.availability = availability
        }

        fun dimensions(dimensions: List<VariantSelection>) = dimensions(JsonField.of(dimensions))

        /**
         * Sets [Builder.dimensions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dimensions] with a well-typed `List<VariantSelection>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun dimensions(dimensions: JsonField<List<VariantSelection>>) = apply {
            this.dimensions = dimensions.map { it.toMutableList() }
        }

        /**
         * Adds a single [VariantSelection] to [dimensions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDimension(dimension: VariantSelection) = apply {
            dimensions =
                (dimensions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("dimensions", it).add(dimension)
                }
        }

        fun images(images: List<ProductImage>) = images(JsonField.of(images))

        /**
         * Sets [Builder.images] to an arbitrary JSON value.
         *
         * You should usually call [Builder.images] with a well-typed `List<ProductImage>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun images(images: JsonField<List<ProductImage>>) = apply {
            this.images = images.map { it.toMutableList() }
        }

        /**
         * Adds a single [ProductImage] to [images].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addImage(image: ProductImage) = apply {
            images =
                (images ?: JsonField.of(mutableListOf())).also {
                    checkKnown("images", it).add(image)
                }
        }

        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun price(price: Money) = price(JsonField.of(price))

        /**
         * Sets [Builder.price] to an arbitrary JSON value.
         *
         * You should usually call [Builder.price] with a well-typed [Money] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun price(price: JsonField<Money>) = apply { this.price = price }

        fun sku(sku: String?) = sku(JsonField.ofNullable(sku))

        /** Alias for calling [Builder.sku] with `sku.orElse(null)`. */
        fun sku(sku: Optional<String>) = sku(sku.getOrNull())

        /**
         * Sets [Builder.sku] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sku] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sku(sku: JsonField<String>) = apply { this.sku = sku }

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
         * Returns an immutable instance of [ProductVariant].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .availability()
         * .dimensions()
         * .images()
         * .name()
         * .price()
         * .sku()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProductVariant =
            ProductVariant(
                checkRequired("id", id),
                checkRequired("availability", availability),
                checkRequired("dimensions", dimensions).map { it.toImmutable() },
                checkRequired("images", images).map { it.toImmutable() },
                checkRequired("name", name),
                checkRequired("price", price),
                checkRequired("sku", sku),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ProductVariant = apply {
        if (validated) {
            return@apply
        }

        id()
        availability().validate()
        dimensions().forEach { it.validate() }
        images().forEach { it.validate() }
        name()
        price().validate()
        sku()
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
            (availability.asKnown().getOrNull()?.validity() ?: 0) +
            (dimensions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (images.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (price.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sku.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProductVariant &&
            id == other.id &&
            availability == other.availability &&
            dimensions == other.dimensions &&
            images == other.images &&
            name == other.name &&
            price == other.price &&
            sku == other.sku &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, availability, dimensions, images, name, price, sku, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProductVariant{id=$id, availability=$availability, dimensions=$dimensions, images=$images, name=$name, price=$price, sku=$sku, additionalProperties=$additionalProperties}"
}
