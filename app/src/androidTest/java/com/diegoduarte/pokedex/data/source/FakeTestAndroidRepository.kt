package com.diegoduarte.pokedex.data.source

import androidx.annotation.VisibleForTesting
import com.diegoduarte.pokedex.data.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeTestAndroidRepository: PokedexRepository {

    var pokedexServiceData: LinkedHashMap<String, Pokemon> = LinkedHashMap()

    override fun refreshPokemonList(): Flow<Result<Nothing>> {

        return flow{
            Thread.sleep(2000)
            emit(Result.Loading)
        }
    }

    override val listPokemon: Flow<Result<List<Pokemon>>>
        get() = flow{emit(Result.Success(pokedexServiceData.values.toList()))}

    @VisibleForTesting
    fun addPokemon(vararg pokemons: Pokemon) {
        for (pokemon in pokemons) {
            pokedexServiceData[pokemon.id.toString()] = pokemon
        }
    }


    @VisibleForTesting
    fun deletePokemon() {
        pokedexServiceData.clear()
    }
}