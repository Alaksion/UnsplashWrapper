package io.github.alaksion.unsplashwrapper.api.models.user.data.profile


import io.github.alaksion.unsplashwrapper.api.models.user.domain.profile.UserSocial
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserSocialResponse(
    @SerialName("instagram_username")
    val instagramUsername: String? = null,
    @SerialName("portfolio_url")
    val portfolioUrl: String? = null,
    @SerialName("twitter_username")
    val twitterUsername: String? = null
)

internal fun UserSocialResponse.toDomain(): UserSocial = UserSocial(
    instagramUsername = this.instagramUsername,
    portfolioUrl = this.portfolioUrl,
    twitterUsername = this.twitterUsername
)
