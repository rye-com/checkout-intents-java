package com.rye.errors

class PollTimeoutException(
    val intentId: String,
    val attempts: Int,
    val maxAttempts: Int,
    val pollIntervalMs: Long,
    message: String,
) : CheckoutIntentsException(message)
