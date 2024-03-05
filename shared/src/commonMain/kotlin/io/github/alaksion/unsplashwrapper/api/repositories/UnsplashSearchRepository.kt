package io.github.alaksion.unsplashwrapper.api.repositories

import io.github.alaksion.unsplashwrapper.api.datasources.SearchRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.datasources.SearchRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.models.collections.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.collections.domain.SearchCollections
import io.github.alaksion.unsplashwrapper.api.models.photo.data.search.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.search.SearchPhotos
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.search.SearchPhotosParameters
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.user.domain.SearchUser

public interface UnsplashSearchRepository {

    suspend fun searchPhotos(
        parameters: SearchPhotosParameters
    ): SearchPhotos

    suspend fun searchCollections(
        page: Int,
        perPage: Int,
        query: String
    ): SearchCollections

    suspend fun searchUsers(
        page: Int,
        perPage: Int,
        query: String
    ): SearchUser

}

internal class UnsplashSearchRepositoryImpl private constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : UnsplashSearchRepository {

    override suspend fun searchPhotos(parameters: SearchPhotosParameters): SearchPhotos =
        searchRemoteDataSource.searchPhotos(parametersRequest = parameters).toDomain()

    override suspend fun searchCollections(
        page: Int,
        perPage: Int,
        query: String
    ): SearchCollections = searchRemoteDataSource.searchCollections(
        query = query,
        page = page,
        perPage = perPage
    ).toDomain()

    override suspend fun searchUsers(page: Int, perPage: Int, query: String): SearchUser =
        searchRemoteDataSource.searchUsers(
            query = query,
            page = page,
            perPage = perPage
        ).toDomain()

    companion object {
        val INSTANCE: UnsplashSearchRepository = UnsplashSearchRepositoryImpl(
            searchRemoteDataSource = SearchRemoteDataSourceImpl.INSTANCE
        )
    }
}