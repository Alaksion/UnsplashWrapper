package io.github.alaksion.unsplashwrapper.api.photos.data.models

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoUrl
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoUrlResponse(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)

internal fun PhotoUrlResponse.toDomain(): PhotoUrl = PhotoUrl(raw, full, regular, small, thumb)


