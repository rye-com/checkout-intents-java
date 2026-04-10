@file:JvmName("EmptyHandler")

package com.rye.core.handlers

import com.rye.core.http.HttpResponse
import com.rye.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
