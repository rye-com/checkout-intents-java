// File generated from our OpenAPI spec by Stainless.

package com.rye.models.checkoutintents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.rye.core.JsonValue
import com.rye.core.jsonMapper
import com.rye.errors.CheckoutIntentsInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class PaymentMethodTest {

    @Test
    fun ofStripeToken() {
        val stripeToken =
            PaymentMethod.StripeTokenPaymentMethod.builder()
                .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                .build()

        val paymentMethod = PaymentMethod.ofStripeToken(stripeToken)

        assertThat(paymentMethod.stripeToken()).contains(stripeToken)
        assertThat(paymentMethod.basisTheory()).isEmpty
        assertThat(paymentMethod.nekuda()).isEmpty
        assertThat(paymentMethod.drawdown()).isEmpty
    }

    @Test
    fun ofStripeTokenRoundtrip() {
        val jsonMapper = jsonMapper()
        val paymentMethod =
            PaymentMethod.ofStripeToken(
                PaymentMethod.StripeTokenPaymentMethod.builder()
                    .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
                    .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
                    .build()
            )

        val roundtrippedPaymentMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paymentMethod),
                jacksonTypeRef<PaymentMethod>(),
            )

        assertThat(roundtrippedPaymentMethod).isEqualTo(paymentMethod)
    }

    @Test
    fun ofBasisTheory() {
        val basisTheory =
            PaymentMethod.BasisTheoryPaymentMethod.builder()
                .basisTheoryToken("basisTheoryToken")
                .type(PaymentMethod.BasisTheoryPaymentMethod.Type.BASIS_THEORY_TOKEN)
                .build()

        val paymentMethod = PaymentMethod.ofBasisTheory(basisTheory)

        assertThat(paymentMethod.stripeToken()).isEmpty
        assertThat(paymentMethod.basisTheory()).contains(basisTheory)
        assertThat(paymentMethod.nekuda()).isEmpty
        assertThat(paymentMethod.drawdown()).isEmpty
    }

    @Test
    fun ofBasisTheoryRoundtrip() {
        val jsonMapper = jsonMapper()
        val paymentMethod =
            PaymentMethod.ofBasisTheory(
                PaymentMethod.BasisTheoryPaymentMethod.builder()
                    .basisTheoryToken("basisTheoryToken")
                    .type(PaymentMethod.BasisTheoryPaymentMethod.Type.BASIS_THEORY_TOKEN)
                    .build()
            )

        val roundtrippedPaymentMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paymentMethod),
                jacksonTypeRef<PaymentMethod>(),
            )

        assertThat(roundtrippedPaymentMethod).isEqualTo(paymentMethod)
    }

    @Test
    fun ofNekuda() {
        val nekuda =
            PaymentMethod.NekudaPaymentMethod.builder()
                .nekudaUserId("nekudaUserId")
                .type(PaymentMethod.NekudaPaymentMethod.Type.NEKUDA_TOKEN)
                .nekudaMandateData(
                    PaymentMethod.NekudaPaymentMethod.NekudaMandateData.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val paymentMethod = PaymentMethod.ofNekuda(nekuda)

        assertThat(paymentMethod.stripeToken()).isEmpty
        assertThat(paymentMethod.basisTheory()).isEmpty
        assertThat(paymentMethod.nekuda()).contains(nekuda)
        assertThat(paymentMethod.drawdown()).isEmpty
    }

    @Test
    fun ofNekudaRoundtrip() {
        val jsonMapper = jsonMapper()
        val paymentMethod =
            PaymentMethod.ofNekuda(
                PaymentMethod.NekudaPaymentMethod.builder()
                    .nekudaUserId("nekudaUserId")
                    .type(PaymentMethod.NekudaPaymentMethod.Type.NEKUDA_TOKEN)
                    .nekudaMandateData(
                        PaymentMethod.NekudaPaymentMethod.NekudaMandateData.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedPaymentMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paymentMethod),
                jacksonTypeRef<PaymentMethod>(),
            )

        assertThat(roundtrippedPaymentMethod).isEqualTo(paymentMethod)
    }

    @Test
    fun ofDrawdown() {
        val drawdown =
            PaymentMethod.DrawdownPaymentMethod.builder()
                .type(PaymentMethod.DrawdownPaymentMethod.Type.DRAWDOWN)
                .build()

        val paymentMethod = PaymentMethod.ofDrawdown(drawdown)

        assertThat(paymentMethod.stripeToken()).isEmpty
        assertThat(paymentMethod.basisTheory()).isEmpty
        assertThat(paymentMethod.nekuda()).isEmpty
        assertThat(paymentMethod.drawdown()).contains(drawdown)
    }

    @Test
    fun ofDrawdownRoundtrip() {
        val jsonMapper = jsonMapper()
        val paymentMethod =
            PaymentMethod.ofDrawdown(
                PaymentMethod.DrawdownPaymentMethod.builder()
                    .type(PaymentMethod.DrawdownPaymentMethod.Type.DRAWDOWN)
                    .build()
            )

        val roundtrippedPaymentMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paymentMethod),
                jacksonTypeRef<PaymentMethod>(),
            )

        assertThat(roundtrippedPaymentMethod).isEqualTo(paymentMethod)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val paymentMethod =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<PaymentMethod>())

        val e = assertThrows<CheckoutIntentsInvalidDataException> { paymentMethod.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
