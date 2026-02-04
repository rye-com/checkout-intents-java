// File generated from our OpenAPI spec by Stainless.

package com.rye.services.async

import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.checkoutintents.CheckoutIntent
import com.rye.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.rye.models.checkoutintents.CheckoutIntentConfirmParams
import com.rye.models.checkoutintents.CheckoutIntentCreateParams
import com.rye.models.checkoutintents.CheckoutIntentListPageAsync
import com.rye.models.checkoutintents.CheckoutIntentListParams
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams
import com.rye.models.checkoutintents.CheckoutIntentRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CheckoutIntentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutIntentServiceAsync

    /** Create a checkout intent with the given request body. */
    fun create(params: CheckoutIntentCreateParams): CompletableFuture<CheckoutIntent> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CheckoutIntentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent>

    /**
     * Retrieve a checkout intent by id
     *
     * Returns checkout intent information if the lookup succeeds.
     */
    fun retrieve(id: String): CompletableFuture<CheckoutIntent> =
        retrieve(id, CheckoutIntentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
    ): CompletableFuture<CheckoutIntent> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CheckoutIntentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent>

    /** @see retrieve */
    fun retrieve(params: CheckoutIntentRetrieveParams): CompletableFuture<CheckoutIntent> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<CheckoutIntent> =
        retrieve(id, CheckoutIntentRetrieveParams.none(), requestOptions)

    /**
     * Retrieve a paginated list of checkout intents
     *
     * Enables developers to query checkout intents associated with their account, with filters and
     * cursor-based pagination.
     */
    fun list(): CompletableFuture<CheckoutIntentListPageAsync> =
        list(CheckoutIntentListParams.none())

    /** @see list */
    fun list(
        params: CheckoutIntentListParams = CheckoutIntentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntentListPageAsync>

    /** @see list */
    fun list(
        params: CheckoutIntentListParams = CheckoutIntentListParams.none()
    ): CompletableFuture<CheckoutIntentListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<CheckoutIntentListPageAsync> =
        list(CheckoutIntentListParams.none(), requestOptions)

    /** Add payment details to a checkout intent */
    fun addPayment(
        id: String,
        params: CheckoutIntentAddPaymentParams,
    ): CompletableFuture<CheckoutIntent> = addPayment(id, params, RequestOptions.none())

    /** @see addPayment */
    fun addPayment(
        id: String,
        params: CheckoutIntentAddPaymentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent> =
        addPayment(params.toBuilder().id(id).build(), requestOptions)

    /** @see addPayment */
    fun addPayment(params: CheckoutIntentAddPaymentParams): CompletableFuture<CheckoutIntent> =
        addPayment(params, RequestOptions.none())

    /** @see addPayment */
    fun addPayment(
        params: CheckoutIntentAddPaymentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent>

    /**
     * Confirm a checkout intent with provided payment information
     *
     * Confirm means we have buyer's name, address and payment info, so we can move forward to place
     * the order.
     */
    fun confirm(
        id: String,
        params: CheckoutIntentConfirmParams,
    ): CompletableFuture<CheckoutIntent> = confirm(id, params, RequestOptions.none())

    /** @see confirm */
    fun confirm(
        id: String,
        params: CheckoutIntentConfirmParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent> =
        confirm(params.toBuilder().id(id).build(), requestOptions)

    /** @see confirm */
    fun confirm(params: CheckoutIntentConfirmParams): CompletableFuture<CheckoutIntent> =
        confirm(params, RequestOptions.none())

    /** @see confirm */
    fun confirm(
        params: CheckoutIntentConfirmParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent>

    /**
     * Create a checkout intent and immediately trigger the purchase workflow.
     *
     * This is a "fire-and-forget" endpoint that combines create + confirm in one step. The workflow
     * handles offer retrieval, payment authorization, and order placement asynchronously. Poll the
     * GET endpoint to check status.
     */
    fun purchase(params: CheckoutIntentPurchaseParams): CompletableFuture<CheckoutIntent> =
        purchase(params, RequestOptions.none())

    /** @see purchase */
    fun purchase(
        params: CheckoutIntentPurchaseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckoutIntent>

    /**
     * A view of [CheckoutIntentServiceAsync] that provides access to raw HTTP responses for each
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
        ): CheckoutIntentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents`, but is otherwise the
         * same as [CheckoutIntentServiceAsync.create].
         */
        fun create(
            params: CheckoutIntentCreateParams
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CheckoutIntentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>>

        /**
         * Returns a raw HTTP response for `get /api/v1/checkout-intents/{id}`, but is otherwise the
         * same as [CheckoutIntentServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            retrieve(id, CheckoutIntentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: CheckoutIntentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>>

        /** @see retrieve */
        fun retrieve(
            params: CheckoutIntentRetrieveParams
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            retrieve(id, CheckoutIntentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/checkout-intents`, but is otherwise the same
         * as [CheckoutIntentServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<CheckoutIntentListPageAsync>> =
            list(CheckoutIntentListParams.none())

        /** @see list */
        fun list(
            params: CheckoutIntentListParams = CheckoutIntentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntentListPageAsync>>

        /** @see list */
        fun list(
            params: CheckoutIntentListParams = CheckoutIntentListParams.none()
        ): CompletableFuture<HttpResponseFor<CheckoutIntentListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CheckoutIntentListPageAsync>> =
            list(CheckoutIntentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents/{id}/payment`, but is
         * otherwise the same as [CheckoutIntentServiceAsync.addPayment].
         */
        fun addPayment(
            id: String,
            params: CheckoutIntentAddPaymentParams,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            addPayment(id, params, RequestOptions.none())

        /** @see addPayment */
        fun addPayment(
            id: String,
            params: CheckoutIntentAddPaymentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            addPayment(params.toBuilder().id(id).build(), requestOptions)

        /** @see addPayment */
        fun addPayment(
            params: CheckoutIntentAddPaymentParams
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            addPayment(params, RequestOptions.none())

        /** @see addPayment */
        fun addPayment(
            params: CheckoutIntentAddPaymentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>>

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents/{id}/confirm`, but is
         * otherwise the same as [CheckoutIntentServiceAsync.confirm].
         */
        fun confirm(
            id: String,
            params: CheckoutIntentConfirmParams,
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            confirm(id, params, RequestOptions.none())

        /** @see confirm */
        fun confirm(
            id: String,
            params: CheckoutIntentConfirmParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            confirm(params.toBuilder().id(id).build(), requestOptions)

        /** @see confirm */
        fun confirm(
            params: CheckoutIntentConfirmParams
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            confirm(params, RequestOptions.none())

        /** @see confirm */
        fun confirm(
            params: CheckoutIntentConfirmParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>>

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents/purchase`, but is
         * otherwise the same as [CheckoutIntentServiceAsync.purchase].
         */
        fun purchase(
            params: CheckoutIntentPurchaseParams
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>> =
            purchase(params, RequestOptions.none())

        /** @see purchase */
        fun purchase(
            params: CheckoutIntentPurchaseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckoutIntent>>
    }
}
