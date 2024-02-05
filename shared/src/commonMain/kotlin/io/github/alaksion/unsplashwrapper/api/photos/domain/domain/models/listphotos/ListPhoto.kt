package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoUrl
import kotlinx.datetime.LocalDateTime

data class ListPhoto(
    val id: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
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
    val publishedAt: LocalDateTime,
    val lastCollectedAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val coverPhoto: String? = null
)

