// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents.shipments

import com.rye.core.AutoPagerAsync
import com.rye.core.PageAsync
import com.rye.core.checkRequired
import com.rye.models.shipments.Shipment
import com.rye.services.async.checkoutintents.ShipmentServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ShipmentServiceAsync.list */
class ShipmentListPageAsync
private constructor(
    private val service: ShipmentServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ShipmentListParams,
    private val response: ShipmentListPageResponse,
) : PageAsync<Shipment> {

    /**
     * Delegates to [ShipmentListPageResponse], but gracefully handles missing data.
     *
     * @see ShipmentListPageResponse.data
     */
    fun data(): List<Shipment> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ShipmentListPageResponse], but gracefully handles missing data.
     *
     * @see ShipmentListPageResponse.pageInfo
     */
    fun pageInfo(): Optional<ShipmentListPageResponse.PageInfo> =
        response._pageInfo().getOptional("pageInfo")

    override fun items(): List<Shipment> = data()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() &&
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.isPresent

    fun nextPageParams(): ShipmentListParams {
        val nextCursor =
            pageInfo().flatMap { it._endCursor().getOptional("endCursor") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ShipmentListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Shipment> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ShipmentListParams = params

    /** The response that this page was parsed from. */
    fun response(): ShipmentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ShipmentListPageAsync].
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

    /** A builder for [ShipmentListPageAsync]. */
    class Builder internal constructor() {

        private var service: ShipmentServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ShipmentListParams? = null
        private var response: ShipmentListPageResponse? = null

        @JvmSynthetic
        internal fun from(shipmentListPageAsync: ShipmentListPageAsync) = apply {
            service = shipmentListPageAsync.service
            streamHandlerExecutor = shipmentListPageAsync.streamHandlerExecutor
            params = shipmentListPageAsync.params
            response = shipmentListPageAsync.response
        }

        fun service(service: ShipmentServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ShipmentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ShipmentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ShipmentListPageAsync].
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
        fun build(): ShipmentListPageAsync =
            ShipmentListPageAsync(
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

        return other is ShipmentListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ShipmentListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
