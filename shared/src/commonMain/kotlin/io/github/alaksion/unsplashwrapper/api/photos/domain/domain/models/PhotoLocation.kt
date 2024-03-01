package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models

data class PhotoLocation(
    val city: String?,
    val country: String?,
    val position: PhotoPosition?
)

data class PhotoPosition(
    val latitude: Double,
    val longitude: Double
)