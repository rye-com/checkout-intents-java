// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.models.events.Event
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.assertj.core.api.Assertions.assertThat
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
    fun unwrap() {
        val client = CheckoutIntentsOkHttpClient.builder().apiKey("My API Key").build()
        val body = EVENT_PAYLOAD.toByteArray(Charsets.UTF_8)
        val signature = computeSignature(body, WEBHOOK_SECRET)

        val event = client.events().unwrap(body, "v0=$signature", WEBHOOK_SECRET)

        assertThat(event.id()).isEqualTo("evt_1234567890")
        assertThat(event.type()).isEqualTo(Event.Type.CHECKOUT_INTENT_OFFER_RETRIEVED)
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
