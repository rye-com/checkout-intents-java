// File generated from our OpenAPI spec by Stainless.

package com.rye.errors

import com.rye.core.JsonValue
import com.rye.core.http.Headers

abstract class CheckoutIntentsServiceException
protected constructor(message: String, cause: Throwable? = null) :
    CheckoutIntentsException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
