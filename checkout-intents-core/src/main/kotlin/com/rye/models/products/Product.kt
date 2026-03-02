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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Product
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val availability: JsonField<ProductAvailability>,
    private val brand: JsonField<String>,
    private val description: JsonField<String>,
    private val images: JsonField<List<ProductImage>>,
    private val isPurchasable: JsonField<Boolean>,
    private val name: JsonField<String>,
    private val price: JsonField<Money>,
    private val sku: JsonField<String>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("availability")
        @ExcludeMissing
        availability: JsonField<ProductAvailability> = JsonMissing.of(),
        @JsonProperty("brand") @ExcludeMissing brand: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("images")
        @ExcludeMissing
        images: JsonField<List<ProductImage>> = JsonMissing.of(),
        @JsonProperty("isPurchasable")
        @ExcludeMissing
        isPurchasable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<Money> = JsonMissing.of(),
        @JsonProperty("sku") @ExcludeMissing sku: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        availability,
        brand,
        description,
        images,
        isPurchasable,
        name,
        price,
        sku,
        url,
        mutableMapOf(),
    )

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

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
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun brand(): Optional<String> = brand.getOptional("brand")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun images(): List<ProductImage> = images.getRequired("images")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isPurchasable(): Boolean = isPurchasable.getRequired("isPurchasable")

    /**
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

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
     * @throws CheckoutIntentsInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun url(): String = url.getRequired("url")

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
     * Returns the raw JSON value of [brand].
     *
     * Unlike [brand], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<String> = brand

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [images].
     *
     * Unlike [images], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("images") @ExcludeMissing fun _images(): JsonField<List<ProductImage>> = images

    /**
     * Returns the raw JSON value of [isPurchasable].
     *
     * Unlike [isPurchasable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isPurchasable")
    @ExcludeMissing
    fun _isPurchasable(): JsonField<Boolean> = isPurchasable

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
         * Returns a mutable builder for constructing an instance of [Product].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .availability()
         * .brand()
         * .description()
         * .images()
         * .isPurchasable()
         * .name()
         * .price()
         * .sku()
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Product]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var availability: JsonField<ProductAvailability>? = null
        private var brand: JsonField<String>? = null
        private var description: JsonField<String>? = null
        private var images: JsonField<MutableList<ProductImage>>? = null
        private var isPurchasable: JsonField<Boolean>? = null
        private var name: JsonField<String>? = null
        private var price: JsonField<Money>? = null
        private var sku: JsonField<String>? = null
        private var url: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(product: Product) = apply {
            id = product.id
            availability = product.availability
            brand = product.brand
            description = product.description
            images = product.images.map { it.toMutableList() }
            isPurchasable = product.isPurchasable
            name = product.name
            price = product.price
            sku = product.sku
            url = product.url
            additionalProperties = product.additionalProperties.toMutableMap()
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

        fun brand(brand: String?) = brand(JsonField.ofNullable(brand))

        /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
        fun brand(brand: Optional<String>) = brand(brand.getOrNull())

        /**
         * Sets [Builder.brand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brand] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun brand(brand: JsonField<String>) = apply { this.brand = brand }

        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

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

        fun isPurchasable(isPurchasable: Boolean) = isPurchasable(JsonField.of(isPurchasable))

        /**
         * Sets [Builder.isPurchasable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isPurchasable] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isPurchasable(isPurchasable: JsonField<Boolean>) = apply {
            this.isPurchasable = isPurchasable
        }

        fun name(name: String) = name(JsonField.of(name))

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
         * Returns an immutable instance of [Product].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .availability()
         * .brand()
         * .description()
         * .images()
         * .isPurchasable()
         * .name()
         * .price()
         * .sku()
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Product =
            Product(
                checkRequired("id", id),
                checkRequired("availability", availability),
                checkRequired("brand", brand),
                checkRequired("description", description),
                checkRequired("images", images).map { it.toImmutable() },
                checkRequired("isPurchasable", isPurchasable),
                checkRequired("name", name),
                checkRequired("price", price),
                checkRequired("sku", sku),
                checkRequired("url", url),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Product = apply {
        if (validated) {
            return@apply
        }

        id()
        availability().validate()
        brand()
        description()
        images().forEach { it.validate() }
        isPurchasable()
        name()
        price().validate()
        sku()
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
            (availability.asKnown().getOrNull()?.validity() ?: 0) +
            (if (brand.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (images.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (isPurchasable.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (price.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sku.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Product &&
            id == other.id &&
            availability == other.availability &&
            brand == other.brand &&
            description == other.description &&
            images == other.images &&
            isPurchasable == other.isPurchasable &&
            name == other.name &&
            price == other.price &&
            sku == other.sku &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            availability,
            brand,
            description,
            images,
            isPurchasable,
            name,
            price,
            sku,
            url,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Product{id=$id, availability=$availability, brand=$brand, description=$description, images=$images, isPurchasable=$isPurchasable, name=$name, price=$price, sku=$sku, url=$url, additionalProperties=$additionalProperties}"
}
