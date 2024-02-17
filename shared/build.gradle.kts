import buildlogic.BuildSettings

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.detekt)
    alias(libs.plugins.vanniktech)
    alias(libs.plugins.compose)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishAllLibraryVariants()
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
            implementation(libs.ktx.immutablecollections)
            implementation(compose.runtime)
            implementation(compose.ui)
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
}

android {
    namespace = "io.github.alaksion.unsplashwrapper"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
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

mavenPublishing {
    coordinates(
        groupId = BuildSettings.GROUP,
        version = BuildSettings.VERSION,
        artifactId = BuildSettings.ARTIFACT
    )
    pom {
        name = "unsplash-wrapper"
        description =
            "Wrapper SDK of the Unsplash public API. https://unsplash.com/documentation#creating-a-developer-account"
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
        scm {
            url = "https://github.com/Alaksion/UnsplashWrapper"
        }
    }
}