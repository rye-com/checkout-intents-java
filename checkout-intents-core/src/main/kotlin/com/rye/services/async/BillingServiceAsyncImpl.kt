// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.handlers.errorBodyHandler
import com.rye.core.handlers.errorHandler
import com.rye.core.handlers.jsonHandler
import com.rye.core.http.HttpMethod
import com.rye.core.http.HttpRequest
import com.rye.core.http.HttpResponse
import com.rye.core.http.HttpResponse.Handler
import com.rye.core.http.HttpResponseFor
import com.rye.core.http.parseable
import com.rye.core.prepareAsync
import com.rye.models.billing.BillingGetBalanceParams
import com.rye.models.billing.BillingGetBalanceResponse
import com.rye.models.billing.BillingListTransactionsPageAsync
import com.rye.models.billing.BillingListTransactionsPageResponse
import com.rye.models.billing.BillingListTransactionsParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class BillingServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BillingServiceAsync {

    private val withRawResponse: BillingServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BillingServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BillingServiceAsync =
        BillingServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun getBalance(
        params: BillingGetBalanceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BillingGetBalanceResponse> =
        // get /api/v1/billing/balance
        withRawResponse().getBalance(params, requestOptions).thenApply { it.parse() }

    override fun listTransactions(
        params: BillingListTransactionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BillingListTransactionsPageAsync> =
        // get /api/v1/billing/transactions
        withRawResponse().listTransactions(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BillingServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BillingServiceAsync.WithRawResponse =
            BillingServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val getBalanceHandler: Handler<BillingGetBalanceResponse> =
            jsonHandler<BillingGetBalanceResponse>(clientOptions.jsonMapper)

        override fun getBalance(
            params: BillingGetBalanceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BillingGetBalanceResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "billing", "balance")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getBalanceHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listTransactionsHandler: Handler<BillingListTransactionsPageResponse> =
            jsonHandler<BillingListTransactionsPageResponse>(clientOptions.jsonMapper)

        override fun listTransactions(
            params: BillingListTransactionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BillingListTransactionsPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "billing", "transactions")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listTransactionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                BillingListTransactionsPageAsync.builder()
                                    .service(BillingServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
