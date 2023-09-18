package com.volchok.rickmorty.library.memory.domain

import com.volchok.rickmorty.library.api.model.details.CharacterDetails
import com.volchok.rickmorty.library.use_case.domain.SynchronousUseCase
import kotlinx.coroutines.flow.Flow

class ObserveCharacterDetailsUseCase(
    private val localCharacterRepository: LocalCharacterRepository
) : SynchronousUseCase<Unit, Flow<CharacterDetails>> {
    override fun invoke(input: Unit): Flow<CharacterDetails> = localCharacterRepository.character
}