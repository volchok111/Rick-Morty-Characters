package com.volchok.rickmorty.library.api.domain

import com.volchok.rickmorty.library.api.model.CharacterModel
import com.volchok.rickmorty.library.data.model.Data

interface RemoteRepository {
    suspend fun getCharacters(): Data<CharacterModel>
}