package io.github.alaksion.unsplashwrapper.api.models.statistics.data

import io.github.alaksion.unsplashwrapper.api.models.statistics.domain.StatisticsResolution
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class StatisticsResolutionResponse(
    val value: String
) {

    @SerialName("days")
    Days("days");

    fun toDomain() = when (this) {
        Days -> StatisticsResolution.Days
    }

}