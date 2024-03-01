package io.github.alaksion.unsplashwrapper.api.photos.data.models.photouser

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoAuthorLinks
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoUserLinksResponse(
    val self: String,
    val html: String,
    val portfolio: String,
    val photos: String,
    val likes: String,
) {
    fun toDomain(): PhotoAuthorLinks = PhotoAuthorLinks(
        self, html, portfolio, photos, likes
    )
}