package com.diegoduarte.pokedex.data.source.remote

import com.diegoduarte.pokedex.data.source.remote.service.PokemonServiceBuilder
import com.diegoduarte.pokedex.data.source.Result
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import com.diegoduarte.pokedex.data.source.remote.service.PokemonService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val pokemonService: PokemonService):
    RemoteDataSource {

    override suspend fun refreshPokemonList(): Result<List<PokemonResponse>?> {
        try {

            val response = pokemonService.getPokemonList()
            if(response.isSuccessful) {
                val listPokemon = response.body()
                return Result.Success(listPokemon)
            }
            else{
                return Result.Error(Exception(response.errorBody().toString()))
            }
        }catch (e: Exception){
            e.printStackTrace()
            return Result.Error(e)

        }

    }

}