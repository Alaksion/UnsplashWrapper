package io.github.alaksion.unsplashwrapper.sdk

import io.github.alaksion.unsplashwrapper.api.photos.data.repository.UnsplashPhotosRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.photos.domain.repository.UnsplashPhotosRepository
import io.github.alaksion.unsplashwrapper.api.search.data.repository.UnsplashSearchRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.search.domain.repository.UnsplashSearchRepository
import io.github.alaksion.unsplashwrapper.authentication.UnsplashAuth
import io.github.alaksion.unsplashwrapper.authentication.UnsplashAuthImpl
import io.github.alaksion.unsplashwrapper.platform.token.TokenManager
import io.github.alaksion.unsplashwrapper.platform.token.TokenManagerImplementation
import io.github.alaksion.unsplashwrapper.platform.token.TokenType

interface UnsplashSdk {
    fun initialize(apiKey: String, privateKey: String)
}

class UnsplashWrapperSdk private constructor(
    private val tokenManager: TokenManager
) : UnsplashSdk {
    override fun initialize(
        apiKey: String,
        privateKey: String,
    ) {
        tokenManager.storeToken(type = TokenType.PublicToken, value = apiKey)
        tokenManager.storeToken(type = TokenType.PrivateToken, value = privateKey)
    }

    val photosRepository: UnsplashPhotosRepository by lazy { UnsplashPhotosRepositoryImpl.INSTANCE }
    val searchRepository: UnsplashSearchRepository by lazy { UnsplashSearchRepositoryImpl.INSTANCE }

    val auth: UnsplashAuth by lazy { UnsplashAuthImpl.INSTANCE }


    companion object {
        val Instance = UnsplashWrapperSdk(
            tokenManager = TokenManagerImplementation.Instance
        )
    }
}
