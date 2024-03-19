package io.github.alaksion.unsplashwrapper.api.models.user.domain


data class UserLinks(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String? = null,
)
