package com.diegoduarte.pokedex.data.source.remote

import com.diegoduarte.pokedex.data.source.local.database.PokedexDao
import com.diegoduarte.pokedex.data.source.local.database.PokedexDatabase
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import com.diegoduarte.pokedex.data.source.remote.mapper.PokemonResponseMapper
import com.diegoduarte.pokedex.data.source.remote.model.PokedexResponse
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import com.diegoduarte.pokedex.data.source.remote.service.WebServiceFactory
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val pokemonDao: PokedexDao): RemoteDataSource {

    override fun refreshPokemonList(offset: Int, limit: Int) = flow{
        try {
            val listPokemon = WebServiceFactory.service.getPokemonList(offset, limit).results

            val response = fetchPokemon(listPokemon)
            response.forEach {
                pokemonDao
                    .insertAll(PokemonEntityMapper().toLocal(PokemonResponseMapper().toDomain(it)))
            }

            emit(Result.Success(true))
        }catch (e: Exception){
            emit(Result.Error(e))
        }

    }


    private suspend fun fetchPokemon(item: Iterable<PokedexResponse>): List<PokemonResponse> =
        coroutineScope {
            item.map { pokemon ->
                async { // this will allow us to run multiple tasks in parallel
                    WebServiceFactory.service.getPokemon(pokemon.url)
                }
            }.awaitAll()
        }
}