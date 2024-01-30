package io.github.alaksion.unsplashwrapper.api.search.data.models.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchPhotosUserResponse(
    val id: String,
    val username: String,
    val name: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("instagram_username") val instagramUserName: String,
    @SerialName("twitter_username") val twitterUsername: String,
    @SerialName("portfolio_url") val portfolioUrl: String,
    @SerialName("profile_image") val profileImage: SearchPhotosUserImageResponse,
    val links: SearchPhotosUserLinksResponse
)

@Serializable
internal data class SearchPhotosUserImageResponse(
    val medium: String,
    val large: String,
    val small: String,
)

@Serializable
internal data class SearchPhotosUserLinksResponse(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
)