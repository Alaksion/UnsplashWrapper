package io.github.alaksion.unsplashwrapper.sdk

import android.content.Context
import androidx.startup.Initializer

object UnsplashWrapperContext

internal lateinit var appContext: Context

class UnsplashWrapperInitializer : Initializer<UnsplashWrapperContext> {
    override fun create(context: Context): UnsplashWrapperContext {
        appContext = context
        return UnsplashWrapperContext
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        TODO("Not yet implemented")
    }

}