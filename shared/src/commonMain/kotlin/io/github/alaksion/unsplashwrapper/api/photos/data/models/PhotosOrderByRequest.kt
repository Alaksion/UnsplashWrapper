package io.github.alaksion.unsplashwrapper.api.photos.data.models

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoOrderBy
import kotlinx.serialization.Serializable

@Serializable
internal enum class PhotosOrderByRequest(
    val value: String
) {
    Latest("latest"),
    Oldest("oldest"),
    Popular("popular");
}

internal fun PhotoOrderBy.toData() = when (this) {
    PhotoOrderBy.Latest -> PhotosOrderByRequest.Latest
    PhotoOrderBy.Oldest -> PhotosOrderByRequest.Oldest
    PhotoOrderBy.Popular -> PhotosOrderByRequest.Popular
}