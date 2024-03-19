package io.github.alaksion.unsplashwrapper.api.models.parameters

public enum class PhotoOrientation(
    internal val primitiveValue: String,
) {
    Landscape("landscape"),
    Portrait("portrait"),
    Squarish("squarish");
}
