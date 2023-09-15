package com.volchok.rickmorty.library.api.domain

import com.volchok.rickmorty.library.api.model.CharacterModel
import com.volchok.rickmorty.library.data.model.Data
import com.volchok.rickmorty.library.use_case.domain.SuspendUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ObserveCharactersUseCase(
    private val repository: RemoteRepository
) : SuspendUseCase<Unit, Flow<Data<CharacterModel>>> {
    override suspend fun invoke(input: Unit): Flow<Data<CharacterModel>> = flow {
        emit(repository.getCharacters())
    }
}