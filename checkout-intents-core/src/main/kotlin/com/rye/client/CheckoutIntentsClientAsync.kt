// File generated from our OpenAPI spec by Stainless.

package com.rye.client

import com.rye.core.ClientOptions
import com.rye.services.async.BetaServiceAsync
import com.rye.services.async.BillingServiceAsync
import com.rye.services.async.BrandServiceAsync
import com.rye.services.async.CheckoutIntentServiceAsync
import com.rye.services.async.ProductServiceAsync
import com.rye.services.async.ShipmentServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Checkout Intents REST API asynchronously. You can also switch
 * to synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface CheckoutIntentsClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): CheckoutIntentsClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutIntentsClientAsync

    fun checkoutIntents(): CheckoutIntentServiceAsync

    fun betas(): BetaServiceAsync

    fun brands(): BrandServiceAsync

    fun products(): ProductServiceAsync

    fun shipments(): ShipmentServiceAsync

    fun billing(): BillingServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [CheckoutIntentsClientAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutIntentsClientAsync.WithRawResponse

        fun checkoutIntents(): CheckoutIntentServiceAsync.WithRawResponse

        fun betas(): BetaServiceAsync.WithRawResponse

        fun brands(): BrandServiceAsync.WithRawResponse

        fun products(): ProductServiceAsync.WithRawResponse

        fun shipments(): ShipmentServiceAsync.WithRawResponse

        fun billing(): BillingServiceAsync.WithRawResponse
    }
}
