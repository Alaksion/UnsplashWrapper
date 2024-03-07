package io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics

import io.github.alaksion.unsplashwrapper.api.models.statistics.domain.StatisticsResolution
import io.github.alaksion.unsplashwrapper.api.models.statistics.domain.StatisticsValue
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
    val resolution: StatisticsResolution,
    val quantity: Int,
    val values: ImmutableList<StatisticsValue>
)
