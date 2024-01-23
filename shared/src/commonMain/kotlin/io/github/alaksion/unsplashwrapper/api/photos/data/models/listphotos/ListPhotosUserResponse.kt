package io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.data.models.photouser.PhotoUserLinksResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ListPhotoUserResponse(
    val id: String,
    val username: String,
    val name: String,
    @SerialName("portfolio_url") val portfolioUrl: String,
    val bio: String,
    val location: String,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("total_collections") val totalCollections: Int,
    @SerialName("instagram_username") val instagramUserName: String,
    @SerialName("twitter_username") val twitterUsername: String,
    @SerialName("profile_image") val profileImage: ListPhotoUserProfilePictureResponse,
    val links: PhotoUserLinksResponse,
)

@Serializable
internal data class ListPhotoUserProfilePictureResponse(
    val medium: String,
    val large: String,
    val small: String,
)