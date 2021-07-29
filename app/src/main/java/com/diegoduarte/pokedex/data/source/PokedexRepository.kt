package com.diegoduarte.pokedex.data.source

import com.diegoduarte.pokedex.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {

    fun refreshPokemonList(): Flow<Result<Nothing>>
    val listPokemon: Flow<Result<List<Pokemon>>>
}