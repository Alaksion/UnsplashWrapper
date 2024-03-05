package io.github.alaksion.unsplashwrapper.api.models.collections.data

import io.github.alaksion.unsplashwrapper.api.models.collections.domain.CollectionCoverPhoto
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoAuthorResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CollectionCoverPhotoResponse(
    val id: String,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash") val blurHash: String,
    val likes: Int,
    @SerialName("liked_by_user") val likedByUser: Boolean,
    val description: String,
    val user: PhotoAuthorResponse,
    val urls: PhotoUrlResponse,
    val links: PhotoLinksResponse
)

internal fun CollectionCoverPhotoResponse.toDomain(): CollectionCoverPhoto = CollectionCoverPhoto(
    id = this.id,
    width = this.width,
    height = this.height,
    color = UnsplashColor(hex = this.color),
    blurHash = this.blurHash,
    likes = this.likes,
    likedByUser = this.likedByUser,
    description = this.description,
    user = this.user.toDomain(),
    urls = this.urls.toDomain(),
    links = this.links.toDomain(),
)

