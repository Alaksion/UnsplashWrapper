package io.github.alaksion.unsplashwrapper.api.authorization.domain.model

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.datetime.Instant

data class AuthorizationResult(
    val accessToken: String,
    val scopes: ImmutableSet<AuthorizationScope>,
    val createdAt: InstantWrapper
)
