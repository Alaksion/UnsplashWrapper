package io.github.alaksion.unsplashwrapper.api.models.photo.data

import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoDownloadTrackResponse(
    val url: String
)
