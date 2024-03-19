package io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain

import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLinks
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class PhotoDetailsAuthor(
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
    val links: UserLinks
)
