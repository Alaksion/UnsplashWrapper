package io.github.alaksion.unsplashwrapper.api.models.user.domain

import io.github.alaksion.unsplashwrapper.api.models.statistics.domain.StatisticsResolution
import io.github.alaksion.unsplashwrapper.api.models.statistics.domain.StatisticsValue
import kotlinx.collections.immutable.ImmutableList

data class UserStatistics(
    val username: String,
    val downloads: UserStatisticsItem,
    val views: UserStatisticsItem
)

data class UserStatisticsItem(
    val total: Int,
    val historical: UserStatisticsItemHistorical
)

data class UserStatisticsItemHistorical(
    val change: Int,
    val average: Int,
    val resolution: StatisticsResolution,
    val quantity: Int,
    val values: ImmutableList<StatisticsValue>
)
