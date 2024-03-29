package io.github.alaksion.unsplashwrapper.api.datasources

import io.github.alaksion.unsplashwrapper.api.models.collections.data.UserCollectionsResponse
import io.github.alaksion.unsplashwrapper.api.models.photo.data.list.ListPhotosResponse
import io.github.alaksion.unsplashwrapper.api.models.statistics.data.StatisticsResolutionResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.UserPortfolioLinkResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.UserStatisticsResponse
import io.github.alaksion.unsplashwrapper.api.models.user.data.profile.UserProfileResponse
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserLikedPhotosParameters
import io.github.alaksion.unsplashwrapper.api.models.user.domain.UserPhotosParameters
import io.github.alaksion.unsplashwrapper.platform.httpclient.UnsplashHttpClient
import io.github.alaksion.unsplashwrapper.sdk.UnsplashSdkConfig
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

internal interface UserRemoteDataSource {

    suspend fun getUserProfile(
        username: String
    ): UserProfileResponse

    suspend fun getUserPhotos(
        username: String,
        parameters: UserPhotosParameters
    ): List<ListPhotosResponse>

    suspend fun getUserLikedPhotos(
        username: String,
        parameters: UserLikedPhotosParameters
    ): List<ListPhotosResponse>

    suspend fun getUserPortfolioLink(
        username: String
    ): UserPortfolioLinkResponse

    suspend fun getUserStatistics(
        username: String,
        resolution: StatisticsResolutionResponse,
        quantity: Int,
    ): UserStatisticsResponse

    suspend fun getUserCollections(
        username: String,
        perPage: Int,
        page: Int
    ): List<UserCollectionsResponse>

}

internal class UserRemoteDataSourceImplementation private constructor(
    private val dispatcher: CoroutineDispatcher,
    private val client: UnsplashHttpClient
) : UserRemoteDataSource {

    override suspend fun getUserProfile(username: String): UserProfileResponse =
        withContext(dispatcher) {
            client.client.get(
                urlString = UnsplashSdkConfig.buildUrl("/users/{$username}")
            ).body()
        }

    override suspend fun getUserPhotos(
        username: String,
        parameters: UserPhotosParameters
    ): List<ListPhotosResponse> =
        withContext(dispatcher) {
            client.client.get(
                urlString = UnsplashSdkConfig.buildUrl("/users/{$username}/photos"),
                block = {
                    parameter("page", parameters.page)
                    parameter("per_page", parameters.perPage)
                    parameter("order_by", parameters.orderBy.value)
                    parameters.orientation?.let {
                        parameter("orientation", it.primitiveValue)
                    }
                }
            ).body()
        }

    override suspend fun getUserLikedPhotos(
        username: String,
        parameters: UserLikedPhotosParameters
    ): List<ListPhotosResponse> = withContext(dispatcher) {
        client.client.get(
            urlString = UnsplashSdkConfig.buildUrl("/users/{$username}/likes"),
            block = {
                parameter("page", parameters.page)
                parameter("per_page", parameters.perPage)
                parameter("order_by", parameters.orderBy.value)
                parameters.orientation?.let {
                    parameter("orientation", it.primitiveValue)
                }
            }
        ).body()
    }

    override suspend fun getUserPortfolioLink(username: String): UserPortfolioLinkResponse =
        withContext(dispatcher) {
            client.client.get(
                urlString = UnsplashSdkConfig.buildUrl("/users/{$username}/portfolio"),
            ).body()
        }

    override suspend fun getUserStatistics(
        username: String,
        resolution: StatisticsResolutionResponse,
        quantity: Int
    ): UserStatisticsResponse =
        withContext(dispatcher) {
            client.client.get(
                urlString = UnsplashSdkConfig.buildUrl("/users/{$username}/statistics"),
                block = {
                    parameter("resolution", resolution.value)
                    parameter("quantity", quantity)
                }
            ).body()
        }

    override suspend fun getUserCollections(
        username: String,
        perPage: Int,
        page: Int
    ): List<UserCollectionsResponse> =
        withContext(dispatcher) {
            client.client.get(
                urlString = UnsplashSdkConfig.buildUrl("/users/{$username}/collections"),
                block = {
                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            ).body()
        }

    companion object {
        val INSTANCE: UserRemoteDataSource = UserRemoteDataSourceImplementation(
            dispatcher = Dispatchers.IO,
            client = UnsplashHttpClient.Instance
        )
    }
}
