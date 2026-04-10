// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingCreateTopupInvoiceParamsTest {

    @Test
    fun create() {
        BillingCreateTopupInvoiceParams.builder()
            .amountSubunits(500000)
            .chargeAutomatically(false)
            .build()
    }

    @Test
    fun body() {
        val params =
            BillingCreateTopupInvoiceParams.builder()
                .amountSubunits(500000)
                .chargeAutomatically(false)
                .build()

        val body = params._body()

        assertThat(body.amountSubunits()).isEqualTo(500000)
        assertThat(body.chargeAutomatically()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BillingCreateTopupInvoiceParams.builder().amountSubunits(500000).build()

        val body = params._body()

        assertThat(body.amountSubunits()).isEqualTo(500000)
    }
}
