package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoUrl
import kotlinx.datetime.Instant

data class ListPhoto(
    val id: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val width: Int,
    val height: Int,
    val color: String,
    // TODO -> Create a wrapper class for blurhash
    val blurHash: String,
    val likes: Int,
    val likedByUser: Boolean,
    val description: String,
    val user: ListPhotoUser,
    val urls: PhotoUrl,
    val linksResponse: PhotoLinks,
    val currentUserCollections: List<ListPhotoCollections>
)

data class ListPhotoCollections(
    val id: Int,
    val title: String,
    val publishedAt: Instant,
    val lastCollectedAt: Instant,
    val updatedAt: Instant,
    val coverPhoto: String? = null
)

