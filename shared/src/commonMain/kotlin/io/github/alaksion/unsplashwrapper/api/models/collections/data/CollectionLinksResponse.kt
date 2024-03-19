package io.github.alaksion.unsplashwrapper.api.models.collections.data

import io.github.alaksion.unsplashwrapper.api.models.collections.domain.CollectionLinks
import kotlinx.serialization.Serializable

@Serializable
internal data class CollectionLinksResponse(
    val self: String,
    val html: String,
    val photos: String,
    val related: String
)

internal fun CollectionLinksResponse.toDomain(): CollectionLinks = CollectionLinks(
    self = this.self,
    html = this.html,
    photos = this.photos,
    related = this.related
)
