// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckoutIntentConfirmParamsTest {

    @Test
    fun create() {
        CheckoutIntentConfirmParams.builder()
            .id("id")
            .paymentMethod(
                PaymentMethod.StripeTokenPaymentMethod.builder()
                    .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                    .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CheckoutIntentConfirmParams.builder()
                .id("id")
                .paymentMethod(
                    PaymentMethod.StripeTokenPaymentMethod.builder()
                        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CheckoutIntentConfirmParams.builder()
                .id("id")
                .paymentMethod(
                    PaymentMethod.StripeTokenPaymentMethod.builder()
                        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.paymentMethod())
            .isEqualTo(
                PaymentMethod.ofStripeToken(
                    PaymentMethod.StripeTokenPaymentMethod.builder()
                        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                        .build()
                )
            )
    }
}
