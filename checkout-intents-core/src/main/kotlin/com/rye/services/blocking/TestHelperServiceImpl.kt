// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.rye.core.ClientOptions
import com.rye.services.blocking.testhelpers.ReturnService
import com.rye.services.blocking.testhelpers.ReturnServiceImpl
import com.rye.services.blocking.testhelpers.ShipmentService
import com.rye.services.blocking.testhelpers.ShipmentServiceImpl
import java.util.function.Consumer

class TestHelperServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TestHelperService {

    private val withRawResponse: TestHelperService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val returns: ReturnService by lazy { ReturnServiceImpl(clientOptions) }

    private val shipments: ShipmentService by lazy { ShipmentServiceImpl(clientOptions) }

    override fun withRawResponse(): TestHelperService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TestHelperService =
        TestHelperServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun returns(): ReturnService = returns

    override fun shipments(): ShipmentService = shipments

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TestHelperService.WithRawResponse {

        private val returns: ReturnService.WithRawResponse by lazy {
            ReturnServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val shipments: ShipmentService.WithRawResponse by lazy {
            ShipmentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TestHelperService.WithRawResponse =
            TestHelperServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun returns(): ReturnService.WithRawResponse = returns

        override fun shipments(): ShipmentService.WithRawResponse = shipments
    }
}
