package com.diegoduarte.pokedex.data.source.local.mapper

import com.diegoduarte.pokedex.data.model.Profile
import com.diegoduarte.pokedex.data.source.local.entities.ProfileEntity

class ProfileEntityMapper: BaseLocalMapper<ProfileEntity?, Profile?> {
    override fun toLocal(domain: Profile?)= ProfileEntity (
        height = domain?.height,
        weight = domain?.weight,
        egg = domain?.egg,
        ability = domain?.ability,
        gender = domain?.gender
    )

    override fun toDomain(local: ProfileEntity?)= Profile (
        height = local?.height,
        weight = local?.weight,
        egg = local?.egg,
        ability = local?.ability,
        gender = local?.gender
    )
}