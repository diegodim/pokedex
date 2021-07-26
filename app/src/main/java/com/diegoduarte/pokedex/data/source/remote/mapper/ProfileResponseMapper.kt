package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Profile
import com.diegoduarte.pokedex.data.source.remote.model.ProfileResponse

class ProfileResponseMapper: BaseRemoteMapper<ProfileResponse?, Profile?> {
    override fun toDomain(remote: ProfileResponse?)= Profile (
        height = remote?.height,
        weight = remote?.weight,
        egg = remote?.egg,
        ability = remote?.ability,
        gender = remote?.gender
    )
}