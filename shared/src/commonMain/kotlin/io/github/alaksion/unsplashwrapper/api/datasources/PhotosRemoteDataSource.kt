package io.github.alaksion.unsplashwrapper.api.datasources

import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoDownloadTrackResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.details.PhotoDetailsResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.list.ListPhotosOrderByRequest
import io.github.alaksion.unsplashwrapper.api.models.photo.data.list.ListPhotosResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.ratephoto.RatePhotoResponse
import io.github.alaksion.unsplashwrapper.platform.httpclient.UnsplashHttpClient
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
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

    suspend fun photoDetails(
        photoId: String
    ): PhotoDetailsResponse

    suspend fun likePhoto(
        photoId: String
    ): RatePhotoResponse

    suspend fun unlikePhoto(
        photoId: String
    ): RatePhotoResponse

    suspend fun trackPhotoDownload(
        photoId: String
    ): PhotoDownloadTrackResponse
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
                }.body()
        }
    }

    override suspend fun photoDetails(photoId: String): PhotoDetailsResponse {
        return withContext(dispatcher) {
            httpClient.client
                .get(
                    urlString = UnsplashSdkConfig.buildUrl("photos/$photoId")
                ).body()
        }
    }

    override suspend fun likePhoto(photoId: String): RatePhotoResponse = withContext(dispatcher) {
        httpClient.client
            .post(
                urlString = UnsplashSdkConfig.buildUrl("photos/$photoId/like")
            ).body()
    }

    override suspend fun unlikePhoto(photoId: String): RatePhotoResponse = withContext(dispatcher) {
        httpClient.client
            .delete(
                urlString = UnsplashSdkConfig.buildUrl("photos/$photoId/like")
            ).body()
    }

    override suspend fun trackPhotoDownload(photoId: String): PhotoDownloadTrackResponse =
        withContext(dispatcher) {
            httpClient.client
                .get(
                    urlString = UnsplashSdkConfig.buildUrl("photos/$photoId/download")
                ).body()
        }

    companion object {
        val Instance: PhotosRemoteDataSource = PhotosRemoteDataSourceImpl(
            httpClient = UnsplashHttpClient.Instance,
            dispatcher = Dispatchers.IO
        )
    }

}
