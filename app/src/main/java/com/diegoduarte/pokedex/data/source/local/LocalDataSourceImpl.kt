package com.diegoduarte.pokedex.data.source.local



import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.database.PokedexDao
import com.diegoduarte.pokedex.data.source.local.mapper.PokemonEntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.diegoduarte.pokedex.data.source.Result
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity
import java.lang.Exception

class LocalDataSourceImpl(
    private val pokemonDao: PokedexDao):LocalDataSource {

    override fun getListPokemon(): Flow<Result<List<Pokemon>>> {
        return pokemonDao.getPokemonList().map {
            try {
                Result.Success(PokemonEntityMapper().toDomain(it))
            }catch (e: Exception){
                Result.Error(e)
            }
        }
    }

    override suspend fun insertPokemon(pokemon: PokemonEntity) {
        pokemonDao.insertAll(pokemon)
    }


}