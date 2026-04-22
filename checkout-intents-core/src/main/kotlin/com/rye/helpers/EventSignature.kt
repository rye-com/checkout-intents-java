package com.rye.helpers

import com.rye.core.jsonMapper
import com.rye.errors.WebhookSignatureVerificationException
import com.rye.models.events.Event
import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * Utility for verifying webhook signatures and parsing webhook payloads.
 *
 * Example usage:
 * ```
 * val event = EventSignature.unwrap(body, signatureHeader, secret)
 * when (event.type()) {
 *     Event.Type.CHECKOUT_INTENT_CONFIRMED -> handleConfirmed(event)
 *     // ...
 * }
 * ```
 */
object EventSignature {

    private const val SIGNATURE_PREFIX = "v0="
    private const val HMAC_ALGORITHM = "HmacSHA256"

    /**
     * Verifies the webhook signature and parses the payload into an [Event].
     *
     * @param body The raw request body as bytes. Must be the exact bytes received; do not decode or
     *   modify.
     * @param signatureHeader The value of the `x-rye-signature` HTTP header.
     * @param secret Your webhook secret key (typically from the `RYE_HMAC_SECRET_KEY` environment
     *   variable).
     * @return The parsed [Event] if the signature is valid.
     * @throws WebhookSignatureVerificationException if the signature is missing, malformed, or
     *   invalid.
     */
    @JvmStatic
    fun unwrap(body: ByteArray, signatureHeader: String?, secret: String): Event {
        if (signatureHeader == null || !signatureHeader.startsWith(SIGNATURE_PREFIX)) {
            throw WebhookSignatureVerificationException(
                "Invalid signature header format. Expected header starting with '$SIGNATURE_PREFIX'."
            )
        }

        val expectedSignature = signatureHeader.substring(SIGNATURE_PREFIX.length)
        val computedSignature = computeHmacSha256(body, secret)

        if (!secureCompare(computedSignature, expectedSignature)) {
            throw WebhookSignatureVerificationException(
                "Webhook signature verification failed. The signature does not match the payload."
            )
        }

        return try {
            jsonMapper().readValue(body, Event::class.java)
        } catch (e: Exception) {
            throw WebhookSignatureVerificationException("Failed to parse webhook payload.", e)
        }
    }

    /**
     * Verifies the webhook signature and parses the payload into an [Event].
     *
     * Convenience overload that accepts the body as a [String].
     *
     * @param body The raw request body as a string. Must be the exact string received; do not
     *   modify.
     * @param signatureHeader The value of the `x-rye-signature` HTTP header.
     * @param secret Your webhook secret key (typically from the `RYE_HMAC_SECRET_KEY` environment
     *   variable).
     * @return The parsed [Event] if the signature is valid.
     * @throws WebhookSignatureVerificationException if the signature is missing, malformed, or
     *   invalid.
     */
    @JvmStatic
    fun unwrap(body: String, signatureHeader: String?, secret: String): Event =
        unwrap(body.toByteArray(Charsets.UTF_8), signatureHeader, secret)

    private fun computeHmacSha256(data: ByteArray, secret: String): String {
        val mac = Mac.getInstance(HMAC_ALGORITHM)
        mac.init(SecretKeySpec(secret.toByteArray(Charsets.UTF_8), HMAC_ALGORITHM))
        return mac.doFinal(data).joinToString("") { "%02x".format(it) }
    }

    private fun secureCompare(a: String, b: String): Boolean =
        MessageDigest.isEqual(a.toByteArray(Charsets.UTF_8), b.toByteArray(Charsets.UTF_8))
}
