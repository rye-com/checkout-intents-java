// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.rye.core.AutoPager
import com.rye.core.Page
import com.rye.core.checkRequired
import com.rye.services.blocking.CheckoutIntentService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see CheckoutIntentService.list */
class CheckoutIntentListPage
private constructor(
    private val service: CheckoutIntentService,
    private val params: CheckoutIntentListParams,
    private val response: CheckoutIntentListPageResponse,
) : Page<CheckoutIntent> {

    /**
     * Delegates to [CheckoutIntentListPageResponse], but gracefully handles missing data.
     *
     * @see CheckoutIntentListPageResponse.data
     */
    fun data(): List<CheckoutIntent> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CheckoutIntentListPageResponse], but gracefully handles missing data.
     *
     * @see CheckoutIntentListPageResponse.pageInfo
     */
    fun pageInfo(): Optional<CheckoutIntentListPageResponse.PageInfo> =
        response._pageInfo().getOptional("pageInfo")

    override fun items(): List<CheckoutIntent> = data()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() &&
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.isPresent

    fun nextPageParams(): CheckoutIntentListParams {
        val nextCursor =
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CheckoutIntentListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<CheckoutIntent> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CheckoutIntentListParams = params

    /** The response that this page was parsed from. */
    fun response(): CheckoutIntentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CheckoutIntentListPage].
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

    /** A builder for [CheckoutIntentListPage]. */
    class Builder internal constructor() {

        private var service: CheckoutIntentService? = null
        private var params: CheckoutIntentListParams? = null
        private var response: CheckoutIntentListPageResponse? = null

        @JvmSynthetic
        internal fun from(checkoutIntentListPage: CheckoutIntentListPage) = apply {
            service = checkoutIntentListPage.service
            params = checkoutIntentListPage.params
            response = checkoutIntentListPage.response
        }

        fun service(service: CheckoutIntentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CheckoutIntentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CheckoutIntentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CheckoutIntentListPage].
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
        fun build(): CheckoutIntentListPage =
            CheckoutIntentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CheckoutIntentListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CheckoutIntentListPage{service=$service, params=$params, response=$response}"
}
