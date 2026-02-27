// File generated from our OpenAPI spec by Stainless.

package com.rye.models.shipments

import com.rye.core.AutoPager
import com.rye.core.Page
import com.rye.core.checkRequired
import com.rye.services.blocking.ShipmentService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ShipmentService.list */
class ShipmentListPage
private constructor(
    private val service: ShipmentService,
    private val params: ShipmentListParams,
    private val response: ShipmentListPageResponse,
) : Page<Shipment> {

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

    override fun nextPage(): ShipmentListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Shipment> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ShipmentListParams = params

    /** The response that this page was parsed from. */
    fun response(): ShipmentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ShipmentListPage].
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

    /** A builder for [ShipmentListPage]. */
    class Builder internal constructor() {

        private var service: ShipmentService? = null
        private var params: ShipmentListParams? = null
        private var response: ShipmentListPageResponse? = null

        @JvmSynthetic
        internal fun from(shipmentListPage: ShipmentListPage) = apply {
            service = shipmentListPage.service
            params = shipmentListPage.params
            response = shipmentListPage.response
        }

        fun service(service: ShipmentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ShipmentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ShipmentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ShipmentListPage].
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
        fun build(): ShipmentListPage =
            ShipmentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ShipmentListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ShipmentListPage{service=$service, params=$params, response=$response}"
}
