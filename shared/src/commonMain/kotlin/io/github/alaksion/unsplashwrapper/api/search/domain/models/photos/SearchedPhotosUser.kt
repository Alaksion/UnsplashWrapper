package io.github.alaksion.unsplashwrapper.api.search.domain.models.photos

data class SearchedPhotoAuthor(
    val id: String,
    val username: String,
    val name: String,
    val firstName: String,
    val lastName: String,
    val instagramUserName: String,
    val twitterUsername: String,
    val portfolioUrl: String,
    val profileImage: SearchedPhotoAuthorImage,
    val links: SearchedPhotoAuthorLinks
)

data class SearchedPhotoAuthorImage(
    val medium: String,
    val large: String,
    val small: String,
)

data class SearchedPhotoAuthorLinks(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
)