package io.github.alaksion.unsplashwrapper.api.models.user.data

import io.github.alaksion.unsplashwrapper.api.models.statistics.data.StatisticsResolutionResponse
import io.github.alaksion.unsplashwrapper.api.models.statistics.data.StatisticsValueResponse
import io.github.alaksion.unsplashwrapper.api.models.statistics.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserStatistics
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserStatisticsItem
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserStatisticsItemHistorical
import kotlinx.serialization.Serializable

@Serializable
internal data class UserStatisticsResponse(
    val username: String,
    val downloads: UserStatisticsItemResponse,
    val views: UserStatisticsItemResponse
)

internal fun UserStatisticsResponse.toDomain(): UserStatistics = UserStatistics(
    username = this.username,
    downloads = this.downloads.toDomain(),
    views = this.views.toDomain()
)

@Serializable
internal data class UserStatisticsItemResponse(
    val total: Int,
    val historical: UserStatisticsItemHistoricalResponse
)

internal fun UserStatisticsItemResponse.toDomain(): UserStatisticsItem = UserStatisticsItem(
    total = this.total,
    historical = this.historical.toDomain()
)

@Serializable
internal data class UserStatisticsItemHistoricalResponse(
    val change: Int,
    val average: Int,
    val resolution: StatisticsResolutionResponse,
    val quantity: Int,
    val values: List<StatisticsValueResponse>
)

internal fun UserStatisticsItemHistoricalResponse.toDomain(): UserStatisticsItemHistorical =
    UserStatisticsItemHistorical(
        change = this.change,
        average = this.average,
        resolution = this.resolution.toDomain(),
        quantity = this.quantity,
        values = this.values.map { it.toDomain() }
    )
