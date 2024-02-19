package io.github.alaksion.unsplashwrapper.api.search.data.models.photos

import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotoUrls
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotos
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotosItem
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotosLinks
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

internal fun SearchPhotosResponse.toDomain(): SearchedPhotos = SearchedPhotos(
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
    val user: SearchPhotosUserResponse,
    val urlResponse: SearchPhotosUrlResponse,
    val links: SearchPhotosLinksResponse
)

internal fun SearchPhotosItemResponse.toDomain(): SearchedPhotosItem = SearchedPhotosItem(
    id = this.id,
    createdAt = InstantWrapper(this.createdAt),
    width = this.width,
    height = this.height,
    color = UnsplashColor(hex = this.color),
    blurHash = this.blurHash,
    likes = this.likes,
    likedByUser = this.likedByUser,
    description = this.description,
    user = this.user.toDomain(),
    urlResponse = this.urlResponse.toDomain(),
    links = this.links.toDomain(),
)

@Serializable
internal data class SearchPhotosUrlResponse(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)

internal fun SearchPhotosUrlResponse.toDomain(): SearchedPhotoUrls = SearchedPhotoUrls(
    raw = this.raw,
    full = this.full,
    regular = this.regular,
    small = this.small,
    thumb = this.thumb,
)

@Serializable
internal data class SearchPhotosLinksResponse(
    val self: String,
    val html: String,
    val download: String,
)

internal fun SearchPhotosLinksResponse.toDomain(): SearchedPhotosLinks = SearchedPhotosLinks(
    self = this.self,
    html = this.html,
    download = this.download
)

