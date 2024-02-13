package io.github.alaksion.unsplashwrapper.platform.localstorage

import platform.Foundation.NSUserDefaults
import platform.Foundation.setValue

internal actual class LocalStorageImpl : LocalStorage {

    private val userDefaults by lazy {
        NSUserDefaults.standardUserDefaults()
    }

    override fun putString(value: String, key: String) {
        userDefaults.setValue(value = value, forUndefinedKey = key)
    }

    override fun getString(key: String): String? {
        return userDefaults.stringForKey(key)
    }

    actual companion object Provider {
        actual val Instace: LocalStorage = LocalStorageImpl()
    }
}
