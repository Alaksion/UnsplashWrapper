package io.github.alaksion.unsplashwrapper.api.photos.data.remote

import io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos.ListPhotosOrderByRequest
import io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos.ListPhotosResponse
import io.github.alaksion.unsplashwrapper.platform.httpclient.UnsplashHttpClient
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal interface PhotosRemoteDataSource {
    suspend fun listPhotos(
        page: Int = 1,
        resultsPerPage: Int = 10,
        orderBy: ListPhotosOrderByRequest,
    ): List<ListPhotosResponse>
}

internal class PhotosRemoteDataSourceImpl private constructor(
    private val httpClient: UnsplashHttpClient,
    private val dispatcher: CoroutineDispatcher
) : PhotosRemoteDataSource {

    override suspend fun listPhotos(
        page: Int,
        resultsPerPage: Int,
        orderBy: ListPhotosOrderByRequest,
    ): List<ListPhotosResponse> {
        return withContext(dispatcher) {
            httpClient.client
                .get(
                    urlString = UnsplashSdkConfig.buildUrl("photos")
                ) {
                    parameter("page", page)
                    parameter("per_page", resultsPerPage)
                    parameter("order_by", orderBy.value)
                }
                .body<List<ListPhotosResponse>>()
        }
    }

    companion object {
        val Instance: PhotosRemoteDataSource = PhotosRemoteDataSourceImpl(
            httpClient = UnsplashHttpClient.Instance,
            dispatcher = Dispatchers.IO
        )
    }

}
