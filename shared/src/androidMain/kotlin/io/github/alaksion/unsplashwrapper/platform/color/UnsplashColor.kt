package io.github.alaksion.unsplashwrapper.platform.color

import androidx.compose.ui.graphics.Color

actual data class UnsplashColor actual constructor(
    val hex: String
) {
    fun toComposeColor(): Color {
        val transform = this.hex.replace("#", "0xff")
        return Color(transform.toInt())
    }
}
