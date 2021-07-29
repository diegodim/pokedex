package com.diegoduarte.pokedex.data.source.remote

import com.diegoduarte.pokedex.data.source.local.database.PokedexDao
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import com.diegoduarte.pokedex.data.source.remote.mapper.PokemonResponseMapper
import com.diegoduarte.pokedex.data.source.remote.service.WebServiceFactory
import com.diegoduarte.pokedex.data.source.Result
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(): RemoteDataSource {

    override suspend fun refreshPokemonList(): Result<List<PokemonResponse>?> {
        try {

            val response = WebServiceFactory.service.getPokemonList()
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