package io.github.alaksion.unsplashwrapper.api.models.collections.domain

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableList

data class SearchCollections(
    val total: Int,
    val totalPages: Int,
    val results: ImmutableList<SearchCollectionItem>
)

data class SearchCollectionItem(
    val id: String,
    val title: String,
    val description: String? = null,
    val publishedAt: InstantWrapper,
    val lastCollectedAt: InstantWrapper,
    val updatedAt: InstantWrapper,
    val featured: Boolean,
    val totalPhotos: Int,
    val private: Boolean,
    val shareKey: String,
    val coverPhotoResponse: CollectionCoverPhoto,
    val user: PhotoAuthor,
    val links: CollectionLinks
)

