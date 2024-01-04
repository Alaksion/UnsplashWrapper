package io.github.alaksion.unsplashwrapper

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform