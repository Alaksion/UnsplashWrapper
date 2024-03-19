package io.github.alaksion.unsplashwrapper.api.models.user.data

import io.github.alaksion.unsplashwrapper.api.models.user.domain.SearchUser
import io.github.alaksion.unsplashwrapper.api.models.user.domain.SearchUserItem
import kotlinx.collections.immutable.toPersistentList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchUserResponse(
    val total: Int,
    @SerialName("total_pages") val totalPages: Int,
    val results: List<SearchUserItemResponse>
)

internal fun SearchUserResponse.toDomain(): SearchUser = SearchUser(
    total = total,
    totalPages = this.totalPages,
    results = this.results.map { it.toDomain() }.toPersistentList()
)

@Serializable
internal data class SearchUserItemResponse(
    val id: String,
    val username: String,
    val name: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("instagram_username") val instagramUsername: String? = null,
    @SerialName("twitter_username") val twitterUsername: String? = null,
    @SerialName("portfolio_url") val portfolioUrl: String? = null,
    @SerialName("total_likes") val totalLikes: Int,
    @SerialName("total_photos") val totalPhotos: Int,
    @SerialName("total_collections") val totalCollections: Int,
    @SerialName("profile_image") val profilePicture: UserProfilePictureResponse,
    val links: UserLinksResponse
)

internal fun SearchUserItemResponse.toDomain(): SearchUserItem = SearchUserItem(
    id = this.id,
    username = this.username,
    name = this.name,
    firstName = this.firstName,
    lastName = this.lastName,
    instagramUsername = this.instagramUsername,
    twitterUsername = this.twitterUsername,
    portfolioUrl = this.portfolioUrl,
    totalLikes = this.totalLikes,
    totalPhotos = this.totalPhotos,
    totalCollections = this.totalCollections,
    profilePicture = this.profilePicture.toDomain(),
    links = this.links.toDomain(),
)
