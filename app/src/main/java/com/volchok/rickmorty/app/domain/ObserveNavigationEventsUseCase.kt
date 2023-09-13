package com.volchok.rickmorty.app.domain

import com.volchok.rickmorty.library.use_case.domain.SynchronousUseCase
import com.volchok.rickmorty.app.model.NavigationEvent
import kotlinx.coroutines.flow.Flow

class ObserveNavigationEventsUseCase(
    private val mainNavigationController: MainNavigationController
) : SynchronousUseCase<Unit, Flow<NavigationEvent>> {

    override fun invoke(input: Unit): Flow<NavigationEvent> =
        mainNavigationController.navigationEvent
}