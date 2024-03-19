package io.github.alaksion.unsplashwrapper.api.models.collections.data

import io.github.alaksion.unsplashwrapper.api.models.collections.domain.UserCollections
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoAuthorResponse
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.toDomain
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class UserCollectionsResponse(
    val id: String,
    val title: String,
    val description: String? = null,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("published_at") val publishedAt: Instant,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("last_collected_at") val lastCollectedAt: Instant,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("updated_at") val updatedAt: Instant,
    @SerialName("total_photos") val totalPhotos: Int,
    val private: Boolean,
    @SerialName("cover_photo") val coverPhotoResponse: CollectionCoverPhotoResponse,
    val user: PhotoAuthorResponse,
    val links: CollectionLinksResponse
)

internal fun UserCollectionsResponse.toDomain(): UserCollections = UserCollections(
    id = id,
    title = this.title,
    description = this.description,
    publishedAt = InstantWrapper(this.publishedAt),
    lastCollectedAt = InstantWrapper(this.lastCollectedAt),
    updatedAt = InstantWrapper(this.updatedAt),
    totalPhotos = this.totalPhotos,
    private = this.private,
    coverPhoto = this.coverPhotoResponse.toDomain(),
    user = this.user.toDomain(),
    links = this.links.toDomain(),
)
