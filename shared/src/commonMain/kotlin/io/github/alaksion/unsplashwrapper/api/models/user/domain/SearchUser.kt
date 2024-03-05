package io.github.alaksion.unsplashwrapper.api.models.user.domain

import kotlinx.collections.immutable.ImmutableList


data class SearchUser(
    val total: Int,
    val totalPages: Int,
    val results: ImmutableList<SearchUserItem>
)


data class SearchUserItem(
    val id: String,
    val username: String,
    val name: String,
    val firstName: String,
    val lastName: String,
    val instagramUsername: String? = null,
    val twitterUsername: String? = null,
    val portfolioUrl: String? = null,
    val totalLikes: Int,
    val totalPhotos: Int,
    val totalCollections: Int,
    val profilePicture: UserProfilePicture,
    val links: UserLinks
)
