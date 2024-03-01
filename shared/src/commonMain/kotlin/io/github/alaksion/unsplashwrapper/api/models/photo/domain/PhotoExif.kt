package io.github.alaksion.unsplashwrapper.api.models.photo.domain

/*
* Exif stands for Exchangeable image file format. This is an industry standard specification for
* camera device metadata.
* https://pt.wikipedia.org/wiki/Exchangeable_image_file_format
* */

data class PhotoExif(
    val make: String?,
    val model: String?,
    val name: String?,
    val exposureTime: String?,
    val aperture: String?,
    val focalLength: String,
    val iso: Int?
)