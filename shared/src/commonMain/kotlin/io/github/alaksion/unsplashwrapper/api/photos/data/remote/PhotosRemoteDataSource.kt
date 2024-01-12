package io.github.alaksion.unsplashwrapper.api.photos.data.remote

import io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos.ListPhotosResponse
import io.github.alaksion.unsplashwrapper.platform.httpclient.UnsplashHttpClient
import kotlinx.coroutines.CoroutineDispatcher

internal interface PhotosRemoteDataSource {
    suspend fun listPhotos(): ListPhotosResponse
}

internal class PhotosRemoteDataSourceImpl private constructor(
    private val httpClient: UnsplashHttpClient,
    private val dispatcher: CoroutineDispatcher
) : PhotosRemoteDataSource {

    override suspend fun listPhotos(): ListPhotosResponse {
        TODO()
    }

}