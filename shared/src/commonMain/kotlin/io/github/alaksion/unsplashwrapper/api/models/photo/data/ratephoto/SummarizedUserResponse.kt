package io.github.alaksion.unsplashwrapper.api.models.photo.data.ratephoto

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.rate.AuthorSummary
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoAuthorLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.toDomain
import kotlinx.serialization.Serializable

@Serializable
internal data class SummarizedUserResponse(
    val id: String,
    val links: PhotoAuthorLinksResponse,
    val name: String,
    val username: String
)

internal fun SummarizedUserResponse.toDomain(): AuthorSummary = AuthorSummary(
    id = this.id,
    links = this.links.toDomain(),
    name = this.name,
    username = this.username
)