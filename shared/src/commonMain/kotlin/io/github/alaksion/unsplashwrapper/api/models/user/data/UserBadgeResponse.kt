package io.github.alaksion.unsplashwrapper.api.models.user.data


import kotlinx.serialization.Serializable

@Serializable
internal data class UserBadgeResponse(
    val link: String,
    val primary: Boolean,
    val slug: String,
    val title: String
)