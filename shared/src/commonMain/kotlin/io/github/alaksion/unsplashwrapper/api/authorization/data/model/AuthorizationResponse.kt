package io.github.alaksion.unsplashwrapper.api.authorization.data.model

import io.github.alaksion.unsplashwrapper.api.authorization.domain.model.AuthorizationResult
import io.github.alaksion.unsplashwrapper.api.authorization.domain.model.AuthorizationScopes
import kotlinx.collections.immutable.toImmutableSet
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AuthorizationResponse(
    @SerialName("access_token") val token: String,
    @SerialName("token_type") val tokenType: String,
    val scope: String,
    @SerialName("created_at") val createdAt: Long
) {
    fun toDomain(): AuthorizationResult = AuthorizationResult(
        accessToken = this.token,
        createdAt = Instant.fromEpochMilliseconds(this.createdAt),
        scopes = this.scope.split(" ")
            .map { AuthorizationScopes.parseFromString(it) }
            .toImmutableSet()
    )
}