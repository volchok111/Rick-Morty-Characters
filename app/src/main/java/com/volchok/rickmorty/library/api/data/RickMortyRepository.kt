package com.volchok.rickmorty.library.api.data

import com.volchok.rickmorty.library.api.domain.RemoteRepository
import com.volchok.rickmorty.library.api.model.CharacterModel
import com.volchok.rickmorty.library.api.model.details.CharacterDetails
import com.volchok.rickmorty.library.data.model.Data

class RickMortyRepository(
    private val rickMortyApi: RickMortyApi
) : RemoteRepository{
    override suspend fun getCharacters(): Data<CharacterModel> {
        return try {
            val result = rickMortyApi.getCharacters()
            Data.Success(result)
        } catch (ex: Exception) {
            Data.Error(cause = ex)
        }
    }

    override suspend fun getCharacterDetails(id: Int): Data<CharacterDetails> {
        return try {
            val result = rickMortyApi.getCharacterDetails(id)
            Data.Success(result)
        } catch (ex: Exception) {
            Data.Error(cause = ex)
        }
    }
}