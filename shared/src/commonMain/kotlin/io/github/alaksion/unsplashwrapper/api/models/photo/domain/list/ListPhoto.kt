package io.github.alaksion.unsplashwrapper.api.models.photo.domain.list

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoUrls
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthor
import io.github.alaksion.unsplashwrapper.platform.blurhash.Blurhash
import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class ListPhoto(
    val id: String,
    val createdAt: InstantWrapper,
    val updatedAt: InstantWrapper,
    val width: Int,
    val height: Int,
    val color: UnsplashColor,
    val blurHash: Blurhash?,
    val likes: Int,
    val likedByUser: Boolean,
    val description: String?,
    val user: PhotoAuthor,
    val urls: PhotoUrls,
    val links: PhotoLinks,
)

