package io.github.alaksion.unsplashwrapper.sdk

import android.content.Context
import androidx.startup.Initializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object UnsplashWrapperContext

internal lateinit var appContext: Context

class UnsplashWrapperInitializer : Initializer<UnsplashWrapperContext> {
    override fun create(context: Context): UnsplashWrapperContext {
        appContext = context
        return UnsplashWrapperContext
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }

}
