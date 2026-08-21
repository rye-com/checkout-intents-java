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
import com.rye.models.commissions.CommissionListPage
import com.rye.models.commissions.CommissionListPageResponse
import com.rye.models.commissions.CommissionListParams
import java.util.function.Consumer

class CommissionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CommissionService {

    private val withRawResponse: CommissionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CommissionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommissionService =
        CommissionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: CommissionListParams,
        requestOptions: RequestOptions,
    ): CommissionListPage =
        // get /api/v1/commissions
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CommissionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommissionService.WithRawResponse =
            CommissionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<CommissionListPageResponse> =
            jsonHandler<CommissionListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CommissionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommissionListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "commissions")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        CommissionListPage.builder()
                            .service(CommissionServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
