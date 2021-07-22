package com.diegoduarte.pokedex.data.model


data class Pokemon(
    val name: String,
    val id: Int,
    val types: List<Types>,
    var liked: Boolean = false
)
