package io.github.alaksion.unsplashwrapper.api.models.currentuser.domain

import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLinks
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class CurrentUser(
    val bio: String?,
    val downloads: Int,
    val email: String?,
    val firstName: String,
    val followedByUser: Boolean,
    val id: String,
    val instagramUsername: String?,
    val lastName: String,
    val currentUserLinksResponse: UserLinks,
    val location: String?,
    val portfolioUrl: String?,
    val totalCollections: Int,
    val totalLikes: Int,
    val totalPhotos: Int,
    val twitterUsername: String?,
    val updatedAt: InstantWrapper,
    val uploadsRemaining: Int?,
    val username: String
)
