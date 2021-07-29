package com.diegoduarte.pokedex.ui.pokedex.domain

import com.diegoduarte.pokedex.base.UseCase
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetPokemonList(val repository: PokedexRepository, scope: CoroutineScope) 
    : UseCase<List<Pokemon>, Void?>(scope) {

    override fun run(params: Void?): Flow<Result<List<Pokemon>>> {
        return repository.listPokemon
    }
}