package io.github.alaksion.unsplashwrapper.platform.authentication

import io.github.alaksion.unsplashwrapper.api.models.authorization.domain.AuthorizationScope
import io.github.alaksion.unsplashwrapper.api.models.authorization.domain.AuthorizeDTO
import io.github.alaksion.unsplashwrapper.api.models.currentuser.domain.CurrentUser
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashAuthorizationRepository
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashAuthorizationRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashCurrentUserRepository
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashCurrentUserRepositoryImpl
import io.github.alaksion.unsplashwrapper.platform.error.basicError
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.http.URLBuilder
import kotlinx.collections.immutable.ImmutableSet

interface UnsplashAuth {

    suspend fun signIn(
        accessCode: String,
        redirectUri: String,
    ): CurrentUser

    suspend fun signOut()

    fun buildAuthorizeUrl(
        redirectUri: String,
        scopes: ImmutableSet<AuthorizationScope>
    ): String

}

internal class UnsplashAuthImpl private constructor(
    private val tokenManager: TokenManager,
    private val authorizationRepository: UnsplashAuthorizationRepository,
    private val currentUserRepository: UnsplashCurrentUserRepository
) : UnsplashAuth {

    override suspend fun signIn(accessCode: String, redirectUri: String): CurrentUser {
        val validateToken = authorizationRepository.authorize(
            data = AuthorizeDTO(
                redirectUri = redirectUri,
                code = accessCode
            )
        )
        tokenManager.storeToken(
            type = TokenType.UserToken,
            value = validateToken.accessToken
        )
        return currentUserRepository.getCurrentUser()
    }

    override suspend fun signOut() = tokenManager.clearToken(TokenType.UserToken)
    override fun buildAuthorizeUrl(
        redirectUri: String,
        scopes: ImmutableSet<AuthorizationScope>
    ): String {
        val url = URLBuilder(urlString = UnsplashSdkConfig.AUTHORIZE_URL)
        with(url.parameters) {
            append(
                "client_id",
                tokenManager.getToken(TokenType.PublicToken) ?: basicError("Public token not set")
            )
            append("redirect_uri", redirectUri)
            append("response_type", "code")
            append("scope", scopes.joinToString(separator = "+") { it.value })
        }
        return url.buildString()
    }

    companion object {
        val INSTANCE: UnsplashAuth = UnsplashAuthImpl(
            tokenManager = TokenManagerImplementation.Instance,
            authorizationRepository = UnsplashAuthorizationRepositoryImpl.INSTANCE,
            currentUserRepository = UnsplashCurrentUserRepositoryImpl.INSTANCE
        )
    }

}
