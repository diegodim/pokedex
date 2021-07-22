package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.source.remote.model.PokemonResponse

class PokemonResponseMapper: BaseRemoteMapper<PokemonResponse, Pokemon> {



    override  fun toDomain(remote: PokemonResponse) = Pokemon(
            id = remote.id,
            name = remote.name,
            types =  TypesResponseMapper().toDomain(remote.types)
        )

}