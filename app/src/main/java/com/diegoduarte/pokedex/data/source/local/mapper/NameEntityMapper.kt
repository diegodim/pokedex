package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Name
import com.diegoduarte.pokedex.data.source.local.entities.NameEntity

class NameEntityMapper: BaseLocalMapper<NameEntity?, Name?> {
    override fun toLocal(domain: Name?)= NameEntity (
        english = domain!!.english
    )

    override fun toDomain(local: NameEntity?)= Name (
        english = local!!.english
    )
}