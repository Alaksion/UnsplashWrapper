package io.github.alaksion.unsplashwrapper.sdk

internal object UnsplashSdkConfig {

    private val baseUrl = "https://api.unsplash.com"

    fun buildUrl(url: String) = "$baseUrl/$url"

    val version = "v1"

}