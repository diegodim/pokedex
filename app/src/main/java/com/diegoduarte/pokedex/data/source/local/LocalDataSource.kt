package com.diegoduarte.pokedex.data.source.local


import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.Result
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    fun getListPokemon(): Flow<Result<List<Pokemon>>>

    suspend fun insertPokemon(pokemon: PokemonEntity)
}