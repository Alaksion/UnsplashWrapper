@file:Suppress("All")
package io.github.alaksion.unsplashwrapper.platform.blurhash

import platform.posix.pow

actual object BlurhashDecoder {

    private val encodedCharacters =
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%*+,-.:;=?@[]^_{|}~".map { it }

    private val decodeCharacters: Map<String, Int> = mutableMapOf<String, Int>().apply {
        encodedCharacters.forEachIndexed { index, symbol ->
            this[symbol.toString()] = index
        }
    }

    actual fun decode(
        blurHash: String,
        width: Int,
        height: Int,
        punch: Float,
        useCache: Boolean
    ): Blurhash {
        if (blurHash.count() <= 6) return Blurhash(null)
        val sizeFlag = decode83(rawString = blurHash[0].toString())
        val numY = (sizeFlag / 9) + 1
        val numX = (sizeFlag % 9) + 1
        val quantisedMaximumValue = decode83(blurHash[1].toString())
        val maximumValue = (quantisedMaximumValue + 1).toFloat() / 166f

        if (blurHash.length != 4 + 2 * numX * numY) return Blurhash(null)

        return Blurhash(null)
    }

    private fun decode83(rawString: String): Int {
        var value = 0
        rawString.forEach { character ->
            val digit = decodeCharacters[character.toString()]
            digit?.let { safeDigit ->
                value = value * 83 + safeDigit
            }
        }
        return value
    }

    private fun decodeDC(value: Int): Triple<Float, Float, Float> {
        val intR = value shr 16
        val intG = (value shr 8) and 255
        val intB = value and 255
        return Triple(
            first = sRGBToLinear(intR),
            second = sRGBToLinear(intG),
            third = sRGBToLinear(intB)
        )
    }

    private fun sRGBToLinear(value: Int): Float {
        val v: Float = value.toULong().toFloat() / 255f
        return if (v <= 0.4045) return v / 12.92f
        else pow((v + 0.055) / 1.055, 2.4).toFloat()
    }

}


//extension UIImage {
//    public convenience init?(blurHash: String, size: CGSize, punch: Float = 1) {
//
//        let sizeFlag = String (blurHash[0]).decode83()
//        let numY =(sizeFlag / 9) + 1
//        let numX =(sizeFlag % 9) + 1
//
//        let quantisedMaximumValue = String (blurHash[1]).decode83()
//        let maximumValue = Float (quantisedMaximumValue + 1) / 166
//
//        guard blurHash . count == 4+2 * numX * numY else { return nil }
//
//        let colours :[(Float, Float, Float)] = (0..<numX * numY).map {
//        i in
//                if i == 0 {
//                    let value = String (blurHash[2..<6]).decode83()
//                    return decodeDC(value)
//                } else {
//                    let value = String (blurHash[4 + i * 2..<4 + i * 2 + 2]).decode83()
//                    return decodeAC(value, maximumValue: maximumValue * punch)
//                }
//    }
//
//        let width = Int (size.width)
//        let height = Int (size.height)
//        let bytesPerRow = width * 3
//        guard let data =
//            CFDataCreateMutable(kCFAllocatorDefault, bytesPerRow * height) else { return nil }
//        CFDataSetLength(data, bytesPerRow * height)
//        guard let pixels = CFDataGetMutableBytePtr(data) else { return nil }
//
//        for y in 0..<height {
//            for x in 0..<width {
//                var r: Float = 0
//                var g: Float = 0
//                var b: Float = 0
//
//                for j in 0..<numY {
//                    for i in 0..<numX {
//                        let basis = cos (Float.pi * Float(x) * Float(i) / Float(width)) * cos(
//                            Float.pi * Float(
//                                y
//                            ) * Float(j) / Float(height)
//                        )
//                        let colour = colours [i + j * numX]
//                        r += colour.0 * basis
//                        g += colour.1 * basis
//                        b += colour.2 * basis
//                    }
//                }
//
//                let intR = UInt8 (linearTosRGB(r))
//                let intG = UInt8 (linearTosRGB(g))
//                let intB = UInt8 (linearTosRGB(b))
//
//                pixels[3 * x + 0 + y * bytesPerRow] = intR
//                pixels[3 * x + 1 + y * bytesPerRow] = intG
//                pixels[3 * x + 2 + y * bytesPerRow] = intB
//            }
//        }
//
//        let bitmapInfo = CGBitmapInfo (rawValue: CGImageAlphaInfo.none.rawValue)
//
//        guard let provider = CGDataProvider(data: data) else { return nil }
//        guard let cgImage = CGImage(
//            width: width,
//            height: height,
//            bitsPerComponent: 8, bitsPerPixel: 24, bytesPerRow: bytesPerRow,
//        space: CGColorSpaceCreateDeviceRGB(), bitmapInfo: bitmapInfo, provider: provider, decode: nil, shouldInterpolate: true, intent: .defaultIntent) else { return nil }
//
//        self.init(cgImage: cgImage)
//    }
//}

//private func decodeDC(_ value : Int) -> (Float, Float, Float) {
//    let intR = value > > 16
//    let intG =(value > > 8) & 255
//    let intB = value & 255
//    return (sRGBToLinear(intR), sRGBToLinear(intG), sRGBToLinear(intB))
//}
//
//private func decodeAC(_ value : Int, maximumValue: Float) -> (Float, Float, Float) {
//    let quantR = value /(19 * 19)
//    let quantG =(value / 19) % 19
//    let quantB = value % 19
//
//    let rgb =(
//        signPow((Float(quantR) - 9) / 9, 2) * maximumValue,
//        signPow((Float(quantG) - 9) / 9, 2) * maximumValue,
//        signPow((Float(quantB) - 9) / 9, 2) * maximumValue
//    )
//
//    return rgb
//}

//private func signPow(_ value : Float, _ exp: Float) -> Float {
//    return copysign(pow(abs(value), exp), value)
//}

//private func linearTosRGB(_ value : Float) -> Int {
//    let v = max (0, min(1, value))
//    if v <= 0.0031308 { return Int(v * 12.92 * 255 + 0.5) }
//    else {
//        return Int((1.055 * pow(v, 1 / 2.4) - 0.055) * 255 + 0.5)
//    }
//}
//


//private extension String {
//    subscript(offset: Int) -> Character {
//        return self[index(startIndex, offsetBy: offset)]
//    }
//
//    subscript(bounds: CountableClosedRange< Int >) -> Substring {
//        let start = index (startIndex, offsetBy: bounds.lowerBound)
//        let end = index (startIndex, offsetBy: bounds.upperBound)
//        return self[start...end]
//    }
//
//    subscript(bounds: CountableRange< Int >) -> Substring {
//        let start = index (startIndex, offsetBy: bounds.lowerBound)
//        let end = index (startIndex, offsetBy: bounds.upperBound)
//        return self[start..<end]
//    }
//}
