// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.checkRequired
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
import com.rye.models.returns.Return
import com.rye.models.returns.ReturnCreateParams
import com.rye.models.returns.ReturnRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ReturnServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ReturnService {

    private val withRawResponse: ReturnService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ReturnService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ReturnService =
        ReturnServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(params: ReturnCreateParams, requestOptions: RequestOptions): Return =
        // post /api/v1/returns
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: ReturnRetrieveParams, requestOptions: RequestOptions): Return =
        // get /api/v1/returns/{returnId}
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ReturnService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ReturnService.WithRawResponse =
            ReturnServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Return> = jsonHandler<Return>(clientOptions.jsonMapper)

        override fun create(
            params: ReturnCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Return> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "returns")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Return> = jsonHandler<Return>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ReturnRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Return> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("returnId", params.returnId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "returns", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
