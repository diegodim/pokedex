package com.diegoduarte.pokedex.data.source.local



import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.database.PokedexDao
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataSourceImpl(
    private val pokemonDao: PokedexDao):LocalDataSource {

    override fun getListPokemon(): Flow<List<Pokemon>> {
        return pokemonDao.getPokemonList().map {
                PokemonEntityMapper().toDomain(it)
            }
        }



}