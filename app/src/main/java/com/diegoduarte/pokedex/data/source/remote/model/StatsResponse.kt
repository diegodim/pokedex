package com.diegoduarte.pokedex.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class StatsResponse (
    @SerializedName("HP")
    val hp: Int? = null,
    @SerializedName("Attack")
    val attack: Int? = null,
    @SerializedName("Defense")
    val defense: Int? = null,
    @SerializedName("Sp. Attack")
    val spAttack: Int? = null,
    @SerializedName("Sp. Defense")
    val spDefense: Int? = null,
    @SerializedName("Speed")
    val speed: Int? = null
)