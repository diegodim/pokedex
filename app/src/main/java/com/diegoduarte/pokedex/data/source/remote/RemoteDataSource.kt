package com.diegoduarte.pokedex.data.source.remote


import com.diegoduarte.pokedex.data.source.Result
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun refreshPokemonList(): Result<List<PokemonResponse>?>

}