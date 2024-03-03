package io.github.alaksion.unsplashwrapper.api.models.photo.data.statistics

import io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics.PhotoStatisticsResolution
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class PhotoStatisticsResolutionResponse(
    val value: String
) {

    @SerialName("days")
    Days("days");

    fun toDomain() = when (this) {
        Days -> PhotoStatisticsResolution.Days
    }

}