package io.github.alaksion.unsplashwrapper.platform.color

import androidx.compose.ui.graphics.Color

data class UnsplashColor(
    val hex: String
) {
    val composeColor: Color = try {
        Color(parseColor(hex))
    } catch (e: Throwable) {
        Color.White
    }
}

private fun parseColor(hexString: String): Int {
    require(hexString.isNotEmpty())

    if (hexString[0] != '#') {
        throw IllegalArgumentException("Invalid ehx string")
    }
    // Use a long to avoid rollovers on #ffXXXXXX
    var color = hexString.substring(1).toLong(16)
    if (hexString.length == 7) {
        // Set the alpha value
        color = color or 0x00000000ff000000L
    } else if (hexString.length != 9) {
        throw IllegalArgumentException("Unknown color")
    }
    return color.toInt()

}
