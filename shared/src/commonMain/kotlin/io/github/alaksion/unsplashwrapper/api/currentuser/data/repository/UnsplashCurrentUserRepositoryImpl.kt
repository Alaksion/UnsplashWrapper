package io.github.alaksion.unsplashwrapper.api.currentuser.data.repository

import io.github.alaksion.unsplashwrapper.api.currentuser.data.model.toDomain
import io.github.alaksion.unsplashwrapper.api.currentuser.data.remote.UnsplashCurrentUserRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.currentuser.data.remote.UnsplashCurrentUserRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.currentuser.domain.UnsplashCurrentUserRepository
import io.github.alaksion.unsplashwrapper.api.currentuser.domain.model.CurrentUser
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType

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