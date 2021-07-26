package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Evolution
import com.diegoduarte.pokedex.data.source.remote.model.EvolutionResponse

class EvolutionResponseMapper: BaseRemoteMapper<EvolutionResponse?, Evolution?> {
    override fun toDomain(remote: EvolutionResponse?)= Evolution (
        prev = remote?.prev,
        next = remote?.next
    )
}