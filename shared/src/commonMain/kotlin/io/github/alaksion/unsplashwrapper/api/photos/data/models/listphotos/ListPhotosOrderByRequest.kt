package io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoOrderBy
import kotlinx.serialization.Serializable

@Serializable
internal enum class ListPhotosOrderByRequest(
    val value: String
) {
    Latest("latest"),
    Oldest("oldest"),
    Popular("popular");
}

internal fun ListPhotoOrderBy.toData() = when (this) {
    ListPhotoOrderBy.Latest -> ListPhotosOrderByRequest.Latest
    ListPhotoOrderBy.Oldest -> ListPhotosOrderByRequest.Oldest
    ListPhotoOrderBy.Popular -> ListPhotosOrderByRequest.Popular
}
