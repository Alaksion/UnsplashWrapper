package io.github.alaksion.unsplashwrapper.api.photos.data.models.listphotos

import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoCollections
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotoUrl
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.listphotos.ListPhotos

internal object ListPhotosMapper {

    fun map(response: ListPhotosResponse): ListPhotos {
        return ListPhotos(
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
            linksResponse = linksMappers(response.linksResponse),
            currentUserCollections = response.currentUserCollections.map {
                collectionMapper(it)
            },
        )
    }

    private fun urlMapper(response: ListPhotoUrlResponse): ListPhotoUrl =
        ListPhotoUrl(
            raw = response.raw,
            full = response.full,
            regular = response.regular,
            small = response.small,
            thumb = response.thumb,
        )

    private fun linksMappers(response: ListPhotoLinksResponse): ListPhotoLinks =
        ListPhotoLinks(
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
