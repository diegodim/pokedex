package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Types
import com.diegoduarte.pokedex.data.source.remote.model.TypesResponse

class TypesResponseMapper: BaseRemoteMapper<TypesResponse, Types> {



    override fun toDomain(remote: TypesResponse) = Types(
        type = TypeResponseMapper().toDomain(remote.type),
        slot = remote.slot
    )

}