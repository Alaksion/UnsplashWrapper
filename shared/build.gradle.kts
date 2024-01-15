plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.detekt)
    id("maven-publish")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.negotiation)
            implementation(libs.ktx.serialization)
            implementation(libs.ktx.datetime)
            implementation(libs.kotlinx.coroutines.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.androidx.startup)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }

    androidTarget {
        publishLibraryVariants = listOf("debug", "release")
    }
}

android {
    namespace = "io.github.alaksion.unsplashwrapper"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}

detekt {

    source.setFrom(
        "src/commonMain/kotlin",
        "src/androidMain/kotlin",
        "src/iosMain/kotlin"
    )

    config.setFrom(files("$rootDir/configuration/detekt/config.yml"))
}

publishing {
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
}