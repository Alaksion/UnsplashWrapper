package io.github.alaksion.unsplashwrapper.api.models.photo.data.ratephoto

import io.github.alaksion.unsplashwrapper.api.photos.data.models.photouser.PhotoUserLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.rate.AuthorSummary
import kotlinx.serialization.Serializable

@Serializable
internal data class SummarizedUserResponse(
    val id: String,
    val links: PhotoUserLinksResponse,
    val name: String,
    val username: String
)

internal fun SummarizedUserResponse.toDomain(): AuthorSummary = AuthorSummary(
    id = this.id,
    links = this.links.toDomain(),
    name = this.name,
    username = this.username
)