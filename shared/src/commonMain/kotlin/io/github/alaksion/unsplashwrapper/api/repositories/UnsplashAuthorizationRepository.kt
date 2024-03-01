package io.github.alaksion.unsplashwrapper.api.repositories

import io.github.alaksion.unsplashwrapper.api.datasources.UnsplashAuthorizationRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.datasources.UnsplashAuthorizationRemoteDataSourceImpl
import io.github.alaksion.unsplashwrapper.api.models.authorization.data.AuthorizationRequest
import io.github.alaksion.unsplashwrapper.api.models.authorization.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.authorization.domain.AuthorizationResult
import io.github.alaksion.unsplashwrapper.api.models.authorization.domain.AuthorizeDTO
import io.github.alaksion.unsplashwrapper.platform.error.basicError
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType

internal interface UnsplashAuthorizationRepository {
    suspend fun authorize(data: AuthorizeDTO): AuthorizationResult
}

internal class UnsplashAuthorizationRepositoryImpl private constructor(
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