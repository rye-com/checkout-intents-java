// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

import com.rye.core.AutoPagerAsync
import com.rye.core.PageAsync
import com.rye.core.checkRequired
import com.rye.services.async.OrderServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see OrderServiceAsync.list */
class OrderListPageAsync
private constructor(
    private val service: OrderServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: OrderListParams,
    private val response: OrderListPageResponse,
) : PageAsync<Order> {

    /**
     * Delegates to [OrderListPageResponse], but gracefully handles missing data.
     *
     * @see OrderListPageResponse.data
     */
    fun data(): List<Order> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [OrderListPageResponse], but gracefully handles missing data.
     *
     * @see OrderListPageResponse.pageInfo
     */
    fun pageInfo(): Optional<OrderListPageResponse.PageInfo> =
        response._pageInfo().getOptional("pageInfo")

    override fun items(): List<Order> = data()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() &&
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.isPresent

    fun nextPageParams(): OrderListParams {
        val nextCursor =
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<OrderListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Order> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): OrderListParams = params

    /** The response that this page was parsed from. */
    fun response(): OrderListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OrderListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderListPageAsync]. */
    class Builder internal constructor() {

        private var service: OrderServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: OrderListParams? = null
        private var response: OrderListPageResponse? = null

        @JvmSynthetic
        internal fun from(orderListPageAsync: OrderListPageAsync) = apply {
            service = orderListPageAsync.service
            streamHandlerExecutor = orderListPageAsync.streamHandlerExecutor
            params = orderListPageAsync.params
            response = orderListPageAsync.response
        }

        fun service(service: OrderServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: OrderListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OrderListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OrderListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderListPageAsync =
            OrderListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "OrderListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
