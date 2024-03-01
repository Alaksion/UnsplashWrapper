package io.github.alaksion.unsplashwrapper.api.models.photo.data

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoUrls
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoUrlResponse(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)

internal fun PhotoUrlResponse.toDomain(): PhotoUrls = PhotoUrls(raw, full, regular, small, thumb)


