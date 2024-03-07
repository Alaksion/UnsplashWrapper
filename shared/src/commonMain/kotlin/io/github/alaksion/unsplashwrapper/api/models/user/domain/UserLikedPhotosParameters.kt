package io.github.alaksion.unsplashwrapper.api.models.user.domain

import io.github.alaksion.unsplashwrapper.api.models.parameters.PhotoOrientation

data class UserLikedPhotosParameters(
    val page: Int,
    val perPage: Int,
    val orderBy: UserLikedPhotosOrderBy = UserLikedPhotosOrderBy.Latest,
    val orientation: PhotoOrientation? = null
)

enum class UserLikedPhotosOrderBy(
    internal val value: String
) {
    Latest("latest"),
    Oldest("oldest"),
    Popular("popular");
}
