package io.github.alaksion.unsplashwrapper.api.repositories

import io.github.alaksion.unsplashwrapper.api.datasources.UserRemoteDataSource
import io.github.alaksion.unsplashwrapper.api.datasources.UserRemoteDataSourceImplementation
import io.github.alaksion.unsplashwrapper.api.models.photo.data.list.toDomain
import io.github.alaksion.unsplashwrapper.api.models.photo.domain.list.ListPhoto
import io.github.alaksion.unsplashwrapper.api.models.statistics.domain.StatisticsResolution
import io.github.alaksion.unsplashwrapper.api.models.user.data.profile.toDomain
import io.github.alaksion.unsplashwrapper.api.models.user.data.toDomain
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLikedPhotosParameters
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserPhotosParameters
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserStatistics
import io.github.alaksion.unsplashwrapper.api.models.user.domain.profile.UserProfile

interface UnsplashUserRepository {
    suspend fun getUserProfile(
        username: String
    ): UserProfile

    suspend fun getUserPhotos(
        username: String,
        parameters: UserPhotosParameters
    ): List<ListPhoto>

    suspend fun getUserLikedPhotos(
        username: String,
        parameters: UserLikedPhotosParameters
    ): List<ListPhoto>

    suspend fun getUserPortfolioLink(
        username: String
    ): String

    suspend fun getUserStatistics(
        username: String,
        resolution: StatisticsResolution,
        quantity: Int,
    ): UserStatistics

}

internal class UnsplashUserRepositoryImpl(
    private val dataSource: UserRemoteDataSource
) : UnsplashUserRepository {

    override suspend fun getUserProfile(username: String): UserProfile =
        dataSource.getUserProfile(username).toDomain()

    override suspend fun getUserPhotos(
        username: String,
        parameters: UserPhotosParameters
    ): List<ListPhoto> = dataSource.getUserPhotos(
        username = username,
        parameters = parameters
    ).map { it.toDomain() }

    override suspend fun getUserLikedPhotos(
        username: String,
        parameters: UserLikedPhotosParameters
    ): List<ListPhoto> = dataSource.getUserLikedPhotos(
        username = username,
        parameters = parameters
    ).map { it.toDomain() }

    override suspend fun getUserPortfolioLink(username: String): String =
        dataSource.getUserPortfolioLink(username).url.orEmpty()

    override suspend fun getUserStatistics(
        username: String,
        resolution: StatisticsResolution,
        quantity: Int
    ): UserStatistics = dataSource.getUserStatistics(
        username = username,
        resolution = resolution.toData(),
        quantity = quantity
    ).toDomain()

    companion object {
        val INSTANCE: UnsplashUserRepository = UnsplashUserRepositoryImpl(
            dataSource = UserRemoteDataSourceImplementation.INSTANCE
        )
    }
}
