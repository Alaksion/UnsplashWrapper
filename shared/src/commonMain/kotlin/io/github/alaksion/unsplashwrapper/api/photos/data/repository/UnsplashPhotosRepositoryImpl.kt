package io.github.alaksion.unsplashwrapper.api.photos.data.repository

import io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos.toData
import io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos.toDomain
import io.github.alaksion.unsplashwrapper.api.photos.data.models.photodetails.toDomain
import io.github.alaksion.unsplashwrapper.api.photos.data.remote.PhotosRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.photos.data.remote.PhotosRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhoto
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoOrderBy
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoDetails
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.RatePhoto
import io.github.alaksion.unsplashwrapper.api.photos.domain.repository.UnsplashPhotosRepository
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

internal class UnsplashPhotosRepositoryImpl private constructor(
    private val photosRemoteDataSource: PhotosRemoteDataSource
) : UnsplashPhotosRepository {

    override suspend fun getPhotos(
        page: Int,
        resultsPerPage: Int,
        orderBy: ListPhotoOrderBy
    ): ImmutableList<ListPhoto> =
        photosRemoteDataSource.listPhotos(
            page = page,
            resultsPerPage = resultsPerPage,
            orderBy = orderBy.toData()
        ).map { it.toDomain() }.toPersistentList()

    override suspend fun getPhotoDetails(id: String): PhotoDetails =
        photosRemoteDataSource.photoDetails(id).toDomain()

    override suspend fun likePhoto(photoId: String): RatePhoto {
        TODO("Not yet implemented")
    }

    override suspend fun unlikePhoto(photoId: String): RatePhoto {
        TODO("Not yet implemented")
    }

    companion object {
        val INSTANCE = UnsplashPhotosRepositoryImpl(
            photosRemoteDataSource = PhotosRemoteDataSourceImpl.Instance
        )
    }
}
