// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.services.async.testhelpers.ReturnServiceAsync
import com.rye.services.async.testhelpers.ReturnServiceAsyncImpl
import com.rye.services.async.testhelpers.ShipmentServiceAsync
import com.rye.services.async.testhelpers.ShipmentServiceAsyncImpl
import java.util.function.Consumer

class TestHelperServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TestHelperServiceAsync {

    private val withRawResponse: TestHelperServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val returns: ReturnServiceAsync by lazy { ReturnServiceAsyncImpl(clientOptions) }

    private val shipments: ShipmentServiceAsync by lazy { ShipmentServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): TestHelperServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TestHelperServiceAsync =
        TestHelperServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun returns(): ReturnServiceAsync = returns

    override fun shipments(): ShipmentServiceAsync = shipments

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TestHelperServiceAsync.WithRawResponse {

        private val returns: ReturnServiceAsync.WithRawResponse by lazy {
            ReturnServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val shipments: ShipmentServiceAsync.WithRawResponse by lazy {
            ShipmentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TestHelperServiceAsync.WithRawResponse =
            TestHelperServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun returns(): ReturnServiceAsync.WithRawResponse = returns

        override fun shipments(): ShipmentServiceAsync.WithRawResponse = shipments
    }
}
