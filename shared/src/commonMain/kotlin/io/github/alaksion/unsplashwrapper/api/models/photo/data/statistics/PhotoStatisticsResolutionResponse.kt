package io.github.alaksion.unsplashwrapper.api.models.photo.data.statistics

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class PhotoStatisticsResolutionResponse(
    val value: String
) {

    @SerialName("days")
    Days("days");

}