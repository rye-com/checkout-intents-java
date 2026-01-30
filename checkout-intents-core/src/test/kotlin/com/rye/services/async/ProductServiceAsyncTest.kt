// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.TestServerExtension
import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.products.ProductLookupParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ProductServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun lookup() {
        val client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val productServiceAsync = client.products()

        val productFuture =
            productServiceAsync.lookup(ProductLookupParams.builder().url("url").build())

        val product = productFuture.get()
        product.validate()
    }
}
