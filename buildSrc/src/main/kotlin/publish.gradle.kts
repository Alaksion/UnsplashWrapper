import buildlogic.BuildSettings

plugins {
    `maven-publish`
    signing
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

configure<PublishingExtension> {

    repositories {
        mavenCentral()
    }

    publications {
        create<MavenPublication>("mavenPub") {
            artifact(javadocJar.get())
            pom {
                name = "unsplash-wrapper"
                description =
                    "Wrapper SDK of the Unsplash public API. https://unsplash.com/documentation#creating-a-developer-account"
                version = BuildSettings.VERSION
                group = BuildSettings.GROUP
                artifactId = "unsplash-wrapper"
                licenses {
                    licenses {
                        name = "MIT License"
                        url = "https://opensource.org/license/mit/"
                    }
                }
                developers {
                    developer {
                        id = "Alaksion"
                        name = "Lucca Beurmann"
                        email = "lbeurmann.dev@gmail.com"
                    }
                }
            }
        }
    }

    repositories {
        mavenCentral()
    }
}