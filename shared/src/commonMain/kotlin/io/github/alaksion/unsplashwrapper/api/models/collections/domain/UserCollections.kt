package io.github.alaksion.unsplashwrapper.api.models.collections.domain

import io.github.alaksion.unsplashwrapper.api.models.photoauthor.domain.PhotoAuthor
import kotlinx.datetime.Instant

data class UserCollections(
    val id: String,
    val title: String,
    val description: String? = null,
    val publishedAt: Instant,
    val lastCollectedAt: Instant,
    val updatedAt: Instant,
    val totalPhotos: Int,
    val private: Boolean,
    val coverPhoto: CollectionCoverPhoto,
    val user: PhotoAuthor,
    val links: CollectionLinks
)
