package io.github.alaksion.unsplashwrapper.api.models.authorization.domain

enum class AuthorizationScope(
    internal val value: String
) {

    /**
     * Default. Read public data
     * */
    Public("public"),

    /**
     * Access user’s private data
     * */
    ReadUser("read_user"),

    /**
     * Update the user’s profile
     */
    WriteUser("write_user"),

    /**
     * Read private data from the user’s photos
     * */
    ReadPhotos("read_photos"),

    /**
     * Update photos on the user’s behalf
     * */
    WritePhotos("write_photos"),

    /**
     * Like or unlike a photo on the user’s behalf
     * */
    WriteLikes("write_likes"),

    /**
     * Follow or unfollow a user on the user’s behalf
     * */
    WriteFollowers("write_followers"),

    /**
     * View a user’s private collections
     * */
    ReadCollections("read_collections"),

    /**
     * Create and update a user’s collections.
     * */
    WriteCollections("write_collections");

    internal companion object {
        fun parseFromString(raw: String): AuthorizationScope {
            return entries.first { it.value == raw }
        }
    }

}
