package io.github.alaksion.unsplashwrapper.api.models.photo.domain.rate

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoUrls
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLinks
import io.github.alaksion.unsplashwrapper.platform.blurhash.Blurhash

data class RatePhoto(
    val ratedPhotoSummary: PhotoSummary,
    val ratedPhotoAuthor: AuthorSummary
)

data class PhotoSummary(
    val blurHash: Blurhash,
    val color: String,
    val description: String,
    val height: Int,
    val id: String,
    val likedByUser: Boolean,
    val likes: Int,
    val links: PhotoLinks,
    val urls: PhotoUrls,
    val width: Int
)

data class AuthorSummary(
    val id: String,
    val links: UserLinks,
    val name: String,
    val username: String
)
