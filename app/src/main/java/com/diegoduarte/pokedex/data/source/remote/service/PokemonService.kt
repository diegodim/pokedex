package com.diegoduarte.pokedex.data.source.remote.service

import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import com.diegoduarte.pokedex.data.source.remote.model.GenericResponse
import com.diegoduarte.pokedex.data.source.remote.model.PokedexResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url




interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int

    ): GenericResponse<PokedexResponse>

    @GET
    suspend fun getPokemon(
        @Url url: String
    ): PokemonResponse
}