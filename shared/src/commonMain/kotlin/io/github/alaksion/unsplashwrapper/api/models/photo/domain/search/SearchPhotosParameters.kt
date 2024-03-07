package io.github.alaksion.unsplashwrapper.api.models.photo.domain.search

import io.github.alaksion.unsplashwrapper.api.models.parameters.PhotoOrientation

public data class SearchPhotosParameters(
    val query: String,
    val page: Int = 0,
    val perPage: Int = 10,
    val orderBy: SearchPhotosOrderBy = SearchPhotosOrderBy.Relevant,
    val contentFilter: SearchPhotosContentFilter = SearchPhotosContentFilter.Low,
    val color: SearchPhotosColor? = null,
    val orientation: PhotoOrientation? = null

)

public enum class SearchPhotosOrderBy(
    internal val primitiveValue: String
) {
    Latest("latest"),
    Relevant("relevant");
}

public enum class SearchPhotosContentFilter(
    internal val primitiveValue: String,
) {
    Low("low"),
    High("high");
}

public enum class SearchPhotosColor(
    internal val primitiveValue: String,
) {
    BlackAndWhite("black_and_white"),
    Black("black"),
    White("white"),
    Yellow("yellow"),
    Orange("orange"),
    Red("red"),
    Purple("purple"),
    Magenta("magenta"),
    Green("green"),
    Teal("teal"),
    Blue("blue");
}

