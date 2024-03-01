package io.github.alaksion.unsplashwrapper.api.models.authorization.data

import io.github.alaksion.unsplashwrapper.api.models.authorization.domain.AuthorizationResult
import io.github.alaksion.unsplashwrapper.api.models.authorization.domain.AuthorizationScope
import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
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
)

internal fun AuthorizationResponse.toDomain() = AuthorizationResult(
    accessToken = this.token,
    createdAt = InstantWrapper(Instant.fromEpochMilliseconds(this.createdAt)),
    scopes = this.scope.split(" ")
        .map { AuthorizationScope.parseFromString(it) }
        .toImmutableSet()
)