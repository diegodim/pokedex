package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity

class PokemonEntityMapper: BaseLocalMapper<PokemonEntity, Pokemon> {


    override fun toLocal(domain: Pokemon) = PokemonEntity(
        id = domain.id,
        name = domain.name,
        height = domain.height,
        weight = domain.weight,
        baseExperience = domain.baseExperience,
        types = TypesEntityMapper().toLocal(domain.types).toMutableList(),
        liked = domain.liked
    )

    override fun toDomain(local: PokemonEntity) = Pokemon(
        id = local.id,
        name = local.name,
        height = local.height,
        weight = local.weight,
        baseExperience = local.baseExperience,
        types = TypesEntityMapper().toDomain(local.types),
        liked = local.liked
    )
}