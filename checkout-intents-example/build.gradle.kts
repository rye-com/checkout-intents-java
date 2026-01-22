plugins {
    id("checkout-intents.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":checkout-intents-core"))
    implementation(project(":checkout-intents-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :checkout-intents-example:run` to run `Main`
    // Use `./gradlew :checkout-intents-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.rye.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
