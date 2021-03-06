package com.augusto.bigball.data.api.interceptor

import com.augusto.bigball.data.api.exception.ApiException
import okhttp3.Interceptor
import okhttp3.Response

class CheckResponseInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val response = chain.proceed(request)
        if (!response.isSuccessful) {
            throw ApiException(response.message, response.code)
        }
        return response
    }

}
