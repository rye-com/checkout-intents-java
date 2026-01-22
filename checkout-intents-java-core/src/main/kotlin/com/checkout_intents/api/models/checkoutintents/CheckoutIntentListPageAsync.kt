// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.models.checkoutintents

import com.checkout_intents.api.core.AutoPagerAsync
import com.checkout_intents.api.core.PageAsync
import com.checkout_intents.api.core.checkRequired
import com.checkout_intents.api.services.async.CheckoutIntentServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see CheckoutIntentServiceAsync.list */
class CheckoutIntentListPageAsync
private constructor(
    private val service: CheckoutIntentServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CheckoutIntentListParams,
    private val response: CheckoutIntentListPageResponse,
) : PageAsync<CheckoutIntent> {

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

    override fun nextPage(): CompletableFuture<CheckoutIntentListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<CheckoutIntent> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CheckoutIntentListParams = params

    /** The response that this page was parsed from. */
    fun response(): CheckoutIntentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CheckoutIntentListPageAsync].
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

    /** A builder for [CheckoutIntentListPageAsync]. */
    class Builder internal constructor() {

        private var service: CheckoutIntentServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CheckoutIntentListParams? = null
        private var response: CheckoutIntentListPageResponse? = null

        @JvmSynthetic
        internal fun from(checkoutIntentListPageAsync: CheckoutIntentListPageAsync) = apply {
            service = checkoutIntentListPageAsync.service
            streamHandlerExecutor = checkoutIntentListPageAsync.streamHandlerExecutor
            params = checkoutIntentListPageAsync.params
            response = checkoutIntentListPageAsync.response
        }

        fun service(service: CheckoutIntentServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CheckoutIntentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CheckoutIntentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CheckoutIntentListPageAsync].
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
        fun build(): CheckoutIntentListPageAsync =
            CheckoutIntentListPageAsync(
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

        return other is CheckoutIntentListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CheckoutIntentListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
