package com.rye.models.checkoutintents

import java.time.Duration
import java.util.Optional

class PollOptions private constructor(
    private val pollInterval: Duration?,
    private val maxAttempts: Int?,
) {
    fun pollInterval(): Optional<Duration> = Optional.ofNullable(pollInterval)
    fun maxAttempts(): Optional<Int> = Optional.ofNullable(maxAttempts)

    companion object {
        @JvmField val DEFAULT_POLL_INTERVAL: Duration = Duration.ofSeconds(5)
        @JvmField val DEFAULT_MAX_ATTEMPTS: Int = 120

        @JvmStatic fun none() = PollOptions(null, null)
        @JvmStatic fun builder() = Builder()
    }

    class Builder {
        private var pollInterval: Duration? = null
        private var maxAttempts: Int? = null

        fun pollInterval(pollInterval: Duration) = apply { this.pollInterval = pollInterval }
        fun maxAttempts(maxAttempts: Int) = apply { this.maxAttempts = maxAttempts }
        fun build() = PollOptions(pollInterval, maxAttempts)
    }
}
