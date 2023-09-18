package com.volchok.rickmorty.library.memory.di

import com.volchok.rickmorty.library.memory.data.MemoryCharacterDetailsRepository
import com.volchok.rickmorty.library.memory.data.MemoryCharacterIdRepository
import com.volchok.rickmorty.library.memory.domain.CharacterIdRepository
import com.volchok.rickmorty.library.memory.domain.FetchCharacterDetailsUseCase
import com.volchok.rickmorty.library.memory.domain.GetSelectedCharacterIdUseCase
import com.volchok.rickmorty.library.memory.domain.LocalCharacterRepository
import com.volchok.rickmorty.library.memory.domain.ObserveCharacterDetailsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val memoryModule = module {
    factoryOf(::GetSelectedCharacterIdUseCase)
    factoryOf(::FetchCharacterDetailsUseCase)
    factoryOf(::ObserveCharacterDetailsUseCase)

    singleOf(::MemoryCharacterDetailsRepository) bind LocalCharacterRepository::class
    singleOf(::MemoryCharacterIdRepository) bind CharacterIdRepository::class
}