package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity

class PokemonEntityMapper: BaseLocalMapper<PokemonEntity, Pokemon> {


    override fun toLocal(domain: Pokemon) = PokemonEntity(
        id = domain.id,
        name = domain.name,
        types = TypesEntityMapper().toLocal(domain.types).toMutableList()
    )

    override fun toDomain(local: PokemonEntity) = Pokemon(
        id = local.id,
        name = local.name,
        types = TypesEntityMapper().toDomain(local.types)
    )
}