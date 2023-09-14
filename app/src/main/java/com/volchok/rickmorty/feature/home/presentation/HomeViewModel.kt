package com.volchok.rickmorty.feature.home.presentation

import com.volchok.rickmorty.library.mvvm.presentation.AbstractViewModel

class HomeViewModel : AbstractViewModel<HomeViewModel.State>(State()) {

    data class State(
        val loading: Boolean = false
    ) : AbstractViewModel.State
}