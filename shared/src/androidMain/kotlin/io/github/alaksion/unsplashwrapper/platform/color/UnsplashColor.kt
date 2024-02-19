package io.github.alaksion.unsplashwrapper.platform.color

import androidx.compose.ui.graphics.Color

fun UnsplashColor.toComposeColor(): Color {
    val transform = this.hex.replace("#", "0xff")
    return Color(transform.toInt())
}