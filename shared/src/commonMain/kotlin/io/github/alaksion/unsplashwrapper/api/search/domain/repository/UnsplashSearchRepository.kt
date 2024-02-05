package io.github.alaksion.unsplashwrapper.api.search.domain.repository

import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchPhotosParameters
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotos

public interface UnsplashSearchRepository {

    suspend fun searchPhotos(
        parameters: SearchPhotosParameters
    ): SearchedPhotos

}