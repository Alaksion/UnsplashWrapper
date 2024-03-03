package io.github.alaksion.unsplashwrapper.api.repositories

import io.github.alaksion.unsplashwrapper.api.datasources.PhotosRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.datasources.PhotosRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.models.photo.data.details.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.data.list.toData
import io.github.alaksion.unsplashwrapper.api.models.photo.data.list.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.data.ratephoto.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.data.statistics.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.details.PhotoDetails
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.list.ListPhoto
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.list.ListPhotoOrderBy
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.rate.RatePhoto
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics.PhotoStatistics
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics.PhotoStatisticsResolution
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList

interface UnsplashPhotosRepository {

    suspend fun getPhotos(
        page: Int = 1,
        resultsPerPage: Int = 10,
        orderBy: ListPhotoOrderBy = ListPhotoOrderBy.Latest
    ): ImmutableList<ListPhoto>

    suspend fun getPhotoDetails(
        id: String
    ): PhotoDetails

    suspend fun likePhoto(
        photoId: String
    ): RatePhoto

    suspend fun unlikePhoto(
        photoId: String
    ): RatePhoto

    suspend fun trackPhotoDownload(
        photoId: String
    ): String

    suspend fun getPhotoStatistics(
        photoId: String,
        resolution: PhotoStatisticsResolution,
        quantity: Int
    ): PhotoStatistics
}

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

    override suspend fun likePhoto(photoId: String): RatePhoto =
        photosRemoteDataSource.likePhoto(photoId).toDomain()

    override suspend fun unlikePhoto(photoId: String): RatePhoto =
        photosRemoteDataSource.unlikePhoto(photoId).toDomain()

    override suspend fun trackPhotoDownload(photoId: String): String =
        photosRemoteDataSource.trackPhotoDownload(photoId).url

    override suspend fun getPhotoStatistics(
        photoId: String,
        resolution: PhotoStatisticsResolution,
        quantity: Int
    ): PhotoStatistics = photosRemoteDataSource.getPhotoStatistics(
        photoId = photoId,
        resolution = resolution.toData(),
        quantity = quantity
    ).toDomain()
    companion object {
        val INSTANCE = UnsplashPhotosRepositoryImpl(
            photosRemoteDataSource = PhotosRemoteDataSourceImpl.Instance
        )
    }
}
