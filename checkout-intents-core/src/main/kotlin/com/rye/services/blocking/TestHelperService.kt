// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.core.ClientOptions
import com.rye.services.blocking.testhelpers.ReturnService
import com.rye.services.blocking.testhelpers.ShipmentService
import java.util.function.Consumer

interface TestHelperService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TestHelperService

    fun returns(): ReturnService

    fun shipments(): ShipmentService

    /** A view of [TestHelperService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TestHelperService.WithRawResponse

        fun returns(): ReturnService.WithRawResponse

        fun shipments(): ShipmentService.WithRawResponse
    }
}
