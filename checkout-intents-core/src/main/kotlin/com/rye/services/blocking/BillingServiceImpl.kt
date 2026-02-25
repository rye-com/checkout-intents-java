// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

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
import com.rye.core.prepare
import com.rye.models.billing.BillingGetBalanceParams
import com.rye.models.billing.BillingGetBalanceResponse
import com.rye.models.billing.BillingListTransactionsPage
import com.rye.models.billing.BillingListTransactionsPageResponse
import com.rye.models.billing.BillingListTransactionsParams
import java.util.function.Consumer

class BillingServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BillingService {

    private val withRawResponse: BillingService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BillingService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BillingService =
        BillingServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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
