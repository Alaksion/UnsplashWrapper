package io.github.alaksion.unsplashwrapper.sdk

import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashCurrentUserRepository
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashCurrentUserRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashPhotosRepository
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashPhotosRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashSearchRepository
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashSearchRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashUserRepository
import io.github.alaksion.unsplashwrapper.api.repositories.UnsplashUserRepositoryImpl
import io.github.alaksion.unsplashwrapper.platform.authentication.UnsplashAuth
import io.github.alaksion.unsplashwrapper.platform.authentication.UnsplashAuthImpl
import io.github.alaksion.unsplashwrapper.platform.listeners.HttpListener
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType

interface UnsplashSdk {
    fun initialize(
        apiKey: String,
        privateKey: String,
        httpListener: HttpListener? = null
    )
}

class UnsplashWrapperSdk private constructor(
    private val tokenManager: TokenManager
) : UnsplashSdk {
    override fun initialize(
        apiKey: String,
        privateKey: String,
        httpListener: HttpListener?
    ) {
        tokenManager.storeToken(type = TokenType.PublicToken, value = apiKey)
        tokenManager.storeToken(type = TokenType.PrivateToken, value = privateKey)
        SdkListeners.httpListener = httpListener
    }

    val photosRepository: UnsplashPhotosRepository by lazy { UnsplashPhotosRepositoryImpl.INSTANCE }
    val searchRepository: UnsplashSearchRepository by lazy { UnsplashSearchRepositoryImpl.INSTANCE }
    val currentUserRepository: UnsplashCurrentUserRepository by lazy { UnsplashCurrentUserRepositoryImpl.INSTANCE }
    val userRepository: UnsplashUserRepository by lazy { UnsplashUserRepositoryImpl.INSTANCE }
    val auth: UnsplashAuth by lazy { UnsplashAuthImpl.INSTANCE }

    companion object {
        val Instance = UnsplashWrapperSdk(
            tokenManager = TokenManagerImplementation.Instance
        )
    }
}
