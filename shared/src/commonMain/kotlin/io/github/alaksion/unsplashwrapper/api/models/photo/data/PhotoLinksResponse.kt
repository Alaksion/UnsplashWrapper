package io.github.alaksion.unsplashwrapper.api.models.photo.data

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLinks
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoLinksResponse(
    val self: String,
    val html: String,
    val download: String,
    @SerialName("download_location") val downloadLocation: String? = null,
)

internal fun PhotoLinksResponse.toDomain(): PhotoLinks = PhotoLinks(
    self = this.self,
    html = this.html,
    download = this.download,
    downloadLocation = this.downloadLocation
)