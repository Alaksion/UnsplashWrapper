package io.github.alaksion.unsplashwrapper.wrappers

import android.graphics.Bitmap
import androidx.compose.runtime.Stable

@Stable
data class BitmapWrapper(
    val bitmap: Bitmap?
)
