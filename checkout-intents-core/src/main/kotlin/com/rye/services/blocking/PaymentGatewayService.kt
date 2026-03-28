// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.paymentgateways.PaymentGateway
import com.rye.models.paymentgateways.PaymentGatewayCreateSessionParams
import com.rye.models.paymentgateways.PaymentGatewaySession
import java.util.function.Consumer

interface PaymentGatewayService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PaymentGatewayService

    /**
     * Create a payment gateway session for client-side card tokenization.
     *
     * Returns short-lived credentials scoped to the authenticated developer. Use the credentials
     * with the corresponding gateway's client-side SDK to tokenize a card. Tokens created this way
     * are locked to the developer's container and cannot be used by other developers.
     */
    fun createSession(gateway: PaymentGateway): PaymentGatewaySession =
        createSession(gateway, PaymentGatewayCreateSessionParams.none())

    /** @see createSession */
    fun createSession(
        gateway: PaymentGateway,
        params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaymentGatewaySession =
        createSession(params.toBuilder().gateway(gateway).build(), requestOptions)

    /** @see createSession */
    fun createSession(
        gateway: PaymentGateway,
        params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
    ): PaymentGatewaySession = createSession(gateway, params, RequestOptions.none())

    /** @see createSession */
    fun createSession(
        params: PaymentGatewayCreateSessionParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaymentGatewaySession

    /** @see createSession */
    fun createSession(params: PaymentGatewayCreateSessionParams): PaymentGatewaySession =
        createSession(params, RequestOptions.none())

    /** @see createSession */
    fun createSession(
        gateway: PaymentGateway,
        requestOptions: RequestOptions,
    ): PaymentGatewaySession =
        createSession(gateway, PaymentGatewayCreateSessionParams.none(), requestOptions)

    /**
     * A view of [PaymentGatewayService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PaymentGatewayService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/payment-gateways/{gateway}/session`, but is
         * otherwise the same as [PaymentGatewayService.createSession].
         */
        @MustBeClosed
        fun createSession(gateway: PaymentGateway): HttpResponseFor<PaymentGatewaySession> =
            createSession(gateway, PaymentGatewayCreateSessionParams.none())

        /** @see createSession */
        @MustBeClosed
        fun createSession(
            gateway: PaymentGateway,
            params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaymentGatewaySession> =
            createSession(params.toBuilder().gateway(gateway).build(), requestOptions)

        /** @see createSession */
        @MustBeClosed
        fun createSession(
            gateway: PaymentGateway,
            params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
        ): HttpResponseFor<PaymentGatewaySession> =
            createSession(gateway, params, RequestOptions.none())

        /** @see createSession */
        @MustBeClosed
        fun createSession(
            params: PaymentGatewayCreateSessionParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaymentGatewaySession>

        /** @see createSession */
        @MustBeClosed
        fun createSession(
            params: PaymentGatewayCreateSessionParams
        ): HttpResponseFor<PaymentGatewaySession> = createSession(params, RequestOptions.none())

        /** @see createSession */
        @MustBeClosed
        fun createSession(
            gateway: PaymentGateway,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaymentGatewaySession> =
            createSession(gateway, PaymentGatewayCreateSessionParams.none(), requestOptions)
    }
}
