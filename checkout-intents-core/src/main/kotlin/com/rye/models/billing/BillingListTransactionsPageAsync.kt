// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.rye.core.AutoPagerAsync
import com.rye.core.PageAsync
import com.rye.core.checkRequired
import com.rye.services.async.BillingServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see BillingServiceAsync.listTransactions */
class BillingListTransactionsPageAsync
private constructor(
    private val service: BillingServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: BillingListTransactionsParams,
    private val response: BillingListTransactionsPageResponse,
) : PageAsync<BillingListTransactionsResponse> {

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

    override fun nextPage(): CompletableFuture<BillingListTransactionsPageAsync> =
        service.listTransactions(nextPageParams())

    fun autoPager(): AutoPagerAsync<BillingListTransactionsResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): BillingListTransactionsParams = params

    /** The response that this page was parsed from. */
    fun response(): BillingListTransactionsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [BillingListTransactionsPageAsync].
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

    /** A builder for [BillingListTransactionsPageAsync]. */
    class Builder internal constructor() {

        private var service: BillingServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: BillingListTransactionsParams? = null
        private var response: BillingListTransactionsPageResponse? = null

        @JvmSynthetic
        internal fun from(billingListTransactionsPageAsync: BillingListTransactionsPageAsync) =
            apply {
                service = billingListTransactionsPageAsync.service
                streamHandlerExecutor = billingListTransactionsPageAsync.streamHandlerExecutor
                params = billingListTransactionsPageAsync.params
                response = billingListTransactionsPageAsync.response
            }

        fun service(service: BillingServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: BillingListTransactionsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BillingListTransactionsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [BillingListTransactionsPageAsync].
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
        fun build(): BillingListTransactionsPageAsync =
            BillingListTransactionsPageAsync(
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

        return other is BillingListTransactionsPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "BillingListTransactionsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
