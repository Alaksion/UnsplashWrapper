package io.github.alaksion.unsplashwrapper.api.photos.data.models

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLinks
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoLinksResponse(
    val self: String,
    val html: String,
    val download: String,
    @SerialName("download_location") val downloadLocation: String,
)

internal fun PhotoLinksResponse.toDomain(): PhotoLinks = PhotoLinks(
    self = this.self,
    html = this.html,
    download = this.download,
    downloadLocation = this.downloadLocation
)