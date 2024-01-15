package io.github.alaksion.unsplashwrapper.api.photos.data.models

import kotlinx.serialization.Serializable

@Serializable
internal enum class PhotosOrderByRequest(
    val value: String
) {
    Latest("latest"),
    Oldest("oldest"),
    Popular("popular");
}