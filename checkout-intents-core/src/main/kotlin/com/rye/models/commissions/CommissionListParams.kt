// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.rye.core.Params
import com.rye.core.http.Headers
import com.rye.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * List commissions for the authenticated developer
 *
 * Returns a paginated list of commissions with optional filters using cursor-based pagination. Pass
 * the `endCursor` from a previous response as `after` to fetch the next page, or the `startCursor`
 * as `before` to fetch the previous page. Specifying both `after` and `before` returns 422.
 */
class CommissionListParams
private constructor(
    private val after: String?,
    private val before: String?,
    private val checkoutIntentId: String?,
    private val limit: Int?,
    private val status: CommissionStatus?,
    private val type: CommissionType?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Cursor from a previous response's `pageInfo.endCursor` */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** Cursor from a previous response's `pageInfo.startCursor` */
    fun before(): Optional<String> = Optional.ofNullable(before)

    fun checkoutIntentId(): Optional<String> = Optional.ofNullable(checkoutIntentId)

    /** Maximum number of results to return (default 100) */
    fun limit(): Optional<Int> = Optional.ofNullable(limit)

    /** Lifecycle status of a commission record. */
    fun status(): Optional<CommissionStatus> = Optional.ofNullable(status)

    /**
     * Type of commission earned on an order. Canonical definition used by both the API contract and
     * the internal `@rye-com/ci-commissions` package.
     */
    fun type(): Optional<CommissionType> = Optional.ofNullable(type)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): CommissionListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [CommissionListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CommissionListParams]. */
    class Builder internal constructor() {

        private var after: String? = null
        private var before: String? = null
        private var checkoutIntentId: String? = null
        private var limit: Int? = null
        private var status: CommissionStatus? = null
        private var type: CommissionType? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(commissionListParams: CommissionListParams) = apply {
            after = commissionListParams.after
            before = commissionListParams.before
            checkoutIntentId = commissionListParams.checkoutIntentId
            limit = commissionListParams.limit
            status = commissionListParams.status
            type = commissionListParams.type
            additionalHeaders = commissionListParams.additionalHeaders.toBuilder()
            additionalQueryParams = commissionListParams.additionalQueryParams.toBuilder()
        }

        /** Cursor from a previous response's `pageInfo.endCursor` */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** Cursor from a previous response's `pageInfo.startCursor` */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        fun checkoutIntentId(checkoutIntentId: String?) = apply {
            this.checkoutIntentId = checkoutIntentId
        }

        /** Alias for calling [Builder.checkoutIntentId] with `checkoutIntentId.orElse(null)`. */
        fun checkoutIntentId(checkoutIntentId: Optional<String>) =
            checkoutIntentId(checkoutIntentId.getOrNull())

        /** Maximum number of results to return (default 100) */
        fun limit(limit: Int?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Int) = limit(limit as Int?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Int>) = limit(limit.getOrNull())

        /** Lifecycle status of a commission record. */
        fun status(status: CommissionStatus?) = apply { this.status = status }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<CommissionStatus>) = status(status.getOrNull())

        /**
         * Type of commission earned on an order. Canonical definition used by both the API contract
         * and the internal `@rye-com/ci-commissions` package.
         */
        fun type(type: CommissionType?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<CommissionType>) = type(type.getOrNull())

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
         * Returns an immutable instance of [CommissionListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CommissionListParams =
            CommissionListParams(
                after,
                before,
                checkoutIntentId,
                limit,
                status,
                type,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                before?.let { put("before", it) }
                checkoutIntentId?.let { put("checkoutIntentId", it) }
                limit?.let { put("limit", it.toString()) }
                status?.let { put("status", it.toString()) }
                type?.let { put("type", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommissionListParams &&
            after == other.after &&
            before == other.before &&
            checkoutIntentId == other.checkoutIntentId &&
            limit == other.limit &&
            status == other.status &&
            type == other.type &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            after,
            before,
            checkoutIntentId,
            limit,
            status,
            type,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "CommissionListParams{after=$after, before=$before, checkoutIntentId=$checkoutIntentId, limit=$limit, status=$status, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
