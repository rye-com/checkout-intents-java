package com.checkout_intents.api.errors

class CheckoutIntentsInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    CheckoutIntentsException(message, cause)
