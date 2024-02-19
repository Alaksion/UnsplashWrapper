package io.github.alaksion.unsplashwrapper.api.search.data.repository

import io.github.alaksion.unsplashwrapper.api.search.data.models.photos.toDomain
import io.github.alaksion.unsplashwrapper.api.search.data.remote.SearchRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.search.data.remote.SearchRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchPhotosParameters
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotos
import io.github.alaksion.unsplashwrapper.api.search.domain.repository.UnsplashSearchRepository

internal class UnsplashSearchRepositoryImpl private constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : UnsplashSearchRepository {

    override suspend fun searchPhotos(parameters: SearchPhotosParameters): SearchedPhotos =
        searchRemoteDataSource.searchPhotos(parametersRequest = parameters).toDomain()

    companion object {
        val INSTANCE: UnsplashSearchRepository = UnsplashSearchRepositoryImpl(
            searchRemoteDataSource = SearchRemoteDataSourceImpl.INSTANCE
        )
    }
}