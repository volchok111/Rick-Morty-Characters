package com.volchok.rickmorty.library.memory.domain

import com.volchok.rickmorty.library.api.model.details.CharacterDetails
import kotlinx.coroutines.flow.Flow

interface LocalCharacterRepository {
    val character: Flow<CharacterDetails>

    fun set(character: CharacterDetails)
}