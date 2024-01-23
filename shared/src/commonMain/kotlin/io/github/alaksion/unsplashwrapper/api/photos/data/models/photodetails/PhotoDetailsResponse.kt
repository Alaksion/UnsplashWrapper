package io.github.alaksion.unsplashwrapper.api.photos.data.models.photodetails

import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.photos.data.models.photouser.PhotoUserLinksResponse
import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoDetailsResponse(
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
    val downloads: Int,
    val likes: Int,
    @SerialName("liked_by_user") val likedByUser: String,
    @SerialName("public_domain") val isPublicDomain: Boolean,
    val description: String,
    val exif: PhotoDetailsExifResponse,
    val location: PhotoDetailsLocationResponse,
    val tags: ImmutableList<PhotoDetailsTagResponse>,
    val urls: PhotoUrlResponse,
    val links: PhotoLinksResponse,
    val user: PhotoDetailsUserResponse
)

/*
* Exif stands for Exchangeable image file format. This is an industry standard specification for
* camera device metadata.
* https://pt.wikipedia.org/wiki/Exchangeable_image_file_format
* */
@Serializable
internal data class PhotoDetailsExifResponse(
    val make: String,
    val model: String,
    val name: String,
    @SerialName("exposure_time") val exposureTime: String,
    val aperture: String,
    @SerialName("focal_length") val focalLength: String,
    val iso: Int
)

@Serializable
internal data class PhotoDetailsLocationResponse(
    val city: String,
    val country: String,
    val position: PhotoDetailsLocationCoordinatesResponse
)

@Serializable
internal data class PhotoDetailsLocationCoordinatesResponse(
    val latitude: Double,
    val longitude: Double
)

@Serializable
internal data class PhotoDetailsTagResponse(
    val title: String,
)

@Serializable
internal data class PhotoDetailsUserResponse(
    val id: String,
    @SerialName("updated_at")
    @Serializable(with = LocalDateTimeIso8601Serializer::class)
    val updatedAt: LocalDateTime,
    val username: String,
    val name: String,
    @SerialName("portfolio_url") val portfolioUrl: String,
    val bio: String,
    val location: String,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("total_collections") val totalCollections: Int,
    val links: PhotoUserLinksResponse
)
