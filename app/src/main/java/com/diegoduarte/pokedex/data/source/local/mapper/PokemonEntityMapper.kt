package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity

class PokemonEntityMapper: BaseLocalMapper<PokemonEntity, Pokemon> {


    override fun toLocal(domain: Pokemon) = PokemonEntity(
        id = domain.id,
        name = NameEntityMapper().toLocal(domain.name),
        type = domain.type,
        base = StatsEntityMapper().toLocal(domain.base),
        species = domain.species,
        description = domain.description,
        evolution = EvolutionEntityMapper().toLocal(domain.evolution),
        profile = ProfileEntityMapper().toLocal(domain.profile),
        thumbnail = domain.thumbnail,
        hires = domain.hires,
        liked = domain.liked
    )

    override fun toDomain(local: PokemonEntity) = Pokemon(
        id = local.id,
        name = NameEntityMapper().toDomain(local.name),
        type = local.type,
        base = StatsEntityMapper().toDomain(local.base),
        species = local.species,
        description = local.description,
        evolution = EvolutionEntityMapper().toDomain(local.evolution),
        profile = ProfileEntityMapper().toDomain(local.profile),
        thumbnail = local.thumbnail,
        hires = local.hires,
        liked = local.liked
    )
}