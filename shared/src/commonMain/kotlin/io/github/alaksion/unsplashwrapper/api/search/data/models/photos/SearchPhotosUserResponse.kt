package io.github.alaksion.unsplashwrapper.api.search.data.models.photos

import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotoAuthor
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotoAuthorImage
import io.github.alaksion.unsplashwrapper.api.search.domain.models.photos.SearchedPhotoAuthorLinks
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchPhotosUserResponse(
    val id: String,
    val username: String,
    val name: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("instagram_username") val instagramUserName: String,
    @SerialName("twitter_username") val twitterUsername: String,
    @SerialName("portfolio_url") val portfolioUrl: String,
    @SerialName("profile_image") val profileImage: SearchPhotosUserImageResponse,
    val links: SearchPhotosUserLinksResponse
) {
    fun toDomain(): SearchedPhotoAuthor = SearchedPhotoAuthor(
        id = this.id,
        username = this.username,
        name = this.name,
        firstName = this.firstName,
        lastName = this.lastName,
        instagramUserName = this.instagramUserName,
        twitterUsername = this.twitterUsername,
        portfolioUrl = this.portfolioUrl,
        profileImage = this.profileImage.toDomain(),
        links = this.links.toDomain(),
    )
}

@Serializable
internal data class SearchPhotosUserImageResponse(
    val medium: String,
    val large: String,
    val small: String,
) {
    fun toDomain(): SearchedPhotoAuthorImage = SearchedPhotoAuthorImage(
        medium = this.medium,
        large = this.large,
        small = this.small
    )
}

@Serializable
internal data class SearchPhotosUserLinksResponse(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
) {
    fun toDomain(): SearchedPhotoAuthorLinks = SearchedPhotoAuthorLinks(
        self = this.self,
        html = this.html,
        photos = this.photos,
        likes = this.likes
    )
}