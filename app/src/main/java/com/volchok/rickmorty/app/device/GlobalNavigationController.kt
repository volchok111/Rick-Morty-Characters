package com.volchok.rickmorty.app.device

import com.volchok.rickmorty.app.domain.MainNavigationController
import com.volchok.rickmorty.app.model.BackNavigationEvent
import com.volchok.rickmorty.app.model.ForwardNavigationEvent
import com.volchok.rickmorty.app.model.NavigationEvent
import com.volchok.rickmorty.app.model.Route
import com.volchok.rickmorty.feature.home.domain.HomeNavigationController
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class GlobalNavigationController :
    MainNavigationController,
    HomeNavigationController {

    private val _navigationEvent = MutableSharedFlow<NavigationEvent>(extraBufferCapacity = 1)
    override val navigationEvent = _navigationEvent.asSharedFlow()

    override fun goBack() = goTo(BackNavigationEvent)

    override fun goToHome() = goTo(ForwardNavigationEvent(Route.Home, true))

    override fun goToCharacterInfo() = goTo(ForwardNavigationEvent(Route.Details))

    private fun goTo(navigationEvent: NavigationEvent) {
        _navigationEvent.tryEmit(navigationEvent)
    }
}