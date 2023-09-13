package com.volchok.rickmorty.app.domain

import com.volchok.rickmorty.app.model.NavigationEvent
import kotlinx.coroutines.flow.Flow

interface MainNavigationController {
    val navigationEvent: Flow<NavigationEvent>

    fun goBack()

    fun goToHome()
}