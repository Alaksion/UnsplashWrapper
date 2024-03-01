package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models

data class RatePhoto(
    val ratedPhotoSummary: PhotoSummary,
    val ratedPhotoAuthor: AuthorSummary
)

data class PhotoSummary(
    val blurHash: String,
    val color: String,
    val description: String,
    val height: Int,
    val id: String,
    val likedByUser: Boolean,
    val likes: Int,
    val links: PhotoLinks,
    val urls: PhotoUrl,
    val width: Int
)

data class AuthorSummary(
    val id: String,
    val links: PhotoAuthorLinks,
    val name: String,
    val username: String
)
