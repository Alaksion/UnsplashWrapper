package io.github.alaksion.unsplashwrapper.api.models.user.data

import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLinks
import kotlinx.serialization.Serializable

@Serializable
internal data class UserLinksResponse(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String? = null,
)

internal fun UserLinksResponse.toDomain() = UserLinks(
    self = this.self,
    html = this.html,
    photos = this.photos,
    likes = this.likes,
    portfolio = this.portfolio,
)