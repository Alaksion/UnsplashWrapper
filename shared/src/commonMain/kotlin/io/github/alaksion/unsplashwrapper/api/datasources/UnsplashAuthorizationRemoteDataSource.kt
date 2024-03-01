package io.github.alaksion.unsplashwrapper.api.datasources

import io.github.alaksion.unsplashwrapper.api.models.authorization.data.AuthorizationRequest
import io.github.alaksion.unsplashwrapper.api.models.authorization.data.AuthorizationResponse
import io.github.alaksion.unsplashwrapper.platform.httpclient.UnsplashHttpClient
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal interface UnsplashAuthorizationRemoteDataSource {
    suspend fun requestAuthorization(
        data: AuthorizationRequest
    ): AuthorizationResponse
}

internal class UnsplashAuthorizationRemoteDataSourceImpl private constructor(
    private val httpClient: UnsplashHttpClient,
    private val dispatcher: CoroutineDispatcher
) : UnsplashAuthorizationRemoteDataSource {

    override suspend fun requestAuthorization(data: AuthorizationRequest): AuthorizationResponse =
        withContext(dispatcher) {
            httpClient.client.get(
                urlString = UnsplashSdkConfig.OAUTH_URL
            ) {
                parameter("client_id", data.clientId)
                parameter("client_secret", data.secretKey)
                parameter("redirect_uri", data.redirectUri)
                parameter("code", data.code)
                parameter("grant_type", data.grantType)

            }.body()
        }

    companion object {
        val INSTANCE: UnsplashAuthorizationRemoteDataSource =
            UnsplashAuthorizationRemoteDataSourceImpl(
                dispatcher = Dispatchers.IO,
                httpClient = UnsplashHttpClient.Instance
            )
    }
}



