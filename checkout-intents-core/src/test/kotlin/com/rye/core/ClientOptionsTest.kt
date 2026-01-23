// File generated from our OpenAPI spec by Stainless.

package com.rye.core

import com.rye.core.http.HttpClient
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
internal class ClientOptionsTest {

    private val httpClient = mock<HttpClient>()

    @Test
    fun toBuilder_whenOriginalClientOptionsGarbageCollected_doesNotCloseOriginalClient() {
        var clientOptions =
            ClientOptions.builder().httpClient(httpClient).apiKey("My API Key").build()
        verify(httpClient, never()).close()

        // Overwrite the `clientOptions` variable so that the original `ClientOptions` is GC'd.
        clientOptions = clientOptions.toBuilder().build()
        System.gc()
        Thread.sleep(100)

        verify(httpClient, never()).close()
        // This exists so that `clientOptions` is still reachable.
        assertThat(clientOptions).isEqualTo(clientOptions)
    }

    // Environment auto-inference tests

    @Test
    fun `auto-infers staging environment from API key`() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("RYE/staging-abc123def456")
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.STAGING_URL)
    }

    @Test
    fun `auto-infers production environment from API key`() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("RYE/production-xyz789ghi012")
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.PRODUCTION_URL)
    }

    @Test
    fun `defaults to staging for malformed API key`() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).apiKey("some-random-api-key").build()

        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.STAGING_URL)
    }

    @Test
    fun `explicit baseUrl matching inferred staging environment succeeds`() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("RYE/staging-abc123")
                .baseUrl(ClientOptions.STAGING_URL)
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.STAGING_URL)
    }

    @Test
    fun `explicit baseUrl matching inferred production environment succeeds`() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("RYE/production-abc123")
                .baseUrl(ClientOptions.PRODUCTION_URL)
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.PRODUCTION_URL)
    }

    @Test
    fun `explicit staging baseUrl with production key throws error`() {
        assertThatThrownBy {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .apiKey("RYE/production-abc123")
                    .baseUrl(ClientOptions.STAGING_URL)
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Environment mismatch")
            .hasMessageContaining("production")
            .hasMessageContaining(ClientOptions.STAGING_URL)
    }

    @Test
    fun `explicit production baseUrl with staging key throws error`() {
        assertThatThrownBy {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .apiKey("RYE/staging-abc123")
                    .baseUrl(ClientOptions.PRODUCTION_URL)
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Environment mismatch")
            .hasMessageContaining("staging")
            .hasMessageContaining(ClientOptions.PRODUCTION_URL)
    }

    @Test
    fun `explicit baseUrl with malformed key succeeds`() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("some-random-key")
                .baseUrl(ClientOptions.PRODUCTION_URL)
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.PRODUCTION_URL)
    }

    @Test
    fun `custom baseUrl overrides inference`() {
        val customUrl = "https://custom.api.example.com/"
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("RYE/production-abc123")
                .baseUrl(customUrl)
                .build()

        assertThat(clientOptions.baseUrl()).isEqualTo(customUrl)
    }

    @Test
    fun `empty prefix does not match`() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).apiKey("RYE/-abc123").build()

        // Should default to staging since format is malformed
        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.STAGING_URL)
    }

    @Test
    fun `uppercase environment does not match`() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).apiKey("RYE/STAGING-abc123").build()

        // Should default to staging since format doesn't match (case-sensitive)
        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.STAGING_URL)
    }

    @Test
    fun `partial match does not match`() {
        val clientOptions =
            ClientOptions.builder().httpClient(httpClient).apiKey("RYE/prod-abc123").build()

        // Should default to staging since "prod" is not a valid environment
        assertThat(clientOptions.baseUrl()).isEqualTo(ClientOptions.STAGING_URL)
    }

    @Test
    fun `extractEnvironmentFromApiKey returns staging for staging key`() {
        val result = ClientOptions.extractEnvironmentFromApiKey("RYE/staging-abc123")
        assertThat(result).isEqualTo("staging")
    }

    @Test
    fun `extractEnvironmentFromApiKey returns production for production key`() {
        val result = ClientOptions.extractEnvironmentFromApiKey("RYE/production-xyz789")
        assertThat(result).isEqualTo("production")
    }

    @Test
    fun `extractEnvironmentFromApiKey returns null for malformed key`() {
        assertThat(ClientOptions.extractEnvironmentFromApiKey("invalid-key")).isNull()
        assertThat(ClientOptions.extractEnvironmentFromApiKey("RYE/other-abc123")).isNull()
        assertThat(ClientOptions.extractEnvironmentFromApiKey("RYE/STAGING-abc123")).isNull()
        assertThat(ClientOptions.extractEnvironmentFromApiKey("")).isNull()
    }
}
