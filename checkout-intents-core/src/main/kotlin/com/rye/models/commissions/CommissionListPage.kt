// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.rye.core.AutoPager
import com.rye.core.Page
import com.rye.core.checkRequired
import com.rye.services.blocking.CommissionService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see CommissionService.list */
class CommissionListPage
private constructor(
    private val service: CommissionService,
    private val params: CommissionListParams,
    private val response: CommissionListPageResponse,
) : Page<Commission> {

    /**
     * Delegates to [CommissionListPageResponse], but gracefully handles missing data.
     *
     * @see CommissionListPageResponse.data
     */
    fun data(): List<Commission> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CommissionListPageResponse], but gracefully handles missing data.
     *
     * @see CommissionListPageResponse.pageInfo
     */
    fun pageInfo(): Optional<CommissionListPageResponse.PageInfo> =
        response._pageInfo().getOptional("pageInfo")

    override fun items(): List<Commission> = data()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() &&
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.isPresent

    fun nextPageParams(): CommissionListParams {
        val nextCursor =
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CommissionListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Commission> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CommissionListParams = params

    /** The response that this page was parsed from. */
    fun response(): CommissionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CommissionListPage].
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

    /** A builder for [CommissionListPage]. */
    class Builder internal constructor() {

        private var service: CommissionService? = null
        private var params: CommissionListParams? = null
        private var response: CommissionListPageResponse? = null

        @JvmSynthetic
        internal fun from(commissionListPage: CommissionListPage) = apply {
            service = commissionListPage.service
            params = commissionListPage.params
            response = commissionListPage.response
        }

        fun service(service: CommissionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CommissionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CommissionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CommissionListPage].
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
        fun build(): CommissionListPage =
            CommissionListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CommissionListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CommissionListPage{service=$service, params=$params, response=$response}"
}
