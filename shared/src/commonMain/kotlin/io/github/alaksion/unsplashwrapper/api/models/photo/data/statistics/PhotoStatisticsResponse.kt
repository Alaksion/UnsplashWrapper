package io.github.alaksion.unsplashwrapper.api.models.photo.data.statistics

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

@Serializable
internal data class PhotoStatisticsItemResponse(
    val total: Int,
    val historical: PhotoStatisticsHistoricalResponse
)

@Serializable
internal data class PhotoStatisticsHistoricalResponse(
    val change: Int,
    val resolution: PhotoStatisticsResolutionResponse,
    val quantity: Int,
    val values: List<PhotoStatisticsValue>
)

@Serializable
internal data class PhotoStatisticsValue(
    @Serializable(with = InstantIso8601Serializer::class)
    val date: Instant,
    val value: Int
)

