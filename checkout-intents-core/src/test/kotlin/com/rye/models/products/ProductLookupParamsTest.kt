// File generated from our OpenAPI spec by Stainless.

package com.rye.models.products

import com.rye.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductLookupParamsTest {

    @Test
    fun create() {
        ProductLookupParams.builder().url("url").build()
    }

    @Test
    fun queryParams() {
        val params = ProductLookupParams.builder().url("url").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("url", "url").build())
    }
}
