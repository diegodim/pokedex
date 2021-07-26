package com.diegoduarte.pokedex.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class EvolutionResponse (
    @SerializedName("prev")
    val prev: List<String>? = null,
    @SerializedName("next")
    val next: List<List<String>>? = null,
)