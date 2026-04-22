package com.rye.errors

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
