package io.github.alaksion.unsplashwrapper.api.repositories

import io.github.alaksion.unsplashwrapper.api.models.currentuser.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.currentuser.domain.CurrentUser
import io.github.alaksion.unsplashwrapper.api.datasources.UnsplashCurrentUserRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.datasources.UnsplashCurrentUserRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType

interface UnsplashCurrentUserRepository {

    suspend fun getCurrentUser(): CurrentUser

    fun isUserLoggedIn(): Boolean
}

internal class UnsplashCurrentUserRepositoryImpl private constructor(
    private val dataSource: UnsplashCurrentUserRemoteDataSource,
    private val tokenManager: TokenManager,
) : UnsplashCurrentUserRepository {

    override suspend fun getCurrentUser(): CurrentUser = dataSource.getCurrentUser().toDomain()
    override fun isUserLoggedIn(): Boolean {
        return tokenManager.getToken(TokenType.UserToken) != null
    }

    companion object {
        val INSTANCE: UnsplashCurrentUserRepository = UnsplashCurrentUserRepositoryImpl(
            dataSource = UnsplashCurrentUserRemoteDataSourceImpl.INSTANCE,
            tokenManager = TokenManagerImplementation.Instance
        )
    }
}
