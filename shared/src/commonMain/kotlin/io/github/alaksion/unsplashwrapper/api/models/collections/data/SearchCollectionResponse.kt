package io.github.alaksion.unsplashwrapper.api.models.collections.data

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
    @SerialName("published_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val publishedAt: Instant,
    @SerialName("last_collected_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val lastCollectedAt: Instant,
    @SerialName("updated_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val updatedAt: Instant,
    val featured: Boolean,
    @SerialName("total_photos")
    val totalPhotos: Int,
    val priavet: Boolean,
    @SerialName("share_key")
    val shareKey: String,
)
