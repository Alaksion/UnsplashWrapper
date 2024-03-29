package io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain

import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLinks
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserProfilePicture


data class PhotoAuthor(
    val id: String,
    val username: String,
    val name: String,
    val portfolioUrl: String? = null,
    val bio: String? = null,
    val location: String? = null,
    val totalLikes: Int,
    val totalPhotos: Int,
    val totalCollections: Int,
    val instagramUserName: String? = null,
    val twitterUsername: String? = null,
    val profileImage: UserProfilePicture,
    val links: UserLinks,
)
