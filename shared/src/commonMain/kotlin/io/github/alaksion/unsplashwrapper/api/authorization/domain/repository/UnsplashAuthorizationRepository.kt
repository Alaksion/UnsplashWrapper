package io.github.alaksion.unsplashwrapper.api.authorization.domain.repository

import io.github.alaksion.unsplashwrapper.api.authorization.domain.model.AuthorizationResult
import io.github.alaksion.unsplashwrapper.api.authorization.domain.model.AuthorizeDTO

internal interface UnsplashAuthorizationRepository {
    suspend fun authorize(data: AuthorizeDTO): AuthorizationResult
}