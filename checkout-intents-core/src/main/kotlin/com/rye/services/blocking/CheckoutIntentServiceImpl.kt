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
import com.rye.models.checkoutintents.CheckoutIntent
import com.rye.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.rye.models.checkoutintents.CheckoutIntentConfirmParams
import com.rye.models.checkoutintents.CheckoutIntentCreateParams
import com.rye.models.checkoutintents.CheckoutIntentListPage
import com.rye.models.checkoutintents.CheckoutIntentListPageResponse
import com.rye.models.checkoutintents.CheckoutIntentListParams
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams
import com.rye.models.checkoutintents.CheckoutIntentRetrieveParams
import com.rye.services.blocking.checkoutintents.ShipmentService
import com.rye.services.blocking.checkoutintents.ShipmentServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CheckoutIntentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckoutIntentService {

    private val withRawResponse: CheckoutIntentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val shipments: ShipmentService by lazy { ShipmentServiceImpl(clientOptions) }

    override fun withRawResponse(): CheckoutIntentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutIntentService =
        CheckoutIntentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun shipments(): ShipmentService = shipments

    override fun create(
        params: CheckoutIntentCreateParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: CheckoutIntentRetrieveParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // get /api/v1/checkout-intents/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: CheckoutIntentListParams,
        requestOptions: RequestOptions,
    ): CheckoutIntentListPage =
        // get /api/v1/checkout-intents
        withRawResponse().list(params, requestOptions).parse()

    override fun addPayment(
        params: CheckoutIntentAddPaymentParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents/{id}/payment
        withRawResponse().addPayment(params, requestOptions).parse()

    override fun confirm(
        params: CheckoutIntentConfirmParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents/{id}/confirm
        withRawResponse().confirm(params, requestOptions).parse()

    override fun purchase(
        params: CheckoutIntentPurchaseParams,
        requestOptions: RequestOptions,
    ): CheckoutIntent =
        // post /api/v1/checkout-intents/purchase
        withRawResponse().purchase(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckoutIntentService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val shipments: ShipmentService.WithRawResponse by lazy {
            ShipmentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutIntentService.WithRawResponse =
            CheckoutIntentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun shipments(): ShipmentService.WithRawResponse = shipments

        private val createHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun create(
            params: CheckoutIntentCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents")
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

        private val retrieveHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CheckoutIntentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents", params._pathParam(0))
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

        private val listHandler: Handler<CheckoutIntentListPageResponse> =
            jsonHandler<CheckoutIntentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CheckoutIntentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntentListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents")
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
                        CheckoutIntentListPage.builder()
                            .service(CheckoutIntentServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val addPaymentHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun addPayment(
            params: CheckoutIntentAddPaymentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "checkout-intents",
                        params._pathParam(0),
                        "payment",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addPaymentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val confirmHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun confirm(
            params: CheckoutIntentConfirmParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "checkout-intents",
                        params._pathParam(0),
                        "confirm",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { confirmHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val purchaseHandler: Handler<CheckoutIntent> =
            jsonHandler<CheckoutIntent>(clientOptions.jsonMapper)

        override fun purchase(
            params: CheckoutIntentPurchaseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckoutIntent> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "checkout-intents", "purchase")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { purchaseHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
