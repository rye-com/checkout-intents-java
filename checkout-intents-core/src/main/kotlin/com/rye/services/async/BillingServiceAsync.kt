// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponse
import com.rye.core.http.HttpResponseFor
import com.rye.models.billing.BillingCancelTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceResponse
import com.rye.models.billing.BillingGetBalanceParams
import com.rye.models.billing.BillingGetBalanceResponse
import com.rye.models.billing.BillingListTransactionsPageAsync
import com.rye.models.billing.BillingListTransactionsParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BillingServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BillingServiceAsync

    /** Cancel/void an unpaid top-up invoice. Only invoices in open state can be cancelled. */
    fun cancelTopupInvoice(invoiceId: String): CompletableFuture<Void?> =
        cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none())

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(
        invoiceId: String,
        params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        cancelTopupInvoice(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(
        invoiceId: String,
        params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
    ): CompletableFuture<Void?> = cancelTopupInvoice(invoiceId, params, RequestOptions.none())

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(
        params: BillingCancelTopupInvoiceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(params: BillingCancelTopupInvoiceParams): CompletableFuture<Void?> =
        cancelTopupInvoice(params, RequestOptions.none())

    /** @see cancelTopupInvoice */
    fun cancelTopupInvoice(
        invoiceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none(), requestOptions)

    /**
     * Request an on-demand top-up invoice.. Requires drawdown billing to be enabled. Only one
     * unpaid top-up invoice is allowed at a time.
     */
    fun createTopupInvoice(
        params: BillingCreateTopupInvoiceParams
    ): CompletableFuture<BillingCreateTopupInvoiceResponse> =
        createTopupInvoice(params, RequestOptions.none())

    /** @see createTopupInvoice */
    fun createTopupInvoice(
        params: BillingCreateTopupInvoiceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BillingCreateTopupInvoiceResponse>

    /** Get current drawdown balance for the authenticated developer */
    fun getBalance(): CompletableFuture<BillingGetBalanceResponse> =
        getBalance(BillingGetBalanceParams.none())

    /** @see getBalance */
    fun getBalance(
        params: BillingGetBalanceParams = BillingGetBalanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BillingGetBalanceResponse>

    /** @see getBalance */
    fun getBalance(
        params: BillingGetBalanceParams = BillingGetBalanceParams.none()
    ): CompletableFuture<BillingGetBalanceResponse> = getBalance(params, RequestOptions.none())

    /** @see getBalance */
    fun getBalance(requestOptions: RequestOptions): CompletableFuture<BillingGetBalanceResponse> =
        getBalance(BillingGetBalanceParams.none(), requestOptions)

    /** List drawdown balance transactions for the authenticated developer */
    fun listTransactions(): CompletableFuture<BillingListTransactionsPageAsync> =
        listTransactions(BillingListTransactionsParams.none())

    /** @see listTransactions */
    fun listTransactions(
        params: BillingListTransactionsParams = BillingListTransactionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BillingListTransactionsPageAsync>

    /** @see listTransactions */
    fun listTransactions(
        params: BillingListTransactionsParams = BillingListTransactionsParams.none()
    ): CompletableFuture<BillingListTransactionsPageAsync> =
        listTransactions(params, RequestOptions.none())

    /** @see listTransactions */
    fun listTransactions(
        requestOptions: RequestOptions
    ): CompletableFuture<BillingListTransactionsPageAsync> =
        listTransactions(BillingListTransactionsParams.none(), requestOptions)

    /**
     * A view of [BillingServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BillingServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `delete /api/v1/billing/drawdown/topup/{invoiceId}`, but
         * is otherwise the same as [BillingServiceAsync.cancelTopupInvoice].
         */
        fun cancelTopupInvoice(invoiceId: String): CompletableFuture<HttpResponse> =
            cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none())

        /** @see cancelTopupInvoice */
        fun cancelTopupInvoice(
            invoiceId: String,
            params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            cancelTopupInvoice(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see cancelTopupInvoice */
        fun cancelTopupInvoice(
            invoiceId: String,
            params: BillingCancelTopupInvoiceParams = BillingCancelTopupInvoiceParams.none(),
        ): CompletableFuture<HttpResponse> =
            cancelTopupInvoice(invoiceId, params, RequestOptions.none())

        /** @see cancelTopupInvoice */
        fun cancelTopupInvoice(
            params: BillingCancelTopupInvoiceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see cancelTopupInvoice */
        fun cancelTopupInvoice(
            params: BillingCancelTopupInvoiceParams
        ): CompletableFuture<HttpResponse> = cancelTopupInvoice(params, RequestOptions.none())

        /** @see cancelTopupInvoice */
        fun cancelTopupInvoice(
            invoiceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            cancelTopupInvoice(invoiceId, BillingCancelTopupInvoiceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/billing/drawdown/topup`, but is otherwise
         * the same as [BillingServiceAsync.createTopupInvoice].
         */
        fun createTopupInvoice(
            params: BillingCreateTopupInvoiceParams
        ): CompletableFuture<HttpResponseFor<BillingCreateTopupInvoiceResponse>> =
            createTopupInvoice(params, RequestOptions.none())

        /** @see createTopupInvoice */
        fun createTopupInvoice(
            params: BillingCreateTopupInvoiceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BillingCreateTopupInvoiceResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v1/billing/balance`, but is otherwise the same
         * as [BillingServiceAsync.getBalance].
         */
        fun getBalance(): CompletableFuture<HttpResponseFor<BillingGetBalanceResponse>> =
            getBalance(BillingGetBalanceParams.none())

        /** @see getBalance */
        fun getBalance(
            params: BillingGetBalanceParams = BillingGetBalanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BillingGetBalanceResponse>>

        /** @see getBalance */
        fun getBalance(
            params: BillingGetBalanceParams = BillingGetBalanceParams.none()
        ): CompletableFuture<HttpResponseFor<BillingGetBalanceResponse>> =
            getBalance(params, RequestOptions.none())

        /** @see getBalance */
        fun getBalance(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BillingGetBalanceResponse>> =
            getBalance(BillingGetBalanceParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/billing/transactions`, but is otherwise the
         * same as [BillingServiceAsync.listTransactions].
         */
        fun listTransactions():
            CompletableFuture<HttpResponseFor<BillingListTransactionsPageAsync>> =
            listTransactions(BillingListTransactionsParams.none())

        /** @see listTransactions */
        fun listTransactions(
            params: BillingListTransactionsParams = BillingListTransactionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BillingListTransactionsPageAsync>>

        /** @see listTransactions */
        fun listTransactions(
            params: BillingListTransactionsParams = BillingListTransactionsParams.none()
        ): CompletableFuture<HttpResponseFor<BillingListTransactionsPageAsync>> =
            listTransactions(params, RequestOptions.none())

        /** @see listTransactions */
        fun listTransactions(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BillingListTransactionsPageAsync>> =
            listTransactions(BillingListTransactionsParams.none(), requestOptions)
    }
}
