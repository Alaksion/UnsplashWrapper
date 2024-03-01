package io.github.alaksion.unsplashwrapper.api.models.photoauthor.data

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthorProfilePicture
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoAuthorProfilePictureResponse(
    val medium: String,
    val large: String,
    val small: String,
)

internal fun PhotoAuthorProfilePictureResponse.toDomain(): PhotoAuthorProfilePicture =
    PhotoAuthorProfilePicture(
        medium = this.medium,
        large = this.large,
        small = this.small,
    )

