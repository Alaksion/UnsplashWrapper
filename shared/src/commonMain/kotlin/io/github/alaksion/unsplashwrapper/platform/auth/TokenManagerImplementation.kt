package io.github.alaksion.unsplashwrapper.platform.auth

import io.github.alaksion.unsplashwrapper.platform.localstorage.LocalStorage
import io.github.alaksion.unsplashwrapper.platform.localstorage.LocalStorageImpl

internal interface TokenManager {
    fun storePublicKey(key: String)
    fun getPublicKey(): String?

    fun storeUserToken(token: String)
    fun getUserToken(): String?

}

internal class TokenManagerImplementation private constructor(
    private val localStorage: LocalStorage
) : TokenManager {

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

    internal companion object Keys {
        const val PUBLIC_KEY = "unsplash_public_key"
        const val USER_TOKEN = "unsplash_user_token"

        val Instance: TokenManager = TokenManagerImplementation(
            localStorage = LocalStorageImpl.Instace
        )
    }

}
