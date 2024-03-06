package io.github.alaksion.unsplashwrapper.api.models.photo.data.list

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoAuthorResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.details.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.list.ListPhoto
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.list.ListPhotoCollections
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.toDomain
import io.github.alaksion.unsplashwrapper.platform.blurhash.BlurhashDecoder
import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.toPersistentList
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
    val user: PhotoAuthorResponse,
    val urls: PhotoUrlResponse,
    val links: PhotoLinksResponse,
    @SerialName("current_user_collections") val currentUserCollections: List<ListPhotoCollectionsResponse>
)

internal fun ListPhotosResponse.toDomain(): ListPhoto {
    return ListPhoto(
        id = this.id,
        createdAt = InstantWrapper(this.createdAt),
        updatedAt = InstantWrapper(this.updatedAt),
        width = this.width,
        height = this.height,
        color = UnsplashColor(hex = this.color),
        blurHash = BlurhashDecoder().decode(this.blurHash),
        likes = this.likes,
        likedByUser = this.likedByUser,
        description = this.description,
        user = this.user.toDomain(),
        urls = this.urls.toDomain(),
        links = this.links.toDomain(),
        currentUserCollections = this.currentUserCollections.map { it.toDomain() }
            .toPersistentList(),
    )
}

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

internal fun ListPhotoCollectionsResponse.toDomain() = ListPhotoCollections(
    id = this.id,
    title = this.title,
    publishedAt = InstantWrapper(this.publishedAt),
    lastCollectedAt = InstantWrapper(this.lastCollectedAt),
    updatedAt = InstantWrapper(this.updatedAt),
    coverPhoto = this.coverPhoto,
)
