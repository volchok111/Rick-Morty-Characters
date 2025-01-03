package com.volchok.rickmorty.feature.details.di

import com.volchok.rickmorty.feature.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val detailsModule = module {
    viewModelOf(::DetailsViewModel)
}