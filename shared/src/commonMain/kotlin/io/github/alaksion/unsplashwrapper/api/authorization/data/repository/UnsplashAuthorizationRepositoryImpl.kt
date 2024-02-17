package io.github.alaksion.unsplashwrapper.api.authorization.data.repository

import io.github.alaksion.unsplashwrapper.api.authorization.data.model.AuthorizationRequest
import io.github.alaksion.unsplashwrapper.api.authorization.data.model.toDomain
import io.github.alaksion.unsplashwrapper.api.authorization.data.remote.UnsplashAuthorizationRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.authorization.data.remote.UnsplashAuthorizationRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.authorization.domain.model.AuthorizationResult
import io.github.alaksion.unsplashwrapper.api.authorization.domain.model.AuthorizeDTO
import io.github.alaksion.unsplashwrapper.api.authorization.domain.repository.UnsplashAuthorizationRepository
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType
import io.github.alaksion.unsplashwrapper.platform.error.basicError

internal class UnsplashAuthorizationRepositoryImpl(
    private val dataSource: UnsplashAuthorizationRemoteDataSource,
    private val tokenManager: TokenManager,
) : UnsplashAuthorizationRepository {

    override suspend fun authorize(data: AuthorizeDTO): AuthorizationResult {
        val result = dataSource.requestAuthorization(
            data = AuthorizationRequest(
                clientId = tokenManager.getToken(TokenType.PublicToken)
                    ?: basicError("Public token not set"),
                secretKey = tokenManager.getToken(TokenType.PrivateToken)
                    ?: basicError("Private token not set"),
                redirectUri = data.redirectUri,
                code = data.code
            )
        )
        return result.toDomain()
    }

    companion object {
        val INSTANCE: UnsplashAuthorizationRepository = UnsplashAuthorizationRepositoryImpl(
            dataSource = UnsplashAuthorizationRemoteDataSourceImpl.INSTANCE,
            tokenManager = TokenManagerImplementation.Instance
        )
    }
}