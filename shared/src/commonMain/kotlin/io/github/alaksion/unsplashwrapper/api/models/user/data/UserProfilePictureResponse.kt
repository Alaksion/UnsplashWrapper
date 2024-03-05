package io.github.alaksion.unsplashwrapper.api.models.user.data

import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserProfilePicture
import kotlinx.serialization.Serializable

@Serializable
internal data class UserProfilePictureResponse(
    val medium: String,
    val large: String,
    val small: String,
)

internal fun UserProfilePictureResponse.toDomain(): UserProfilePicture =
    UserProfilePicture(
        medium = this.medium,
        large = this.large,
        small = this.small,
    )

