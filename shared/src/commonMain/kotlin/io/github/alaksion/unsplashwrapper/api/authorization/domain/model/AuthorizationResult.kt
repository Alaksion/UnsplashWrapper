package io.github.alaksion.unsplashwrapper.api.authorization.domain.model

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.datetime.Instant

data class AuthorizationResult(
    val accessToken: String,
    val scopes: ImmutableSet<AuthorizationScope>,
    val createdAt: Instant
)
