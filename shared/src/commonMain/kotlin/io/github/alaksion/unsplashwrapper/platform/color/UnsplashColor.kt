package io.github.alaksion.unsplashwrapper.platform.color

import androidx.compose.ui.graphics.Color

data class UnsplashColor(
    val hex: String
) {
    val composeColor: Color
        get() {
            return try {
                Color(hex.replace("#", "0xff").toInt())
            } catch (e: Throwable) {
                Color.White
            }
        }
}
