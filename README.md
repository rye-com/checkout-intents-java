# Checkout Intents Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.rye/checkout-intents)](https://central.sonatype.com/artifact/com.rye/checkout-intents/0.0.3)
[![javadoc](https://javadoc.io/badge2/com.rye/checkout-intents/0.0.3/javadoc.svg)](https://javadoc.io/doc/com.rye/checkout-intents/0.0.3)

<!-- x-release-please-end -->

The Checkout Intents Java SDK provides convenient access to the [Checkout Intents REST API](https://docs.rye.com) from applications written in Java.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

The REST API documentation can be found on [docs.rye.com](https://docs.rye.com). Javadocs are available on [javadoc.io](https://javadoc.io/doc/com.rye/checkout-intents/0.0.3).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.rye:checkout-intents:0.0.3")
```

### Maven

```xml
<dependency>
  <groupId>com.rye</groupId>
  <artifactId>checkout-intents</artifactId>
  <version>0.0.3</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;
import com.rye.models.checkoutintents.Buyer;
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams;
import com.rye.models.checkoutintents.PaymentMethod;

// Configures using the `checkoutintents.apiKey` and `checkoutintents.baseUrl` system properties
// Or configures using the `CHECKOUT_INTENTS_API_KEY` and `CHECKOUT_INTENTS_BASE_URL` environment variables
CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.fromEnv();

CheckoutIntentPurchaseParams params = CheckoutIntentPurchaseParams.builder()
    .buyer(Buyer.builder()
        .address1("123 Main St")
        .city("New York")
        .country("US")
        .email("john.doe@example.com")
        .firstName("John")
        .lastName("Doe")
        .phone("1234567890")
        .postalCode("10001")
        .province("NY")
        .build())
    .paymentMethod(PaymentMethod.StripeTokenPaymentMethod.builder()
        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
        .build())
    .productUrl("https://rye-protocol.myshopify.com/products/rye-sticker")
    .quantity(1)
    .build();
CheckoutIntent checkoutIntent = client.checkoutIntents().purchase(params);
```

## Client configuration

Configure the client using system properties or environment variables:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;

// Configures using the `checkoutintents.apiKey` and `checkoutintents.baseUrl` system properties
// Or configures using the `CHECKOUT_INTENTS_API_KEY` and `CHECKOUT_INTENTS_BASE_URL` environment variables
CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.fromEnv();
```

Or manually:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    // Configures using the `checkoutintents.apiKey` and `checkoutintents.baseUrl` system properties
    // Or configures using the `CHECKOUT_INTENTS_API_KEY` and `CHECKOUT_INTENTS_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter    | System property           | Environment variable        | Required | Default value                    |
| --------- | ------------------------- | --------------------------- | -------- | -------------------------------- |
| `apiKey`  | `checkoutintents.apiKey`  | `CHECKOUT_INTENTS_API_KEY`  | true     | -                                |
| `baseUrl` | `checkoutintents.baseUrl` | `CHECKOUT_INTENTS_BASE_URL` | true     | `"https://staging.api.rye.com/"` |

System properties take precedence over environment variables.

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import com.rye.client.CheckoutIntentsClient;

CheckoutIntentsClient clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Checkout Intents API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.checkoutIntents().purchase(...)` should be called with an instance of `CheckoutIntentPurchaseParams`, and it will return an instance of `CheckoutIntent`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;
import com.rye.models.checkoutintents.Buyer;
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams;
import com.rye.models.checkoutintents.PaymentMethod;
import java.util.concurrent.CompletableFuture;

// Configures using the `checkoutintents.apiKey` and `checkoutintents.baseUrl` system properties
// Or configures using the `CHECKOUT_INTENTS_API_KEY` and `CHECKOUT_INTENTS_BASE_URL` environment variables
CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.fromEnv();

CheckoutIntentPurchaseParams params = CheckoutIntentPurchaseParams.builder()
    .buyer(Buyer.builder()
        .address1("123 Main St")
        .city("New York")
        .country("US")
        .email("john.doe@example.com")
        .firstName("John")
        .lastName("Doe")
        .phone("1234567890")
        .postalCode("10001")
        .province("NY")
        .build())
    .paymentMethod(PaymentMethod.StripeTokenPaymentMethod.builder()
        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
        .build())
    .productUrl("https://rye-protocol.myshopify.com/products/rye-sticker")
    .quantity(1)
    .build();
CompletableFuture<CheckoutIntent> checkoutIntent = client.async().checkoutIntents().purchase(params);
```

Or create an asynchronous client from the beginning:

```java
import com.rye.client.CheckoutIntentsClientAsync;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync;
import com.rye.models.checkoutintents.Buyer;
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams;
import com.rye.models.checkoutintents.PaymentMethod;
import java.util.concurrent.CompletableFuture;

// Configures using the `checkoutintents.apiKey` and `checkoutintents.baseUrl` system properties
// Or configures using the `CHECKOUT_INTENTS_API_KEY` and `CHECKOUT_INTENTS_BASE_URL` environment variables
CheckoutIntentsClientAsync client = CheckoutIntentsOkHttpClientAsync.fromEnv();

CheckoutIntentPurchaseParams params = CheckoutIntentPurchaseParams.builder()
    .buyer(Buyer.builder()
        .address1("123 Main St")
        .city("New York")
        .country("US")
        .email("john.doe@example.com")
        .firstName("John")
        .lastName("Doe")
        .phone("1234567890")
        .postalCode("10001")
        .province("NY")
        .build())
    .paymentMethod(PaymentMethod.StripeTokenPaymentMethod.builder()
        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
        .build())
    .productUrl("https://rye-protocol.myshopify.com/products/rye-sticker")
    .quantity(1)
    .build();
CompletableFuture<CheckoutIntent> checkoutIntent = client.checkoutIntents().purchase(params);
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Polling helpers

This SDK includes helper methods for the asynchronous checkout flow. The recommended pattern follows Rye's two-phase checkout:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;
import com.rye.models.checkoutintents.Buyer;
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentCreateParams;
import com.rye.models.checkoutintents.CheckoutIntentConfirmParams;
import com.rye.models.checkoutintents.PaymentMethod;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.fromEnv();

// Phase 1: Create and wait for offer
CheckoutIntentCreateParams createParams = CheckoutIntentCreateParams.builder()
    .buyer(Buyer.builder()
        .address1("123 Main St")
        .city("New York")
        .country("US")
        .email("john.doe@example.com")
        .firstName("John")
        .lastName("Doe")
        .phone("1234567890")
        .postalCode("10001")
        .province("NY")
        .build())
    .productUrl("https://example.com/product")
    .quantity(1)
    .build();

CheckoutIntent intent = client.checkoutIntents().createAndPoll(createParams);

// Handle result
if (intent.isFailed()) {
    System.out.println("Failed: " + intent.asFailed().failureReason());
} else if (intent.isAwaitingConfirmation()) {
    // Review pricing with user
    System.out.println("Total: " + intent.asAwaitingConfirmation().offer().total());

    // Phase 2: Confirm and wait for completion
    CheckoutIntentConfirmParams confirmParams = CheckoutIntentConfirmParams.builder()
        .paymentMethod(PaymentMethod.StripeTokenPaymentMethod.builder()
            .stripeToken("tok_visa")
            .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
            .build())
        .build();

    CheckoutIntent completed = client.checkoutIntents()
        .confirmAndPoll(intent.asAwaitingConfirmation().id(), confirmParams);

    if (completed.isCompleted()) {
        System.out.println("Order completed!");
    } else if (completed.isFailed()) {
        System.out.println("Order failed: " + completed.asFailed().failureReason());
    } else {
        throw new IllegalStateException("Unexpected state: " + completed);
    }
} else {
    throw new IllegalStateException("Unexpected state: " + intent);
}
```

Available polling methods:

- `createAndPoll()` - Create and poll until offer is ready (`awaiting_confirmation` or `failed`)
- `confirmAndPoll()` - Confirm and poll until completion (`completed` or `failed`)
- `pollUntilCompleted()` - Poll until `completed` or `failed`
- `pollUntilAwaitingConfirmation()` - Poll until offer is ready or `failed`

All polling methods support customizable timeouts via `PollOptions`:

```java
import com.rye.models.checkoutintents.PollOptions;
import java.time.Duration;

// Configure polling behavior
PollOptions options = PollOptions.builder()
    .pollInterval(Duration.ofSeconds(5))  // Poll every 5 seconds (default)
    .maxAttempts(120)                      // Try up to 120 times, ~10 minutes (default)
    .build();

CheckoutIntent intent = client.checkoutIntents().pollUntilCompleted(intentId, options);
```

### Handling polling timeouts

When polling operations exceed `maxAttempts`, a `PollTimeoutException` is thrown with helpful context:

```java
import com.rye.errors.PollTimeoutException;
import com.rye.models.checkoutintents.PollOptions;

PollOptions options = PollOptions.builder()
    .pollInterval(Duration.ofSeconds(5))
    .maxAttempts(60)
    .build();

try {
    CheckoutIntent intent = client.checkoutIntents().pollUntilCompleted(intentId, options);
} catch (PollTimeoutException e) {
    System.out.println("Polling timed out for intent: " + e.getIntentId());
    System.out.println("Attempted " + e.getAttempts() + " times over " +
        (e.getAttempts() * e.getPollIntervalMs() / 1000) + "s");

    // You can retrieve the current state manually
    CheckoutIntent currentIntent = client.checkoutIntents().retrieve(e.getIntentId());
    System.out.println("Current state: " + currentIntent);
}
```

### Async polling

The asynchronous client also supports polling methods that return `CompletableFuture`:

```java
import com.rye.client.CheckoutIntentsClientAsync;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClientAsync;
import java.util.concurrent.CompletableFuture;

CheckoutIntentsClientAsync client = CheckoutIntentsOkHttpClientAsync.fromEnv();

CompletableFuture<CheckoutIntent> intentFuture = client.checkoutIntents()
    .createAndPoll(createParams);

intentFuture.thenAccept(intent -> {
    if (intent.isAwaitingConfirmation()) {
        System.out.println("Offer ready: " + intent.asAwaitingConfirmation().offer().total());
    }
});
```

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.rye.core.http.Headers;
import com.rye.core.http.HttpResponseFor;
import com.rye.models.checkoutintents.Buyer;
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentCreateParams;

CheckoutIntentCreateParams params = CheckoutIntentCreateParams.builder()
    .buyer(Buyer.builder()
        .address1("123 Main St")
        .city("New York")
        .country("US")
        .email("john.doe@example.com")
        .firstName("John")
        .lastName("Doe")
        .phone("1234567890")
        .postalCode("10001")
        .province("NY")
        .build())
    .productUrl("https://rye-protocol.myshopify.com/products/rye-sticker")
    .quantity(1)
    .build();
HttpResponseFor<CheckoutIntent> checkoutIntent = client.checkoutIntents().withRawResponse().create(params);

int statusCode = checkoutIntent.statusCode();
Headers headers = checkoutIntent.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.rye.models.checkoutintents.CheckoutIntent;

CheckoutIntent parsedCheckoutIntent = checkoutIntent.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`CheckoutIntentsServiceException`](checkout-intents-core/src/main/kotlin/com/rye/errors/CheckoutIntentsServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                |
  | ------ | ------------------------------------------------------------------------------------------------------------------------ |
  | 400    | [`BadRequestException`](checkout-intents-core/src/main/kotlin/com/rye/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](checkout-intents-core/src/main/kotlin/com/rye/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](checkout-intents-core/src/main/kotlin/com/rye/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](checkout-intents-core/src/main/kotlin/com/rye/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](checkout-intents-core/src/main/kotlin/com/rye/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](checkout-intents-core/src/main/kotlin/com/rye/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](checkout-intents-core/src/main/kotlin/com/rye/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](checkout-intents-core/src/main/kotlin/com/rye/errors/UnexpectedStatusCodeException.kt) |

- [`CheckoutIntentsIoException`](checkout-intents-core/src/main/kotlin/com/rye/errors/CheckoutIntentsIoException.kt): I/O networking errors.

- [`CheckoutIntentsRetryableException`](checkout-intents-core/src/main/kotlin/com/rye/errors/CheckoutIntentsRetryableException.kt): Generic error indicating a failure that could be retried by the client.

- [`CheckoutIntentsInvalidDataException`](checkout-intents-core/src/main/kotlin/com/rye/errors/CheckoutIntentsInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`PollTimeoutException`](checkout-intents-core/src/main/kotlin/com/rye/errors/PollTimeoutException.kt): Thrown when polling operations exceed the configured `maxAttempts`. Contains `intentId`, `attempts`, `maxAttempts`, and `pollIntervalMs` for debugging.

- [`CheckoutIntentsException`](checkout-intents-core/src/main/kotlin/com/rye/errors/CheckoutIntentsException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Pagination

The SDK defines methods that return a paginated lists of results. It provides convenient ways to access the results either one page at a time or item-by-item across all pages.

### Auto-pagination

To iterate through all results across all pages, use the `autoPager()` method, which automatically fetches more pages as needed.

When using the synchronous client, the method returns an [`Iterable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)

```java
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentListPage;

CheckoutIntentListPage page = client.checkoutIntents().list();

// Process as an Iterable
for (CheckoutIntent checkoutIntent : page.autoPager()) {
    System.out.println(checkoutIntent);
}

// Process as a Stream
page.autoPager()
    .stream()
    .limit(50)
    .forEach(checkoutIntent -> System.out.println(checkoutIntent));
```

When using the asynchronous client, the method returns an [`AsyncStreamResponse`](checkout-intents-core/src/main/kotlin/com/rye/core/http/AsyncStreamResponse.kt):

```java
import com.rye.core.http.AsyncStreamResponse;
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentListPageAsync;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

CompletableFuture<CheckoutIntentListPageAsync> pageFuture = client.async().checkoutIntents().list();

pageFuture.thenRun(page -> page.autoPager().subscribe(checkoutIntent -> {
    System.out.println(checkoutIntent);
}));

// If you need to handle errors or completion of the stream
pageFuture.thenRun(page -> page.autoPager().subscribe(new AsyncStreamResponse.Handler<>() {
    @Override
    public void onNext(CheckoutIntent checkoutIntent) {
        System.out.println(checkoutIntent);
    }

    @Override
    public void onComplete(Optional<Throwable> error) {
        if (error.isPresent()) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error.get());
        } else {
            System.out.println("No more!");
        }
    }
}));

// Or use futures
pageFuture.thenRun(page -> page.autoPager()
    .subscribe(checkoutIntent -> {
        System.out.println(checkoutIntent);
    })
    .onCompleteFuture()
    .whenComplete((unused, error) -> {
        if (error != null) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error);
        } else {
            System.out.println("No more!");
        }
    }));
```

### Manual pagination

To access individual page items and manually request the next page, use the `items()`,
`hasNextPage()`, and `nextPage()` methods:

```java
import com.rye.models.checkoutintents.CheckoutIntent;
import com.rye.models.checkoutintents.CheckoutIntentListPage;

CheckoutIntentListPage page = client.checkoutIntents().list();
while (true) {
    for (CheckoutIntent checkoutIntent : page.items()) {
        System.out.println(checkoutIntent);
    }

    if (!page.hasNextPage()) {
        break;
    }

    page = page.nextPage();
}
```

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `CHECKOUT_INTENTS_LOG` environment variable to `info`:

```sh
export CHECKOUT_INTENTS_LOG=info
```

Or to `debug` for more verbose logging:

```sh
export CHECKOUT_INTENTS_LOG=debug
```

## ProGuard and R8

Although the SDK uses reflection, it is still usable with [ProGuard](https://github.com/Guardsquare/proguard) and [R8](https://developer.android.com/topic/performance/app-optimization/enable-app-optimization) because `checkout-intents-core` is published with a [configuration file](checkout-intents-core/src/main/resources/META-INF/proguard/checkout-intents-core.pro) containing [keep rules](https://www.guardsquare.com/manual/configuration/usage).

ProGuard and R8 should automatically detect and use the published rules, but you can also manually copy the keep rules if necessary.

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`CheckoutIntentsOkHttpClient`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClient.kt) or [`CheckoutIntentsOkHttpClientAsync`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

Also note that there are bugs in older Jackson versions that can affect the SDK. We don't work around all Jackson bugs ([example](https://github.com/FasterXML/jackson-databind/issues/3240)) and expect users to upgrade Jackson for those instead.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff between requests.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a request.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.rye.models.checkoutintents.CheckoutIntent;

CheckoutIntent checkoutIntent = client.checkoutIntents().create(
  params, RequestOptions.builder().timeout(Duration.ofSeconds(30)).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;
import java.time.Duration;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Environments

The SDK sends requests to the staging by default. To send requests to a different environment, configure the client like so:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    .fromEnv()
    .production()
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `checkout-intents-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`CheckoutIntentsClient`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClient.kt), [`CheckoutIntentsClientAsync`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientAsync.kt), [`CheckoutIntentsClientImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientImpl.kt), and [`CheckoutIntentsClientAsyncImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientAsyncImpl.kt), all of which can work with any HTTP client
- `checkout-intents-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`CheckoutIntentsOkHttpClient`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClient.kt) and [`CheckoutIntentsOkHttpClientAsync`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClientAsync.kt), which provide a way to construct [`CheckoutIntentsClientImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientImpl.kt) and [`CheckoutIntentsClientAsyncImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientAsyncImpl.kt), respectively, using OkHttp
- `checkout-intents`
  - Depends on and exposes the APIs of both `checkout-intents-core` and `checkout-intents-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`checkout-intents` dependency](#installation) with `checkout-intents-core`
2. Copy `checkout-intents-client-okhttp`'s [`OkHttpClient`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`CheckoutIntentsClientImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientImpl.kt) or [`CheckoutIntentsClientAsyncImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientAsyncImpl.kt), similarly to [`CheckoutIntentsOkHttpClient`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClient.kt) or [`CheckoutIntentsOkHttpClientAsync`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`checkout-intents` dependency](#installation) with `checkout-intents-core`
2. Write a class that implements the [`HttpClient`](checkout-intents-core/src/main/kotlin/com/rye/core/http/HttpClient.kt) interface
3. Construct [`CheckoutIntentsClientImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientImpl.kt) or [`CheckoutIntentsClientAsyncImpl`](checkout-intents-core/src/main/kotlin/com/rye/client/CheckoutIntentsClientAsyncImpl.kt), similarly to [`CheckoutIntentsOkHttpClient`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClient.kt) or [`CheckoutIntentsOkHttpClientAsync`](checkout-intents-client-okhttp/src/main/kotlin/com/rye/client/okhttp/CheckoutIntentsOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.rye.core.JsonValue;
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams;

CheckoutIntentPurchaseParams params = CheckoutIntentPurchaseParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set undocumented parameters on _nested_ headers, query params, or body classes, call the `putAdditionalProperty` method on the nested class:

```java
import com.rye.core.JsonValue;
import com.rye.models.checkoutintents.Buyer;
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams;

CheckoutIntentPurchaseParams params = CheckoutIntentPurchaseParams.builder()
    .buyer(Buyer.builder()
        .putAdditionalProperty("secretProperty", JsonValue.from("42"))
        .build())
    .build();
```

These properties can be accessed on the nested built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](checkout-intents-core/src/main/kotlin/com/rye/core/Values.kt) object to its setter:

```java
import com.rye.core.JsonValue;
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams;
import com.rye.models.checkoutintents.PaymentMethod;

CheckoutIntentPurchaseParams params = CheckoutIntentPurchaseParams.builder()
    .buyer(JsonValue.from(42))
    .paymentMethod(PaymentMethod.StripeTokenPaymentMethod.builder()
        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
        .build())
    .productUrl("https://rye-protocol.myshopify.com/products/rye-sticker")
    .quantity(1)
    .build();
```

The most straightforward way to create a [`JsonValue`](checkout-intents-core/src/main/kotlin/com/rye/core/Values.kt) is using its `from(...)` method:

```java
import com.rye.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](checkout-intents-core/src/main/kotlin/com/rye/core/Values.kt):

```java
import com.rye.core.JsonMissing;
import com.rye.models.checkoutintents.CheckoutIntentPurchaseParams;
import com.rye.models.checkoutintents.PaymentMethod;

CheckoutIntentPurchaseParams params = CheckoutIntentPurchaseParams.builder()
    .paymentMethod(PaymentMethod.StripeTokenPaymentMethod.builder()
        .stripeToken("tok_1RkrWWHGDlstla3f1Fc7ZrhH")
        .type(PaymentMethod.StripeTokenPaymentMethod.Type.STRIPE_TOKEN)
        .build())
    .productUrl("productUrl")
    .quantity(1)
    .buyer(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.rye.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.betas().checkoutSessions().create(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.rye.core.JsonField;
import java.util.Optional;

JsonField<String> productUrl = client.betas().checkoutSessions().create(params)._productUrl();

if (productUrl.isMissing()) {
  // The property is absent from the JSON response
} else if (productUrl.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = productUrl.asString();

  // Try to deserialize into a custom type
  MyClass myObject = productUrl.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`CheckoutIntentsInvalidDataException`](checkout-intents-core/src/main/kotlin/com/rye/errors/CheckoutIntentsInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.rye.models.betas.CheckoutSession;

CheckoutSession checkoutSession = client.betas().checkoutSessions().create(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.rye.models.checkoutintents.CheckoutIntent;

CheckoutIntent checkoutIntent = client.checkoutIntents().purchase(
  params, RequestOptions.builder().responseValidation(true).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.rye.client.CheckoutIntentsClient;
import com.rye.client.okhttp.CheckoutIntentsOkHttpClient;

CheckoutIntentsClient client = CheckoutIntentsOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/rye-com/checkout-intents-java/issues) with questions, bugs, or suggestions.
