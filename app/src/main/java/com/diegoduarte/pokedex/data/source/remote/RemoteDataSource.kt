package com.diegoduarte.pokedex.data.source.remote

import androidx.lifecycle.LiveData
import com.diegoduarte.pokedex.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun refreshPokemonList(offset: Int, limit: Int): Flow<Result<Boolean>>

}