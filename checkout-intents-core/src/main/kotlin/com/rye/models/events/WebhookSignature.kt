package com.rye.models.events

import com.rye.core.jsonMapper
import com.rye.errors.CheckoutIntentsException
import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

internal class EventSignature(private val secret: String) {

    fun unwrap(body: ByteArray, signatureHeader: String?): Event {
        if (signatureHeader == null || !signatureHeader.startsWith(SIGNATURE_PREFIX)) {
            throw WebhookSignatureVerificationException(
                "Invalid signature header format. Expected header starting with '$SIGNATURE_PREFIX'."
            )
        }

        val expectedSignature = signatureHeader.substring(SIGNATURE_PREFIX.length)
        val computedSignature = computeHmacSha256(body)

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

    fun unwrap(body: String, signatureHeader: String?): Event =
        unwrap(body.toByteArray(Charsets.UTF_8), signatureHeader)

    private fun computeHmacSha256(data: ByteArray): String {
        val mac = Mac.getInstance(HMAC_ALGORITHM)
        mac.init(SecretKeySpec(secret.toByteArray(Charsets.UTF_8), HMAC_ALGORITHM))
        return mac.doFinal(data).joinToString("") { "%02x".format(it) }
    }

    private companion object {
        private const val SIGNATURE_PREFIX = "v0="
        private const val HMAC_ALGORITHM = "HmacSHA256"

        private fun secureCompare(a: String, b: String): Boolean =
            MessageDigest.isEqual(a.toByteArray(Charsets.UTF_8), b.toByteArray(Charsets.UTF_8))
    }
}

/**
 * Exception thrown when webhook signature verification fails.
 *
 * This can occur when:
 * - The signature header is missing or malformed
 * - The computed signature does not match the expected signature
 * - The webhook payload cannot be parsed
 */
class WebhookSignatureVerificationException
@JvmOverloads
constructor(message: String, cause: Throwable? = null) : CheckoutIntentsException(message, cause)
