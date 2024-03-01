package io.github.alaksion.unsplashwrapper.api.models.photo.domain

data class PhotoLinks(
    val self: String,
    val html: String,
    val download: String,
    val downloadLocation: String?,
)