package com.volchok.rickmorty.app.ui

import android.app.Application
import com.volchok.rickmorty.app.di.mainModule
import com.volchok.rickmorty.feature.details.di.detailsModule
import com.volchok.rickmorty.feature.home.di.homeModule
import com.volchok.rickmorty.library.api.di.apiModule
import com.volchok.rickmorty.library.memory.di.memoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(applicationContext)
            modules(
                apiModule,
                detailsModule,
                homeModule,
                mainModule,
                memoryModule
            )
        }
        super.onCreate()
    }
}