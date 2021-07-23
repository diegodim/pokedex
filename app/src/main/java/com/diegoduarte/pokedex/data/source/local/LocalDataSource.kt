package com.diegoduarte.pokedex.data.source.local

import androidx.lifecycle.LiveData
import com.diegoduarte.pokedex.data.model.Pokemon

interface LocalDataSource {

    fun getListPokemon(): LiveData<List<Pokemon>>
}