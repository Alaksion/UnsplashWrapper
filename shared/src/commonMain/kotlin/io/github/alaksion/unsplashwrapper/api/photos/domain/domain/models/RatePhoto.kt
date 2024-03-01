package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class RatePhoto(
    val id: String,
    val createdAt: InstantWrapper,
    val updatedAt: InstantWrapper,
    val width: Int,
    val height: Int,
    val color: String,
    val blurHash: String,
    val download: Int,
    val likes: Int,
    val likedByUser: Boolean,
    val publicDomain: Boolean,
    val description: String,
    val exif: PhotoExif,
    val location: PhotoLocation,
    val tags: PhotoTag,
    val urls: PhotoUrl,
    val links: PhotoLinks,
    val author: PhotoAuthor
)
