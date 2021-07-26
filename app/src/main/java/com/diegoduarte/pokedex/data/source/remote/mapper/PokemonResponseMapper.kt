package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.local.mapper.StatsEntityMapper
import com.diegoduarte.pokedex.data.source.local.mapper.EvolutionEntityMapper
import com.diegoduarte.pokedex.data.source.local.mapper.NameEntityMapper
import com.diegoduarte.pokedex.data.source.local.mapper.ProfileEntityMapper
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse

class PokemonResponseMapper: BaseRemoteMapper<PokemonResponse, Pokemon> {



    override  fun toDomain(remote: PokemonResponse) = Pokemon(
            id = remote.id,
            name = NameResponseMapper().toDomain(remote.name),
            type = remote.type,
            base = StatsResponseMapper().toDomain(remote.base),
            species = remote.species,
            description = remote.description,
            evolution = EvolutionResponseMapper().toDomain(remote.evolution),
            profile = ProfileResponseMapper().toDomain(remote.profile),
            thumbnail = remote.thumbnail,
            hires = remote.hires,
        )

}