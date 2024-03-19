package io.github.alaksion.unsplashwrapper.api.repositories

import io.github.alaksion.unsplashwrapper.api.datasources.UserRemoteDataSource

interface UnsplashUserRepository {
    suspend fun getUserProfile()

}

internal class UnsplashUserRepositoryImpl(
    private val dataSource: UserRemoteDataSource
) : UnsplashUserRepository {
    override suspend fun getUserProfile() {
        TODO("Not yet implemented")
    }
}