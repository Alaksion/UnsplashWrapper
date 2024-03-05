package io.github.alaksion.unsplashwrapper.api.models.collections.domain

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoUrls
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthor
import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor

data class CollectionCoverPhoto(
    val id: String,
    val width: Int,
    val height: Int,
    val color: UnsplashColor,
    val blurHash: String,
    val likes: Int,
    val likedByUser: Boolean,
    val description: String,
    val user: PhotoAuthor,
    val urls: PhotoUrls,
    val links: PhotoLinks
)
