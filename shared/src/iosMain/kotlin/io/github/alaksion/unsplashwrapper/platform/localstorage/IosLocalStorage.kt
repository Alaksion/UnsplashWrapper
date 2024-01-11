package io.github.alaksion.unsplashwrapper.platform.localstorage

import io.github.alaksion.unsplashwrapper.platform.localstorage.LocalStorage
import platform.Foundation.NSUserDefaults
import platform.Foundation.setValue

actual class LocalStorageImpl : LocalStorage {

    private val userDefaults by lazy {
        NSUserDefaults.standardUserDefaults()
    }

    override fun putString(value: String, key: String) {
        userDefaults.setValue(value = value, forUndefinedKey = key)
    }

    override fun getString(key: String): String? {
        return userDefaults.stringForKey(key)
    }
}
