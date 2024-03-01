package io.github.alaksion.unsplashwrapper.api.models.photo.data.ratephoto


import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.rate.PhotoSummary
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SummarizedPhotoResponse(
    val blurHash: String,
    val color: String,
    val description: String,
    val height: Int,
    val id: String,
    @SerialName("liked_by_user") val likedByUser: Boolean,
    val likes: Int,
    val links: PhotoLinksResponse,
    val urls: PhotoUrlResponse,
    val width: Int
)

internal fun SummarizedPhotoResponse.toDomain(): PhotoSummary = PhotoSummary(
    blurHash = this.blurHash,
    color = this.color,
    description = this.description,
    height = this.height,
    id = this.id,
    likedByUser = this.likedByUser,
    likes = this.likes,
    links = this.links.toDomain(),
    urls = this.urls.toDomain(),
    width = this.width,
)