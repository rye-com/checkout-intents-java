// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponse
import com.rye.core.http.HttpResponseFor
import com.rye.models.billing.BillingCancelTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceResponse
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

    /** Cancel/void an unpaid top-up invoice. Only invoices in open state can be cancelled. */
    fun cancelTopupInvoice(invoiceId: String) =
        cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none())

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(
        invoiceId: String,
        params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = cancelTopupInvoice(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(
        invoiceId: String,
        params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
    ) = cancelTopupInvoice(invoiceId, params, RequestOptions.none())

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(
        params: BillingCancelTopupInvoiceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(params: BillingCancelTopupInvoiceParams) =
        cancelTopupInvoice(params, RequestOptions.none())

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(invoiceId: String, requestOptions: RequestOptions) =
        cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none(), requestOptions)

    /**
     * Request an on-demand top-up invoice.. Requires drawdown billing to be enabled. Only one
     * unpaid top-up invoice is allowed at a time.
     */
    fun createTopupInvoice(
        params: BillingCreateTopupInvoiceParams
    ): BillingCreateTopupInvoiceResponse = createTopupInvoice(params, RequestOptions.none())

    /** @see createTopupInvoice */
    fun createTopupInvoice(
        params: BillingCreateTopupInvoiceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BillingCreateTopupInvoiceResponse

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
         * Returns a raw HTTP response for `delete /api/v1/billing/drawdown/topup/{invoiceId}`, but
         * is otherwise the same as [BillingService.cancelTopupInvoice].
         */
        @MustBeClosed
        fun cancelTopupInvoice(invoiceId: String): HttpResponse =
            cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none())

        /** @see cancelTopupInvoice */
        @MustBeClosed
        fun cancelTopupInvoice(
            invoiceId: String,
            params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            cancelTopupInvoice(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see cancelTopupInvoice */
        @MustBeClosed
        fun cancelTopupInvoice(
            invoiceId: String,
            params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
        ): HttpResponse = cancelTopupInvoice(invoiceId, params, RequestOptions.none())

        /** @see cancelTopupInvoice */
        @MustBeClosed
        fun cancelTopupInvoice(
            params: BillingCancelTopupInvoiceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see cancelTopupInvoice */
        @MustBeClosed
        fun cancelTopupInvoice(params: BillingCancelTopupInvoiceParams): HttpResponse =
            cancelTopupInvoice(params, RequestOptions.none())

        /** @see cancelTopupInvoice */
        @MustBeClosed
        fun cancelTopupInvoice(invoiceId: String, requestOptions: RequestOptions): HttpResponse =
            cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/billing/drawdown/topup`, but is otherwise
         * the same as [BillingService.createTopupInvoice].
         */
        @MustBeClosed
        fun createTopupInvoice(
            params: BillingCreateTopupInvoiceParams
        ): HttpResponseFor<BillingCreateTopupInvoiceResponse> =
            createTopupInvoice(params, RequestOptions.none())

        /** @see createTopupInvoice */
        @MustBeClosed
        fun createTopupInvoice(
            params: BillingCreateTopupInvoiceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BillingCreateTopupInvoiceResponse>

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
