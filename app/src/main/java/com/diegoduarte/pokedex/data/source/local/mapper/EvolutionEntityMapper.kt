package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Evolution
import com.diegoduarte.pokedex.data.source.local.entities.EvolutionEntity

class EvolutionEntityMapper: BaseLocalMapper<EvolutionEntity?, Evolution?> {

    override fun toLocal(domain: Evolution?) = EvolutionEntity (
        prev = domain?.prev,
        next = domain?.next
    )

    override fun toDomain(local: EvolutionEntity?) = Evolution (
        prev = local?.prev,
        next = local?.next
    )
}