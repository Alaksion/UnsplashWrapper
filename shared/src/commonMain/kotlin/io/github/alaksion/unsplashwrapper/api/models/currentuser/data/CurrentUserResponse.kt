package io.github.alaksion.unsplashwrapper.api.models.currentuser.data


import io.github.alaksion.unsplashwrapper.api.models.currentuser.domain.CurrentUser
import io.github.alaksion.unsplashwrapper.api.models.user.data.UserLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CurrentUserResponse(
    val bio: String? = null,
    val downloads: Int,
    val email: String? = null,
    @SerialName("first_name") val firstName: String,
    @SerialName("followed_by_user") val followedByUser: Boolean,
    val id: String,
    @SerialName("instagram_username") val instagramUsername: String? = null,
    @SerialName("last_name") val lastName: String,
    val currentUserLinksResponse: UserLinksResponse,
    val location: String? = null,
    @SerialName("portfolio_url") val portfolioUrl: String? = null,
    @SerialName("total_collections") val totalCollections: Int,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos")
    val totalPhotos: Int,
    @SerialName("twitter_username") val twitterUsername: String? = null,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("updated_at") val updatedAt: Instant,
    @SerialName("uploads_remaining") val uploadsRemaining: Int? = null,
    val username: String
)

internal fun CurrentUserResponse.toDomain(): CurrentUser = CurrentUser(
    bio = this.bio,
    downloads = this.downloads,
    email = this.email,
    firstName = this.firstName,
    followedByUser = this.followedByUser,
    id = this.id,
    instagramUsername = this.instagramUsername,
    lastName = this.lastName,
    currentUserLinksResponse = this.currentUserLinksResponse.toDomain(),
    location = this.location,
    portfolioUrl = this.portfolioUrl,
    totalCollections = this.totalCollections,
    totalLikes = this.totalLikes,
    totalPhotos = this.totalPhotos,
    twitterUsername = this.twitterUsername,
    updatedAt = InstantWrapper(this.updatedAt),
    uploadsRemaining = this.uploadsRemaining,
    username = this.username,
)
