package io.github.alaksion.unsplashwrapper.platform.error

import kotlinx.serialization.Serializable

abstract class UnsplashError : Throwable() {
    abstract val errors: List<String>
}

data class HttpError(
    val statusCode: Int,
    override val errors: List<String>
) : UnsplashError()

data class SerializationError(
    override val errors: List<String>
) : UnsplashError()

data class Unknown(
    override val errors: List<String>,
    override val cause: Throwable
) : UnsplashError()

@Serializable
internal data class UnsplashRemoteError(
    val errors: List<String> = listOf()
)