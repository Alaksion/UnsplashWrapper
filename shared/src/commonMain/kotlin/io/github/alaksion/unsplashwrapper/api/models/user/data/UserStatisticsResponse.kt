package io.github.alaksion.unsplashwrapper.api.models.user.data

import io.github.alaksion.unsplashwrapper.api.models.statistics.data.StatisticsResolutionResponse
import io.github.alaksion.unsplashwrapper.api.models.statistics.data.StatisticsValueResponse
import kotlinx.serialization.Serializable

@Serializable
internal data class UserStatisticsResponse(
    val username: String,
    val downloads: UserStatisticsItemResponse,
    val views: UserStatisticsItemResponse
)

@Serializable
internal data class UserStatisticsItemResponse(
    val total: Int,
    val historical: UserStatisticsItemHistoricalResponse
)

@Serializable
internal data class UserStatisticsItemHistoricalResponse(
    val change: Int,
    val average: Int,
    val resolution: StatisticsResolutionResponse,
    val quantity: Int,
    val values: List<StatisticsValueResponse>
)
