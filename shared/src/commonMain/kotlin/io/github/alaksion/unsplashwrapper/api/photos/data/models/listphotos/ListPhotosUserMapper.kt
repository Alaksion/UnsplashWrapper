package io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoUser
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoUserLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoUserProfilePicture

internal object ListPhotosUserMapper {

    fun map(response: ListPhotoUserResponse): ListPhotoUser = ListPhotoUser(
        id = response.id,
        username = response.username,
        name = response.name,
        portfolioUrl = response.portfolioUrl,
        bio = response.bio,
        location = response.location,
        totalLikes = response.totalLikes,
        totalPhotos = response.totalPhotos,
        totalCollections = response.totalCollections,
        instagramUserName = response.instagramUserName,
        twitterUsername = response.twitterUsername,
        profileImage = profileImageMapper(response.profileImage),
        links = linksMapper(response.links),
    )

    private fun profileImageMapper(response: ListPhotoUserProfilePictureResponse): ListPhotoUserProfilePicture =
        ListPhotoUserProfilePicture(
            medium = response.medium,
            large = response.large,
            small = response.small,
        )

    private fun linksMapper(response: ListPhotoUserLinksResponse): ListPhotoUserLinks =
        ListPhotoUserLinks(
            self = response.self,
            html = response.html,
            portfolio = response.portfolio,
            photos = response.photos,
            likes = response.likes,
        )

}
