package io.github.alaksion.unsplashwrapper.api.photos.domain.repository

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.RatePhoto
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhoto
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoOrderBy
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoDetails
import kotlinx.collections.immutable.ImmutableList

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
}
