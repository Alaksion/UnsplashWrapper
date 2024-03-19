package io.github.alaksion.unsplashwrapper.api.models.user.domain.profile

import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLinks
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserProfilePicture
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class UserProfile(
    val badge: UserBadge,
    val bio: String? = null,
    val downloads: Int,
    val firstName: String,
    val followedByUser: Boolean,
    val followersCount: Int,
    val followingCount: Int,
    val id: String,
    val lastName: String,
    val links: UserLinks,
    val location: String? = null,
    val name: String,
    val profileImage: UserProfilePicture,
    val social: UserSocial,
    val totalCollections: Int,
    val totalLikes: Int,
    val totalPhotos: Int,
    val updatedAt: InstantWrapper,
    val username: String
)
