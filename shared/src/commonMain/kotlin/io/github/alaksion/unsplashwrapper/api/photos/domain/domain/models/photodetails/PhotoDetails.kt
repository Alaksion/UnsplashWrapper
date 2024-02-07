package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.photodetails


import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoUrl
import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.Instant

data class PhotoDetails(
    val id: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val width: Int,
    val height: Int,
    val color: String,
    val blurHash: String,
    val downloads: Int,
    val likes: Int,
    val likedByUser: String,
    val isPublicDomain: Boolean,
    val description: String,
    val exif: PhotoExif,
    val location: PhotoLocation,
    val tags: ImmutableList<String>,
    val urls: PhotoUrl,
    val links: PhotoLinks,
    val author: Author
)

/*
* Exif stands for Exchangeable image file format. This is an industry standard specification for
* camera device metadata.
* https://pt.wikipedia.org/wiki/Exchangeable_image_file_format
* */
data class PhotoExif(
    val make: String,
    val model: String,
    val name: String,
    val exposureTime: String,
    val aperture: String, val focalLength: String,
    val iso: Int
)


data class PhotoLocation(
    val city: String,
    val country: String,
    val latitude: Double,
    val longitude: Double
)

data class Author(
    val id: String,
    val updatedAt: Instant,
    val username: String,
    val name: String,
    val portfolioUrl: String,
    val bio: String,
    val location: String,
    val totalLikes: Int,
    val totalPhotos: Int,
    val totalCollections: Int,
    val links: AuthorLinks
)

data class AuthorLinks(
    val self: String,
    val html: String,
    val portfolio: String,
    val photos: String,
    val likes: String,
)
