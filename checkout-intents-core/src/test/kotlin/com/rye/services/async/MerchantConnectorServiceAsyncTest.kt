// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.models.merchantconnectors.MerchantConnectorCreateInstallationLinkParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MerchantConnectorServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun createInstallationLink() {
        val client = CheckoutIntentsOkHttpClientAsync.builder().apiKey("My API Key").build()
        val merchantConnectorServiceAsync = client.merchantConnectors()

        val installationLinkFuture =
            merchantConnectorServiceAsync.createInstallationLink(
                MerchantConnectorCreateInstallationLinkParams.builder()
                    .connector(MerchantConnectorCreateInstallationLinkParams.Connector.SHOPIFY)
                    .storeUrl("storeUrl")
                    .private_(true)
                    .build()
            )

        val installationLink = installationLinkFuture.get()
        installationLink.validate()
    }
}
