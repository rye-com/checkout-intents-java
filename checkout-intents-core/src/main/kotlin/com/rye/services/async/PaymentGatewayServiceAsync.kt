// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.paymentgateways.PaymentGateway
import com.rye.models.paymentgateways.PaymentGatewayCreateSessionParams
import com.rye.models.paymentgateways.PaymentGatewaySession
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface PaymentGatewayServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PaymentGatewayServiceAsync

    /**
     * Create a payment gateway session for client-side card tokenization.
     *
     * Returns short-lived credentials scoped to the authenticated developer. Use the credentials
     * with the corresponding gateway's client-side SDK to tokenize a card. Tokens created this way
     * are locked to the developer's container and cannot be used by other developers.
     */
    fun createSession(gateway: PaymentGateway): CompletableFuture<PaymentGatewaySession> =
        createSession(gateway, PaymentGatewayCreateSessionParams.none())

    /** @see createSession */
    fun createSession(
        gateway: PaymentGateway,
        params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaymentGatewaySession> =
        createSession(params.toBuilder().gateway(gateway).build(), requestOptions)

    /** @see createSession */
    fun createSession(
        gateway: PaymentGateway,
        params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
    ): CompletableFuture<PaymentGatewaySession> =
        createSession(gateway, params, RequestOptions.none())

    /** @see createSession */
    fun createSession(
        params: PaymentGatewayCreateSessionParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaymentGatewaySession>

    /** @see createSession */
    fun createSession(
        params: PaymentGatewayCreateSessionParams
    ): CompletableFuture<PaymentGatewaySession> = createSession(params, RequestOptions.none())

    /** @see createSession */
    fun createSession(
        gateway: PaymentGateway,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaymentGatewaySession> =
        createSession(gateway, PaymentGatewayCreateSessionParams.none(), requestOptions)

    /**
     * A view of [PaymentGatewayServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PaymentGatewayServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/payment-gateways/{gateway}/session`, but is
         * otherwise the same as [PaymentGatewayServiceAsync.createSession].
         */
        fun createSession(
            gateway: PaymentGateway
        ): CompletableFuture<HttpResponseFor<PaymentGatewaySession>> =
            createSession(gateway, PaymentGatewayCreateSessionParams.none())

        /** @see createSession */
        fun createSession(
            gateway: PaymentGateway,
            params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaymentGatewaySession>> =
            createSession(params.toBuilder().gateway(gateway).build(), requestOptions)

        /** @see createSession */
        fun createSession(
            gateway: PaymentGateway,
            params: PaymentGatewayCreateSessionParams = PaymentGatewayCreateSessionParams.none(),
        ): CompletableFuture<HttpResponseFor<PaymentGatewaySession>> =
            createSession(gateway, params, RequestOptions.none())

        /** @see createSession */
        fun createSession(
            params: PaymentGatewayCreateSessionParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaymentGatewaySession>>

        /** @see createSession */
        fun createSession(
            params: PaymentGatewayCreateSessionParams
        ): CompletableFuture<HttpResponseFor<PaymentGatewaySession>> =
            createSession(params, RequestOptions.none())

        /** @see createSession */
        fun createSession(
            gateway: PaymentGateway,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaymentGatewaySession>> =
            createSession(gateway, PaymentGatewayCreateSessionParams.none(), requestOptions)
    }
}
