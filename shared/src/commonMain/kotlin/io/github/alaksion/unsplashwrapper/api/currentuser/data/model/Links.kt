package io.github.alaksion.unsplashwrapper.api.currentuser.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("html")
    val html: String,
    @SerialName("likes")
    val likes: String,
    @SerialName("photos")
    val photos: String,
    @SerialName("portfolio")
    val portfolio: String,
    @SerialName("self")
    val self: String
)