package com.volchok.rickmorty.library.api.di

import com.volchok.rickmorty.library.api.data.RickMortyApi
import com.volchok.rickmorty.library.api.data.RickMortyRepository
import com.volchok.rickmorty.library.api.domain.ObserveCharactersUseCase
import com.volchok.rickmorty.library.api.domain.RemoteRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    factory {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .followSslRedirects(false)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(40, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .build()
            .create(RickMortyApi::class.java)
    }

    factoryOf(::ObserveCharactersUseCase)
    factoryOf(::RickMortyRepository) bind RemoteRepository::class
}