package com.volchok.rickmorty.library.memory.domain

import com.volchok.rickmorty.library.use_case.domain.SynchronousUseCase

class GetSelectedCharacterIdUseCase(
    private val repository: CharacterIdRepository
) : SynchronousUseCase<Unit, Int> {
    override fun invoke(input: Unit): Int = repository.selectedCharacterId
}