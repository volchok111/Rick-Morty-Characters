package com.volchok.rickmorty.library.memory.domain

import com.volchok.rickmorty.library.api.domain.RemoteRepository
import com.volchok.rickmorty.library.api.model.details.CharacterDetails
import com.volchok.rickmorty.library.data.model.Data
import com.volchok.rickmorty.library.use_case.domain.SuspendUseCase
import com.volchok.rickmorty.library.use_case.domain.invoke
import com.volchok.space_x.library.data.model.safeCall

class FetchCharacterDetailsUseCase(
    private val repository: RemoteRepository,
    private val localCharacterRepository: LocalCharacterRepository,
    private val getSelectedCharacterIdUseCase: GetSelectedCharacterIdUseCase
) : SuspendUseCase<Unit, Data<CharacterDetails>> {
    override suspend fun invoke(input: Unit): Data<CharacterDetails> = safeCall {
        characterInfo()
    }

    private suspend fun characterInfo(): CharacterDetails {
        val characterId = getSelectedCharacterIdUseCase()
        val result = repository.getCharacterDetails(characterId).getSuccessValueOrThrow()
        val character = CharacterDetails(
            gender = result.gender,
            id = result.id,
            image = result.image,
            location = result.location,
            name = result.name,
            origin = result.origin,
            species = result.species,
            status = result.status,
            type = result.type
        )
        localCharacterRepository.set(character)
        return character
    }
}