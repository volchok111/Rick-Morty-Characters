package com.volchok.rickmorty.app.di

import com.volchok.rickmorty.app.device.GlobalNavigationController
import com.volchok.rickmorty.app.presentation.MainViewModel
import com.volchok.rickmorty.app.domain.MainNavigationController
import com.volchok.rickmorty.app.domain.ObserveNavigationEventsUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.binds
import org.koin.dsl.module

internal val mainModule = module {
    viewModelOf(::MainViewModel)
    factory { ObserveNavigationEventsUseCase(get()) }

    single { GlobalNavigationController() }.binds(
        arrayOf(
            MainNavigationController::class
        )
    )
}