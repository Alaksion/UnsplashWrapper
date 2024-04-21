package io.github.alaksion.unsplashwrapper.platform.listeners

import io.github.alaksion.unsplashwrapper.platform.wrappers.InstantWrapper


interface HttpListener {

    fun onReceive(httpResponse: HttpResponse)

}

data class HttpResponse(
    val code: Int,
    val body: String,
    val headers: List<HttpHeader>,
    val timeStamp: InstantWrapper
)

data class HttpHeader(
    val name: String,
    val value: String
)