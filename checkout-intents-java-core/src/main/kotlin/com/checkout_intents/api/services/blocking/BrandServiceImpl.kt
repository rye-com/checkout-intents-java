// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
import com.checkout_intents.api.core.checkRequired
import com.checkout_intents.api.core.handlers.errorBodyHandler
import com.checkout_intents.api.core.handlers.errorHandler
import com.checkout_intents.api.core.handlers.jsonHandler
import com.checkout_intents.api.core.http.HttpMethod
import com.checkout_intents.api.core.http.HttpRequest
import com.checkout_intents.api.core.http.HttpResponse
import com.checkout_intents.api.core.http.HttpResponse.Handler
import com.checkout_intents.api.core.http.HttpResponseFor
import com.checkout_intents.api.core.http.parseable
import com.checkout_intents.api.core.prepare
import com.checkout_intents.api.models.brands.BrandRetrieveParams
import com.checkout_intents.api.models.brands.BrandRetrieveResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class BrandServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BrandService {

    private val withRawResponse: BrandService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BrandService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BrandService =
        BrandServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: BrandRetrieveParams,
        requestOptions: RequestOptions,
    ): BrandRetrieveResponse =
        // get /api/v1/brands/domain/{domain}
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BrandService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BrandService.WithRawResponse =
            BrandServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<BrandRetrieveResponse> =
            jsonHandler<BrandRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: BrandRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("domain", params.domain().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "brands", "domain", params._pathParam(0))
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
