package io.github.alaksion.unsplashwrapper.api.photos.data.models.ratephoto


import io.github.alaksion.unsplashwrapper.api.photos.domain.domain.models.RatePhoto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RatePhotoResponse(
    @SerialName("photo")
    val summarizedPhotoResponse: SummarizedPhotoResponse,
    val user: SummarizedUserResponse
)

internal fun RatePhotoResponse.toDomain(): RatePhoto = RatePhoto(
    ratedPhotoSummary = this.summarizedPhotoResponse.toDomain(),
    ratedPhotoAuthor = this.user.toDomain()
)