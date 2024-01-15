package io.github.alaksion.unsplashwrapper.api.photos.domain.repository

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoOrderBy
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotos

interface UnsplashPhotosRepository {

    suspend fun getPhotos(
        page: Int = 1,
        resultsPerPage: Int = 10,
        orderBy: PhotoOrderBy = PhotoOrderBy.Latest
    ): List<ListPhotos>

}