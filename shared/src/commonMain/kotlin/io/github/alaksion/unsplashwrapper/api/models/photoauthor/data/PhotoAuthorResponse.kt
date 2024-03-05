package io.github.alaksion.unsplashwrapper.api.models.photoauthor.data

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthor
import io.github.alaksion.unsplashwrapper.api.models.user.data.UserLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.UserProfilePictureResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoAuthorResponse(
    val id: String,
    val username: String,
    val name: String,
    @SerialName("portfolio_url") val portfolioUrl: String? = null,
    val bio: String? = null,
    val location: String? = null,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("total_collections") val totalCollections: Int,
    @SerialName("instagram_username") val instagramUserName: String? = null,
    @SerialName("twitter_username") val twitterUsername: String? = null,
    @SerialName("profile_image") val profileImage: UserProfilePictureResponse,
    val links: UserLinksResponse,
)

internal fun PhotoAuthorResponse.toDomain(): PhotoAuthor = PhotoAuthor(
    id = this.id,
    username = this.username,
    name = this.name,
    portfolioUrl = this.portfolioUrl,
    bio = this.bio,
    location = this.location,
    totalLikes = this.totalLikes,
    totalPhotos = this.totalPhotos,
    totalCollections = this.totalCollections,
    instagramUserName = this.instagramUserName,
    twitterUsername = this.twitterUsername,
    profileImage = this.profileImage.toDomain(),
    links = this.links.toDomain(),
)
