package io.github.alaksion.unsplashwrapper.api.authorization.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AuthorizationResponse(
    @SerialName("access_token") val token: String,
    @SerialName("token_type") val tokenType: String,
    val scope: String,
    @SerialName("created_at") val createdAt: Int
)
