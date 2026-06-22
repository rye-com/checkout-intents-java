// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking.testhelpers

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.testhelpers.shipments.ShipmentAdvanceParams
import com.rye.models.testhelpers.shipments.ShipmentAdvanceResponse
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
     * Advance the simulated shipment for a checkout intent. To trigger delayed or canceled shipping
     * scenarios, create the checkout intent with a matching shipping and delivery test product:
     * https://rye.com/docs/api-v2/testing/test-products#shipping-&-delivery
     */
    fun advance(checkoutIntentId: String): ShipmentAdvanceResponse =
        advance(checkoutIntentId, ShipmentAdvanceParams.none())

    /** @see advance */
    fun advance(
        checkoutIntentId: String,
        params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ShipmentAdvanceResponse =
        advance(params.toBuilder().checkoutIntentId(checkoutIntentId).build(), requestOptions)

    /** @see advance */
    fun advance(
        checkoutIntentId: String,
        params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
    ): ShipmentAdvanceResponse = advance(checkoutIntentId, params, RequestOptions.none())

    /** @see advance */
    fun advance(
        params: ShipmentAdvanceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ShipmentAdvanceResponse

    /** @see advance */
    fun advance(params: ShipmentAdvanceParams): ShipmentAdvanceResponse =
        advance(params, RequestOptions.none())

    /** @see advance */
    fun advance(checkoutIntentId: String, requestOptions: RequestOptions): ShipmentAdvanceResponse =
        advance(checkoutIntentId, ShipmentAdvanceParams.none(), requestOptions)

    /** A view of [ShipmentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ShipmentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /api/v1/test-helpers/checkout-intents/{checkoutIntentId}/shipments/advance`, but is
         * otherwise the same as [ShipmentService.advance].
         */
        @MustBeClosed
        fun advance(checkoutIntentId: String): HttpResponseFor<ShipmentAdvanceResponse> =
            advance(checkoutIntentId, ShipmentAdvanceParams.none())

        /** @see advance */
        @MustBeClosed
        fun advance(
            checkoutIntentId: String,
            params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ShipmentAdvanceResponse> =
            advance(params.toBuilder().checkoutIntentId(checkoutIntentId).build(), requestOptions)

        /** @see advance */
        @MustBeClosed
        fun advance(
            checkoutIntentId: String,
            params: ShipmentAdvanceParams = ShipmentAdvanceParams.none(),
        ): HttpResponseFor<ShipmentAdvanceResponse> =
            advance(checkoutIntentId, params, RequestOptions.none())

        /** @see advance */
        @MustBeClosed
        fun advance(
            params: ShipmentAdvanceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ShipmentAdvanceResponse>

        /** @see advance */
        @MustBeClosed
        fun advance(params: ShipmentAdvanceParams): HttpResponseFor<ShipmentAdvanceResponse> =
            advance(params, RequestOptions.none())

        /** @see advance */
        @MustBeClosed
        fun advance(
            checkoutIntentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ShipmentAdvanceResponse> =
            advance(checkoutIntentId, ShipmentAdvanceParams.none(), requestOptions)
    }
}
