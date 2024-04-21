package io.github.alaksion.unsplashwrapper.platform.listeners

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper
import kotlinx.collections.immutable.ImmutableList


interface HttpListener {

    fun onReceive(httpResponse: HttpResponse)

}

data class HttpResponse(
    val code: Int,
    val body: String,
    val headers: ImmutableList<String>,
    val timeStamp: InstantWrapper
)