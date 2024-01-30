package io.github.alaksion.unsplashwrapper.api.photos.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoLinksResponse(
    val self: String,
    val html: String,
    val download: String,
    @SerialName("download_location") val downloadLocation: String,
)