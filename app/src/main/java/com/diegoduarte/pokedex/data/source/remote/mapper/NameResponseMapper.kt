package com.diegoduarte.pokedex.data.source.remote.mapper

import com.diegoduarte.pokedex.data.model.Name
import com.diegoduarte.pokedex.data.source.remote.mapper.BaseRemoteMapper
import com.diegoduarte.pokedex.data.source.remote.model.NameResponse

class NameResponseMapper: BaseRemoteMapper<NameResponse?, Name?> {
    override fun toDomain(remote: NameResponse?)= Name (
        english = remote?.english
    )
}