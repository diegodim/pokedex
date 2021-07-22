package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Type
import com.diegoduarte.pokedex.data.source.remote.model.TypeResponse


class TypeResponseMapper: BaseRemoteMapper<TypeResponse, Type> {

    override fun toDomain(remote: TypeResponse) = Type(
        name = remote.name
    )


}