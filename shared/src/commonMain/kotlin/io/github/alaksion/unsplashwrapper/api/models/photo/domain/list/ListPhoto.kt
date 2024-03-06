package io.github.alaksion.unsplashwrapper.api.models.photo.domain.list

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoUrls
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthor
import io.github.alaksion.unsplashwrapper.platform.blurhash.Blurhash
import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableList

data class ListPhoto(
    val id: String,
    val createdAt: InstantWrapper,
    val updatedAt: InstantWrapper,
    val width: Int,
    val height: Int,
    val color: UnsplashColor,
    val blurHash: Blurhash,
    val likes: Int,
    val likedByUser: Boolean,
    val description: String?,
    val user: PhotoAuthor,
    val urls: PhotoUrls,
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

