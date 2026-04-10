// File generated from our OpenAPI spec by Stainless.

package com.rye.models.billing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.jsonMapper
import com.rye.models.checkoutintents.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingCreateTopupInvoiceResponseTest {

    @Test
    fun create() {
        val billingCreateTopupInvoiceResponse =
            BillingCreateTopupInvoiceResponse.builder()
                .id("in_abc123")
                .amount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .bankTransferDetails(
                    BillingCreateTopupInvoiceResponse.BankTransferDetails.builder()
                        .accountHolderName("accountHolderName")
                        .accountNumber("accountNumber")
                        .bankName("bankName")
                        .routingNumber("routingNumber")
                        .build()
                )
                .status(BillingCreateTopupInvoiceResponse.Status.DRAFT)
                .url("https://invoice.stripe.com/i/acct_xxx/test_xxx")
                .build()

        assertThat(billingCreateTopupInvoiceResponse.id()).isEqualTo("in_abc123")
        assertThat(billingCreateTopupInvoiceResponse.amount())
            .isEqualTo(Money.builder().amountSubunits(1500).currencyCode("USD").build())
        assertThat(billingCreateTopupInvoiceResponse.bankTransferDetails())
            .isEqualTo(
                BillingCreateTopupInvoiceResponse.BankTransferDetails.builder()
                    .accountHolderName("accountHolderName")
                    .accountNumber("accountNumber")
                    .bankName("bankName")
                    .routingNumber("routingNumber")
                    .build()
            )
        assertThat(billingCreateTopupInvoiceResponse.status())
            .isEqualTo(BillingCreateTopupInvoiceResponse.Status.DRAFT)
        assertThat(billingCreateTopupInvoiceResponse.url())
            .contains("https://invoice.stripe.com/i/acct_xxx/test_xxx")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val billingCreateTopupInvoiceResponse =
            BillingCreateTopupInvoiceResponse.builder()
                .id("in_abc123")
                .amount(Money.builder().amountSubunits(1500).currencyCode("USD").build())
                .bankTransferDetails(
                    BillingCreateTopupInvoiceResponse.BankTransferDetails.builder()
                        .accountHolderName("accountHolderName")
                        .accountNumber("accountNumber")
                        .bankName("bankName")
                        .routingNumber("routingNumber")
                        .build()
                )
                .status(BillingCreateTopupInvoiceResponse.Status.DRAFT)
                .url("https://invoice.stripe.com/i/acct_xxx/test_xxx")
                .build()

        val roundtrippedBillingCreateTopupInvoiceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(billingCreateTopupInvoiceResponse),
                jacksonTypeRef<BillingCreateTopupInvoiceResponse>(),
            )

        assertThat(roundtrippedBillingCreateTopupInvoiceResponse)
            .isEqualTo(billingCreateTopupInvoiceResponse)
    }
}
