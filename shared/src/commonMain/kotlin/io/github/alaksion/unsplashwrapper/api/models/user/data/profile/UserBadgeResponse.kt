package io.github.alaksion.unsplashwrapper.api.models.user.data.profile


import io.github.alaksion.unsplashwrapper.api.models.user.domain.profile.UserBadge
import kotlinx.serialization.Serializable

@Serializable
internal data class UserBadgeResponse(
    val link: String,
    val primary: Boolean,
    val slug: String,
    val title: String
)

internal fun UserBadgeResponse.toDomain(): UserBadge = UserBadge(
    link = this.link,
    primary = this.primary,
    slug = this.slug,
    title = this.title,
)
