// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.checkoutintents

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.checkoutintents.shipments.ShipmentListPageAsync
import com.rye.models.checkoutintents.shipments.ShipmentListParams
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

    /** List shipments for a checkout intent */
    fun list(id: String): CompletableFuture<ShipmentListPageAsync> =
        list(id, ShipmentListParams.none())

    /** @see list */
    fun list(
        id: String,
        params: ShipmentListParams = ShipmentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ShipmentListPageAsync> =
        list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    fun list(
        id: String,
        params: ShipmentListParams = ShipmentListParams.none(),
    ): CompletableFuture<ShipmentListPageAsync> = list(id, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ShipmentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ShipmentListPageAsync>

    /** @see list */
    fun list(params: ShipmentListParams): CompletableFuture<ShipmentListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(id: String, requestOptions: RequestOptions): CompletableFuture<ShipmentListPageAsync> =
        list(id, ShipmentListParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /api/v1/checkout-intents/{id}/shipments`, but is
         * otherwise the same as [ShipmentServiceAsync.list].
         */
        fun list(id: String): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(id, ShipmentListParams.none())

        /** @see list */
        fun list(
            id: String,
            params: ShipmentListParams = ShipmentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        fun list(
            id: String,
            params: ShipmentListParams = ShipmentListParams.none(),
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(id, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ShipmentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>>

        /** @see list */
        fun list(
            params: ShipmentListParams
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ShipmentListPageAsync>> =
            list(id, ShipmentListParams.none(), requestOptions)
    }
}
