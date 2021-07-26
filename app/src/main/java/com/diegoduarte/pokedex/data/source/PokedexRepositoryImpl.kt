package com.diegoduarte.pokedex.data.source

import androidx.lifecycle.LiveData
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.LocalDataSource
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSource
import com.diegoduarte.pokedex.data.source.remote.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource) : PokedexRepository{


    override fun refreshPokemonList(): Flow<Result<Boolean>> {
        return remoteDataSource.refreshPokemonList()
    }

    override val listPokemon: LiveData<List<Pokemon>>
        get() = localDataSource.getListPokemon()


}