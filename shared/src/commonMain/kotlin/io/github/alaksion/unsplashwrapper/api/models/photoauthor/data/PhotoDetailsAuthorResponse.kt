package io.github.alaksion.unsplashwrapper.api.models.photoauthor.data

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoDetailsAuthor
import io.github.alaksion.unsplashwrapper.api.models.user.data.UserLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoDetailsAuthorResponse(
    val id: String,
    @SerialName("updated_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val updatedAt: Instant,
    val username: String,
    val name: String,
    @SerialName("portfolio_url") val portfolioUrl: String?,
    val bio: String,
    val location: String,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("total_collections") val totalCollections: Int,
    val links: UserLinksResponse
)

internal fun PhotoDetailsAuthorResponse.toDomain(): PhotoDetailsAuthor = PhotoDetailsAuthor(
    id = this.id,
    updatedAt = InstantWrapper(this.updatedAt),
    username = this.username,
    name = this.name,
    portfolioUrl = this.portfolioUrl,
    bio = this.bio,
    location = this.location,
    totalLikes = this.totalLikes,
    totalPhotos = this.totalPhotos,
    totalCollections = this.totalCollections,
    links = this.links.toDomain(),
)
