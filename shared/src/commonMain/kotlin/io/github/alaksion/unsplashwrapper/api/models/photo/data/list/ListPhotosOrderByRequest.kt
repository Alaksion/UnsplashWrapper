package io.github.alaksion.unsplashwrapper.api.models.photo.data.list

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.list.ListPhotoOrderBy
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
