package com.diegoduarte.pokedex.data.source.local

import androidx.lifecycle.LiveData
import com.diegoduarte.pokedex.data.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface LocalDataSource {

    fun getListPokemon(): Flow<List<Pokemon>>
}