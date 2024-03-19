package io.github.alaksion.unsplashwrapper.api.models.collections.domain

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthor
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class UserCollections(
    val id: String,
    val title: String,
    val description: String? = null,
    val publishedAt: InstantWrapper,
    val lastCollectedAt: InstantWrapper,
    val updatedAt: InstantWrapper,
    val totalPhotos: Int,
    val private: Boolean,
    val coverPhoto: CollectionCoverPhoto,
    val user: PhotoAuthor,
    val links: CollectionLinks
)
