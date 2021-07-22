package com.diegoduarte.pokedex.data.source.remote.model

import com.diegoduarte.pokedex.R
import com.google.gson.annotations.SerializedName

data class TypeResponse(
    @SerializedName("name")
    val name: String
)