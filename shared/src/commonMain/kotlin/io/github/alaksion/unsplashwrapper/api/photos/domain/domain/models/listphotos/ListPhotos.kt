package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos

import kotlinx.datetime.LocalDateTime

data class ListPhotos(
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
    val urls: ListPhotoUrl,
    val linksResponse: ListPhotoLinks,
    val currentUserCollections: List<ListPhotoCollections>
)

data class ListPhotoUrl(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)

data class ListPhotoLinks(
    val self: String,
    val html: String,
    val download: String,
    val downloadLocation: String,
)

data class ListPhotoCollections(
    val id: Int,
    val title: String,
    val publishedAt: LocalDateTime,
    val lastCollectedAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val coverPhoto: String? = null
)

