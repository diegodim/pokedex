package com.diegoduarte.pokedex.data.model

import com.diegoduarte.pokedex.R

data class Type(
    val name: String
)
{
    val color: Int
    get() = when(name){
        "grass"-> R.color.green
        "bug"-> R.color.green
        "fire"-> R.color.red
        "electric"-> R.color.yellow
        "poison"-> R.color.purple
        "ground"-> R.color.brown
        "rock"->R.color.gray
        else -> R.color.blue
    }
}