plugins {
    id("checkout-intents.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":checkout-intents-java-core"))
    implementation(project(":checkout-intents-java-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :checkout-intents-java-example:run` to run `Main`
    // Use `./gradlew :checkout-intents-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.checkout_intents.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
