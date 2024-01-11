package io.github.alaksion.unsplashwrapper

import io.github.alaksion.unsplashwrapper.platform.localstorage.LocalStorage

internal interface AuthManager {
    fun storePublicKey(key: String)
    fun getPublicKey(): String?

    fun storeUserToken(token: String)
    fun getUserToken(): String?

}

internal class AuthenticationManager(
    private val localStorage: LocalStorage
) : AuthManager {

    override fun storePublicKey(key: String) =
        localStorage.putString(
            value = key,
            key = PUBLIC_KEY
        )

    override fun getPublicKey(): String? = localStorage.getString(PUBLIC_KEY)

    override fun storeUserToken(token: String) =
        localStorage.putString(
            value = token,
            key = USER_TOKEN
        )

    override fun getUserToken(): String? = localStorage.getString(USER_TOKEN)

    internal companion object {
        const val PUBLIC_KEY = "unsplash_public_key"
        const val USER_TOKEN = "unsplash_user_token"
    }

}
