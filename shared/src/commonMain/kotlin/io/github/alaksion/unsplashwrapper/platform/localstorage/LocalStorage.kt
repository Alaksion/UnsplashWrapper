package io.github.alaksion.unsplashwrapper.platform.localstorage

internal interface LocalStorage {
    fun putString(value: String, key: String)
    fun getString(key: String): String?
}

internal expect class LocalStorageImpl : LocalStorage {

    companion object Provider {
        val Instace: LocalStorage
    }

}
