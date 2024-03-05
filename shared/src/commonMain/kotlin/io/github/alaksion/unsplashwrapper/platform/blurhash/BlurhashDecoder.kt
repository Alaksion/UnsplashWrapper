package io.github.alaksion.unsplashwrapper.platform.blurhash

expect class BlurhashDecoder {

    fun decode(
        blurHash: String?,
        width: Int,
        height: Int,
        punch: Float = 1f,
        useCache: Boolean = true
    ): Blurhash
}