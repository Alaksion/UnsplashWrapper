package io.github.alaksion.unsplashwrapper.api.models.user.data.profile


import io.github.alaksion.unsplashwrapper.api.models.user.data.UserLinksResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.UserProfilePictureResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.user.domain.profile.UserProfile
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserProfileResponse(
    val badge: UserBadgeResponse,
    val bio: String? = null,
    val downloads: Int,
    @SerialName("first_name") val firstName: String,
    @SerialName("followed_by_user") val followedByUser: Boolean,
    @SerialName("followers_count") val followersCount: Int,
    @SerialName("following_count") val followingCount: Int,
    val id: String,
    @SerialName("instagram_username") val instagramUsername: String,
    @SerialName("last_name") val lastName: String,
    val links: UserLinksResponse,
    val location: String? = null,
    val name: String,
    val portfolioUrl: String? = null,
    @SerialName("profile_image")
    val profileImage: UserProfilePictureResponse,
    val social: UserSocialResponse,
    @SerialName("total_collections") val totalCollections: Int,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("twitter_username") val twitterUsername: String? = null,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("updated_at") val updatedAt: Instant,
    val username: String
)

internal fun UserProfileResponse.toDomain(): UserProfile = UserProfile(
    badge = this.badge.toDomain(),
    bio = this.bio,
    downloads = this.downloads,
    firstName = this.firstName,
    followedByUser = this.followedByUser,
    followersCount = this.followersCount,
    followingCount = this.followingCount,
    id = this.id,
    lastName = this.lastName,
    links = this.links.toDomain(),
    location = this.location,
    name = this.name,
    profileImage = this.profileImage.toDomain(),
    social = this.social.toDomain(),
    totalCollections = this.totalCollections,
    totalLikes = this.totalLikes,
    totalPhotos = this.totalPhotos,
    updatedAt = InstantWrapper(this.updatedAt),
    username = this.username,
)