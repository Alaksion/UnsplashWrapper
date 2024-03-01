package io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models


import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoAuthor
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoExif
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoLocation
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoTag
import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.PhotoUrl
import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableList

data class PhotoDetails(
    val id: String,
    val createdAt: InstantWrapper,
    val updatedAt: InstantWrapper,
    val width: Int,
    val height: Int,
    val color: UnsplashColor,
    val blurHash: String,
    val downloads: Int,
    val likes: Int,
    val likedByUser: Boolean,
    val isPublicDomain: Boolean,
    val description: String?,
    val exif: PhotoExif,
    val location: PhotoLocation,
    val tags: ImmutableList<PhotoTag>,
    val urls: PhotoUrl,
    val links: PhotoLinks,
    val author: PhotoAuthor
)


