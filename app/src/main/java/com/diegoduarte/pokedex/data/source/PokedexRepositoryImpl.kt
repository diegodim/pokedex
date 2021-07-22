package com.diegoduarte.pokedex.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.database.PokedexDatabase
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import com.diegoduarte.pokedex.data.source.remote.Result
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import com.diegoduarte.pokedex.data.source.remote.service.WebServiceFactory
import com.diegoduarte.pokedex.data.source.remote.mapper.PokemonResponseMapper
import com.diegoduarte.pokedex.data.source.remote.model.PokedexResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
        private val database: PokedexDatabase,
        private val dispatcher: CoroutineDispatcher = Dispatchers.IO):

    PokedexRepository{



    override fun refreshPokemonList(offset: Int, limit: Int) = flow{
        try {
            val listPokemon = WebServiceFactory.service.getPokemonList(offset, limit).results

            val response = fetchPokemon(listPokemon)
            response.forEach {
                database.pokemonDao()
                    .insertAll(PokemonEntityMapper().toLocal(PokemonResponseMapper().toDomain(it)))
            }

            emit(Result.Success(true))
        }catch (e: Exception){
            emit(Result.Error(e))
        }

    }

    override val listPokemon: LiveData<List<Pokemon>>
        get() = Transformations.map(database.pokemonDao().getPokemonList()) {
            PokemonEntityMapper().toDomain(it)
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