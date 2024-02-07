package io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoLinksResponse
import io.github.alaksion.unsplashwrapper.api.photos.data.models.PhotoUrlResponse
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoUrl
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhoto
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoCollections

internal object ListPhotosMapper {

    fun map(response: ListPhotosResponse): ListPhoto {
        return ListPhoto(
            id = response.id,
            createdAt = response.createdAt,
            updatedAt = response.updatedAt,
            width = response.width,
            height = response.height,
            color = response.color,
            blurHash = response.blurHash,
            likes = response.likes,
            likedByUser = response.likedByUser,
            description = response.description,
            user = ListPhotosUserMapper.map(response.user),
            urls = urlMapper(response.urls),
            links = linksMappers(response.links),
            currentUserCollections = response.currentUserCollections.map {
                collectionMapper(it)
            },
        )
    }

    private fun urlMapper(response: PhotoUrlResponse): PhotoUrl =
        PhotoUrl(
            raw = response.raw,
            full = response.full,
            regular = response.regular,
            small = response.small,
            thumb = response.thumb,
        )

    private fun linksMappers(response: PhotoLinksResponse): PhotoLinks =
        PhotoLinks(
            self = response.self,
            html = response.html,
            download = response.download,
            downloadLocation = response.downloadLocation,
        )

    private fun collectionMapper(response: ListPhotoCollectionsResponse): ListPhotoCollections =
        ListPhotoCollections(
            id = response.id,
            title = response.title,
            publishedAt = response.publishedAt,
            lastCollectedAt = response.lastCollectedAt,
            updatedAt = response.updatedAt,
            coverPhoto = response.coverPhoto,
        )

}
