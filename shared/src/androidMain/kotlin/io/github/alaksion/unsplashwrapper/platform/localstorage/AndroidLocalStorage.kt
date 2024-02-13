package io.github.alaksion.unsplashwrapper.platform.localstorage

import android.content.Context
import io.github.alaksion.unsplashwrapper.sdk.appContext

internal actual class LocalStorageImpl(
    private val context: Context
) : LocalStorage {

    private val preferences by lazy {
        context.getSharedPreferences("unsplash-wrapper", Context.MODE_PRIVATE)
    }

    override fun putString(value: String, key: String) {
        preferences.edit().putString(
            key, value
        ).apply()
    }

    override fun getString(key: String): String? {
        return preferences.getString(key, null)
    }

    actual companion object Provider {
        actual val Instace: LocalStorage = LocalStorageImpl(context = appContext)
    }
}
