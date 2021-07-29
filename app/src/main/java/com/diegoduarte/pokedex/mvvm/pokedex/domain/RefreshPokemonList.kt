package com.diegoduarte.pokedex.mvvm.pokedex.domain

import com.diegoduarte.pokedex.base.UseCase
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.remote.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class RefreshPokemonList(val repository: PokedexRepository, scope: CoroutineScope):
    UseCase<Result<Boolean>, Void?>(scope) {

    override fun run(params: Void?): Flow<Result<Boolean>> {
        return repository.refreshPokemonList()
    }
}