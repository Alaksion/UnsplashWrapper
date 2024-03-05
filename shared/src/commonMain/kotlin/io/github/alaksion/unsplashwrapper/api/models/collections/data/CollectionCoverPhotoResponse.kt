package io.github.alaksion.unsplashwrapper.api.models.collections.data

import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.data.PhotoAuthorResponse
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
