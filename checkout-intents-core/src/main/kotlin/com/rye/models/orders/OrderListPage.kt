// File generated from our OpenAPI spec by Stainless.

package com.rye.models.orders

import com.rye.core.AutoPager
import com.rye.core.Page
import com.rye.core.checkRequired
import com.rye.services.blocking.OrderService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see OrderService.list */
class OrderListPage
private constructor(
    private val service: OrderService,
    private val params: OrderListParams,
    private val response: OrderListPageResponse,
) : Page<Order> {

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

    override fun nextPage(): OrderListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Order> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): OrderListParams = params

    /** The response that this page was parsed from. */
    fun response(): OrderListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OrderListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderListPage]. */
    class Builder internal constructor() {

        private var service: OrderService? = null
        private var params: OrderListParams? = null
        private var response: OrderListPageResponse? = null

        @JvmSynthetic
        internal fun from(orderListPage: OrderListPage) = apply {
            service = orderListPage.service
            params = orderListPage.params
            response = orderListPage.response
        }

        fun service(service: OrderService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: OrderListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OrderListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OrderListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderListPage =
            OrderListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "OrderListPage{service=$service, params=$params, response=$response}"
}
