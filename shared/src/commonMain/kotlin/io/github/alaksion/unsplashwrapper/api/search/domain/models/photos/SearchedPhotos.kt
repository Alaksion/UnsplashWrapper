package io.github.alaksion.unsplashwrapper.api.search.domain.models.photos

import io.github.alaksion.unsplashwrapper.platform.color.UnsplashColor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.Instant

data class SearchedPhotos(
    val resultsCount: Int,
    val totalPages: Int,
    val results: ImmutableList<SearchedPhotosItem>
)

data class SearchedPhotosItem(
    val id: String,
    val createdAt: InstantWrapper,
    val width: Int,
    val height: Int,
    val color: UnsplashColor,
    val blurHash: String,
    val likes: Int,
    val likedByUser: String,
    val description: String,
    val user: SearchedPhotoAuthor,
    val urlResponse: SearchedPhotoUrls,
    val links: SearchedPhotosLinks
)

data class SearchedPhotoUrls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)

data class SearchedPhotosLinks(
    val self: String,
    val html: String,
    val download: String,
)


