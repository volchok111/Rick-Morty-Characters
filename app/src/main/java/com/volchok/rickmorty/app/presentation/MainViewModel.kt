package com.volchok.rickmorty.app.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.rickmorty.app.domain.ObserveNavigationEventsUseCase
import com.volchok.rickmorty.app.model.Route
import com.volchok.rickmorty.library.mvvm.presentation.AbstractViewModel
import com.volchok.rickmorty.app.model.ForwardNavigationEvent
import com.volchok.rickmorty.app.model.NavigationEvent
import kotlinx.coroutines.launch

class MainViewModel(
    private val observeNavigationEventsUseCase: ObserveNavigationEventsUseCase,
) : AbstractViewModel<MainViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            observeNavigationEventsUseCase(Unit).collect { onNavigationEvent(it) }
        }
    }

    fun onNavigationEventConsumed() {
        state = state.copy(navigationEvent = null)
    }

    private fun onNavigationEvent(navigationEvent: NavigationEvent) {
        state = state.copy(navigationEvent = navigationEvent)
    }

    data class State(
        val isOffline: Boolean = false,
        val navigationEvent: NavigationEvent? = ForwardNavigationEvent(Route.Initial)
    ) : AbstractViewModel.State
}