@file:JvmName("StringHandler")

package com.checkout_intents.api.core.handlers

import com.checkout_intents.api.core.http.HttpResponse
import com.checkout_intents.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
