// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.checkoutintents

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.checkoutintents.shipments.ShipmentListPage
import com.rye.models.checkoutintents.shipments.ShipmentListParams
import java.util.function.Consumer

interface ShipmentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ShipmentService

    /** List shipments for a checkout intent */
    fun list(id: String): ShipmentListPage = list(id, ShipmentListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: ShipmentListParams = ShipmentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ShipmentListPage = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(id: String, params: ShipmentListParams = ShipmentListParams.none()): ShipmentListPage =
        list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ShipmentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ShipmentListPage

    /** @see list */
    fun list(params: ShipmentListParams): ShipmentListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): ShipmentListPage =
        list(id, ShipmentListParams.none(), requestOptions)

    /** A view of [ShipmentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ShipmentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/checkout-intents/{id}/shipments`, but is
         * otherwise the same as [ShipmentService.list].
         */
        @MustBeClosed
        fun list(id: String): HttpResponseFor<ShipmentListPage> =
            list(id, ShipmentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: ShipmentListParams = ShipmentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ShipmentListPage> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            id: String,
            params: ShipmentListParams = ShipmentListParams.none(),
        ): HttpResponseFor<ShipmentListPage> = list(id, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ShipmentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ShipmentListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: ShipmentListParams): HttpResponseFor<ShipmentListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(id: String, requestOptions: RequestOptions): HttpResponseFor<ShipmentListPage> =
            list(id, ShipmentListParams.none(), requestOptions)
    }
}
