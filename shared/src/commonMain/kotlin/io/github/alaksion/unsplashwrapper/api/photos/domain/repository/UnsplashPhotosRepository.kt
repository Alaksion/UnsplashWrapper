package io.github.alaksion.unsplashwrapper.api.photos.domain.repository

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.ListPhotoOrderBy
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhoto
import kotlinx.collections.immutable.ImmutableList

interface UnsplashPhotosRepository {

    suspend fun getPhotos(
        page: Int = 1,
        resultsPerPage: Int = 10,
        orderBy: ListPhotoOrderBy = ListPhotoOrderBy.Latest
    ): ImmutableList<ListPhoto>

}
