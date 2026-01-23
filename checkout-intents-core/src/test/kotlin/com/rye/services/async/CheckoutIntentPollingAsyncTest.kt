package com.rye.services.async

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.rye.client.CheckoutIntentsClientAsync
import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync
import com.rye.core.Sleeper
import com.rye.errors.PollTimeoutException
import com.rye.models.checkoutintents.PollOptions
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class CheckoutIntentPollingAsyncTest {

    private lateinit var baseUrl: String
    private lateinit var client: CheckoutIntentsClientAsync
    private lateinit var checkoutIntentService: CheckoutIntentServiceAsync

    private val sleepCount = AtomicInteger(0)
    private val lastSleepDuration = AtomicInteger(0)

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        sleepCount.set(0)
        lastSleepDuration.set(0)
        client =
            CheckoutIntentsOkHttpClientAsync.builder()
                .baseUrl(baseUrl)
                .apiKey("test-api-key")
                .sleeper(
                    object : Sleeper {
                        override fun sleep(duration: Duration) {
                            sleepCount.incrementAndGet()
                            lastSleepDuration.set(duration.toMillis().toInt())
                        }

                        override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
                            sleepCount.incrementAndGet()
                            lastSleepDuration.set(duration.toMillis().toInt())
                            return CompletableFuture.completedFuture(null)
                        }

                        override fun close() {}
                    }
                )
                .build()
        checkoutIntentService = client.checkoutIntents()
        resetAllScenarios()
    }

    @Test
    fun pollUntilCompleted_returnsImmediatelyWhenCompleted() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(completedIntentJson("test-id"))
                )
        )

        val result = checkoutIntentService.pollUntilCompleted("test-id").get()

        assertThat(result.isCompleted()).isTrue()
        assertThat(sleepCount.get()).isEqualTo(0)
        verify(1, getRequestedFor(urlPathEqualTo("/api/v1/checkout-intents/test-id")))
    }

    @Test
    fun pollUntilCompleted_returnsImmediatelyWhenFailed() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(failedIntentJson("test-id"))
                )
        )

        val result = checkoutIntentService.pollUntilCompleted("test-id").get()

        assertThat(result.isFailed()).isTrue()
        assertThat(sleepCount.get()).isEqualTo(0)
    }

    @Test
    fun pollUntilCompleted_pollsUntilStateChanges() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(placingOrderIntentJson("test-id"))
                )
                .willSetStateTo("POLL_1")
        )
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs("POLL_1")
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(placingOrderIntentJson("test-id"))
                )
                .willSetStateTo("POLL_2")
        )
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs("POLL_2")
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(completedIntentJson("test-id"))
                )
        )

        val result = checkoutIntentService.pollUntilCompleted("test-id").get()

        assertThat(result.isCompleted()).isTrue()
        assertThat(sleepCount.get()).isEqualTo(2)
        verify(3, getRequestedFor(urlPathEqualTo("/api/v1/checkout-intents/test-id")))
    }

    @Test
    fun pollUntilCompleted_throwsTimeoutExceptionAfterMaxAttempts() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(placingOrderIntentJson("test-id"))
                )
        )

        val options = PollOptions.builder().maxAttempts(3).build()

        val executionException =
            assertThrows<ExecutionException> {
                checkoutIntentService.pollUntilCompleted("test-id", options).get()
            }

        val exception = executionException.cause as PollTimeoutException
        assertThat(exception.intentId).isEqualTo("test-id")
        assertThat(exception.attempts).isEqualTo(3)
        assertThat(exception.maxAttempts).isEqualTo(3)
        assertThat(sleepCount.get()).isEqualTo(2)
    }

    @Test
    fun pollUntilAwaitingConfirmation_returnsWhenAwaitingConfirmation() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(retrievingOfferIntentJson("test-id"))
                )
                .willSetStateTo("POLL_1")
        )
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs("POLL_1")
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(awaitingConfirmationIntentJson("test-id"))
                )
        )

        val result = checkoutIntentService.pollUntilAwaitingConfirmation("test-id").get()

        assertThat(result.isAwaitingConfirmation()).isTrue()
        assertThat(sleepCount.get()).isEqualTo(1)
    }

    @Test
    fun pollUntilCompleted_respectsRetryAfterMsHeader() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withHeader("retry-after-ms", "1234")
                        .withBody(placingOrderIntentJson("test-id"))
                )
                .willSetStateTo("POLL_1")
        )
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs("POLL_1")
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(completedIntentJson("test-id"))
                )
        )

        checkoutIntentService.pollUntilCompleted("test-id").get()

        assertThat(lastSleepDuration.get()).isEqualTo(1234)
    }

    @Test
    fun pollUntilCompleted_usesCustomPollInterval() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(placingOrderIntentJson("test-id"))
                )
                .willSetStateTo("POLL_1")
        )
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .inScenario("polling")
                .whenScenarioStateIs("POLL_1")
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(completedIntentJson("test-id"))
                )
        )

        val options = PollOptions.builder().pollInterval(Duration.ofMillis(2500)).build()

        checkoutIntentService.pollUntilCompleted("test-id", options).get()

        assertThat(lastSleepDuration.get()).isEqualTo(2500)
    }

    @Test
    fun pollUntilCompleted_sendsPollingHeaders() {
        stubFor(
            get(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "application/json")
                        .withBody(completedIntentJson("test-id"))
                )
        )

        checkoutIntentService.pollUntilCompleted("test-id").get()

        verify(
            getRequestedFor(urlPathEqualTo("/api/v1/checkout-intents/test-id"))
                .withHeader("X-Stainless-Poll-Helper", equalTo("true"))
                .withHeader("X-Stainless-Custom-Poll-Interval", equalTo("5000"))
        )
    }

    // Helper methods to generate JSON responses

    private fun retrievingOfferIntentJson(id: String) =
        """
        {
            "id": "$id",
            "state": "retrieving_offer",
            "buyer": {
                "address1": "123 Main St",
                "city": "New York",
                "country": "US",
                "email": "test@example.com",
                "firstName": "John",
                "lastName": "Doe",
                "phone": "1234567890",
                "postalCode": "10001",
                "province": "NY"
            },
            "createdAt": "2024-01-01T00:00:00Z",
            "productUrl": "https://example.com/product",
            "quantity": 1
        }
        """

    private fun awaitingConfirmationIntentJson(id: String) =
        """
        {
            "id": "$id",
            "state": "awaiting_confirmation",
            "buyer": {
                "address1": "123 Main St",
                "city": "New York",
                "country": "US",
                "email": "test@example.com",
                "firstName": "John",
                "lastName": "Doe",
                "phone": "1234567890",
                "postalCode": "10001",
                "province": "NY"
            },
            "createdAt": "2024-01-01T00:00:00Z",
            "productUrl": "https://example.com/product",
            "quantity": 1,
            "offer": {
                "shippingPrice": {"value": 500, "currency": "USD"},
                "subtotal": {"value": 5000, "currency": "USD"},
                "total": {"value": 5500, "currency": "USD"}
            }
        }
        """

    private fun placingOrderIntentJson(id: String) =
        """
        {
            "id": "$id",
            "state": "placing_order",
            "buyer": {
                "address1": "123 Main St",
                "city": "New York",
                "country": "US",
                "email": "test@example.com",
                "firstName": "John",
                "lastName": "Doe",
                "phone": "1234567890",
                "postalCode": "10001",
                "province": "NY"
            },
            "createdAt": "2024-01-01T00:00:00Z",
            "productUrl": "https://example.com/product",
            "quantity": 1,
            "offer": {
                "shippingPrice": {"value": 500, "currency": "USD"},
                "subtotal": {"value": 5000, "currency": "USD"},
                "total": {"value": 5500, "currency": "USD"}
            }
        }
        """

    private fun completedIntentJson(id: String) =
        """
        {
            "id": "$id",
            "state": "completed",
            "buyer": {
                "address1": "123 Main St",
                "city": "New York",
                "country": "US",
                "email": "test@example.com",
                "firstName": "John",
                "lastName": "Doe",
                "phone": "1234567890",
                "postalCode": "10001",
                "province": "NY"
            },
            "createdAt": "2024-01-01T00:00:00Z",
            "productUrl": "https://example.com/product",
            "quantity": 1,
            "offer": {
                "shippingPrice": {"value": 500, "currency": "USD"},
                "subtotal": {"value": 5000, "currency": "USD"},
                "total": {"value": 5500, "currency": "USD"}
            },
            "orders": []
        }
        """

    private fun failedIntentJson(id: String) =
        """
        {
            "id": "$id",
            "state": "failed",
            "buyer": {
                "address1": "123 Main St",
                "city": "New York",
                "country": "US",
                "email": "test@example.com",
                "firstName": "John",
                "lastName": "Doe",
                "phone": "1234567890",
                "postalCode": "10001",
                "province": "NY"
            },
            "createdAt": "2024-01-01T00:00:00Z",
            "productUrl": "https://example.com/product",
            "quantity": 1,
            "errors": [{"code": "error", "message": "Something went wrong"}]
        }
        """
}
