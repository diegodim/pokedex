package com.diegoduarte.pokedex.data.source

import androidx.lifecycle.LiveData
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.remote.Result
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {

    fun refreshPokemonList(): Flow<Result<Boolean>>
    val listPokemon: LiveData<List<Pokemon>>
}