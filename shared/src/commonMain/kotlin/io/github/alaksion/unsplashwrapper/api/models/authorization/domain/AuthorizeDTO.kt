package io.github.alaksion.unsplashwrapper.api.models.authorization.domain

data class AuthorizeDTO(
    val redirectUri: String,
    val code: String,
)
