package io.github.alaksion.unsplashwrapper.api.models.statistics.data

import io.github.alaksion.unsplashwrapper.api.models.statistics.domain.StatisticsValue
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.Serializable

@Serializable
internal data class StatisticsValueResponse(
    @Serializable(with = InstantIso8601Serializer::class)
    val date: Instant,
    val value: Int
)

internal fun StatisticsValueResponse.toDomain(): StatisticsValue = StatisticsValue(
    date = InstantWrapper(this.date),
    value = this.value
)