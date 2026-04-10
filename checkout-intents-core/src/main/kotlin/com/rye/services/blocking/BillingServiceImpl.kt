// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

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
import com.rye.core.prepare
import com.rye.models.billing.BillingCancelTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceParams
import com.rye.models.billing.BillingCreateTopupInvoiceResponse
import com.rye.models.billing.BillingGetBalanceParams
import com.rye.models.billing.BillingGetBalanceResponse
import com.rye.models.billing.BillingListTransactionsPage
import com.rye.models.billing.BillingListTransactionsPageResponse
import com.rye.models.billing.BillingListTransactionsParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class BillingServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BillingService {

    private val withRawResponse: BillingService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BillingService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BillingService =
        BillingServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun cancelTopupInvoice(
        params: BillingCancelTopupInvoiceParams,
        requestOptions: RequestOptions,
    ) {
        // delete /api/v1/billing/drawdown/topup/{invoiceId}
        withRawResponse().cancelTopupInvoice(params, requestOptions)
    }

    override fun createTopupInvoice(
        params: BillingCreateTopupInvoiceParams,
        requestOptions: RequestOptions,
    ): BillingCreateTopupInvoiceResponse =
        // post /api/v1/billing/drawdown/topup
        withRawResponse().createTopupInvoice(params, requestOptions).parse()

    override fun getBalance(
        params: BillingGetBalanceParams,
        requestOptions: RequestOptions,
    ): BillingGetBalanceResponse =
        // get /api/v1/billing/balance
        withRawResponse().getBalance(params, requestOptions).parse()

    override fun listTransactions(
        params: BillingListTransactionsParams,
        requestOptions: RequestOptions,
    ): BillingListTransactionsPage =
        // get /api/v1/billing/transactions
        withRawResponse().listTransactions(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BillingService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BillingService.WithRawResponse =
            BillingServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val cancelTopupInvoiceHandler: Handler<Void?> = emptyHandler()

        override fun cancelTopupInvoice(
            params: BillingCancelTopupInvoiceParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { cancelTopupInvoiceHandler.handle(it) }
            }
        }

        private val createTopupInvoiceHandler: Handler<BillingCreateTopupInvoiceResponse> =
            jsonHandler<BillingCreateTopupInvoiceResponse>(clientOptions.jsonMapper)

        override fun createTopupInvoice(
            params: BillingCreateTopupInvoiceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BillingCreateTopupInvoiceResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "billing", "drawdown", "topup")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createTopupInvoiceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getBalanceHandler: Handler<BillingGetBalanceResponse> =
            jsonHandler<BillingGetBalanceResponse>(clientOptions.jsonMapper)

        override fun getBalance(
            params: BillingGetBalanceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BillingGetBalanceResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "billing", "balance")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getBalanceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listTransactionsHandler: Handler<BillingListTransactionsPageResponse> =
            jsonHandler<BillingListTransactionsPageResponse>(clientOptions.jsonMapper)

        override fun listTransactions(
            params: BillingListTransactionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BillingListTransactionsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "billing", "transactions")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listTransactionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        BillingListTransactionsPage.builder()
                            .service(BillingServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
