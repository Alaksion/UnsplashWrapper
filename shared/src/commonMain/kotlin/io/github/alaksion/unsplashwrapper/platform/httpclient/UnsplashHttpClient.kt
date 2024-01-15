package io.github.alaksion.unsplashwrapper.platform.httpclient

import io.github.alaksion.unsplashwrapper.platform.AuthManager
import io.github.alaksion.unsplashwrapper.platform.AuthenticationManager
import io.github.alaksion.unsplashwrapper.platform.error.HttpError
import io.github.alaksion.unsplashwrapper.platform.error.SerializationError
import io.github.alaksion.unsplashwrapper.platform.error.Unknown
import io.github.alaksion.unsplashwrapper.platform.error.UnsplashRemoteError
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

internal class UnsplashHttpClient private constructor(
    private val authManager: AuthManager
) {
    val client = HttpClient() {
        install(DefaultRequest) {
            authManager.getUserToken()?.let { userToken ->
                bearerAuth(userToken)

            } ?: header("Authorization", "Client-id ${authManager.getPublicKey()}")

            header("Version", UnsplashSdkConfig.version)
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
        HttpResponseValidator {
            handleResponseExceptionWithRequest { cause, _ ->
                when (cause) {
                    is ClientRequestException -> {
                        val exceptionResponse = cause.response
                        val parseBody = runCatching {
                            Json.decodeFromString<UnsplashRemoteError>(
                                exceptionResponse.call.response.bodyAsText()
                            )
                        }.fold(
                            onSuccess = { it.errors },
                            onFailure = { listOf("Unknown Error") }
                        )

                        throw HttpError(
                            statusCode = exceptionResponse.status.value,
                            errors = parseBody
                        )
                    }

                    is SerializationException -> throw SerializationError(
                        errors = listOf(cause.message.orEmpty())
                    )

                    else -> throw Unknown(
                        cause = cause,
                        errors = listOf(cause.message.orEmpty())
                    )
                }
            }
        }
    }

    companion object {
        val Instance = UnsplashHttpClient(
            authManager = AuthenticationManager.Instance
        )
    }
}
