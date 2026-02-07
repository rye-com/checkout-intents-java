// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.shipments.Shipment
import com.rye.models.shipments.ShipmentListPageAsync
import com.rye.models.shipments.ShipmentListParams
import com.rye.models.shipments.ShipmentRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ShipmentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ShipmentServiceAsync

    /**
     * Retrieve a shipment by id
     *
     * Returns shipment information if the lookup succeeds.
     */
    fun retrieve(id: String): CompletableFuture<Shipment> =
        retrieve(id, ShipmentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Shipment> = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
    ): CompletableFuture<Shipment> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ShipmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Shipment>

    /** @see retrieve */
    fun retrieve(params: ShipmentRetrieveParams): CompletableFuture<Shipment> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<Shipment> =
        retrieve(id, ShipmentRetrieveParams.none(), requestOptions)

    /**
     * Retrieve a paginated list of shipments
     *
     * Enables developers to query shipments associated with their account, with filters and
     * cursor-based pagination.
     */
    fun list(): CompletableFuture<ShipmentListPageAsync> = list(ShipmentListParams.none())

    /** @see list */
    fun list(
        params: ShipmentListParams = ShipmentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ShipmentListPageAsync>

    /** @see list */
    fun list(
        params: ShipmentListParams = ShipmentListParams.none()
    ): CompletableFuture<ShipmentListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ShipmentListPageAsync> =
        list(ShipmentListParams.none(), requestOptions)

    /**
     * A view of [ShipmentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ShipmentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/shipments/{id}`, but is otherwise the same
         * as [ShipmentServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<Shipment>> =
            retrieve(id, ShipmentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Shipment>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ShipmentRetrieveParams = ShipmentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Shipment>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ShipmentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Shipment>>

        /** @see retrieve */
        fun retrieve(params: ShipmentRetrieveParams): CompletableFuture<HttpResponseFor<Shipment>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Shipment>> =
            retrieve(id, ShipmentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/shipments`, but is otherwise the same as
         * [ShipmentServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(ShipmentListParams.none())

        /** @see list */
        fun list(
            params: ShipmentListParams = ShipmentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>>

        /** @see list */
        fun list(
            params: ShipmentListParams = ShipmentListParams.none()
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(ShipmentListParams.none(), requestOptions)
    }
}
