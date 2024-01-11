package io.github.alaksion.unsplashwrapper.platform.localstorage

interface LocalStorage {
    fun putString(value: String, key: String)
    fun getString(key: String): String?
}

expect class LocalStorageImpl : LocalStorage {

    companion object Provider {
        val Instace: LocalStorage
    }

}
