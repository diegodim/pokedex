package com.diegoduarte.pokedex.mvvm.pokedex.domain

import com.diegoduarte.pokedex.base.UseCase
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.remote.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class RefreshData(val repository: PokedexRepository, scope: CoroutineScope):
    UseCase<Result<Boolean>, RefreshData.Params>(scope) {


    data class Params constructor(val offset: Int,
                                  val limit: Int)

    override fun run(params: Params?): Flow<Result<Boolean>> {
        return repository.refreshPokemonList(params!!.offset, params.limit)
    }
}