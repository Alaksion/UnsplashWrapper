package io.github.alaksion.unsplashwrapper.api.models.authorization.domain

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableSet

data class AuthorizationResult(
    val accessToken: String,
    val scopes: ImmutableSet<AuthorizationScope>,
    val createdAt: InstantWrapper
)
