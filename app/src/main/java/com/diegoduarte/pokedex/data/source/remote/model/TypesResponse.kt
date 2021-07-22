package com.diegoduarte.pokedex.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class TypesResponse(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: TypeResponse
)
