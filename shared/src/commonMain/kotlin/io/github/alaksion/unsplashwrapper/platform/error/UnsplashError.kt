package io.github.alaksion.unsplashwrapper.platform.error

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable

abstract class UnsplashError : Throwable() {
    abstract val errors: ImmutableList<String>
}

data class HttpError(
    val statusCode: Int,
    override val errors: ImmutableList<String>
) : UnsplashError()

data class Unknown(
    override val errors: ImmutableList<String>,
    override val cause: Throwable
) : UnsplashError()

data class BasicError(override val errors: ImmutableList<String>) : UnsplashError()

@Serializable
internal data class UnsplashRemoteError(
    val errors: List<String> = listOf()
)

fun basicError(messages: String): Nothing = throw BasicError(persistentListOf(messages))
