package com.diegoduarte.pokedex.data.source.remote.model


import com.diegoduarte.pokedex.data.model.Evolution
import com.diegoduarte.pokedex.data.model.Name
import com.diegoduarte.pokedex.data.model.Profile
import com.diegoduarte.pokedex.data.model.Stats
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: NameResponse? = null,
    @SerializedName("type")
    val type: List<String>? = null,
    @SerializedName("base")
    val base: StatsResponse? = null,
    @SerializedName("species")
    val species: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("evolution")
    val evolution: EvolutionResponse? = null,
    @SerializedName("profile")
    val profile: ProfileResponse? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = "",
    @SerializedName("hires")
    val hires: String? = ""
)
