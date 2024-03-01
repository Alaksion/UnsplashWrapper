package io.github.alaksion.unsplashwrapper.api.models.photo.data

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoExif
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
* Exif stands for Exchangeable image file format. This is an industry standard specification for
* camera device metadata.
* https://pt.wikipedia.org/wiki/Exchangeable_image_file_format
* */
@Serializable
internal data class PhotoExifResponse(
    val make: String? = null,
    val model: String? = null,
    val name: String? = null,
    @SerialName("exposure_time") val exposureTime: String? = null,
    val aperture: String? = null,
    @SerialName("focal_length") val focalLength: String,
    val iso: Int? = null
)

internal fun PhotoExifResponse.toDomain(): PhotoExif = PhotoExif(
    make = this.make,
    model = this.model,
    name = this.name,
    exposureTime = this.exposureTime,
    aperture = this.aperture,
    focalLength = this.focalLength,
    iso = this.iso,
)