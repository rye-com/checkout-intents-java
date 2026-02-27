// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.rye.core.AutoPager
import com.rye.core.Page
import com.rye.core.checkRequired
import com.rye.services.blocking.BillingService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see BillingService.listTransactions */
class BillingListTransactionsPage
private constructor(
    private val service: BillingService,
    private val params: BillingListTransactionsParams,
    private val response: BillingListTransactionsPageResponse,
) : Page<BillingListTransactionsResponse> {

    /**
     * Delegates to [BillingListTransactionsPageResponse], but gracefully handles missing data.
     *
     * @see BillingListTransactionsPageResponse.data
     */
    fun data(): List<BillingListTransactionsResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [BillingListTransactionsPageResponse], but gracefully handles missing data.
     *
     * @see BillingListTransactionsPageResponse.pageInfo
     */
    fun pageInfo(): Optional<BillingListTransactionsPageResponse.PageInfo> =
        response._pageInfo().getOptional("pageInfo")

    override fun items(): List<BillingListTransactionsResponse> = data()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() &&
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.isPresent

    fun nextPageParams(): BillingListTransactionsParams {
        val nextCursor =
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): BillingListTransactionsPage =
        service.listTransactions(nextPageParams())

    fun autoPager(): AutoPager<BillingListTransactionsResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): BillingListTransactionsParams = params

    /** The response that this page was parsed from. */
    fun response(): BillingListTransactionsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BillingListTransactionsPage].
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

    /** A builder for [BillingListTransactionsPage]. */
    class Builder internal constructor() {

        private var service: BillingService? = null
        private var params: BillingListTransactionsParams? = null
        private var response: BillingListTransactionsPageResponse? = null

        @JvmSynthetic
        internal fun from(billingListTransactionsPage: BillingListTransactionsPage) = apply {
            service = billingListTransactionsPage.service
            params = billingListTransactionsPage.params
            response = billingListTransactionsPage.response
        }

        fun service(service: BillingService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BillingListTransactionsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BillingListTransactionsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [BillingListTransactionsPage].
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
        fun build(): BillingListTransactionsPage =
            BillingListTransactionsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BillingListTransactionsPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "BillingListTransactionsPage{service=$service, params=$params, response=$response}"
}
