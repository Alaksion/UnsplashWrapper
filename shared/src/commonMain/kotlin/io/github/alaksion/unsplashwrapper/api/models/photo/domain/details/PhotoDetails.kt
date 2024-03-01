package io.github.alaksion.unsplashwrapper.api.models.photo.domain.details


import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoExif
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLinks
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoLocation
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoTag
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.PhotoUrls
import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoDetailsAuthor
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
    val urls: PhotoUrls,
    val links: PhotoLinks,
    val author: PhotoDetailsAuthor
)


