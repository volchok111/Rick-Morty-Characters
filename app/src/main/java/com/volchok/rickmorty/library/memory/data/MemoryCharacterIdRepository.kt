package com.volchok.rickmorty.library.memory.data

import com.volchok.rickmorty.library.memory.domain.CharacterIdRepository

class MemoryCharacterIdRepository: CharacterIdRepository {
    override var selectedCharacterId: Int = 0
}