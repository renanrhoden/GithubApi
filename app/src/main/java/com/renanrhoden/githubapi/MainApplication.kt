package com.renanrhoden.githubapi

import android.app.Application
import com.renanrhoden.coreapi.inject.networkModule
import com.renanrhoden.githubapi.injection.baseUrlModule
import com.renanrhoden.inject.viewModelModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(viewModelModule, networkModule, baseUrlModule)
        }
    }
}