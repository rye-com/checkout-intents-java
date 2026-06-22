// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async.testhelpers

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.testhelpers.shipments.ShipmentAdvanceParams
import com.rye.models.testhelpers.shipments.ShipmentAdvanceResponse
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

    fun advance(checkoutIntentId: String): CompletableFuture<ShipmentAdvanceResponse> =
        advance(checkoutIntentId, ShipmentAdvanceParams.none())

    /** @see advance */
    fun advance(
        checkoutIntentId: String,
        params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ShipmentAdvanceResponse> =
        advance(params.toBuilder().checkoutIntentId(checkoutIntentId).build(), requestOptions)

    /** @see advance */
    fun advance(
        checkoutIntentId: String,
        params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
    ): CompletableFuture<ShipmentAdvanceResponse> =
        advance(checkoutIntentId, params, RequestOptions.none())

    /** @see advance */
    fun advance(
        params: ShipmentAdvanceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ShipmentAdvanceResponse>

    /** @see advance */
    fun advance(params: ShipmentAdvanceParams): CompletableFuture<ShipmentAdvanceResponse> =
        advance(params, RequestOptions.none())

    /** @see advance */
    fun advance(
        checkoutIntentId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ShipmentAdvanceResponse> =
        advance(checkoutIntentId, ShipmentAdvanceParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `post
         * /api/v1/test-helpers/checkout-intents/{checkoutIntentId}/shipments/advance`, but is
         * otherwise the same as [ShipmentServiceAsync.advance].
         */
        fun advance(
            checkoutIntentId: String
        ): CompletableFuture<HttpResponseFor<ShipmentAdvanceResponse>> =
            advance(checkoutIntentId, ShipmentAdvanceParams.none())

        /** @see advance */
        fun advance(
            checkoutIntentId: String,
            params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ShipmentAdvanceResponse>> =
            advance(params.toBuilder().checkoutIntentId(checkoutIntentId).build(), requestOptions)

        /** @see advance */
        fun advance(
            checkoutIntentId: String,
            params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
        ): CompletableFuture<HttpResponseFor<ShipmentAdvanceResponse>> =
            advance(checkoutIntentId, params, RequestOptions.none())

        /** @see advance */
        fun advance(
            params: ShipmentAdvanceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ShipmentAdvanceResponse>>

        /** @see advance */
        fun advance(
            params: ShipmentAdvanceParams
        ): CompletableFuture<HttpResponseFor<ShipmentAdvanceResponse>> =
            advance(params, RequestOptions.none())

        /** @see advance */
        fun advance(
            checkoutIntentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ShipmentAdvanceResponse>> =
            advance(checkoutIntentId, ShipmentAdvanceParams.none(), requestOptions)
    }
}
