package io.github.alaksion.unsplashwrapper.api.photos.data.models

import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoUrlResponse(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)
