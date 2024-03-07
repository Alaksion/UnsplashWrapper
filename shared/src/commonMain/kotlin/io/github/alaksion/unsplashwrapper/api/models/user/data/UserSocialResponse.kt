package io.github.alaksion.unsplashwrapper.api.models.user.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSocialResponse(
    @SerialName("instagram_username")
    val instagramUsername: String? = null,
    @SerialName("portfolio_url")
    val portfolioUrl: String? = null,
    @SerialName("twitter_username")
    val twitterUsername: String? = null
)