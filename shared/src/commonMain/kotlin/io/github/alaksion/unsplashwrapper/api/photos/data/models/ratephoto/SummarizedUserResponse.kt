package io.github.alaksion.unsplashwrapper.api.photos.data.models.ratephoto

import io.github.alaksion.unsplashwrapper.api.photos.data.models.photouser.PhotoUserLinksResponse
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.AuthorSummary
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