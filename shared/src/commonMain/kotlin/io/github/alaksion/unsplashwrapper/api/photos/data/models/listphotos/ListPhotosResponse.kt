package io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoUrlResponse
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ListPhotosResponse(
    val id: String,
    @SerialName("created_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val createdAt: Instant,
    @SerialName("updated_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val updatedAt: Instant,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash") val blurHash: String,
    val likes: Int,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    val description: String? = null,
    val user: ListPhotoUserResponse,
    val urls: PhotoUrlResponse,
    val links: PhotoLinksResponse,
    @SerialName("current_user_collections") val currentUserCollections: List<ListPhotoCollectionsResponse>
)

@Serializable
internal data class ListPhotoCollectionsResponse(
    val id: Int,
    val title: String,
    @SerialName("published_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val publishedAt: Instant,
    @SerialName("last_collected_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val lastCollectedAt: Instant,
    @SerialName("updated_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val updatedAt: Instant,
    @SerialName("cover_photo") val coverPhoto: String? = null
)
