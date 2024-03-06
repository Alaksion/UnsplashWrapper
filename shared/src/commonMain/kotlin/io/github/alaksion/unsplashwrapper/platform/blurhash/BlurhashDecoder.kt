package io.github.alaksion.unsplashwrapper.platform.blurhash

expect class BlurhashDecoder() {

    fun decode(
        blurHash: String?,
        width: Int = 200,
        height: Int = 200,
        punch: Float = 1f,
        useCache: Boolean = true
    ): Blurhash
}