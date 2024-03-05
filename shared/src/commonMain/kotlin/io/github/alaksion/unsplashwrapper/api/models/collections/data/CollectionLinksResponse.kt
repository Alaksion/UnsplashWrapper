package io.github.alaksion.unsplashwrapper.api.models.collections.data

import kotlinx.serialization.Serializable

@Serializable
internal data class CollectionLinksResponse(
    val self: String,
    val html: String,
    val photos: String,
    val related: String
)
