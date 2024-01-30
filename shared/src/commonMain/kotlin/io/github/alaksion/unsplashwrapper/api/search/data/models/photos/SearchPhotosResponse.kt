package io.github.alaksion.unsplashwrapper.api.search.data.models.photos

import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchPhotosResponse(
    val total: Int,
    @SerialName("total_pages") val totalPages: Int,
    val results: ImmutableList<SearchPhotosItemResponse>
)

@Serializable
internal data class SearchPhotosItemResponse(
    val id: String,
    @SerialName("created_at")
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val createdAt: LocalDateTime,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash") val blurHash: String,
    val likes: Int,
    @SerialName("liked_by_user") val likedByUser: String,
    val description: String,
    val user: SearchPhotosUserResponse,
    val urlResponse: SearchPhotosUrlResponse,
    val links: SearchPhotosLinksResponse
)

@Serializable
internal data class SearchPhotosUrlResponse(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)

@Serializable
internal data class SearchPhotosLinksResponse(
    val self: String,
    val html: String,
    val download: String,
)

