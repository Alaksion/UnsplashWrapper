package io.github.alaksion.unsplashwrapper.sdk

internal object UnsplashSdkConfig {

    private const val baseUrl = "https://api.unsplash.com"
    const val OAUTH_URL = "https://unsplash.com/oauth/token"

    fun buildUrl(url: String) = "$baseUrl/$url"

    const val version = "v1"

}
