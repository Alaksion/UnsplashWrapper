package io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoUrlResponse
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ListPhotosResponse(
    val id: String,
    @SerialName("created_at")
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val createdAt: LocalDateTime,
    @SerialName("updated_at")
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val updatedAt: LocalDateTime,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash") val blurHash: String,
    val likes: Int,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    val description: String,
    val user: ListPhotoUserResponse,
    val urls: PhotoUrlResponse,
    val linksResponse: PhotoLinksResponse,
    @SerialName("current_user_collections") val currentUserCollections: List<ListPhotoCollectionsResponse>
)

@Serializable
internal data class ListPhotoCollectionsResponse(
    val id: Int,
    val title: String,
    @SerialName("published_at")
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val publishedAt: LocalDateTime,
    @SerialName("last_collected_at")
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val lastCollectedAt: LocalDateTime,
    @SerialName("updated_at")
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val updatedAt: LocalDateTime,
    @SerialName("cover_photo") val coverPhoto: String? = null
)
