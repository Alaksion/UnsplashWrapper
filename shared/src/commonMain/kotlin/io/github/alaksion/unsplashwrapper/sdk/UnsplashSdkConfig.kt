package io.github.alaksion.unsplashwrapper.sdk

internal object UnsplashSdkConfig {

    private const val baseUrl = "https://api.unsplash.com"

    fun buildUrl(url: String) = "$baseUrl/$url"

    const val version = "v1"

}
