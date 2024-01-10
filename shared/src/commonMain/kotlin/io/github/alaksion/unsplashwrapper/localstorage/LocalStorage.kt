package io.github.alaksion.unsplashwrapper.localstorage

internal interface LocalStorage {
    fun putString(value: String, key: String)
    fun getString(key: String): String?
}

expect class LocalStorageImpl: LocalStorage