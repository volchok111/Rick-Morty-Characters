package com.volchok.rickmorty.library.api.data

import com.volchok.rickmorty.library.api.model.CharacterModel
import retrofit2.http.GET

interface RickMortyApi {

    @GET("character")
    suspend fun getCharacters(): CharacterModel
}