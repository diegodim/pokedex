package com.diegoduarte.pokedex.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.database.PokedexDao
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper

class LocalDataSourceImpl(
    private val pokemonDao: PokedexDao):LocalDataSource {
    override fun getListPokemon(): LiveData<List<Pokemon>> {
        return Transformations.map(pokemonDao.getPokemonList()) {
            PokemonEntityMapper().toDomain(it)
        }
    }


}