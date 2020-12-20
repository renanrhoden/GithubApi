package com.renanrhoden.githubapi

import android.app.Application
import com.renanrhoden.inject.viewModelModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(viewModelModule))
        }
    }
}