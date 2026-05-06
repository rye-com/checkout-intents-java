// File generated from our OpenAPI spec by Stainless.

package com.rye.models.merchantconnectors

import com.rye.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MerchantConnectorCreateInstallationLinkParamsTest {

    @Test
    fun create() {
        MerchantConnectorCreateInstallationLinkParams.builder()
            .connector(MerchantConnectorCreateInstallationLinkParams.Connector.SHOPIFY)
            .storeUrl("storeUrl")
            .private_(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MerchantConnectorCreateInstallationLinkParams.builder()
                .connector(MerchantConnectorCreateInstallationLinkParams.Connector.SHOPIFY)
                .storeUrl("storeUrl")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("shopify")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            MerchantConnectorCreateInstallationLinkParams.builder()
                .connector(MerchantConnectorCreateInstallationLinkParams.Connector.SHOPIFY)
                .storeUrl("storeUrl")
                .private_(true)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("storeUrl", "storeUrl").put("private", "true").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            MerchantConnectorCreateInstallationLinkParams.builder()
                .connector(MerchantConnectorCreateInstallationLinkParams.Connector.SHOPIFY)
                .storeUrl("storeUrl")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("storeUrl", "storeUrl").build())
    }
}
