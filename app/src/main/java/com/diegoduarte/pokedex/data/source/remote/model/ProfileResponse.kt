package com.diegoduarte.pokedex.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("weight")
    val weight: String? = null,
    @SerializedName("egg")
    val egg: List<String>? = null,
    @SerializedName("ability")
    val ability: List<List<String>>? = null,
    @SerializedName("gender")
    val gender: String? = null

)