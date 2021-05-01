package com.augusto.bigball

import android.app.Application
import com.augusto.bigball.di.apiModule
import com.augusto.bigball.di.dataModule
import com.augusto.bigball.di.useCaseModule
import com.augusto.bigball.di.viewModelModule
import org.koin.android.ext.koin.androidContext

class App: Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    apiModule,
                    viewModelModule,
                    useCaseModule
                )
            )
        }
    }

    companion object {
        lateinit var instance: App
    }
}