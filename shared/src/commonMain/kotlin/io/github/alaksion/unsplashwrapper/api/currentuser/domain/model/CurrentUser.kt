package io.github.alaksion.unsplashwrapper.api.currentuser.domain.model

import io.github.alaksion.unsplashwrapper.api.currentuser.data.model.Links
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CurrentUser(
    val bio: String,
    val downloads: Int,
    val email: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("followed_by_user") val followedByUser: Boolean,
    val id: String,
    @SerialName("instagram_username") val instagramUsername: String,
    @SerialName("last_name") val lastName: String,
    val links: Links,
    val location: String? = null,
    @SerialName("portfolio_url") val portfolioUrl: String? = null,
    @SerialName("total_collections") val totalCollections: Int,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos")
    val totalPhotos: Int,
    @SerialName("twitter_username") val twitterUsername: String,
    @Serializable(with = InstantIso8601Serializer::class)
    @SerialName("updated_at") val updatedAt: Instant,
    @SerialName("uploads_remaining") val uploadsRemaining: Int,
    val username: String
)
