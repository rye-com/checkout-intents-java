// File generated from our OpenAPI spec by Stainless.

package com.rye.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.rye.client.CheckoutIntentsClient
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient
import com.rye.core.JsonValue
import com.rye.core.http.Headers
import com.rye.core.jsonMapper
import com.rye.errors.BadRequestException
import com.rye.errors.CheckoutIntentsException
import com.rye.errors.InternalServerException
import com.rye.errors.NotFoundException
import com.rye.errors.PermissionDeniedException
import com.rye.errors.RateLimitException
import com.rye.errors.UnauthorizedException
import com.rye.errors.UnexpectedStatusCodeException
import com.rye.errors.UnprocessableEntityException
import com.rye.models.checkoutintents.Buyer
import com.rye.models.checkoutintents.CheckoutIntentCreateParams
import com.rye.models.checkoutintents.VariantSelection
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: CheckoutIntentsClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            CheckoutIntentsOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun checkoutIntentsCreate400() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate400WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate401() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate401WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate403() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate403WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate404() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate404WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate422() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate422WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate429() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate429WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate500() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate500WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate999() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreate999WithRawResponse() {
        val checkoutIntentService = client.checkoutIntents().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun checkoutIntentsCreateInvalidJsonBody() {
        val checkoutIntentService = client.checkoutIntents()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<CheckoutIntentsException> {
                checkoutIntentService.create(
                    CheckoutIntentCreateParams.builder()
                        .buyer(
                            Buyer.builder()
                                .address1("123 Main St")
                                .city("New York")
                                .country("US")
                                .email("john.doe@example.com")
                                .firstName("John")
                                .lastName("Doe")
                                .phone("1234567890")
                                .postalCode("10001")
                                .province("NY")
                                .address2("Apt 1")
                                .build()
                        )
                        .productUrl("productUrl")
                        .quantity(1)
                        .constraints(
                            CheckoutIntentCreateParams.Constraints.builder()
                                .maxShippingPrice(500)
                                .maxTotalPrice(100000)
                                .offerRetrievalEffort(
                                    CheckoutIntentCreateParams.Constraints.OfferRetrievalEffort.MAX
                                )
                                .build()
                        )
                        .addPromoCode("sqF12lZ1VlBb")
                        .addVariantSelection(
                            VariantSelection.builder()
                                .label("Size, Color, etc.")
                                .value("Small, Red, XS, L, etc.")
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
