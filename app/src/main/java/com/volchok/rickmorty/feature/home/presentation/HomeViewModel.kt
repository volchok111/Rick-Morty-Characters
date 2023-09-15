package com.volchok.rickmorty.feature.home.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.rickmorty.library.api.domain.ObserveCharactersUseCase
import com.volchok.rickmorty.library.api.model.CharacterItem
import com.volchok.rickmorty.library.data.model.Data
import com.volchok.rickmorty.library.mvvm.presentation.AbstractViewModel
import com.volchok.rickmorty.library.use_case.domain.invoke
import kotlinx.coroutines.launch

class HomeViewModel(
    private val observeCharactersUseCase: ObserveCharactersUseCase
) : AbstractViewModel<HomeViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            observeCharactersUseCase().collect { list ->
                if (list is Data.Success) {
                    state = state.copy(characters = list.value.results.map { it.toItem() }, loading = false)
                }
            }
        }
    }

    private fun CharacterItem.toItem() = State.CharacterItem(
        id,
        image,
        name,
        status
    )

    data class State(
        val characters: List<CharacterItem> = emptyList(),
        val loading: Boolean = true
    ) : AbstractViewModel.State {
        data class CharacterItem(
            val id: Int? = null,
            val image: String? = null,
            val name: String? = null,
            val status: String? = null,
        )
    }
}