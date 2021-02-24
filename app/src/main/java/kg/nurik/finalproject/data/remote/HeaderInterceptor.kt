package kg.nurik.finalproject.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("x-rapidapi-key", "05c20da58cmshc5d40ab2dea3b16p1339e6jsnf7cde060245c")
            .header("x-rapidapi-host", "sportscore1.p.rapidapi.com")
        return chain.proceed(request.build())
    }
}