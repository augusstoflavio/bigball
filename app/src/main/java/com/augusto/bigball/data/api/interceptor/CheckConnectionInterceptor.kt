package com.augusto.bigball.data.api.interceptor

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.augusto.bigball.App
import com.augusto.bigball.data.api.exception.NoConnectionException
import okhttp3.Interceptor
import okhttp3.Response

class CheckConnectionInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!hasConnection()) {
            throw NoConnectionException()
        }

        return chain.proceed(chain.request())
    }

    private fun hasConnection(): Boolean {
        return true
//        val cm = App.instance
//            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//        cm.activeNetwork
//
//        return cm.activeNetwork != null
    }
}
