package io.github.alaksion.unsplashwrapper.api.currentuser.data.repository

import io.github.alaksion.unsplashwrapper.api.currentuser.data.model.toDomain
import io.github.alaksion.unsplashwrapper.api.currentuser.data.remote.UnsplashCurrentUserRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.currentuser.data.remote.UnsplashCurrentUserRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.currentuser.domain.UnsplashCurrentUserRepository
import io.github.alaksion.unsplashwrapper.api.currentuser.domain.model.CurrentUser

internal class UnsplashCurrentUserRepositoryImpl private constructor(
    private val dataSource: UnsplashCurrentUserRemoteDataSource
) : UnsplashCurrentUserRepository {

    override suspend fun getCurrentUser(): CurrentUser = dataSource.getCurrentUser().toDomain()

    companion object {
        val INSTANCE: UnsplashCurrentUserRepository = UnsplashCurrentUserRepositoryImpl(
            dataSource = UnsplashCurrentUserRemoteDataSourceImpl.INSTANCE
        )
    }
}