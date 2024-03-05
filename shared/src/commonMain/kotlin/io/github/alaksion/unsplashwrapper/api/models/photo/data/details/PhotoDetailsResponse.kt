package io.github.alaksion.unsplashwrapper.api.models.photo.data.details

import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoExifResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLocation
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoPosition
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoTag
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.details.PhotoDetails
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoDetailsAuthorResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.toPersistentList
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoDetailsResponse(
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
    val downloads: Int,
    val likes: Int,
    @SerialName("liked_by_user") val likedByUser: Boolean,
    @SerialName("public_domain") val isPublicDomain: Boolean,
    val description: String?,
    val exif: PhotoExifResponse,
    val location: PhotoDetailsLocationResponse,
    val tags: List<PhotoDetailsTagResponse>,
    val urls: PhotoUrlResponse,
    val links: PhotoLinksResponse,
    val user: PhotoDetailsAuthorResponse
)

internal fun PhotoDetailsResponse.toDomain(): PhotoDetails = PhotoDetails(
    id = this.id,
    createdAt = InstantWrapper(this.createdAt),
    updatedAt = InstantWrapper(this.updatedAt),
    width = this.width,
    height = this.height,
    color = UnsplashColor(hex = this.color),
    blurHash = this.blurHash,
    downloads = this.downloads,
    likes = this.likes,
    likedByUser = this.likedByUser,
    isPublicDomain = this.isPublicDomain,
    description = this.description,
    exif = this.exif.toDomain(),
    location = this.location.toDomain(),
    tags = this.tags.map { PhotoTag(it.title) }.toPersistentList(),
    urls = this.urls.toDomain(),
    links = this.links.toDomain(),
    author = this.user.toDomain(),
)


@Serializable
internal data class PhotoDetailsLocationResponse(
    val city: String?,
    val country: String?,
    val position: PhotoDetailsLocationCoordinatesResponse?
) {
    fun toDomain(): PhotoLocation = PhotoLocation(
        city = this.city,
        country = this.country,
        position = this.position?.toDomain(),
    )
}

@Serializable
internal data class PhotoDetailsLocationCoordinatesResponse(
    val latitude: Double,
    val longitude: Double
) {
    fun toDomain(): PhotoPosition = PhotoPosition(
        latitude = this.latitude,
        longitude = this.longitude
    )
}

@Serializable
internal data class PhotoDetailsTagResponse(
    val title: String,
)
