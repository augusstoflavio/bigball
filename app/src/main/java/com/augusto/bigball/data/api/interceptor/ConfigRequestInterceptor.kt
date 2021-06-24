package com.augusto.bigball.data.api.interceptor

import com.augusto.bigball.core.data.dataSource.AuthLocalDataSource
import okhttp3.Interceptor
import okhttp3.Response

class ConfigRequestInterceptor(private val authLocalDataSource: AuthLocalDataSource): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request()
            .newBuilder()
            .addHeader(HEADER_CONTENT_TYPE, "application/json")

        if (authLocalDataSource.isLoggedIn()) {
            builder.addHeader(HEADER_AUTHORIZATION, authLocalDataSource.getToken()!!)
        }

        return chain.proceed(builder.build())
    }

    companion object {
        private const val HEADER_AUTHORIZATION = "Authorization"
        private const val HEADER_CONTENT_TYPE = "Content-Type"
    }
}