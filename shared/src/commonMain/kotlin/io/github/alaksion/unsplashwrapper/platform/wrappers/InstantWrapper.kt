package io.github.alaksion.unsplashwrapper.platform.wrappers

import androidx.compose.runtime.Stable
import kotlinx.datetime.Instant

@Stable
data class InstantWrapper(
    val instant: Instant
)
