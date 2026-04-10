// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.checkRequired
import com.rye.core.handlers.emptyHandler
import com.rye.core.handlers.errorBodyHandler
import com.rye.core.handlers.errorHandler
import com.rye.core.handlers.jsonHandler
import com.rye.core.http.HttpMethod
import com.rye.core.http.HttpRequest
import com.rye.core.http.HttpResponse
import com.rye.core.http.HttpResponse.Handler
import com.rye.core.http.HttpResponseFor
import com.rye.core.http.json
import com.rye.core.http.parseable
import com.rye.core.prepareAsync
import com.rye.models.billing.BillingCancelTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceResponse
import com.rye.models.billing.BillingGetBalanceParams
import com.rye.models.billing.BillingGetBalanceResponse
import com.rye.models.billing.BillingListTransactionsPageAsync
import com.rye.models.billing.BillingListTransactionsPageResponse
import com.rye.models.billing.BillingListTransactionsParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class BillingServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BillingServiceAsync {

    private val withRawResponse: BillingServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BillingServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BillingServiceAsync =
        BillingServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun cancelTopupInvoice(
        params: BillingCancelTopupInvoiceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /api/v1/billing/drawdown/topup/{invoiceId}
        withRawResponse().cancelTopupInvoice(params, requestOptions).thenAccept {}

    override fun createTopupInvoice(
        params: BillingCreateTopupInvoiceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BillingCreateTopupInvoiceResponse> =
        // post /api/v1/billing/drawdown/topup
        withRawResponse().createTopupInvoice(params, requestOptions).thenApply { it.parse() }

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

        private val cancelTopupInvoiceHandler: Handler<Void?> = emptyHandler()

        override fun cancelTopupInvoice(
            params: BillingCancelTopupInvoiceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("invoiceId", params.invoiceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "billing",
                        "drawdown",
                        "topup",
                        params._pathParam(0),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { cancelTopupInvoiceHandler.handle(it) }
                    }
                }
        }

        private val createTopupInvoiceHandler: Handler<BillingCreateTopupInvoiceResponse> =
            jsonHandler<BillingCreateTopupInvoiceResponse>(clientOptions.jsonMapper)

        override fun createTopupInvoice(
            params: BillingCreateTopupInvoiceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BillingCreateTopupInvoiceResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "billing", "drawdown", "topup")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createTopupInvoiceHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

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
