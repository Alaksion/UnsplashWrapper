package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoUrl
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.Instant

data class ListPhoto(
    val id: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val width: Int,
    val height: Int,
    val color: String,
    val blurHash: String,
    val likes: Int,
    val likedByUser: Boolean,
    val description: String?,
    val user: ListPhotoUser,
    val urls: PhotoUrl,
    val links: PhotoLinks,
    val currentUserCollections: ImmutableList<ListPhotoCollections>
)

data class ListPhotoCollections(
    val id: Int,
    val title: String,
    val publishedAt: InstantWrapper,
    val lastCollectedAt: InstantWrapper,
    val updatedAt: InstantWrapper,
    val coverPhoto: String? = null
)

