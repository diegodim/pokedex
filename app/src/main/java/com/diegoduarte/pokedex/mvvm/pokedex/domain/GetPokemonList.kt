package com.diegoduarte.pokedex.mvvm.pokedex.domain

import com.diegoduarte.pokedex.base.UseCase
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.PokedexRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetPokemonList(val repository: PokedexRepository, scope: CoroutineScope) 
    : UseCase<List<Pokemon>, Void?>(scope) {

    override fun run(params: Void?): Flow<List<Pokemon>> {
        return repository.listPokemon
    }
}