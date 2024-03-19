package io.github.alaksion.unsplashwrapper.platform.color

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UIntVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.Foundation.NSScanner
import platform.Foundation.scanHexInt
import platform.UIKit.UIColor

/*
* Copy & pasted from here: https://stackoverflow.com/questions/62703813/hex-color-function-for-ios-in-kotlin-multiplatform
* */

@Suppress("All")
actual data class UnsplashColor actual constructor(
    val hex: String
) {
    @OptIn(ExperimentalForeignApi::class)
    fun UnsplashColor.toUIColor(hexStr: String): UIColor {
        var cString: String = hexStr.toUpperCase()

        if (cString.startsWith("#")) {
            cString = cString.removePrefix("#")
        }

        if (cString.length != 8) {
            return UIColor.grayColor
        }

        var a: UInt
        var r: UInt
        var g: UInt
        var b: UInt

        memScoped {
            val scanner = NSScanner(cString)
            var pointed: UIntVar = alloc<UIntVar>()
            scanner.scanHexInt(pointed.ptr)
            val pointedValue: UInt = pointed.value

            a = ((pointedValue and 4278190080u) shl 24) / 255u
            r = ((pointedValue and 16711680u) shl 16) / 255u
            g = ((pointedValue and 65280u) shl 8) / 255u
            b = ((pointedValue and 255u) shl 0) / 255u

            return UIColor(
                red = r.toDouble(),
                green = g.toDouble(),
                blue = b.toDouble(),
                alpha = a.toDouble()
            )
        }
    }

}
