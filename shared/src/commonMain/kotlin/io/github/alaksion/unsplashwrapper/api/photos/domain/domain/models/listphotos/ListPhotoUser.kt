package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos

data class ListPhotoUser(
    val id: String,
    val username: String,
    val name: String,
    val portfolioUrl: String?,
    val bio: String?,
    val location: String?,
    val totalLikes: Int,
    val totalPhotos: Int,
    val totalCollections: Int,
    val instagramUserName: String?,
    val twitterUsername: String?,
    val profileImage: ListPhotoUserProfilePicture,
    val links: ListPhotoUserLinks
)

data class ListPhotoUserLinks(
    val self: String,
    val html: String,
    val portfolio: String,
    val photos: String,
    val likes: String,
)


data class ListPhotoUserProfilePicture(
    val medium: String,
    val large: String,
    val small: String,
)
