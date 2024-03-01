package io.github.alaksion.unsplashwrapper.api.models.photo.domain

data class PhotoLocation(
    val city: String?,
    val country: String?,
    val position: PhotoPosition?
)

data class PhotoPosition(
    val latitude: Double,
    val longitude: Double
)