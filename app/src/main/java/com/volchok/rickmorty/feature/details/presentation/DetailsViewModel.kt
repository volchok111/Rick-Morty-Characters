package com.volchok.rickmorty.feature.details.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.rickmorty.library.api.model.details.CharacterDetails
import com.volchok.rickmorty.library.memory.domain.FetchCharacterDetailsUseCase
import com.volchok.rickmorty.library.memory.domain.ObserveCharacterDetailsUseCase
import com.volchok.rickmorty.library.mvvm.presentation.AbstractViewModel
import com.volchok.rickmorty.library.use_case.domain.invoke
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val fetchCharacterDetailsUseCase: FetchCharacterDetailsUseCase,
    private val observeCharacterDetailsUseCase: ObserveCharacterDetailsUseCase
) : AbstractViewModel<DetailsViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            fetchCharacterDetailsUseCase()
        }
        viewModelScope.launch {
            observeCharacterDetailsUseCase().collect {
                state = state.copy(character = it, loading = false)
            }
        }
    }

    data class State(
        val loading: Boolean = true,
        val character: CharacterDetails? = null
    ) : AbstractViewModel.State
}