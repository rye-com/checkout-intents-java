package com.checkout_intents.api.errors

open class CheckoutIntentsException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
