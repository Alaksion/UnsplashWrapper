package io.github.alaksion.unsplashwrapper.api.models.user.domain

import io.github.alaksion.unsplashwrapper.api.models.parameters.PhotoOrientation

data class UserPhotosParameters(
    val page: Int,
    val perPage: Int,
    val orderBy: UserPhotosOrderBy = UserPhotosOrderBy.Latest,
    val orientation: PhotoOrientation? = null
)

enum class UserPhotosOrderBy(
    internal val value: String
) {
    Latest("latest"),
    Oldest("oldest"),
    Popular("popular"),
    Views("views"),
    Downloads("downloads");
}
