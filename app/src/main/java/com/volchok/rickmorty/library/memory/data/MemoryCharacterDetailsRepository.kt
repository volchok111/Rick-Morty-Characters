package com.volchok.rickmorty.library.memory.data

import com.volchok.rickmorty.library.api.model.details.CharacterDetails
import com.volchok.rickmorty.library.memory.domain.LocalCharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

class MemoryCharacterDetailsRepository : LocalCharacterRepository {
    private val _character = MutableStateFlow<CharacterDetails?>(null)
    override val character: Flow<CharacterDetails> = _character.filterNotNull()

    override fun set(character: CharacterDetails) {
        _character.tryEmit(character)
    }
}