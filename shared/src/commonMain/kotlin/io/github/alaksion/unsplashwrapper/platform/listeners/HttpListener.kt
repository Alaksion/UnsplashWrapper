package io.github.alaksion.unsplashwrapper.platform.listeners


interface HttpListener {

    fun onReceive(httpResponse: HttpResponse)

}

data class HttpResponse(
    val code: Int,
    val body: String,
    val headers: List<HttpHeader>,
    val timeStamp: String,
    val url: String,
    val method: String,
)

data class HttpHeader(
    val name: String,
    val value: String
)
