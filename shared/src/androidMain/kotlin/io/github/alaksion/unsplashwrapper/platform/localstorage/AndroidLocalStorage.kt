package io.github.alaksion.unsplashwrapper.platform.localstorage

import android.content.Context
import io.github.alaksion.unsplashwrapper.sdk.appContext

internal actual class LocalStorageImpl(
    private val context: Context
) : LocalStorage {

    private val preferences by lazy {
        context.getSharedPreferences("unsplash-wrapper", Context.MODE_PRIVATE)
    }

    override fun putString(value: String, key: String) =
        preferences.edit().putString(
            key, value
        ).apply()

    override fun getString(key: String): String? = preferences.getString(key, null)

    override fun clearKey(key: String) = preferences.edit().remove(key).apply()

    actual companion object Provider {
        actual val INSTANCE: LocalStorage = LocalStorageImpl(context = appContext)
    }
}
