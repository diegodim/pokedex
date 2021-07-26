package com.diegoduarte.pokedex.data.source.remote

import com.diegoduarte.pokedex.data.source.local.database.PokedexDao
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import com.diegoduarte.pokedex.data.source.remote.mapper.PokemonResponseMapper
import com.diegoduarte.pokedex.data.source.remote.service.WebServiceFactory
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val pokemonDao: PokedexDao): RemoteDataSource {

    override fun refreshPokemonList() = flow{
        try {


            val response = WebServiceFactory.service.getPokemonList()

            if(response.isSuccessful) {
                val listPokemon = response.body()
                listPokemon?.forEach {
                    pokemonDao
                        .insertAll(PokemonEntityMapper().toLocal(PokemonResponseMapper().toDomain(it)))
                }

                emit(Result.Success(response.isSuccessful))

            }
            else{
                emit(Result.Error(Exception(response.errorBody().toString())))
            }
        }catch (e: Exception){
            emit(Result.Error(e))
            e.printStackTrace()
        }

    }


    /*private suspend fun fetchPokemon(item: Iterable<PokedexResponse>): List<PokemonResponse> =
        coroutineScope {
            item.map { pokemon ->
                async { // this will allow us to run multiple tasks in parallel
                    WebServiceFactory.service.getPokemon(pokemon.url)
                }
            }.awaitAll()
        }*/
}