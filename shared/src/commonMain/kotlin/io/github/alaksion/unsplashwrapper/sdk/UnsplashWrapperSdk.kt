package io.github.alaksion.unsplashwrapper.sdk

import io.github.alaksion.unsplashwrapper.AuthManager

interface UnsplashSdk {
    fun initialize(apiKey: String)
}

class UnsplashWrapperSdk private constructor(
    private val authManager: AuthManager
) : UnsplashSdk {
    override fun initialize(apiKey: String) {
        authManager.storePublicKey(apiKey)
    }

    companion object {
        val instance = UnsplashWrapperSdk(
            
        )
    }

}