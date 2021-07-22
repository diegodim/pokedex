package com.diegoduarte.pokedex.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class PokedexResponse (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)