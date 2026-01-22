// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.services.blocking

import com.checkout_intents.api.core.ClientOptions
import com.checkout_intents.api.core.RequestOptions
import com.checkout_intents.api.core.http.HttpResponseFor
import com.checkout_intents.api.models.checkoutintents.CheckoutIntent
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentAddPaymentParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentConfirmParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentCreateParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentListPage
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentListParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentPurchaseParams
import com.checkout_intents.api.models.checkoutintents.CheckoutIntentRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface CheckoutIntentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckoutIntentService

    /** Create a checkout intent with the given request body. */
    fun create(params: CheckoutIntentCreateParams): CheckoutIntent =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CheckoutIntentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent

    /**
     * Retrieve a checkout intent by id
     *
     * Returns checkout intent information if the lookup succeeds.
     */
    fun retrieve(id: String): CheckoutIntent = retrieve(id, CheckoutIntentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
    ): CheckoutIntent = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CheckoutIntentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent

    /** @see retrieve */
    fun retrieve(params: CheckoutIntentRetrieveParams): CheckoutIntent =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CheckoutIntent =
        retrieve(id, CheckoutIntentRetrieveParams.none(), requestOptions)

    /**
     * Retrieve a paginated list of checkout intents
     *
     * Enables developers to query checkout intents associated with their account, with filters and
     * cursor-based pagination.
     */
    fun list(): CheckoutIntentListPage = list(CheckoutIntentListParams.none())

    /** @see list */
    fun list(
        params: CheckoutIntentListParams = CheckoutIntentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntentListPage

    /** @see list */
    fun list(
        params: CheckoutIntentListParams = CheckoutIntentListParams.none()
    ): CheckoutIntentListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CheckoutIntentListPage =
        list(CheckoutIntentListParams.none(), requestOptions)

    /** Add payment details to a checkout intent */
    fun addPayment(id: String, params: CheckoutIntentAddPaymentParams): CheckoutIntent =
        addPayment(id, params, RequestOptions.none())

    /** @see addPayment */
    fun addPayment(
        id: String,
        params: CheckoutIntentAddPaymentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent = addPayment(params.toBuilder().id(id).build(), requestOptions)

    /** @see addPayment */
    fun addPayment(params: CheckoutIntentAddPaymentParams): CheckoutIntent =
        addPayment(params, RequestOptions.none())

    /** @see addPayment */
    fun addPayment(
        params: CheckoutIntentAddPaymentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent

    /**
     * Confirm a checkout intent with provided payment information
     *
     * Confirm means we have buyer's name, address and payment info, so we can move forward to place
     * the order.
     */
    fun confirm(id: String, params: CheckoutIntentConfirmParams): CheckoutIntent =
        confirm(id, params, RequestOptions.none())

    /** @see confirm */
    fun confirm(
        id: String,
        params: CheckoutIntentConfirmParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent = confirm(params.toBuilder().id(id).build(), requestOptions)

    /** @see confirm */
    fun confirm(params: CheckoutIntentConfirmParams): CheckoutIntent =
        confirm(params, RequestOptions.none())

    /** @see confirm */
    fun confirm(
        params: CheckoutIntentConfirmParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent

    /**
     * Create a checkout intent and immediately trigger the purchase workflow.
     *
     * This is a "fire-and-forget" endpoint that combines create + confirm in one step. The workflow
     * handles offer retrieval, payment authorization, and order placement asynchronously. Poll the
     * GET endpoint to check status.
     */
    fun purchase(params: CheckoutIntentPurchaseParams): CheckoutIntent =
        purchase(params, RequestOptions.none())

    /** @see purchase */
    fun purchase(
        params: CheckoutIntentPurchaseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckoutIntent

    /**
     * A view of [CheckoutIntentService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckoutIntentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents`, but is otherwise the
         * same as [CheckoutIntentService.create].
         */
        @MustBeClosed
        fun create(params: CheckoutIntentCreateParams): HttpResponseFor<CheckoutIntent> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CheckoutIntentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent>

        /**
         * Returns a raw HTTP response for `get /api/v1/checkout-intents/{id}`, but is otherwise the
         * same as [CheckoutIntentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<CheckoutIntent> =
            retrieve(id, CheckoutIntentRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: CheckoutIntentRetrieveParams = CheckoutIntentRetrieveParams.none(),
        ): HttpResponseFor<CheckoutIntent> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: CheckoutIntentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: CheckoutIntentRetrieveParams): HttpResponseFor<CheckoutIntent> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<CheckoutIntent> =
            retrieve(id, CheckoutIntentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/checkout-intents`, but is otherwise the same
         * as [CheckoutIntentService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<CheckoutIntentListPage> = list(CheckoutIntentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CheckoutIntentListParams = CheckoutIntentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntentListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: CheckoutIntentListParams = CheckoutIntentListParams.none()
        ): HttpResponseFor<CheckoutIntentListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<CheckoutIntentListPage> =
            list(CheckoutIntentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents/{id}/payment`, but is
         * otherwise the same as [CheckoutIntentService.addPayment].
         */
        @MustBeClosed
        fun addPayment(
            id: String,
            params: CheckoutIntentAddPaymentParams,
        ): HttpResponseFor<CheckoutIntent> = addPayment(id, params, RequestOptions.none())

        /** @see addPayment */
        @MustBeClosed
        fun addPayment(
            id: String,
            params: CheckoutIntentAddPaymentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent> =
            addPayment(params.toBuilder().id(id).build(), requestOptions)

        /** @see addPayment */
        @MustBeClosed
        fun addPayment(params: CheckoutIntentAddPaymentParams): HttpResponseFor<CheckoutIntent> =
            addPayment(params, RequestOptions.none())

        /** @see addPayment */
        @MustBeClosed
        fun addPayment(
            params: CheckoutIntentAddPaymentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent>

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents/{id}/confirm`, but is
         * otherwise the same as [CheckoutIntentService.confirm].
         */
        @MustBeClosed
        fun confirm(
            id: String,
            params: CheckoutIntentConfirmParams,
        ): HttpResponseFor<CheckoutIntent> = confirm(id, params, RequestOptions.none())

        /** @see confirm */
        @MustBeClosed
        fun confirm(
            id: String,
            params: CheckoutIntentConfirmParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent> =
            confirm(params.toBuilder().id(id).build(), requestOptions)

        /** @see confirm */
        @MustBeClosed
        fun confirm(params: CheckoutIntentConfirmParams): HttpResponseFor<CheckoutIntent> =
            confirm(params, RequestOptions.none())

        /** @see confirm */
        @MustBeClosed
        fun confirm(
            params: CheckoutIntentConfirmParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent>

        /**
         * Returns a raw HTTP response for `post /api/v1/checkout-intents/purchase`, but is
         * otherwise the same as [CheckoutIntentService.purchase].
         */
        @MustBeClosed
        fun purchase(params: CheckoutIntentPurchaseParams): HttpResponseFor<CheckoutIntent> =
            purchase(params, RequestOptions.none())

        /** @see purchase */
        @MustBeClosed
        fun purchase(
            params: CheckoutIntentPurchaseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckoutIntent>
    }
}
