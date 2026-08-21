// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.merchantconnectors.InstallationLink
import com.rye.models.merchantconnectors.MerchantConnectorCreateInstallationLinkParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MerchantConnectorServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MerchantConnectorServiceAsync

    /**
     * Generate an installation link for a merchant connector (e.g. Shopify).
     *
     * The returned URL begins the connector's OAuth handshake. Direct the merchant to it; once they
     * authorize the Rye app, the connector redirects back to Rye to complete the install. The
     * merchant is attributed to the calling developer and becomes available for checkout via this
     * account.
     */
    fun createInstallationLink(
        connector: MerchantConnectorCreateInstallationLinkParams.Connector,
        params: MerchantConnectorCreateInstallationLinkParams,
    ): CompletableFuture<InstallationLink> =
        createInstallationLink(connector, params, RequestOptions.none())

    /** @see createInstallationLink */
    fun createInstallationLink(
        connector: MerchantConnectorCreateInstallationLinkParams.Connector,
        params: MerchantConnectorCreateInstallationLinkParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InstallationLink> =
        createInstallationLink(params.toBuilder().connector(connector).build(), requestOptions)

    /** @see createInstallationLink */
    fun createInstallationLink(
        params: MerchantConnectorCreateInstallationLinkParams
    ): CompletableFuture<InstallationLink> = createInstallationLink(params, RequestOptions.none())

    /** @see createInstallationLink */
    fun createInstallationLink(
        params: MerchantConnectorCreateInstallationLinkParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InstallationLink>

    /**
     * A view of [MerchantConnectorServiceAsync] that provides access to raw HTTP responses for each
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
        ): MerchantConnectorServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /api/v1/merchant-connectors/{connector}/installation-link`, but is otherwise the same as
         * [MerchantConnectorServiceAsync.createInstallationLink].
         */
        fun createInstallationLink(
            connector: MerchantConnectorCreateInstallationLinkParams.Connector,
            params: MerchantConnectorCreateInstallationLinkParams,
        ): CompletableFuture<HttpResponseFor<InstallationLink>> =
            createInstallationLink(connector, params, RequestOptions.none())

        /** @see createInstallationLink */
        fun createInstallationLink(
            connector: MerchantConnectorCreateInstallationLinkParams.Connector,
            params: MerchantConnectorCreateInstallationLinkParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InstallationLink>> =
            createInstallationLink(params.toBuilder().connector(connector).build(), requestOptions)

        /** @see createInstallationLink */
        fun createInstallationLink(
            params: MerchantConnectorCreateInstallationLinkParams
        ): CompletableFuture<HttpResponseFor<InstallationLink>> =
            createInstallationLink(params, RequestOptions.none())

        /** @see createInstallationLink */
        fun createInstallationLink(
            params: MerchantConnectorCreateInstallationLinkParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InstallationLink>>
    }
}
