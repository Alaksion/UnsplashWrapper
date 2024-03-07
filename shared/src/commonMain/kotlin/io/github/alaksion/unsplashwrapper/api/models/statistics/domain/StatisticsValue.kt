package io.github.alaksion.unsplashwrapper.api.models.statistics.domain

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper

data class StatisticsValue(
    val date: InstantWrapper,
    val value: Int
)