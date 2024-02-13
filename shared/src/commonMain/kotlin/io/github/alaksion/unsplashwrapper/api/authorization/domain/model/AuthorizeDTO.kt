package io.github.alaksion.unsplashwrapper.api.authorization.domain.model

data class AuthorizeDTO(
    val redirectUri: String,
    val code: String,
)
