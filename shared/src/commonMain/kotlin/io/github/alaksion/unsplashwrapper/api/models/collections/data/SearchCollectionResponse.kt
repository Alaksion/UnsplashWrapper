package io.github.alaksion.unsplashwrapper.api.models.collections.data

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoAuthorResponse
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchCollectionResponse(
    val total: Int,
    @SerialName("total_pages")
    val totalPages: Int,
    val results: List<SearchCollectionItemResponse>
)

@Serializable
internal data class SearchCollectionItemResponse(
    val id: String,
    val title: String,
    val description: String? = null,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("published_at") val publishedAt: Instant,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("last_collected_at") val lastCollectedAt: Instant,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("updated_at") val updatedAt: Instant,
    val featured: Boolean,
    @SerialName("total_photos")
    val totalPhotos: Int,
    val private: Boolean,
    @SerialName("share_key") val shareKey: String,
    @SerialName("cover_photo") val coverPhotoResponse: CollectionCoverPhotoResponse,
    val user: PhotoAuthorResponse,
    val links: CollectionLinksResponse
)
