package io.github.alaksion.unsplashwrapper.api.models.photo.domain.statistics

import io.github.alaksion.unsplashwrapper.api.models.photo.data.statistics.PhotoStatisticsResolutionResponse


enum class PhotoStatisticsResolution {

    Days;

    internal fun toData(): PhotoStatisticsResolutionResponse = when (this) {
        Days -> PhotoStatisticsResolutionResponse.Days
    }

}