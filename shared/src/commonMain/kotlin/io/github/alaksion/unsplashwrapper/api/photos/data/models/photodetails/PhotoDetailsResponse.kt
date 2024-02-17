package io.github.alaksion.unsplashwrapper.api.photos.data.models.photodetails

import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.photos.data.models.photouser.PhotoUserLinksResponse
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.photodetails.Author
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.photodetails.PhotoDetails
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.photodetails.PhotoExif
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.photodetails.PhotoLocation
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.photodetails.PhotoPosition
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
    val exif: PhotoDetailsExifResponse,
    val location: PhotoDetailsLocationResponse,
    val tags: List<PhotoDetailsTagResponse>,
    val urls: PhotoUrlResponse,
    val links: PhotoLinksResponse,
    val user: PhotoDetailsUserResponse
)

internal fun PhotoDetailsResponse.toDomain(): PhotoDetails = PhotoDetails(
    id = this.id,
    createdAt = InstantWrapper(this.createdAt),
    updatedAt = InstantWrapper(this.updatedAt),
    width = this.width,
    height = this.height,
    color = this.color,
    blurHash = this.blurHash,
    downloads = this.downloads,
    likes = this.likes,
    likedByUser = this.likedByUser,
    isPublicDomain = this.isPublicDomain,
    description = this.description,
    exif = this.exif.toDomain(),
    location = this.location.toDomain(),
    tags = this.tags.map { it.title }.toPersistentList(),
    urls = this.urls.toDomain(),
    links = this.links.toDomain(),
    author = this.user.toDomain(),
)

/*
* Exif stands for Exchangeable image file format. This is an industry standard specification for
* camera device metadata.
* https://pt.wikipedia.org/wiki/Exchangeable_image_file_format
* */
@Serializable
internal data class PhotoDetailsExifResponse(
    val make: String? = null,
    val model: String? = null,
    val name: String? = null,
    @SerialName("exposure_time") val exposureTime: String? = null,
    val aperture: String? = null,
    @SerialName("focal_length") val focalLength: String,
    val iso: Int? = null
) {
    fun toDomain(): PhotoExif = PhotoExif(
        make = this.make,
        model = this.model,
        name = this.name,
        exposureTime = this.exposureTime,
        aperture = this.aperture,
        focalLength = this.focalLength,
        iso = this.iso,
    )
}

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

@Serializable
internal data class PhotoDetailsUserResponse(
    val id: String,
    @SerialName("updated_at")
    @Serializable(with = InstantIso8601Serializer::class)
    val updatedAt: Instant,
    val username: String,
    val name: String,
    @SerialName("portfolio_url") val portfolioUrl: String?,
    val bio: String,
    val location: String,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("total_collections") val totalCollections: Int,
    val links: PhotoUserLinksResponse
)

internal fun PhotoDetailsUserResponse.toDomain(): Author = Author(
    id = this.id,
    updatedAt = InstantWrapper(this.updatedAt),
    username = this.username,
    name = this.name,
    portfolioUrl = this.portfolioUrl,
    bio = this.bio,
    location = this.location,
    totalLikes = this.totalLikes,
    totalPhotos = this.totalPhotos,
    totalCollections = this.totalCollections,
    links = this.links.toDomain(),
)
