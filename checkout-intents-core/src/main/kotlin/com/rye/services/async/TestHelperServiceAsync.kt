// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.services.async.testhelpers.ReturnServiceAsync
import com.rye.services.async.testhelpers.ShipmentServiceAsync
import java.util.function.Consumer

interface TestHelperServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TestHelperServiceAsync

    fun returns(): ReturnServiceAsync

    fun shipments(): ShipmentServiceAsync

    /**
     * A view of [TestHelperServiceAsync] that provides access to raw HTTP responses for each
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
        ): TestHelperServiceAsync.WithRawResponse

        fun returns(): ReturnServiceAsync.WithRawResponse

        fun shipments(): ShipmentServiceAsync.WithRawResponse
    }
}
