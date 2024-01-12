package io.github.alaksion.unsplashwrapper.platform.httpclient

import io.github.alaksion.unsplashwrapper.platform.AuthManager
import io.github.alaksion.unsplashwrapper.platform.AuthenticationManager
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class UnsplashHttpClient private constructor(
    val authManager: AuthManager
) {
    val client = HttpClient() {
        install(DefaultRequest) {
            val key = authManager.getUserToken() ?: authManager.getPublicKey()
            header("Authorization", key)
        }
        install(Logging) {
            level = LogLevel.INFO
            sanitizeHeader { header -> header == "Authorization" }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
            )
        }
    }

    companion object {
        val Instance = UnsplashHttpClient(
            authManager = AuthenticationManager.Instance
        )
    }
}