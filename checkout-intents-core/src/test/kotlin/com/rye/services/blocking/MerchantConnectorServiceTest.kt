// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.merchantconnectors.MerchantConnectorCreateInstallationLinkParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MerchantConnectorServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun createInstallationLink() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val merchantConnectorService = client.merchantConnectors()

        val installationLink =
            merchantConnectorService.createInstallationLink(
                MerchantConnectorCreateInstallationLinkParams.builder()
                    .connector(MerchantConnectorCreateInstallationLinkParams.Connector.SHOPIFY)
                    .storeUrl("storeUrl")
                    .private_(true)
                    .build()
            )

        installationLink.validate()
    }
}
