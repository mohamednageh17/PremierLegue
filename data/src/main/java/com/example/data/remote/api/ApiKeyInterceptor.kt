package com.example.data.remote.api

import com.example.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.headers

        val header = originalHttpUrl.newBuilder()
            .add("X-Auth-Token", BuildConfig.API_TOKEN)
            .build()

        val requestBuilder = original.newBuilder().headers(header)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}