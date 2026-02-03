// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.shipments.Shipment
import com.rye.models.shipments.ShipmentListPage
import com.rye.models.shipments.ShipmentListParams
import com.rye.models.shipments.ShipmentRetrieveParams
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

    /**
     * Retrieve a shipment by id
     *
     * Returns shipment information if the lookup succeeds.
     */
    fun retrieve(id: String): Shipment = retrieve(id, ShipmentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Shipment = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
    ): Shipment = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ShipmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Shipment

    /** @see retrieve */
    fun retrieve(params: ShipmentRetrieveParams): Shipment = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): Shipment =
        retrieve(id, ShipmentRetrieveParams.none(), requestOptions)

    /**
     * Retrieve a paginated list of shipments
     *
     * Enables developers to query shipments associated with their account, with filters and
     * cursor-based pagination.
     */
    fun list(): ShipmentListPage = list(ShipmentListParams.none())

    /** @see list */
    fun list(
        params: ShipmentListParams = ShipmentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ShipmentListPage

    /** @see list */
    fun list(params: ShipmentListParams = ShipmentListParams.none()): ShipmentListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ShipmentListPage =
        list(ShipmentListParams.none(), requestOptions)

    /** A view of [ShipmentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ShipmentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/shipments/{id}`, but is otherwise the same
         * as [ShipmentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<Shipment> =
            retrieve(id, ShipmentRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Shipment> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
        ): HttpResponseFor<Shipment> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ShipmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Shipment>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ShipmentRetrieveParams): HttpResponseFor<Shipment> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<Shipment> =
            retrieve(id, ShipmentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/shipments`, but is otherwise the same as
         * [ShipmentService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ShipmentListPage> = list(ShipmentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ShipmentListParams = ShipmentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ShipmentListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ShipmentListParams = ShipmentListParams.none()
        ): HttpResponseFor<ShipmentListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ShipmentListPage> =
            list(ShipmentListParams.none(), requestOptions)
    }
}
