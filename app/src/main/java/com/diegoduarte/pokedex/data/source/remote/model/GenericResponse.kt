package com.diegoduarte.pokedex.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class GenericResponse<T>(

    @SerializedName("results")
    val results: List<T>
)
