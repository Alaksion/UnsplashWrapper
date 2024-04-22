package io.github.alaksion.unsplashwrapper.platform.httpclient

import io.github.alaksion.unsplashwrapper.platform.error.HttpError
import io.github.alaksion.unsplashwrapper.platform.error.Unknown
import io.github.alaksion.unsplashwrapper.platform.error.UnsplashRemoteError
import io.github.alaksion.unsplashwrapper.platform.listeners.HttpHeader
import io.github.alaksion.unsplashwrapper.platform.listeners.HttpResponse
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType
import io.github.alaksion.unsplashwrapper.sdk.SdkListeners
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.toHttpDate
import io.ktor.serialization.kotlinx.json.json
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.serialization.json.Json

internal class UnsplashHttpClient private constructor(
    private val tokenManager: TokenManager
) {
    val client = HttpClient {
        install(DefaultRequest) {
            tokenManager.getToken(TokenType.UserToken)?.let { userToken ->
                bearerAuth(userToken)

            } ?: header(
                "Authorization",
                "Client-ID ${tokenManager.getToken(TokenType.PublicToken)}"
            )

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
            // Parse Errors
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
                            errors = parseBody.toPersistentList()
                        )
                    }

                    else -> throw Unknown(
                        cause = cause,
                        errors = persistentListOf(cause.message.orEmpty())
                    )
                }
            }
        }

        install(ResponseObserver) {
            onResponse { response ->
                SdkListeners.httpListener?.onReceive(
                    httpResponse = HttpResponse(
                        code = response.status.value,
                        timeStamp = response.requestTime.toHttpDate(),
                        headers = mutableListOf<HttpHeader>().apply {
                            response.headers.forEach { name, body ->
                                add(
                                    HttpHeader(
                                        name = name,
                                        value = body.joinToString { " " }
                                    )
                                )
                            }
                        },
                        body = "Not yet avaialble",
                        url = response.call.request.url.toString()
                    )
                )
            }
        }
    }

    companion object {
        val Instance = UnsplashHttpClient(
            tokenManager = TokenManagerImplementation.Instance
        )
    }
}
