package com.volchok.rickmorty.library.api.data

import com.volchok.rickmorty.library.api.model.CharacterModel
import com.volchok.rickmorty.library.api.model.details.CharacterDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface RickMortyApi {

    @GET("character")
    suspend fun getCharacters(): CharacterModel

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path(value = "id") id: Int): CharacterDetails
}