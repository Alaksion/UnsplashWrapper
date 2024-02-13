package io.github.alaksion.unsplashwrapper.api.authorization.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AuthorizationRequest(
    @SerialName("client_id") val clientId: String,
    @SerialName("secret_key") val secretKey: String,
    @SerialName("redirect_uri") val redirectUri: String,
    val code: String,
    @SerialName("grant_type") val grantType: String = "authorization_code"
)
