package io.github.alaksion.unsplashwrapper.api.currentuser.domain

import io.github.alaksion.unsplashwrapper.api.currentuser.domain.model.CurrentUser

interface UnsplashCurrentUserRepository {

    suspend fun getCurrentUser(): CurrentUser
}