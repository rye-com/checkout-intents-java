// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.BaseDeserializer
import com.rye.core.BaseSerializer
import com.rye.core.JsonValue
import com.rye.core.allMaxBy
import com.rye.core.getOrThrow
import com.rye.errors.CheckoutIntentsInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = ProductSubscription.Deserializer::class)
@JsonSerialize(using = ProductSubscription.Serializer::class)
class ProductSubscription
private constructor(
    private val product: ProductSubscriptionProduct? = null,
    private val store: ProductSubscriptionStore? = null,
    private val _json: JsonValue? = null,
) {

    fun product(): Optional<ProductSubscriptionProduct> = Optional.ofNullable(product)

    fun store(): Optional<ProductSubscriptionStore> = Optional.ofNullable(store)

    fun isProduct(): Boolean = product != null

    fun isStore(): Boolean = store != null

    fun asProduct(): ProductSubscriptionProduct = product.getOrThrow("product")

    fun asStore(): ProductSubscriptionStore = store.getOrThrow("store")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.rye.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = productSubscription.accept(new ProductSubscription.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitProduct(ProductSubscriptionProduct product) {
     *         return Optional.of(product.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws CheckoutIntentsInvalidDataException if [Visitor.unknown] is not overridden in
     *   [visitor] and the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            product != null -> visitor.visitProduct(product)
            store != null -> visitor.visitStore(store)
            else -> visitor.unknown(_json)
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
    fun validate(): ProductSubscription = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitProduct(product: ProductSubscriptionProduct) {
                    product.validate()
                }

                override fun visitStore(store: ProductSubscriptionStore) {
                    store.validate()
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
                override fun visitProduct(product: ProductSubscriptionProduct) = product.validity()

                override fun visitStore(store: ProductSubscriptionStore) = store.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProductSubscription && product == other.product && store == other.store
    }

    override fun hashCode(): Int = Objects.hash(product, store)

    override fun toString(): String =
        when {
            product != null -> "ProductSubscription{product=$product}"
            store != null -> "ProductSubscription{store=$store}"
            _json != null -> "ProductSubscription{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ProductSubscription")
        }

    companion object {

        @JvmStatic
        fun ofProduct(product: ProductSubscriptionProduct) = ProductSubscription(product = product)

        @JvmStatic fun ofStore(store: ProductSubscriptionStore) = ProductSubscription(store = store)
    }

    /**
     * An interface that defines how to map each variant of [ProductSubscription] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitProduct(product: ProductSubscriptionProduct): T

        fun visitStore(store: ProductSubscriptionStore): T

        /**
         * Maps an unknown variant of [ProductSubscription] to a value of type [T].
         *
         * An instance of [ProductSubscription] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws CheckoutIntentsInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw CheckoutIntentsInvalidDataException("Unknown ProductSubscription: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ProductSubscription>(ProductSubscription::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ProductSubscription {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<ProductSubscriptionProduct>())?.let {
                            ProductSubscription(product = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ProductSubscriptionStore>())?.let {
                            ProductSubscription(store = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> ProductSubscription(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<ProductSubscription>(ProductSubscription::class) {

        override fun serialize(
            value: ProductSubscription,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.product != null -> generator.writeObject(value.product)
                value.store != null -> generator.writeObject(value.store)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ProductSubscription")
            }
        }
    }
}
