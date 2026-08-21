// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

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
import com.rye.core.http.parseable
import com.rye.core.prepareAsync
import com.rye.models.merchantconnectors.InstallationLink
import com.rye.models.merchantconnectors.MerchantConnectorCreateInstallationLinkParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MerchantConnectorServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : MerchantConnectorServiceAsync {

    private val withRawResponse: MerchantConnectorServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MerchantConnectorServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): MerchantConnectorServiceAsync =
        MerchantConnectorServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun createInstallationLink(
        params: MerchantConnectorCreateInstallationLinkParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InstallationLink> =
        // get /api/v1/merchant-connectors/{connector}/installation-link
        withRawResponse().createInstallationLink(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MerchantConnectorServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MerchantConnectorServiceAsync.WithRawResponse =
            MerchantConnectorServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createInstallationLinkHandler: Handler<InstallationLink> =
            jsonHandler<InstallationLink>(clientOptions.jsonMapper)

        override fun createInstallationLink(
            params: MerchantConnectorCreateInstallationLinkParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InstallationLink>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("connector", params.connector().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "merchant-connectors",
                        params._pathParam(0),
                        "installation-link",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createInstallationLinkHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
