package io.github.alaksion.unsplashwrapper.api.models.photo.data.search

import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.search.SearchPhotos
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.search.SearchPhotosItem
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoAuthorResponse
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
internal data class SearchPhotosResponse(
    val total: Int,
    @SerialName("total_pages") val totalPages: Int,
    val results: List<SearchPhotosItemResponse>
)

internal fun SearchPhotosResponse.toDomain(): SearchPhotos = SearchPhotos(
    resultsCount = this.total,
    totalPages = this.totalPages,
    results = this.results.map { it.toDomain() }.toPersistentList()
)

@Serializable
internal data class SearchPhotosItemResponse(
    val id: String,
    @SerialName("created_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val createdAt: Instant,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash") val blurHash: String,
    val likes: Int,
    @SerialName("liked_by_user") val likedByUser: String,
    val description: String,
    val user: PhotoAuthorResponse,
    val urlResponse: PhotoUrlResponse,
    val links: PhotoLinksResponse
)

internal fun SearchPhotosItemResponse.toDomain(): SearchPhotosItem = SearchPhotosItem(
    id = this.id,
    createdAt = InstantWrapper(this.createdAt),
    width = this.width,
    height = this.height,
    color = UnsplashColor(hex = this.color),
    blurHash = BlurhashDecoder.decode(this.blurHash),
    likes = this.likes,
    likedByUser = this.likedByUser,
    description = this.description,
    user = this.user.toDomain(),
    urls = this.urlResponse.toDomain(),
    links = this.links.toDomain(),
)

