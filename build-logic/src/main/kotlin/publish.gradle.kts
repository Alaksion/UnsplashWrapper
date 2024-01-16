plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("mavenPub") {
            pom {
                name = "unsplash-wrapper"
                description =
                    "Wrapper SDK of the Unsplash public API. https://unsplash.com/documentation#creating-a-developer-account"
                version = "0.0.1"
                group = "io.github.alaksion"
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