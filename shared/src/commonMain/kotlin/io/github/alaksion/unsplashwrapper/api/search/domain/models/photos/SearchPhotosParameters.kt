package io.github.alaksion.unsplashwrapper.api.search.domain.models.photos

public data class SearchPhotosParametersRequest(
    val query: String,
    val page: Int = 0,
    val perPage: Int = 10,
    val orderBy: SearchPhotosOrderBy = SearchPhotosOrderBy.Relevant,
    val contentFilter: SearchPhotosContentFilter = SearchPhotosContentFilter.Low,
    val color: SearchPhotosColor? = null,
    val orientation: SearchPhotosOrientation? = null

)

public enum class SearchPhotosOrderBy(
    val primitiveValue: String
) {
    Latest("latest"),
    Relevant("relevant");
}

public enum class SearchPhotosContentFilter(
    val primitiveValue: String,
) {
    Low("low"),
    High("high");
}

public enum class SearchPhotosColor(
    val primitiveValue: String,
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

public enum class SearchPhotosOrientation(
    val primitiveValue: String,
) {
    Landscape("landscape"),
    Portrait("portrait"),
    Squarish("squarish");
}