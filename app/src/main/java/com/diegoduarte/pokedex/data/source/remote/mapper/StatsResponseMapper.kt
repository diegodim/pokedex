package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Stats
import com.diegoduarte.pokedex.data.source.remote.model.StatsResponse

class StatsResponseMapper: BaseRemoteMapper<StatsResponse?, Stats?> {
    override fun toDomain(remote: StatsResponse?)= Stats (
        hp = remote?.hp,
        attack = remote?.attack,
        defense = remote?.defense,
        spAttack = remote?.spAttack,
        spDefense = remote?.spDefense,
        speed = remote?.speed
    )
}