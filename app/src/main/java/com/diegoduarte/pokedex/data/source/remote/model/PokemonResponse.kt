package com.diegoduarte.pokedex.data.source.remote.model


import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("types")
    val types: List<TypesResponse>
)
