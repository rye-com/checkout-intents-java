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
import com.rye.models.products.Product
import com.rye.models.products.ProductLookupParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ProductServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ProductServiceAsync {

    private val withRawResponse: ProductServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ProductServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProductServiceAsync =
        ProductServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun lookup(
        params: ProductLookupParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Product> =
        // get /api/v1/products/lookup
        withRawResponse().lookup(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProductServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProductServiceAsync.WithRawResponse =
            ProductServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val lookupHandler: Handler<Product> = jsonHandler<Product>(clientOptions.jsonMapper)

        override fun lookup(
            params: ProductLookupParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Product>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "products", "lookup")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { lookupHandler.handle(it) }
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
