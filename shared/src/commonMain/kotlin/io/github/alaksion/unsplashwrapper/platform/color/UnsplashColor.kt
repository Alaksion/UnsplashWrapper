package io.github.alaksion.unsplashwrapper.platform.color

import androidx.compose.ui.graphics.Color

private const val RADIX = 16

@Suppress("MagicNumber", "SwallowedException", "TooGenericExceptionCaught")
data class UnsplashColor(
    val hex: String
) {
    val composeColor: Color = try {
        Color(parseColor(hex))
    } catch (e: Exception) {
        Color.White
    }
}

@Suppress("MagicNumber")
private fun parseColor(hexString: String): Int {
    require(hexString.isNotEmpty())
    require(hexString[0] == '#')

    // Use a long to avoid rollovers on #ffXXXXXX
    var color = hexString.substring(1).toLong(RADIX)
    if (hexString.length == 7) {
        // Set the alpha value
        color = color or 0x00000000ff000000L
    }
    require(hexString.length == 9)
    return color.toInt()

}
