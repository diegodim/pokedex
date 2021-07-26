package com.diegoduarte.pokedex.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class NameResponse (
    @SerializedName("english")
    val english: String
)