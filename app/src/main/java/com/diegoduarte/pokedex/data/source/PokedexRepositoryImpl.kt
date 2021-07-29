package com.diegoduarte.pokedex.data.source

import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.LocalDataSource
import com.diegoduarte.pokedex.data.source.local.database.PokedexDatabase
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSource
import com.diegoduarte.pokedex.data.source.remote.mapper.PokemonResponseMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource) : PokedexRepository{


    override fun refreshPokemonList() = flow {

        val response = remoteDataSource.refreshPokemonList()

        if (response is Result.Success) {

            response.data?.forEach {
                localDataSource.insertPokemon(PokemonEntityMapper().toLocal(PokemonResponseMapper().toDomain(it)))
            }
            emit(Result.Loading)
        } else if (response is Result.Error) {
            emit(Result.Error(response.exception))
        }

    }


    override val listPokemon: Flow<Result<List<Pokemon>>>
        get() = localDataSource.getListPokemon()


}