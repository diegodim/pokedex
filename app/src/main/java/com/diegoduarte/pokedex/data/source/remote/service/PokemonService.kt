package com.diegoduarte.pokedex.data.source.remote.service

import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET




interface PokemonService {

    @GET("pokemon/all")
    suspend fun getPokemonList(): Response<List<PokemonResponse>>

}