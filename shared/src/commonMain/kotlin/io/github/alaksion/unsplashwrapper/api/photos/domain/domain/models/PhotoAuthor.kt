package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class PhotoAuthor(
    val id: String,
    val updatedAt: InstantWrapper,
    val username: String,
    val name: String,
    val portfolioUrl: String?,
    val bio: String,
    val location: String,
    val totalLikes: Int,
    val totalPhotos: Int,
    val totalCollections: Int,
    val links: PhotoAuthorLinks
)

data class PhotoAuthorLinks(
    val self: String,
    val html: String,
    val portfolio: String?,
    val photos: String,
    val likes: String,
)