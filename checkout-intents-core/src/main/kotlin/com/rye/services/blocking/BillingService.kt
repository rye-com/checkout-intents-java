// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.billing.BillingGetBalanceParams
import com.rye.models.billing.BillingGetBalanceResponse
import com.rye.models.billing.BillingListTransactionsPage
import com.rye.models.billing.BillingListTransactionsParams
import java.util.function.Consumer

interface BillingService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BillingService

    /** Get current drawdown balance for the authenticated developer */
    fun getBalance(): BillingGetBalanceResponse = getBalance(BillingGetBalanceParams.none())

    /** @see getBalance */
    fun getBalance(
        params: BillingGetBalanceParams = BillingGetBalanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BillingGetBalanceResponse

    /** @see getBalance */
    fun getBalance(
        params: BillingGetBalanceParams = BillingGetBalanceParams.none()
    ): BillingGetBalanceResponse = getBalance(params, RequestOptions.none())

    /** @see getBalance */
    fun getBalance(requestOptions: RequestOptions): BillingGetBalanceResponse =
        getBalance(BillingGetBalanceParams.none(), requestOptions)

    /** List drawdown balance transactions for the authenticated developer */
    fun listTransactions(): BillingListTransactionsPage =
        listTransactions(BillingListTransactionsParams.none())

    /** @see listTransactions */
    fun listTransactions(
        params: BillingListTransactionsParams = BillingListTransactionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BillingListTransactionsPage

    /** @see listTransactions */
    fun listTransactions(
        params: BillingListTransactionsParams = BillingListTransactionsParams.none()
    ): BillingListTransactionsPage = listTransactions(params, RequestOptions.none())

    /** @see listTransactions */
    fun listTransactions(requestOptions: RequestOptions): BillingListTransactionsPage =
        listTransactions(BillingListTransactionsParams.none(), requestOptions)

    /** A view of [BillingService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BillingService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/billing/balance`, but is otherwise the same
         * as [BillingService.getBalance].
         */
        @MustBeClosed
        fun getBalance(): HttpResponseFor<BillingGetBalanceResponse> =
            getBalance(BillingGetBalanceParams.none())

        /** @see getBalance */
        @MustBeClosed
        fun getBalance(
            params: BillingGetBalanceParams = BillingGetBalanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BillingGetBalanceResponse>

        /** @see getBalance */
        @MustBeClosed
        fun getBalance(
            params: BillingGetBalanceParams = BillingGetBalanceParams.none()
        ): HttpResponseFor<BillingGetBalanceResponse> = getBalance(params, RequestOptions.none())

        /** @see getBalance */
        @MustBeClosed
        fun getBalance(requestOptions: RequestOptions): HttpResponseFor<BillingGetBalanceResponse> =
            getBalance(BillingGetBalanceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/billing/transactions`, but is otherwise the
         * same as [BillingService.listTransactions].
         */
        @MustBeClosed
        fun listTransactions(): HttpResponseFor<BillingListTransactionsPage> =
            listTransactions(BillingListTransactionsParams.none())

        /** @see listTransactions */
        @MustBeClosed
        fun listTransactions(
            params: BillingListTransactionsParams = BillingListTransactionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BillingListTransactionsPage>

        /** @see listTransactions */
        @MustBeClosed
        fun listTransactions(
            params: BillingListTransactionsParams = BillingListTransactionsParams.none()
        ): HttpResponseFor<BillingListTransactionsPage> =
            listTransactions(params, RequestOptions.none())

        /** @see listTransactions */
        @MustBeClosed
        fun listTransactions(
            requestOptions: RequestOptions
        ): HttpResponseFor<BillingListTransactionsPage> =
            listTransactions(BillingListTransactionsParams.none(), requestOptions)
    }
}
