package io.github.alaksion.unsplashwrapper.api.photos.data.models.photouser

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.photodetails.AuthorLinks
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoUserLinksResponse(
    val self: String,
    val html: String,
    val portfolio: String,
    val photos: String,
    val likes: String,
) {
    fun toDomain(): AuthorLinks = AuthorLinks(
        self, html, portfolio, photos, likes
    )
}