// File generated from our OpenAPI spec by Stainless.

package com.rye.models.merchantconnectors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InstallationLinkTest {

    @Test
    fun create() {
        val installationLink =
            InstallationLink.builder()
                .connector(InstallationLink.Connector.SHOPIFY)
                .url("url")
                .build()

        assertThat(installationLink.connector()).isEqualTo(InstallationLink.Connector.SHOPIFY)
        assertThat(installationLink.url()).isEqualTo("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val installationLink =
            InstallationLink.builder()
                .connector(InstallationLink.Connector.SHOPIFY)
                .url("url")
                .build()

        val roundtrippedInstallationLink =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(installationLink),
                jacksonTypeRef<InstallationLink>(),
            )

        assertThat(roundtrippedInstallationLink).isEqualTo(installationLink)
    }
}
