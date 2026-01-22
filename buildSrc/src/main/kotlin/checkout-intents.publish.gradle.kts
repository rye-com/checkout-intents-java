import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal")) {
          maven {
              name = "LocalFileSystem"
              url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("checkout-intent-api")
        description.set("HTTP REST API for checkout intents")
        url.set("https://docs.rye.com")

        licenses {
            license {
                name.set("MIT")
            }
        }

        developers {
            developer {
                name.set("Checkout Intents")
                email.set("dev@rye.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/stainless-sdks/checkout-intents-java.git")
            developerConnection.set("scm:git:git://github.com/stainless-sdks/checkout-intents-java.git")
            url.set("https://github.com/stainless-sdks/checkout-intents-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
