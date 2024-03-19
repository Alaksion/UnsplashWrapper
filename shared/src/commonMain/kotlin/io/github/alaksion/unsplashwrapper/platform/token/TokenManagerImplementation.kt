package io.github.alaksion.unsplashwrapper.platform.token

import io.github.alaksion.unsplashwrapper.platform.localstorage.LocalStorage
import io.github.alaksion.unsplashwrapper.platform.localstorage.LocalStorageImpl

internal interface TokenManager {
    fun storeToken(type: TokenType, value: String)
    fun getToken(type: TokenType): String?
    fun clearToken(type: TokenType)

}

internal enum class TokenType(
    internal val key: String
) {
    PublicToken("public_token"),
    PrivateToken("private_token"),
    UserToken("user_token");
}

internal class TokenManagerImplementation private constructor(
    private val localStorage: LocalStorage
) : TokenManager {

    override fun storeToken(type: TokenType, value: String) {
        localStorage.putString(
            value = value,
            key = type.key
        )
    }

    override fun getToken(type: TokenType): String? {
        return localStorage.getString(type.key)
    }

    override fun clearToken(type: TokenType) {
        localStorage.clearKey(type.key)
    }

    internal companion object Keys {

        val Instance: TokenManager = TokenManagerImplementation(
            localStorage = LocalStorageImpl.INSTANCE
        )
    }

}
