package com.diegoduarte.pokedex.ui.pokedex.domain

import com.diegoduarte.pokedex.base.UseCase
import com.diegoduarte.pokedex.data.source.PokedexRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import com.diegoduarte.pokedex.data.source.Result

class RefreshPokemonList(val repository: PokedexRepository, scope: CoroutineScope):
    UseCase<Nothing, Void?>(scope) {

    override fun run(params: Void?): Flow<Result<Nothing>> {
        return repository.refreshPokemonList()
    }
}