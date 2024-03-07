package io.github.alaksion.unsplashwrapper.api.models.statistics.domain

import io.github.alaksion.unsplashwrapper.api.models.statistics.data.StatisticsResolutionResponse


enum class StatisticsResolution {

    Days;

    internal fun toData(): StatisticsResolutionResponse = when (this) {
        Days -> StatisticsResolutionResponse.Days
    }

}