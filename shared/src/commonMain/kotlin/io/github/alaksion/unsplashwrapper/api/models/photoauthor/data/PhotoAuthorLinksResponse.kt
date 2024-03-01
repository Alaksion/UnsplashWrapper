package io.github.alaksion.unsplashwrapper.api.models.photoauthor.data

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthorLinks
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoAuthorLinksResponse(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String? = null,
)

internal fun PhotoAuthorLinksResponse.toDomain() = PhotoAuthorLinks(
    self = this.self,
    html = this.html,
    photos = this.photos,
    likes = this.likes,
    portfolio = this.portfolio,
)