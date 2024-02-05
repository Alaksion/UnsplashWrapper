package io.github.alaksion.unsplashwrapper.sdk

import io.github.alaksion.unsplashwrapper.api.photos.data.repository.UnsplashPhotosRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.photos.domain.repository.UnsplashPhotosRepository
import io.github.alaksion.unsplashwrapper.api.search.data.repository.UnsplashSearchRepositoryImpl
import io.github.alaksion.unsplashwrapper.api.search.domain.repository.UnsplashSearchRepository
import io.github.alaksion.unsplashwrapper.platform.auth.TokenManager
import io.github.alaksion.unsplashwrapper.platform.auth.TokenManagerImplementation

interface UnsplashSdk {
    fun initialize(apiKey: String)
}

class UnsplashWrapperSdk private constructor(
    private val tokenManager: TokenManager
) : UnsplashSdk {
    override fun initialize(apiKey: String) {
        tokenManager.storePublicKey(apiKey)
    }

    val photosRepository: UnsplashPhotosRepository by lazy { UnsplashPhotosRepositoryImpl.INSTANCE }
    val searchRepository: UnsplashSearchRepository by lazy { UnsplashSearchRepositoryImpl.INSTANCE }


    companion object {
        val Instance = UnsplashWrapperSdk(
            tokenManager = TokenManagerImplementation.Instance
        )
    }
}
