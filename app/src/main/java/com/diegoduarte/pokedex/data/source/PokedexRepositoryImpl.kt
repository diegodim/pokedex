package com.diegoduarte.pokedex.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.LocalDataSource
import com.diegoduarte.pokedex.data.source.local.database.PokedexDatabase
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSource
import com.diegoduarte.pokedex.data.source.remote.Result
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse
import com.diegoduarte.pokedex.data.source.remote.service.WebServiceFactory
import com.diegoduarte.pokedex.data.source.remote.mapper.PokemonResponseMapper
import com.diegoduarte.pokedex.data.source.remote.model.PokedexResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource) : PokedexRepository{


    override fun refreshPokemonList(offset: Int, limit: Int): Flow<Result<Boolean>> {
        return remoteDataSource.refreshPokemonList(offset, limit)
    }

    override val listPokemon: LiveData<List<Pokemon>>
        get() = localDataSource.getListPokemon()


}