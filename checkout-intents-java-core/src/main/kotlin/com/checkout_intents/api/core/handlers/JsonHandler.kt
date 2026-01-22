@file:JvmName("JsonHandler")

package com.checkout_intents.api.core.handlers

import com.checkout_intents.api.core.http.HttpResponse
import com.checkout_intents.api.core.http.HttpResponse.Handler
import com.checkout_intents.api.errors.CheckoutIntentsInvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw CheckoutIntentsInvalidDataException("Error reading response", e)
            }
    }
