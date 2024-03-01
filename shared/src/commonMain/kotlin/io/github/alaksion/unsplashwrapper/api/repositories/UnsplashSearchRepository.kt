package io.github.alaksion.unsplashwrapper.api.repositories

import io.github.alaksion.unsplashwrapper.api.datasources.SearchRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.datasources.SearchRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.models.photo.data.search.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.search.SearchPhotosParameters
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.search.SearchPhotos

public interface UnsplashSearchRepository {

    suspend fun searchPhotos(
        parameters: SearchPhotosParameters
    ): SearchPhotos

}

internal class UnsplashSearchRepositoryImpl private constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : UnsplashSearchRepository {

    override suspend fun searchPhotos(parameters: SearchPhotosParameters): SearchPhotos =
        searchRemoteDataSource.searchPhotos(parametersRequest = parameters).toDomain()

    companion object {
        val INSTANCE: UnsplashSearchRepository = UnsplashSearchRepositoryImpl(
            searchRemoteDataSource = SearchRemoteDataSourceImpl.INSTANCE
        )
    }
}