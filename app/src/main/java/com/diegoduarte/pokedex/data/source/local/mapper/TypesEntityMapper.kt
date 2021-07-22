package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Types
import com.diegoduarte.pokedex.data.source.local.entities.TypesEntity

class TypesEntityMapper: BaseLocalMapper<TypesEntity, Types> {

    override fun toLocal(domain: Types) = TypesEntity (
        type =  TypeEntityMapper().toLocal(domain.type),
        slot = domain.slot
    )

    override fun toDomain(local: TypesEntity) = Types (
    type =  TypeEntityMapper().toDomain(local.type),
    slot = local.slot
    )
}