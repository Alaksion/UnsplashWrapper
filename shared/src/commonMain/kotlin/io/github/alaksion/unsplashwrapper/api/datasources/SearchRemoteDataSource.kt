package io.github.alaksion.unsplashwrapper.api.datasources

import io.github.alaksion.unsplashwrapper.api.models.photo.data.search.SearchPhotosResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.search.SearchPhotosParameters
import io.github.alaksion.unsplashwrapper.platform.httpclient.UnsplashHttpClient
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal interface SearchRemoteDataSource {
    suspend fun searchPhotos(
        parametersRequest: SearchPhotosParameters
    ): SearchPhotosResponse
}

internal class SearchRemoteDataSourceImpl private constructor(
    private val dispatcher: CoroutineDispatcher,
    private val httpClient: UnsplashHttpClient,
) : SearchRemoteDataSource {

    override suspend fun searchPhotos(parametersRequest: SearchPhotosParameters): SearchPhotosResponse =
        withContext(dispatcher) {
            httpClient.client
                .get(
                    urlString = UnsplashSdkConfig.buildUrl("photos")
                ) {
                    parameter("query", parametersRequest.query)
                    parameter("page", parametersRequest.page)
                    parameter("per_page", parametersRequest.perPage)
                    parameter("order_by", parametersRequest.orderBy.primitiveValue)
                    parameter("content filter", parametersRequest.contentFilter.primitiveValue)
                    parametersRequest.color?.let { safeColor ->
                        parameter("color", safeColor.primitiveValue)
                    }
                    parametersRequest.orientation?.let { safeOrientation ->
                        parameter("orientation", safeOrientation.primitiveValue)
                    }
                }.body()
        }

    companion object {
        val INSTANCE: SearchRemoteDataSource = SearchRemoteDataSourceImpl(
            httpClient = UnsplashHttpClient.Instance,
            dispatcher = Dispatchers.IO
        )
    }
}