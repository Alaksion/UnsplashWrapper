package io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableList

data class PhotoStatistics(
    val id: String,
    val downloads: PhotoStatisticsItem,
    val views: PhotoStatisticsItem,
    val likes: PhotoStatisticsItem
)

data class PhotoStatisticsItem(
    val total: Int,
    val historical: PhotoStatisticsHistorical
)

data class PhotoStatisticsHistorical(
    val change: Int,
    val resolution: PhotoStatisticsResolution,
    val quantity: Int,
    val values: ImmutableList<PhotoStatisticsValue>
)

data class PhotoStatisticsValue(
    val date: InstantWrapper,
    val value: Int
)
