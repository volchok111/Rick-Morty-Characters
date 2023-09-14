package com.volchok.rickmorty.feature.details.presentation

import com.volchok.rickmorty.library.mvvm.presentation.AbstractViewModel

class DetailsViewModel : AbstractViewModel<DetailsViewModel.State>(State()) {

    data class State(
        val loading: Boolean = false
    ) : AbstractViewModel.State
}