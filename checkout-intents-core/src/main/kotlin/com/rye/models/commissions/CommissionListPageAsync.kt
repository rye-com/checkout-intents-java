// File generated from our OpenAPI spec by Stainless.

package com.rye.models.commissions

import com.rye.core.AutoPagerAsync
import com.rye.core.PageAsync
import com.rye.core.checkRequired
import com.rye.services.async.CommissionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see CommissionServiceAsync.list */
class CommissionListPageAsync
private constructor(
    private val service: CommissionServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CommissionListParams,
    private val response: CommissionListPageResponse,
) : PageAsync<Commission> {

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

    override fun nextPage(): CompletableFuture<CommissionListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Commission> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CommissionListParams = params

    /** The response that this page was parsed from. */
    fun response(): CommissionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CommissionListPageAsync].
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

    /** A builder for [CommissionListPageAsync]. */
    class Builder internal constructor() {

        private var service: CommissionServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CommissionListParams? = null
        private var response: CommissionListPageResponse? = null

        @JvmSynthetic
        internal fun from(commissionListPageAsync: CommissionListPageAsync) = apply {
            service = commissionListPageAsync.service
            streamHandlerExecutor = commissionListPageAsync.streamHandlerExecutor
            params = commissionListPageAsync.params
            response = commissionListPageAsync.response
        }

        fun service(service: CommissionServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CommissionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CommissionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CommissionListPageAsync].
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
        fun build(): CommissionListPageAsync =
            CommissionListPageAsync(
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

        return other is CommissionListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CommissionListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
