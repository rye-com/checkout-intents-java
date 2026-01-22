// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking.betas

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
import com.checkout_intents.api.core.handlers.errorBodyHandler
import com.checkout_intents.api.core.handlers.errorHandler
import com.checkout_intents.api.core.handlers.jsonHandler
import com.checkout_intents.api.core.http.HttpMethod
import com.checkout_intents.api.core.http.HttpRequest
import com.checkout_intents.api.core.http.HttpResponse
import com.checkout_intents.api.core.http.HttpResponse.Handler
import com.checkout_intents.api.core.http.HttpResponseFor
import com.checkout_intents.api.core.http.json
import com.checkout_intents.api.core.http.parseable
import com.checkout_intents.api.core.prepare
import com.checkout_intents.api.models.betas.CheckoutSession
import com.checkout_intents.api.models.betas.checkoutsessions.CheckoutSessionCreateParams
import java.util.function.Consumer

class CheckoutSessionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckoutSessionService {

    private val withRawResponse: CheckoutSessionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CheckoutSessionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutSessionService =
        CheckoutSessionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CheckoutSessionCreateParams,
        requestOptions: RequestOptions,
    ): CheckoutSession =
        // post /api/v1/betas/checkout-sessions
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckoutSessionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutSessionService.WithRawResponse =
            CheckoutSessionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CheckoutSession> =
            jsonHandler<CheckoutSession>(clientOptions.jsonMapper)

        override fun create(
            params: CheckoutSessionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutSession> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "betas", "checkout-sessions")
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
    }
}
