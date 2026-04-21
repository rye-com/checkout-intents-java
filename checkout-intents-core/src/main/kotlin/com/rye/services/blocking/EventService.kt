// File generated from our OpenAPI spec by Stainless.

package com.rye.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.rye.core.ClientOptions
import com.rye.core.RequestOptions
import com.rye.core.http.HttpResponseFor
import com.rye.models.events.Event
import com.rye.models.events.EventListPage
import com.rye.models.events.EventListParams
import com.rye.models.events.EventRetrieveParams
import com.rye.models.events.WebhookSignatureVerificationException
import java.util.function.Consumer

interface EventService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Verifies the webhook signature and parses the payload into an [Event].
     *
     * @param body The raw request body as bytes. Must be the exact bytes received; do not decode or
     *   modify.
     * @param signatureHeader The value of the `x-rye-signature` HTTP header.
     * @param secret Your webhook secret key (typically from the `RYE_HMAC_SECRET_KEY` environment
     *   variable).
     * @return The parsed [Event] if the signature is valid.
     * @throws WebhookSignatureVerificationException if the signature is missing, malformed, or
     *   invalid.
     */
    fun unwrap(body: ByteArray, signatureHeader: String?, secret: String): Event

    /**
     * Verifies the webhook signature and parses the payload into an [Event].
     *
     * Convenience overload that accepts the body as a [String].
     *
     * @param body The raw request body as a string. Must be the exact string received; do not
     *   modify.
     * @param signatureHeader The value of the `x-rye-signature` HTTP header.
     * @param secret Your webhook secret key (typically from the `RYE_HMAC_SECRET_KEY` environment
     *   variable).
     * @return The parsed [Event] if the signature is valid.
     * @throws WebhookSignatureVerificationException if the signature is missing, malformed, or
     *   invalid.
     */
    fun unwrap(body: String, signatureHeader: String?, secret: String): Event =
        unwrap(body.toByteArray(Charsets.UTF_8), signatureHeader, secret)

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService

    /** Retrieves an event by ID. */
    fun retrieve(id: String): Event = retrieve(id, EventRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EventRetrieveParams = EventRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Event = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(id: String, params: EventRetrieveParams = EventRetrieveParams.none()): Event =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: EventRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Event

    /** @see retrieve */
    fun retrieve(params: EventRetrieveParams): Event = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): Event =
        retrieve(id, EventRetrieveParams.none(), requestOptions)

    /** Retrieve a paginated list of events. */
    fun list(): EventListPage = list(EventListParams.none())

    /** @see list */
    fun list(
        params: EventListParams = EventListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EventListPage

    /** @see list */
    fun list(params: EventListParams = EventListParams.none()): EventListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): EventListPage =
        list(EventListParams.none(), requestOptions)

    /** A view of [EventService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/events/{id}`, but is otherwise the same as
         * [EventService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<Event> = retrieve(id, EventRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: EventRetrieveParams = EventRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Event> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: EventRetrieveParams = EventRetrieveParams.none(),
        ): HttpResponseFor<Event> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: EventRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Event>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: EventRetrieveParams): HttpResponseFor<Event> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<Event> =
            retrieve(id, EventRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/events`, but is otherwise the same as
         * [EventService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<EventListPage> = list(EventListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EventListParams = EventListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EventListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: EventListParams = EventListParams.none()): HttpResponseFor<EventListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EventListPage> =
            list(EventListParams.none(), requestOptions)
    }
}
