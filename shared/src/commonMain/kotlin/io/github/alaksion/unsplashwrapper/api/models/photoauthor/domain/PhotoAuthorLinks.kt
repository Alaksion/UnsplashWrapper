package io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain


data class PhotoAuthorLinks(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String? = null,
)