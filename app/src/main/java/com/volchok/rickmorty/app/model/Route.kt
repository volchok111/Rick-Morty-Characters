package com.volchok.rickmorty.app.model

enum class Route {
    Details,
    Home;

    operator fun invoke() = name.lowercase()

    companion object {
        val Initial = Home
    }
}