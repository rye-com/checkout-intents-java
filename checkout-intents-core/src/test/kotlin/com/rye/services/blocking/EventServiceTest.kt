// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.events.Event
import com.rye.models.events.WebhookSignatureVerificationException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EventServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()

        val event = eventService.retrieve("id")

        event.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()

        val page = eventService.list()

        page.response().validate()
    }

    @Test
    fun unwrapWithValidSignature() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val body = EVENT_PAYLOAD.toByteArray(Charsets.UTF_8)
        val signature = computeSignature(body, WEBHOOK_SECRET)

        val event = eventService.unwrap(body, "v0=$signature", WEBHOOK_SECRET)

        assertThat(event.id()).isEqualTo("evt_1234567890")
        assertThat(event.createdAt()).isEqualTo("2026-03-25T00:00:00Z")
        assertThat(event.object_()).isEqualTo(Event.Object.EVENT)
        assertThat(event.source().id()).isEqualTo("ci_1234567890")
        assertThat(event.source().type()).isEqualTo(Event.Source.Type.CHECKOUT_INTENT)
        assertThat(event.type()).isEqualTo(Event.Type.CHECKOUT_INTENT_OFFER_RETRIEVED)
    }

    @Test
    fun unwrapWithStringBody() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val signature = computeSignature(EVENT_PAYLOAD.toByteArray(Charsets.UTF_8), WEBHOOK_SECRET)

        val event = eventService.unwrap(EVENT_PAYLOAD, "v0=$signature", WEBHOOK_SECRET)

        assertThat(event.id()).isEqualTo("evt_1234567890")
    }

    @Test
    fun unwrapWithNullSignatureHeader() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val body = EVENT_PAYLOAD.toByteArray(Charsets.UTF_8)

        assertThatThrownBy { eventService.unwrap(body, null, WEBHOOK_SECRET) }
            .isInstanceOf(WebhookSignatureVerificationException::class.java)
            .hasMessageContaining("Invalid signature header format")
    }

    @Test
    fun unwrapWithMissingPrefix() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val body = EVENT_PAYLOAD.toByteArray(Charsets.UTF_8)
        val signature = computeSignature(body, WEBHOOK_SECRET)

        assertThatThrownBy { eventService.unwrap(body, signature, WEBHOOK_SECRET) }
            .isInstanceOf(WebhookSignatureVerificationException::class.java)
            .hasMessageContaining("Invalid signature header format")
    }

    @Test
    fun unwrapWithInvalidSignature() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val body = EVENT_PAYLOAD.toByteArray(Charsets.UTF_8)

        assertThatThrownBy { eventService.unwrap(body, "v0=invalid_signature", WEBHOOK_SECRET) }
            .isInstanceOf(WebhookSignatureVerificationException::class.java)
            .hasMessageContaining("signature verification failed")
    }

    @Test
    fun unwrapWithWrongSecret() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val body = EVENT_PAYLOAD.toByteArray(Charsets.UTF_8)
        val signature = computeSignature(body, WEBHOOK_SECRET)

        assertThatThrownBy { eventService.unwrap(body, "v0=$signature", "wrong_secret") }
            .isInstanceOf(WebhookSignatureVerificationException::class.java)
            .hasMessageContaining("signature verification failed")
    }

    @Test
    fun unwrapWithTamperedBody() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val body = EVENT_PAYLOAD.toByteArray(Charsets.UTF_8)
        val signature = computeSignature(body, WEBHOOK_SECRET)
        val tamperedBody = EVENT_PAYLOAD.replace("evt_1234567890", "evt_tampered")

        assertThatThrownBy { eventService.unwrap(tamperedBody, "v0=$signature", WEBHOOK_SECRET) }
            .isInstanceOf(WebhookSignatureVerificationException::class.java)
            .hasMessageContaining("signature verification failed")
    }

    @Test
    fun unwrapWithInvalidJson() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()
        val body = "not valid json".toByteArray(Charsets.UTF_8)
        val signature = computeSignature(body, WEBHOOK_SECRET)

        assertThatThrownBy { eventService.unwrap(body, "v0=$signature", WEBHOOK_SECRET) }
            .isInstanceOf(WebhookSignatureVerificationException::class.java)
            .hasMessageContaining("Failed to parse webhook payload")
    }

    @Test
    fun unwrapWithRealWebhookPayload() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()

        val body =
            """{"id":"evt_ci_acf8e2c44f4c4583bd5b58d291242bb2_awaiting_confirmation","object":"event","type":"checkout_intent.offer_retrieved","createdAt":"2026-04-21T03:27:50.000Z","source":{"type":"checkout_intent","id":"ci_acf8e2c44f4c4583bd5b58d291242bb2"}}"""
        val signature = "v0=a296fa9084469414e018aa8c33f68d315f88a0b503babb3825f7de87f473803e"
        val secret = "6b2f15a9c9ee825fcf6f6447351a810c"

        val event = eventService.unwrap(body, signature, secret)

        assertThat(event.id())
            .isEqualTo("evt_ci_acf8e2c44f4c4583bd5b58d291242bb2_awaiting_confirmation")
        assertThat(event.type()).isEqualTo(Event.Type.CHECKOUT_INTENT_OFFER_RETRIEVED)
        assertThat(event.source().id()).isEqualTo("ci_acf8e2c44f4c4583bd5b58d291242bb2")
        assertThat(event.source().type()).isEqualTo(Event.Source.Type.CHECKOUT_INTENT)
    }

    companion object {
        private const val WEBHOOK_SECRET = "test_webhook_secret_key"

        private val EVENT_PAYLOAD =
            """
            {
                "id": "evt_1234567890",
                "createdAt": "2026-03-25T00:00:00Z",
                "object": "event",
                "source": {
                    "id": "ci_1234567890",
                    "type": "checkout_intent"
                },
                "type": "checkout_intent.offer_retrieved"
            }
            """
                .trimIndent()

        private fun computeSignature(data: ByteArray, key: String): String {
            val mac = Mac.getInstance("HmacSHA256")
            mac.init(SecretKeySpec(key.toByteArray(Charsets.UTF_8), "HmacSHA256"))
            return mac.doFinal(data).joinToString("") { "%02x".format(it) }
        }
    }
}
