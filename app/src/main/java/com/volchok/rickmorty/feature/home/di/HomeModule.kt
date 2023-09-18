package com.volchok.rickmorty.feature.home.di

import com.volchok.rickmorty.feature.home.domain.OpenCharacterDetailsUseCase
import com.volchok.rickmorty.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)

    factoryOf(::OpenCharacterDetailsUseCase)
}