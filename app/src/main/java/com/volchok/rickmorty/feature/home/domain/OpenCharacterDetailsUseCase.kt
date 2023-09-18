package com.volchok.rickmorty.feature.home.domain

import com.volchok.rickmorty.library.memory.domain.CharacterIdRepository
import com.volchok.rickmorty.library.use_case.domain.SynchronousUseCase

class OpenCharacterDetailsUseCase(
    private val homeNavigationController: HomeNavigationController,
    private val characterIdRepository: CharacterIdRepository
) : SynchronousUseCase<Int, Unit> {
    override fun invoke(input: Int) {
        characterIdRepository.selectedCharacterId = input
        homeNavigationController.goToCharacterInfo()
    }
}