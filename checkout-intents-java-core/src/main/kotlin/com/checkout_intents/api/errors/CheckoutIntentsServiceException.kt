// File generated from our OpenAPI spec by Stainless.

package com.checkout_intents.api.errors

import com.checkout_intents.api.core.JsonValue
import com.checkout_intents.api.core.http.Headers

abstract class CheckoutIntentsServiceException
protected constructor(message: String, cause: Throwable? = null) :
    CheckoutIntentsException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
