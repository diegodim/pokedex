package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Stats
import com.diegoduarte.pokedex.data.source.local.entities.StatsEntity

class StatsEntityMapper: BaseLocalMapper<StatsEntity?, Stats?> {

    override fun toLocal(domain: Stats?)= StatsEntity (
        hp = domain?.hp,
        attack = domain?.attack,
        defense = domain?.defense,
        spAttack = domain?.spAttack,
        spDefense = domain?.spDefense,
        speed = domain?.speed
    )

    override fun toDomain(local: StatsEntity?)= Stats (
        hp = local?.hp,
        attack = local?.attack,
        defense = local?.defense,
        spAttack = local?.spAttack,
        spDefense = local?.spDefense,
        speed = local?.speed
    )
}