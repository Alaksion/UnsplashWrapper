package io.github.alaksion.unsplashwrapper.api.photos.data.repository

import io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos.ListPhotosMapper
import io.github.alaksion.unsplashwrapper.api.photos.data.models.toData
import io.github.alaksion.unsplashwrapper.api.photos.data.remote.PhotosRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.photos.data.remote.PhotosRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoOrderBy
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotos
import io.github.alaksion.unsplashwrapper.api.photos.domain.repository.UnsplashPhotosRepository

internal class UnsplashPhotosRepositoryImpl private constructor(
    private val photosRemoteDataSource: PhotosRemoteDataSource
) : UnsplashPhotosRepository {

    override suspend fun getPhotos(
        page: Int,
        resultsPerPage: Int,
        orderBy: PhotoOrderBy
    ): ListPhotos = ListPhotosMapper.map(
        photosRemoteDataSource.listPhotos(
            page = page,
            resultsPerPage = resultsPerPage,
            orderBy = orderBy.toData()
        )
    )

    companion object {
        val Instace = UnsplashPhotosRepositoryImpl(
            photosRemoteDataSource = PhotosRemoteDataSourceImpl.Instance
        )
    }
}