package com.volchok.rickmorty.library.api.model

data class CharacterModel(
    val info: Info,
    val results: List<CharacterItem>
)