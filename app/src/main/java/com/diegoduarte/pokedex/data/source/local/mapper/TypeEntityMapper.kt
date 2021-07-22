package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Type
import com.diegoduarte.pokedex.data.source.local.entities.TypeEntity

class TypeEntityMapper: BaseLocalMapper<TypeEntity, Type> {
    override fun toLocal(domain: Type) = TypeEntity (
        name = domain.name
    )

    override fun toDomain(local: TypeEntity) = Type (
        name = local.name
    )
}