package io.github.alaksion.unsplashwrapper.api.models.photo.data.statistics

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics.PhotoStatistics
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics.PhotoStatisticsHistorical
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics.PhotoStatisticsItem
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics.PhotoStatisticsValue
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.toPersistentList
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoStatisticsResponse(
    val id: String,
    val downloads: PhotoStatisticsItemResponse,
    val views: PhotoStatisticsItemResponse,
    val likes: PhotoStatisticsItemResponse
)

internal fun PhotoStatisticsResponse.toDomain(): PhotoStatistics = PhotoStatistics(
    id = this.id,
    downloads = this.downloads.toDomain(),
    views = this.views.toDomain(),
    likes = this.likes.toDomain()
)

@Serializable
internal data class PhotoStatisticsItemResponse(
    val total: Int,
    val historical: PhotoStatisticsHistoricalResponse
)

internal fun PhotoStatisticsItemResponse.toDomain(): PhotoStatisticsItem = PhotoStatisticsItem(
    total = this.total,
    historical = this.historical.toDomain()
)

@Serializable
internal data class PhotoStatisticsHistoricalResponse(
    val change: Int,
    val resolution: PhotoStatisticsResolutionResponse,
    val quantity: Int,
    val values: List<PhotoStatisticsValueResponse>
)

internal fun PhotoStatisticsHistoricalResponse.toDomain(): PhotoStatisticsHistorical =
    PhotoStatisticsHistorical(
        change = this.change,
        resolution = this.resolution.toDomain(),
        quantity = this.quantity,
        values = this.values.map { it.toDomain() }.toPersistentList()
    )

@Serializable
internal data class PhotoStatisticsValueResponse(
    @Serializable(with = InstantIso8601Serializer::class)
    val date: Instant,
    val value: Int
)

internal fun PhotoStatisticsValueResponse.toDomain(): PhotoStatisticsValue = PhotoStatisticsValue(
    date = InstantWrapper(this.date),
    value = this.value
)
