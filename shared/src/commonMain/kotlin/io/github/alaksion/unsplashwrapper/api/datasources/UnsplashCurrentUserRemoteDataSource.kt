package io.github.alaksion.unsplashwrapper.api.datasources

import io.github.alaksion.unsplashwrapper.api.models.currentuser.data.CurrentUserResponse
import io.github.alaksion.unsplashwrapper.platform.httpclient.UnsplashHttpClient
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal interface UnsplashCurrentUserRemoteDataSource {

    suspend fun getCurrentUser(): CurrentUserResponse

}

internal class UnsplashCurrentUserRemoteDataSourceImpl private constructor(
    private val client: UnsplashHttpClient,
    private val dispatcher: CoroutineDispatcher
) : UnsplashCurrentUserRemoteDataSource {

    override suspend fun getCurrentUser(): CurrentUserResponse = withContext(dispatcher) {
        client.client.get(
            urlString = UnsplashSdkConfig.buildUrl("/me")
        ).body()
    }

    companion object {
        val INSTANCE: UnsplashCurrentUserRemoteDataSource = UnsplashCurrentUserRemoteDataSourceImpl(
            dispatcher = Dispatchers.IO,
            client = UnsplashHttpClient.Instance
        )
    }

}